package aiss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOutServlet
 */
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("twitter");
		request.getSession().removeAttribute("twitch");
		request.getSession().removeAttribute("summoner");
		request.getSession().removeAttribute("game");
		request.getSession().removeAttribute("player");
		request.getSession().removeAttribute("champ");
		request.getSession().removeAttribute("err");
		response.sendRedirect(request.getContextPath() + "/");
	}

}
