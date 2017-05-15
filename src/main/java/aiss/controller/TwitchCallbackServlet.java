package aiss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mb3364.twitch.api.Twitch;

/**
 * Servlet implementation class TwitchCallbackServlet
 */
public class TwitchCallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitch twitch = (Twitch) request.getSession().getAttribute("twitch");
		boolean authSuccess = twitch.auth().awaitAccessToken();
		if (authSuccess){
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

}
