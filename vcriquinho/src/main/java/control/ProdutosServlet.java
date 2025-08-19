package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.management.AttributeNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import dao.ProdutoDAO;
import model.ContaInvAut;
import model.Produto;
import model.RendaFixa;
import model.RendaVariavel;

/**
 * Servlet implementation class ProdutosServlet
 */
@WebServlet("/produtos/*")
public class ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try {
			String id = request.getPathInfo().substring(1);
			ProdutoDAO dao = new ProdutoDAO();
			Produto produto = dao.consultar(Integer.parseInt(id));
			JSONObject json = new JSONObject(produto);
			
			response.getWriter().print(json);
		} catch (NullPointerException e) {
			response.sendError(404, "Cliente nao encontrado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> requests = request.getParameterMap();
		Produto produto = null;
		
		try {
			ProdutoDAO dao = new ProdutoDAO();
			if (requests.get("dias_carencia") != null) {
				produto = new RendaFixa(
						0,
						requests.get("nome")[0],
						requests.get("descricao")[0],
						Integer.parseInt(requests.get("rendimento")[0]),
						Integer.parseInt(requests.get("dias_carencia")[0]),
						requests.get("em_carencia")[0].equals("true")
						);
			} else {
				produto = new RendaVariavel(0, 
						requests.get("nome")[0],
						requests.get("descricao")[0],
						Integer.parseInt(requests.get("rendimento")[0])
						);
			}
			int id = Integer.parseInt(requests.get("id_conta")[0]);
			ContaInvAut conta = new ContaInvAut(id, 0, produto, null);
			dao.incluir(conta);
			response.setStatus(201);
		} catch (SQLException e) {
			response.sendError(500);
			e.printStackTrace();
		} catch (NullPointerException e) {
			response.sendError(400, "Campos nao preenchidos");
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String body = request.getReader().lines().reduce("", (acc, line) -> acc + line);		
		 Produto produto = null;
		    JSONObject json = new JSONObject(body);

			try {
				int id = Integer.parseInt(request.getPathInfo().substring(1));
				ProdutoDAO dao = new ProdutoDAO();
				if (json.has("dias_carencia")) {
					produto = new RendaFixa(
							id,
							testeAtributo(json, "nome"),
							testeAtributo(json, "descricao"),
							Integer.parseInt(testeAtributo(json, "rendimento")),
							Integer.parseInt(testeAtributo(json, "dias_carencia")),
							testeAtributo(json, "em_carencia").equals("true")
							);
				} else {
					produto = new RendaVariavel(
							id,
							testeAtributo(json, "nome"),
							testeAtributo(json, "descricao"),
							Integer.parseInt(testeAtributo(json, "rendimento"))
							);
				}
				dao.atualizar(produto);
				response.setStatus(200);
			} catch (SQLException e) {
				response.sendError(500);
				e.printStackTrace();
			} catch (NullPointerException e) {
				response.sendError(400, "Campos vazios");
				e.printStackTrace();
			} catch (AttributeNotFoundException e) {
				response.sendError(404, "Cliente nao encontrado");
			}
	}
	
	private String testeAtributo(JSONObject json, String key) {
		try {
			return json.getString(key);
		} catch (JSONException e) {
			return null;
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getPathInfo().substring(1);
			ProdutoDAO dao = new ProdutoDAO();
			dao.remover(Integer.parseInt(id));
			response.setStatus(204);
		} catch (SQLException e) {
			response.sendError(500);
			e.printStackTrace();
		} catch (NullPointerException e) {
			response.sendError(400, "Id nao informado");
		}
	}

}
