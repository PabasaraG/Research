/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.webtier.servlet.helper;

import com.tourbuddy.base.entities.Loca;
import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Profile;
import com.tourbuddy.base.entities.Route;
import com.tourbuddy.base.entities.Tour;
import com.tourbuddy.base.entities.User;
import com.tourbuddy.base.entity.dao.LocationDAOs;
import com.tourbuddy.base.entity.dao.LocationRouteDAO;
import com.tourbuddy.base.entity.dao.TourDAOs;
import com.tourbuddy.base.entity.dao.UserDAO;
import com.tourbuddy.base.meta.comm.MessageToken;
import com.tourbuddy.base.meta.comm.PayloadToken;
import com.tourbuddy.base.meta.comm.Token;
import java.util.List;

/**
 *
 * @author Sanduni
 */
public class EntityHelpers {

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

    /**
     * get locations(locations or hotels) according to the selected category
     *
     * @param location
     * @return
     */
    public static Token getLocationsList(Location location) {
        Token token2;
        List<Location> locationList1 = new LocationDAOs().getLocationsList(location);

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

    /**
     * add selected accommodation for tour table
     *
     * @param tour
     * @return
     */
    public static Token addSelectedAccom(Tour tour) {

        Token token = new MessageToken();
        int addData = new LocationDAOs().addSelectedAccom(tour);
        if (addData > 0) {
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
        }
        return token;
    }

    /**
     * get location list for particular tour Id to draw the routes
     *
     * @param route
     * @return
     */
    public static Token getDrawRouteLocations(Route route) {
        Token token2;
        List<Route> routeLocationList = new LocationRouteDAO().getDrawRouteLocations(route);
        if (routeLocationList != null) {
            token2 = new PayloadToken(routeLocationList);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");
        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }
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

        List<Location> locationList1 = new LocationDAOs().getLocation(location);
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

    /**
     * get location list for selected map route from the drop down
     *
     * @param route
     * @return
     */
    public static Token getSelectedRoute(Route route) {
        Token token2;

        List<Route> routeLocationList = new LocationRouteDAO().getSelectedRoute(route);
        if (routeLocationList != null) {

            token2 = new PayloadToken(routeLocationList);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");
        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }
        return token2;
    }

    /**
     * get selected alternative route from db
     *
     * @param route
     * @return
     */
    public static Token getSelectedAlternativeRoute(Route route) {
        Token token2;

        List<Route> routeLocationList = new LocationRouteDAO().getSelectedAlternativeRoute(route);
        if (routeLocationList != null) {

            token2 = new PayloadToken(routeLocationList);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");
        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }
        return token2;
    }

    /**
     * get location list of alternative routes
     *
     * @param alterRoute
     * @return
     */
    public static Token getAlternativeRoute(Route alterRoute) {

        Token token2;
        List<Route> routeLocationList = new LocationRouteDAO().getAlternativeRoute(alterRoute);

        if (routeLocationList != null) {
            token2 = new PayloadToken(routeLocationList);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");
        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }
        return token2;
    }

    /**
     * add or update profile information
     *
     * @param profile
     * @return
     */
    public static Token addUpdateProfile(Profile profile) {

        Token token = new MessageToken();
        int addData = new UserDAO().addUpdateProfile(profile);

        if (addData > 0) {
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
        }
        return token;
    }

    /**
     * update user personal information
     *
     * @param user
     * @return
     */
    public static Token updateUser(User user) {

        Token token = new MessageToken();
        int addData = new UserDAO().updateUser(user);

        if (addData > 0) {
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
        }
        return token;
    }

    public static Token addSelectedRoute(Tour sroute) {

        Token token = new MessageToken();
        int addData = new TourDAOs().addSelectedRoute(sroute);
        if (addData > 0) {
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
        }
        return token;
    }

    /**
     * get summary route info
     *
     * @param alterRoute
     * @return
     */
    public static Token getSummary(Route alterRoute) {

        Token token2;
        List<Tour> routeLocationList = new LocationRouteDAO().getSummary(alterRoute);
        if (routeLocationList != null) {
            token2 = new PayloadToken(routeLocationList);
            token2.setCode(Token.SUCCESS);
            token2.setMessage("Done");
        } else {
            token2 = new PayloadToken();
            token2.setCode(Token.NOT_ALLOWED);
            token2.setMessage("Error");
        }
        return token2;
    }

    public static Token addSelectedLocs(Tour plcTour) {
        Token token = new MessageToken();
        int addData = new LocationDAOs().addSelectedLocs(plcTour);
        if (addData > 0) {
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
        }
        return token;
    }

    public static Token getLocations(String lname) {
        Token token2;

        List<Loca> locationList1 = new LocationDAOs().getLocations(lname);
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

    public static Token updateTourDates(Tour updatetourdates) {

        Token token = new MessageToken();
        int addData = new LocationRouteDAO().updateTourDates(updatetourdates);

        if (addData > 0) {
            token.setCode(Token.SUCCESS);
            token.setMessage("Done");
        } else {
            token.setCode(Token.NOT_ALLOWED);
            token.setMessage("Error");
        }
        return token;
    }
}


