package aiss.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import java.net.*;

import aiss.model.Twitch;

/**
 * Servlet implementation class TwitchCallbackServlet
 */
public class TwitchCallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("code"));
		String url = "https://api.twitch.tv/kraken/oauth2/token?client_id=1bcrhm611zm99ho32sf2nbkn1rmuc9&client_secret=nspq6052fpnsbv2tg6l7279bm4hdy7&code="+request.getParameter("code")+"&grant_type=authorization_code&redirect_uri=http://aiss-smash-live.appspot.com/TwitchCallback&state=200";
//		Client client = new Client(new Context(), Protocol.HTTP);
//		ClientResource cr = new ClientResource(url);
////		cr.setEntityBuffering(true);
//		Twitch twitch = null;
//////		cr.setNext(client);
//		try {
//			twitch = cr.post(twitch, Twitch.class);
//		} catch (ResourceException e) {
//			System.err.println(cr.getResponse());
//		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);		
		httpPost.addHeader("Content-Type", "application/json");
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
			System.out.println(response2.getStatusLine());
			HttpEntity entity2 = response2.getEntity();
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line;
			try {

				br = new BufferedReader(new InputStreamReader(entity2.getContent()));
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(sb.toString());
			EntityUtils.consume(entity2);
		
		    response2.close();
		
		String split[] = sb.toString().split("\"");
		for (String s : split){
			System.out.println(s);
		}
		Twitch twitch = new Twitch(split[3],split[7],split[11]);
		System.out.println(twitch.getCanal().getDisplayName() + " aToken: "+twitch.getAccess_token()+" rToken: "+twitch.getRefresh_token()+" scope: "+twitch.getScope());
    	request.getSession().setAttribute("twitch", twitch);
		response.sendRedirect(request.getContextPath() + "/");
	}

}
