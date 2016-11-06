/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.webtier.servlet.helper;

import com.tourbuddy.base.Manager.TourManager;

import com.tourbuddy.base.dataminner.Datamine;
import com.tourbuddy.base.entities.Loca;
import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Route;
import com.tourbuddy.base.entities.Survey;
import com.tourbuddy.base.entities.Tour;
import com.tourbuddy.base.entities.User;
import com.tourbuddy.base.entity.dao.LocationDAO;
import com.tourbuddy.base.entity.dao.LocationDAOs;
import com.tourbuddy.base.entity.dao.LocationRouteDAO;
import com.tourbuddy.base.entity.dao.TourDAO;
import com.tourbuddy.base.entity.dao.UserDAO;
import com.tourbuddy.base.meta.comm.MessageToken;
import com.tourbuddy.base.meta.comm.PayloadMapToken;
import com.tourbuddy.base.meta.comm.PayloadToken;
import com.tourbuddy.base.meta.comm.Token;
import com.tourbuddy.base.ontology.TextProcessing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sanduni
 */
public class EntityHelper {

    public static List<Location> changeBudget(Location accommodation) {
        Token token = new MessageToken();
        List<Location> accomList = new LocationDAO().changeBudget(accommodation);
        if (accomList != null) {
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
        }
        return accomList;
    }

    public static Token addTour(Tour tour, int userId) {
        Token token = new MessageToken();
        System.out.println("entity helper done");
        int addData = new TourDAO().addData(tour,userId);
        System.out.println("entity helper done2");
        if (addData > 0) {
            TourManager.getInstance().setTour((int) userId, tour);
            System.out.println("entity helper done3");
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            System.out.println("entity helper done4");
            token.setMessage("Error");
        }
        return token;
    }

    /* public static Token login(User user) {
     Token token = new MessageToken();
     int addData = new UserDAO().login(user);
     if (addData > 0) {
     token.setCode(Token.SUCCESS);
     token.setMessage("Done");
     } else {
     token.setCode(Token.NOT_ALLOWED);
     token.setMessage("Error");
     }
     return token;
     }*/
    public static Token register(User user) {
        Token token = new MessageToken();
        int addData = new UserDAO().addUser(user);

        System.out.println("Sanduni Entity Helper birthdate" + user.getBirthdate());
        if (addData > 0) {
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
        }
        return token;
    }

    //get locations(locations or hotels) according to the selected category
    public static Token getLocationsList(Location location) {
        // Token token = new MessageToken();
        Token token2;

        List<Location> locationList1 = new LocationDAO().getLocationsList(location);
        if (locationList1 != null) {

            token2 = new PayloadToken(locationList1);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");
            //token2.setPayload(locationList1);
        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }

        System.out.println("Prageeth token" + token2.getCode());
        return token2;
    }

    /**
     * get particular location by its location name to display more details
     * modal of the selected location
     *
     * @param location
     * @return
     */
    public static Token getLocation(Location location) {

        Token token2;

        List<Location> locationList1 = new LocationDAO().getLocation(location);
        if (locationList1 != null) {

            token2 = new PayloadToken(locationList1);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");

        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }

        return token2;
    }

    //get location list for particular tour Id to draw the routes
    public static Token getDrawRouteLocations(Route route) {
        // Token token = new MessageToken();
        Token token2;

        List<Route> routeLocationList = new LocationRouteDAO().getDrawRouteLocations(route);
        if (routeLocationList != null) {

            token2 = new PayloadToken(routeLocationList);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");
            //token2.setPayload(locationList1);
        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }

        //System.out.println("Prageeth token" + token2.getCode());
        return token2;
    }

    //get location list for selected map route from the drop down
    public static Token getSelectedRoute(Route route) {
        // Token token = new MessageToken();
        Token token2;

        List<Route> routeLocationList = new LocationRouteDAO().getSelectedRoute(route);
        if (routeLocationList != null) {

            token2 = new PayloadToken(routeLocationList);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");
            //token2.setPayload(locationList1);
        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }

        //System.out.println("Prageeth token" + token2.getCode());
        return token2;
    }
    /*
     //add selected accommodation to the tour table in database
     
     public static Token addSelectedAccom(Location location) {
     Token token = new MessageToken();
     int addData = new LocationDAO().addSelectedAccom(location);

     System.out.println("Sanduni Entity Helper birthdate"+user.getBirthdate());
     if (addData > 0) {
     token.setCode(Token.SUCCESS);
     token.setMessage("Done");
     } else {
     token.setCode(Token.NOT_ALLOWED);
     token.setMessage("Error");
     }
     return token;
     }
     */
    
     public static Token generateCatToTour(String tourname, int userId,Survey survey) {
    PayloadMapToken token = new PayloadMapToken();
        Datamine dm=new Datamine();
        //catogory
        String cat[]=dm.dmResult(survey);
         System.out.println("cate"+cat[0]+cat[1]+cat[2]);
        List<String> catList = new ArrayList<String>();
        catList.add(cat[0]);
        catList.add(cat[1]);
        catList.add(cat[2]);
         System.out.println("hihihihi"+survey.getQ1());
         System.out.println(tourname);
    //    tour.setSelectedCategories("adc");
        int addData = new TourDAO().updateData(tourname,catList);
         Map<String,List<Loca>> catMap = new HashMap<String, List<Loca>>();
       
            catMap = new TourDAO().getCategoryList(catList);
       
        if(!catMap.isEmpty()){
            token.setPayload(catMap);
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
            System.out.println(catMap);
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
            System.out.println("token waradi");
        }
        return token;
    }

    public static Token generateCategoryToTour(String tourname) {

        PayloadMapToken token = new PayloadMapToken();
        TextProcessing tp= new TextProcessing();
        String cat[]=tp.getcategory();
        
         Map<String,List<Loca>> catMap = new HashMap<String, List<Loca>>();
       List<String> catList = new ArrayList<String>();
        catList.add(cat[0]);
        catList.add(cat[1]);
        catList.add(cat[2]);
        System.out.println("My tour"+tourname);
         int addData = new TourDAO().updateData(tourname,catList);
            catMap = new TourDAO().getCategoryList(catList);
       
        if(!catMap.isEmpty()){
            token.setPayload(catMap);
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
            System.out.println(catMap);
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
            System.out.println("token waradi");
        }
        return token;
    }

    public static Token getTours(String user) {
        Token token2;

        List<Tour> locationList1 = new LocationDAO().getTours(user);
        if (locationList1 != null) {

            token2 = new PayloadToken(locationList1);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");

        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }

        return token2;
    }
}
