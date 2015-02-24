package com.app.ds.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by deepak.barr on 24/2/15.
 */
public class HWServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.getWriter().print("Hello, GAE");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
