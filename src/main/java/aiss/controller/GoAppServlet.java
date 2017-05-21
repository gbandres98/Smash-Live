package aiss.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import aiss.model.LolChampion;
import aiss.model.LolCurrentGame;
import aiss.model.LolSummoner;
import aiss.model.Participant;

/**
 * Servlet implementation class GoAppServlet
 */
public class GoAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("summoner");
		request.getSession().removeAttribute("game");
		request.getSession().removeAttribute("player");
		request.getSession().removeAttribute("champ");
		request.getSession().removeAttribute("err");
		String url = "https://" + request.getParameter("reg") + ".api.riotgames.com/lol/summoner/v3/summoners/by-name/"
				+ request.getParameter("summ") + "?api_key=RGAPI-fdfd4cde-e39b-4dcf-8059-83760a08bc5e";
		System.out.println(url);
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request1 = new HttpGet(url);
		HttpResponse response1 = client.execute(request1);

		// System.out.println("Response Code : "
		// + response1.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		String james = result.toString();
		// System.out.println(james);
		ObjectMapper mapper = new ObjectMapper();
		LolSummoner summoner = null;
		summoner = mapper.readValue(james, LolSummoner.class);
		if (summoner.getId() == null) {
			request.setAttribute("error", "wrongSummoner");
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			System.out.println(summoner.getName());
			request.getSession().setAttribute("summoner", summoner);
			request.getSession().setAttribute("reg", request.getParameter("reg"));
			// Lee la partida actual (si la hay)
			url = "https://" + request.getParameter("reg")
					+ ".api.riotgames.com/lol/spectator/v3/active-games/by-summoner/" + summoner.getId()
					+ "?api_key=RGAPI-fdfd4cde-e39b-4dcf-8059-83760a08bc5e";
			HttpClient client1 = HttpClientBuilder.create().build();
			HttpGet request11 = new HttpGet(url);
			HttpResponse response11 = client1.execute(request11);

			// System.out.println("Response Code : "
			// + response1.getStatusLine().getStatusCode());

			BufferedReader rd1 = new BufferedReader(new InputStreamReader(response11.getEntity().getContent()));

			StringBuffer result1 = new StringBuffer();
			String line1 = "";
			while ((line1 = rd1.readLine()) != null) {
				result1.append(line1);
			}
			String james1 = result1.toString();
			// System.out.println(james);
			ObjectMapper mapper1 = new ObjectMapper();
			LolCurrentGame game = null;
			game = mapper1.readValue(james1, LolCurrentGame.class);
			if (game.getGameMode() != null) {
				request.getSession().setAttribute("game", game);
				for (Participant p : game.getParticipants()) {
					// System.out.println("participant: " + p.getSummonerName()
					// +" " + p.getSummonerId());
					// System.out.println("summoner: " + summoner.getName() +" "
					// + summoner.getId() );
					if (p.getSummonerId().equals(summoner.getId())) {
						// System.out.println("FOUNDparticipant: " +
						// p.getSummonerName() +" " + p.getSummonerId());
						// System.out.println("FOUNDsummoner: " +
						// summoner.getName() +" " + summoner.getId() );
						request.getSession().setAttribute("player", p);
						// System.out.println("champ id: "+p.getChampionId());
					}
				}
				url = "https://" + request.getParameter("reg") + ".api.riotgames.com/lol/static-data/v3/champions/"
						+ ((Participant) request.getSession().getAttribute("player")).getChampionId()
						+ "?champData=image&api_key=RGAPI-fdfd4cde-e39b-4dcf-8059-83760a08bc5e";
				System.out.println(url);
				HttpClient client11 = HttpClientBuilder.create().build();
				HttpGet request111 = new HttpGet(url);
				HttpResponse response111 = client11.execute(request111);

				// System.out.println("Response Code : "
				// + response1.getStatusLine().getStatusCode());

				BufferedReader rd11 = new BufferedReader(new InputStreamReader(response111.getEntity().getContent()));

				StringBuffer result11 = new StringBuffer();
				String line11 = "";
				while ((line11 = rd11.readLine()) != null) {
					result11.append(line11);
				}
				String james11 = result11.toString();
				// System.out.println(james);
				ObjectMapper mapper11 = new ObjectMapper();
				LolChampion champ = null;
				champ = mapper11.readValue(james11, LolChampion.class);
				// System.out.println(champ.getName()+", "+champ.getTitle());
				request.getSession().setAttribute("champ", champ);
			}
			response.sendRedirect(request.getContextPath() + "/app.jsp");
		}
	}
}
