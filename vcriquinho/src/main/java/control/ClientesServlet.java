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

import dao.ClienteDAO;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

/**
 * Servlet implementation class ClientesServlet
 */
@WebServlet("/clientes/*")
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesServlet() {
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
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = dao.consultar(Integer.parseInt(id));
			JSONObject json = new JSONObject(cliente);
			
			response.getWriter().print(json);
			//response.getWriter().print("\n\n"+request.getQueryString());
		} catch (NullPointerException e) {
			response.sendError(404, "Cliente nao encontrado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> requests = request.getParameterMap();
		//Map<String, String> erros = null;
		Cliente cliente = null;
		
		try {
			ClienteDAO dao = new ClienteDAO();
			if (requests.get("cpf") != null) {
				cliente = new PessoaFisica(
						0,
						requests.get("nome")[0],
						requests.get("email")[0],
						requests.get("cpf")[0]
						);
			} else if (requests.get("cnpj") != null) {
				cliente = new PessoaJuridica(
						0,
						requests.get("nome")[0],
						requests.get("email")[0],
						requests.get("cnpj")[0]
						);
			} else throw new NullPointerException("cpf/cnpj nao preenchido");
			dao.incluir(cliente);
			response.setStatus(201);
		} catch (SQLException e) {
			response.sendError(500);
			e.printStackTrace();
		} catch (NullPointerException e) {
			response.sendError(400, "Campos nao preenchidos");
			//erros.put("error", e.getMessage());
			//JSONObject json = new JSONObject(erros);
		}
		
		//doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String body = request.getReader().lines().reduce("", (acc, line) -> acc + line);		
	    Cliente cliente = null;
	    JSONObject json = new JSONObject(body);

		try {
			int id = Integer.parseInt(request.getPathInfo().substring(1));
			ClienteDAO dao = new ClienteDAO();
			if (json.has("cpf")) {
				cliente = new PessoaFisica(
						id,
						testeAtributo(json, "nome"),
						testeAtributo(json, "email"),
						json.getString("cpf")
						);
			} else if (json.has("cnpj")) {
				cliente = new PessoaJuridica(
						id,
						testeAtributo(json, "nome"),
						testeAtributo(json, "email"),
						json.getString("cnpj")
						);
			} else {
				cliente = new PessoaFisica(
						id,
						testeAtributo(json, "nome"),
						testeAtributo(json, "email"),
						null
						);
			}
			dao.atualizar(cliente);
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
			ClienteDAO dao = new ClienteDAO();
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
