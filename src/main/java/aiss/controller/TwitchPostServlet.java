package aiss.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.api.client.util.IOUtils;
import com.google.appengine.repackaged.com.google.common.io.CharStreams;

import aiss.model.Twitch;

/**
 * Servlet implementation class TwitchPostServlet
 */
public class TwitchPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitch twitch = (Twitch) request.getSession().getAttribute("twitch");
		String url = "https://api.twitch.tv/kraken/channels/"+twitch.getCanal().getName();
		System.out.println(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut(url);
//		httpPut.addHeader("Client-ID:"," 1bcrhm611zm99ho32sf2nbkn1rmuc9");
		httpPut.addHeader("Authorization", "OAuth "+twitch.getAccess_token());
		System.out.println(twitch.getAccess_token());
		httpPut.addHeader("Content-Type","application/json");
		StringEntity data = new StringEntity("{\"channel\": {\"status\": \""+request.getParameter("title")+"\"}}");
		System.out.println(httpPut.getFirstHeader("Authorization").getValue());
		System.out.println(CharStreams.toString(new InputStreamReader(
			      data.getContent(), Charsets.UTF_8)));
		
		System.out.println(data.toString());
		
		httpPut.setEntity(data);
		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

            @Override
            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                /* Get status code */
                int httpResponseCode = httpResponse.getStatusLine().getStatusCode();
                System.out.println("Response code: " + httpResponseCode);
                if (httpResponseCode >= 200 && httpResponseCode < 300) {
                    /* Convert response to String */
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    return null;
                    /* throw new ClientProtocolException("Unexpected response status: " + httpResponseCode); */
                }
            }
        };

        try {
            /* Execute URL and attach after execution response handler */
            String strResponse = httpClient.execute(httpPut, responseHandler);
            /* Print the response */
            System.out.println("Response: " + strResponse);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

}
