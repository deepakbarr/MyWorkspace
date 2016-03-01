package com.hackathon.tunesbot.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by deepak.barr on 24/2/15.
 */
public class HWServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.getWriter().print("Hello, This is data manager !!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
