/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.webtier.servlet;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tourbuddy.base.entities.Loca;
import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Profile;
import com.tourbuddy.base.entities.Route;
import com.tourbuddy.base.entities.Survey;
import com.tourbuddy.base.entities.Tour;
import com.tourbuddy.base.entities.User;
import com.tourbuddy.base.meta.comm.MessageToken;
import com.tourbuddy.base.meta.comm.PayloadListToken;
import com.tourbuddy.base.meta.comm.Token;
import com.tourbuddy.base.ontology.OntologyConnector_1;
import com.tourbuddy.base.routegenerator.AlternativeTourPlanGenerator;
import com.tourbuddy.base.routegenerator.RouteGeneratorCaller;
import com.tourbuddy.base.webtier.servlet.helper.EntityHelper;
import com.tourbuddy.base.webtier.servlet.helper.EntityHelpers;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author Sanduni
 */
@WebServlet(name = "EntityFacade", urlPatterns = {"/EntityFacade"})
public class EntityFacade extends HttpServlet {

    public enum Command {

        ADD_TOUR,
        LOGIN,
        REGISTER,
        GETDIRECTION,
        GETLOCATIONS,
        GETSELECTEDLOCATION,
        ADD_SELECTED_ACCOM,
        ROUTEGEN,
        ALTERNATIVEROUTEGEN,
        DRAWROUTE,
        SELECTEDROUTE,
        ADDUPDATEPROFILE,
        UPDATEUSER,
        ADDSELECTEDACCOM,
        DRAWALTERNATIVEROUTE,
        ADDSELECTEDROUTE,
        GETSUM,
        SELECTEDALTERNATIVEROUTE,
        GETSURVEY,
        GETTWITTER,
        ADDSELECTEDLOCS,
        GETSELECTEDLOCATIONS,
        GETTOURS,
        ONTOLOGY_LOCATION,
        GETACCOMS,
        UPDATETOURDATES

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
            throws ServletException, IOException, JSONException, ParseException {
        HttpSession session = request.getSession(true);
        HttpSession httpSession = request.getSession(true);
        Token token = null;
        Tour tour = null;
        User user = null;
        if (session != null) {
            user = (User) session.getAttribute("userSession");
            if (user == null) {
                response.sendRedirect(request.getServletContext().getContextPath() + "/signin.jsp");
            }
        } else {
            response.sendRedirect(request.getServletContext().getContextPath() + "/signin.jsp");
        }

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

                case GETDIRECTION:
                    strObject = request.getParameter("data");
                    Route route = gson.fromJson(strObject, Route.class);
                    break;

                //get accommodation list for selected category
                case GETLOCATIONS:
                    strObject = request.getParameter("data");
                    Location location = gson.fromJson(strObject, Location.class);
                    token = EntityHelpers.getLocationsList(location);
                    break;

                case GETSELECTEDLOCATION:
                    strObject = request.getParameter("data");
                    Location onelocation = gson.fromJson(strObject, Location.class);
                    token = EntityHelpers.getLocation(onelocation);
                    break;

                //start route generator
                case ROUTEGEN:
                    Tour tourn = new Tour();
                    tourn.setTourName(httpSession.getAttribute("tourname").toString());
                    new RouteGeneratorCaller().routeOrderFinder(tourn.getTourName());
                    break;

                //generate alternative that fits with the user specified tour duration   
                case ALTERNATIVEROUTEGEN:
                    //strObject = request.getParameter("data");
                    Tour alternativeRoute = new Tour();
                    alternativeRoute.setTourName(httpSession.getAttribute("tourname").toString());
                    new AlternativeTourPlanGenerator().suggestTourPlan(alternativeRoute);
                    break;

                //get default route details to draw
                case DRAWROUTE:
                    //strObject = request.getParameter("data");
                    Route drawRoute = new Route();
                    drawRoute.setTourId(httpSession.getAttribute("tourname").toString());
                    
                    token = EntityHelpers.getDrawRouteLocations(drawRoute);
                    break;

                //get selected route map from the db
                case SELECTEDROUTE:
                    strObject = request.getParameter("data");
                    Route getSelectedRoute = gson.fromJson(strObject, Route.class);
                    getSelectedRoute.setTourId(httpSession.getAttribute("tourname").toString());
                    token = EntityHelpers.getSelectedRoute(getSelectedRoute);
                    break;

                case ADDUPDATEPROFILE:
                    strObject = request.getParameter("data");
                    Profile profile = gson.fromJson(strObject, Profile.class);
                    token = EntityHelpers.addUpdateProfile(profile);
                    break;

                case UPDATEUSER:
                    strObject = request.getParameter("data");
                    User updateUser = gson.fromJson(strObject, User.class);
                    token = EntityHelpers.updateUser(updateUser);
                    break;

                //add selected accommodation for tour table
                case ADDSELECTEDACCOM:
                    strObject = request.getParameter("data");
                    Tour accomTour = gson.fromJson(strObject, Tour.class);
                    accomTour.setTourName(httpSession.getAttribute("tourname").toString());
                    token = EntityHelpers.addSelectedAccom(accomTour);
                    break;

                //get generated alternative route to draw to the map
                case DRAWALTERNATIVEROUTE:
                    strObject = request.getParameter("data");
                    Route alterRoute = new Route();
                    alterRoute.setTourId(httpSession.getAttribute("tourname").toString());
                    token = EntityHelpers.getAlternativeRoute(alterRoute);
                    break;

                case ADDSELECTEDROUTE:
                    strObject = request.getParameter("data");
                    Tour sroute = gson.fromJson(strObject, Tour.class);
                    HttpSession httpSession2 = request.getSession(true);
                    httpSession2.setAttribute("tour_add", sroute);
                    httpSession2.setAttribute("tour_name", sroute.getTourName());
                    httpSession2.setAttribute("selected_route", sroute.getSelectedRoute());
                    httpSession2.setMaxInactiveInterval(720000);
                    break;

                case GETSUM:
                    //strObject = request.getParameter("data");
                    Route sum = new Route();
                    sum.setTourId(httpSession.getAttribute("tourname").toString());
                    token = EntityHelpers.getSummary(sum);
                    break;

                //get selected alternative route map from the db
                case SELECTEDALTERNATIVEROUTE:
                    strObject = request.getParameter("data");
                    Route getSelectedAlternativeRoute = gson.fromJson(strObject, Route.class);
                    getSelectedAlternativeRoute.setTourId(httpSession.getAttribute("tourname").toString());
                    token = EntityHelpers.getSelectedAlternativeRoute(getSelectedAlternativeRoute);
                    break;

                case ADD_TOUR:
                    strObject = request.getParameter("data");
                    tour = gson.fromJson(strObject, Tour.class);
                    System.out.println("facade done");

                    httpSession.setAttribute("tourSession", tour);
                    httpSession.setAttribute("tourID", tour.getTourId());
                    httpSession.setAttribute("tourname", tour.getTourName());
                    httpSession.setAttribute("tour_accom_type", tour.getAccType());
                    httpSession.setAttribute("start_date", tour.getStartDate());
                    httpSession.setAttribute("end_date", tour.getEndDate());

                    httpSession.setMaxInactiveInterval(720000);
                    token = EntityHelper.addTour(tour, user.getUserId());
                    System.out.println(user.getUserId());
                    System.out.println("facade done 2");
                    break;

                case GETSURVEY:
                    strObject = request.getParameter("data");
                    Survey sv = gson.fromJson(strObject, Survey.class);

                    System.out.println(httpSession.getAttribute("tourname"));
                    //System.out.println("hhhhhh"+tour.getTourName());

                    token = EntityHelper.generateCatToTour(httpSession.getAttribute("tourname").toString(), user.getUserId(), sv);
                    System.out.println(sv.getQ1() + sv.getQ2());
                    break;

                case GETTWITTER:
                    //  Twitter twitter = TwitterManager.getInstance().getTwitter();
                    System.out.println(httpSession.getAttribute("tourname"));
                    token = EntityHelper.generateCategoryToTour(httpSession.getAttribute("tourname").toString());
                    break;

                case ADDSELECTEDLOCS:
                    strObject = request.getParameter("data");

                    System.out.print(httpSession.getAttribute("tourname"));
                    Tour plcTour = gson.fromJson(strObject, Tour.class);
                    plcTour.setTourName(httpSession.getAttribute("tourname").toString());
                    token = EntityHelpers.addSelectedLocs(plcTour);
                    break;

                case GETSELECTEDLOCATIONS:
                    strObject = request.getParameter("data");
                    Loca onelocation1 = gson.fromJson(strObject, Loca.class);
                    token = EntityHelpers.getLocations(onelocation1.getLname());
                    break;

                case GETTOURS:
                    System.out.println(httpSession.getAttribute("user_name").toString());
                    token = EntityHelper.getTours(httpSession.getAttribute("user_name").toString());

                    System.out.println();
                    break;

                case ONTOLOGY_LOCATION:
                    strObject = request.getParameter("data");
                    ArrayList<Location> locationDetail = new OntologyConnector_1().getLocationDetail(strObject);

                    if (!locationDetail.isEmpty()) {
                        token = new PayloadListToken();
                        ((PayloadListToken) token).setPayload(locationDetail);
                        token.setCode(Token.SUCCESS);
                        token.setMessage("Result List");
                    } else {
                        token = new MessageToken();
                        token.setCode(Token.BAD_REQUEST);
                        token.setMessage("Empty List");
                    }
                    break;

                case UPDATETOURDATES:
                    strObject = request.getParameter("data");
                    //System.out.print(httpSession.getAttribute("tourname"));
                    Tour updatetourdates = gson.fromJson(strObject, Tour.class);
                    updatetourdates.setTourName(httpSession.getAttribute("tourname").toString());
                    String sdate = httpSession.getAttribute("start_date").toString().substring(8);
                    int newEnd = Integer.parseInt(sdate) + Integer.parseInt(updatetourdates.getEndDate());
                    String firstpartdate = httpSession.getAttribute("start_date").toString().substring(0, 8);
                    firstpartdate = firstpartdate + String.valueOf(newEnd);
                    updatetourdates.setEndDate(firstpartdate);
                    token = EntityHelpers.updateTourDates(updatetourdates);
                    break;
                case GETACCOMS:
                    Location location1 = new Location();
                    location1.setCategory(httpSession.getAttribute("tour_accom_type").toString());
                    token = EntityHelpers.getLocationsList(location1);
                    break;

            }
        } catch (NullPointerException ex) {
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

        response.setContentType("applicaton/json;charset=UTF-8");
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(EntityFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EntityFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(EntityFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EntityFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
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
