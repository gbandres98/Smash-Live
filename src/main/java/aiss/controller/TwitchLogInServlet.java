package aiss.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.auth.Scopes;

/**
 * Servlet implementation class TwitchLogInServlet
 */
public class TwitchLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitch twitch = new Twitch();
		twitch.setClientId("1bcrhm611zm99ho32sf2nbkn1rmuc9");
		request.getSession().setAttribute("twitch", twitch);
		URI callbackUri = null;
		try {
			callbackUri = new URI("http://localhost:8090/TwitchCallback");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String authUrl = twitch.auth().getAuthenticationUrl(twitch.getClientId(),
				callbackUri, Scopes.USER_READ, Scopes.CHANNEL_READ, Scopes.CHANNEL_EDITOR);
		response.sendRedirect(authUrl);
		
	}

}
