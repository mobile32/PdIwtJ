package com.example.guestbook;

import com.google.appengine.api.users.*;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mobil on 16.11.2016.
 */

public class RegistrationServlet extends HttpServlet {

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user;

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (email != null) {
            user = new User(login, password, email);
        } else {
            user = new User(login, password);
        }

        ObjectifyService.ofy().save().entity(user).now();

        resp.sendRedirect("/registrationpage.jsp");
    }
}