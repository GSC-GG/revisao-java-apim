package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.ContaCDI;
import model.ContaCorrente;

/**
 * Servlet implementation class Main
 */
@WebServlet("/simulacao")
public class Simulacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Simulacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoConta;
		try {
			tipoConta = request.getParameter("tipo_conta");
		} catch (NullPointerException e) {
			tipoConta = "corrente";
		}

		int saldo;
		try {
			saldo = Integer.parseInt(request.getParameter("saldo"));
		} catch (NullPointerException e) {
			saldo = 0;
		}

		int cdi;
		try {
			cdi = Integer.parseInt(request.getParameter("cdi"));
		} catch (NullPointerException e) {
			cdi = 0;
		}

		int diasCarencia;
		try {
			diasCarencia = Integer.parseInt(request.getParameter("dias_carencia"));
		} catch (NullPointerException e) {
			diasCarencia = 0;
		}
		Conta conta = null;
		int valor = 0;
		response.getWriter().println("\tRendimento\n");
		
		if (tipoConta.equals("corrente")) {
			conta = new ContaCorrente(0, saldo, null);
			response.getWriter().print("30 dias: ");
			response.getWriter().println(saldo);

			response.getWriter().print("60 dias: ");
			response.getWriter().println(saldo);

			response.getWriter().print("90 dias: ");
			response.getWriter().println(saldo);

			response.getWriter().print("180 dias: ");
			response.getWriter().println(saldo);
		}
		
		if (tipoConta.equals("cdi")) {
			conta = new ContaCDI(0, saldo, null);
			response.getWriter().print("30 dias: ");
			ContaCDI.setCdi(cdi);
			for (int i = 0; i < 30; i++) {
				((ContaCDI) conta).calcularSaldo();
			}
			valor = conta.getSaldo();
			response.getWriter().println(saldo);
			
			response.getWriter().print("60 dias: ");
			ContaCDI.setCdi(cdi);
			for (int i = 30; i < 60; i++) {
				((ContaCDI) conta).calcularSaldo();
			}
			valor = conta.getSaldo();
			response.getWriter().println(saldo);

			response.getWriter().print("90 dias: ");
			ContaCDI.setCdi(cdi);
			for (int i = 60; i < 90; i++) {
				((ContaCDI) conta).calcularSaldo();
			}
			valor = conta.getSaldo();
			response.getWriter().println(saldo);

			response.getWriter().print("180 dias: ");
			ContaCDI.setCdi(cdi);
			for (int i = 90; i < 180; i++) {
				((ContaCDI) conta).calcularSaldo();
			}
			valor = conta.getSaldo();
			response.getWriter().println(saldo);
		}
		
		if (tipoConta.equals("investimento_automatico")) {
			
		}
	}

}
