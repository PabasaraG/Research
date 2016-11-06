/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.webtier.servlet;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tourbuddy.base.entities.User;
import com.tourbuddy.base.entity.dao.UserDAO;
import com.tourbuddy.base.meta.comm.MessageToken;
import com.tourbuddy.base.meta.comm.PayloadListToken;
import com.tourbuddy.base.meta.comm.Token;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sanduni
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Token token = null;

        String strObject = request.getParameter("data");
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder()).create();
        User user = gson.fromJson(strObject, User.class);
        if (user.getUsername() == null || user.getPassword() == null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect(request.getServletContext().getContextPath() + "/signin.jsp");
        } else {
            try {
                User user1 = new UserDAO().login(user);
                if (user1 != null) {
                    HttpSession httpSession = request.getSession(true);
                    httpSession.setAttribute("userSession", user1);
                    httpSession.setAttribute("user_name", user1.getUsername());
                    httpSession.setAttribute("first_name", user1.getFirstname());
                    httpSession.setAttribute("last_name", user1.getLastname());
                    httpSession.setAttribute("birth_date", user1.getBirthdate());
                    httpSession.setAttribute("country", user1.getCountry());
                    httpSession.setAttribute("gender", user1.getGender());
                    httpSession.setAttribute("user_image", user1.getUserImage());
                    httpSession.setMaxInactiveInterval(720000);

                    System.out.println("Sanduni LOGIN FACADE " + user1.getCountry());

                    List<User> tempUserList = new ArrayList<User>();
                    token = new PayloadListToken(tempUserList);
                    token.setCode(Token.SUCCESS);
                    token.setMessage("Login success !");
                    System.out.println("Prageeth Token LOGIN FACADE " + token.getCode());
                } else {
                    token = new MessageToken();
                    token.setCode(Token.UNAUTHORIZED);
                    token.setMessage("Login failed");
                    System.out.println("Prageeth Sanduni LOGIN FACADE " + token.getCode());
                }
            } catch (NumberFormatException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.WARNING, null, ex);
                token = new MessageToken();
                token.setCode(Token.UNAUTHORIZED);
                token.setMessage("Login failed");
            }

            response.setContentType("applicaton/json;charset=UTF-8");
            //nee d try-carch
            PrintWriter out = response.getWriter();
            gson.toJson(token, out);
            out.flush();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
