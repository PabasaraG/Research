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
import com.tourbuddy.base.meta.comm.MessageToken;
import com.tourbuddy.base.meta.comm.Token;
import com.tourbuddy.base.webtier.servlet.helper.EntityHelpers;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeParseException;
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
 * @author sanduni
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    public enum Command {

        REGISTER
    }

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
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder()).create();
        try {
            String cmd = request.getParameter("cmd");
            String strObject;
            switch (EntityFacade.Command.valueOf(cmd)) {

                //user registration
                case REGISTER:
                    strObject = request.getParameter("data");
                    User user1 = gson.fromJson(strObject, User.class);
                    HttpSession httpSession1 = request.getSession(true);
                    httpSession1.setAttribute("userSession", user1);
                    httpSession1.setAttribute("user_name", user1.getUsername());
                    httpSession1.setAttribute("user_image", user1.getUserImage());
                    httpSession1.setMaxInactiveInterval(720000);
                    token = EntityHelpers.register(user1);
                    break;

        }

    }
        catch (NullPointerException ex) {
            token = new MessageToken();
            token.setCode(Token.INTE_SERVER_ERROR);
            token.setMessage("Error occured during process, please contact system administrator ");
            Logger.getLogger(EntityFacade.class.getName()).log(Level.WARNING, null, ex);
        } catch (DateTimeParseException ex) {
            token = new MessageToken();
            token.setCode(Token.CONFLICT);
            token.setMessage("Invalid input parameters ");
            Logger.getLogger(EntityFacade.class.getName()).log(Level.WARNING, null, ex);
        } catch (NumberFormatException ex) {
            token = new MessageToken();
            token.setCode(Token.CONFLICT);
            token.setMessage("Invalid input parameters ");
            Logger.getLogger(EntityFacade.class.getName()).log(Level.WARNING, null, ex);
        }

        response.setContentType("application/json");
        //nee d try-carch
        PrintWriter out = response.getWriter();
        gson.toJson(token, out);
        out.flush();
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
