package aiss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TwitterLogInServlet extends HttpServlet {
    private static final long serialVersionUID = -6205814293093350242L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey("5H9LPdteIlWG7ER6KHf0lnfcl");
        configurationBuilder.setOAuthConsumerSecret("lVSV6FIOYiaBfNumOfJDmVhncU2ocuEgHkb8MVGza3g9DzUzge");
        configurationBuilder.setUseSSL(true);
//        configurationBuilder.setOAuthAuthenticationURL("https://api.twitter.com/oauth/authenticate");
//        configurationBuilder.setOAuthAuthorizationURL("https://api.twitter.com/oauth/authenticate");
        Configuration configuration = configurationBuilder.build();
    	Twitter twitter = new TwitterFactory(configuration).getInstance();
        request.getSession().setAttribute("twitter", twitter);
        try {
            StringBuffer callbackURL = request.getRequestURL();
            int index = callbackURL.lastIndexOf("/");
            callbackURL.replace(index, callbackURL.length(), "").append("/TwitterCallback");

            RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL.toString());
            ;
            request.getSession().setAttribute("requestToken", requestToken);
            response.sendRedirect("https://api.twitter.com/oauth/authenticate?oauth_token="+requestToken.getToken());

        } catch (TwitterException e) {
            throw new ServletException(e);
        }

    }
}
