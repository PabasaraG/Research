/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.routegenerator;

import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Route;
import com.tourbuddy.base.entities.Tour;
import com.tourbuddy.base.entity.dao.LocationDAOs;
import com.tourbuddy.base.entity.dao.LocationRouteDAO;
import com.tourbuddy.base.entity.dao.TourDAOs;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author Sanduni
 */
public class AlternativeTourPlanGenerator {

    public void suggestTourPlan(Tour alternativeRoute) throws JSONException, ParseException {

        //get tour details-need tourId
        String tourId = alternativeRoute.getTourName(); //get this from session
        Tour tourDetails = new TourDAOs().getTour(alternativeRoute.getTourName());
        System.out.println("Tour Details :" + tourDetails.getStartDate() + " " + tourDetails.getEndDate());
       
        String start = tourDetails.getStartDate().substring(8);
        String end = tourDetails.getEndDate().substring(8);
        int tourDuration = Integer.parseInt(end) - Integer.parseInt(start);
        System.out.println("REAL DATE :" + start + " " + end + " " + tourDuration);

        //get premium route  details
        List<Route> routeDetails = new LocationRouteDAO().getDefaultRoute(tourId);
        //to print the locations of default route
        for (Route route : routeDetails) {
            System.out.println("Default Route list :" + route.getLocationId());
            //System.out.println(location.getPoints());
        }

        int position = 0;
        int i = 0;
        ArrayList<Route> finalRoutes = new ArrayList<Route>();
        Route r = new Route();

        Route hotel = new Route();
        hotel.setDestinationPlaceName(routeDetails.get(0).getSourcePlaceName());
        hotel.setDestinationLatitude(routeDetails.get(0).getSourceLatitude());
        hotel.setDestinationLongitude(routeDetails.get(0).getSourceLongitude());
        finalRoutes.add(hotel);

        System.out.println("before proceeding with the loop :" + finalRoutes.get(0).getDestinationPlaceName());

        //new code starts here
        for (Route route : routeDetails) {

            //get the location name of each location of the premium route
            String locName = route.getDestinationPlaceName();

            //find the category of the locName
            String locNameCategory = new LocationDAOs().getCategoryLocName(locName);

            //get all the locations that belongs to that category
            List<Location> categoryLocList = new ArrayList();
            categoryLocList = new LocationDAOs().getAllLocationsCategory(locNameCategory);

            //the location array that sends to the route generator algorithm
            ArrayList<Location> locations_details_ontology = new ArrayList();

            //to add the accommodation location as the first to the ontology array
            i++;

            Location loc1 = new Location();
            loc1.setLocationName(finalRoutes.get(finalRoutes.size() - 1).getDestinationPlaceName());
            loc1.setLatitude(finalRoutes.get(finalRoutes.size() - 1).getDestinationLatitude());
            loc1.setLongitude(finalRoutes.get(finalRoutes.size() - 1).getDestinationLongitude());
            locations_details_ontology.add(loc1);
            
           
            for (Location loc : categoryLocList) {

                if (!locations_details_ontology.get(0).getLocationName().equals(loc.getLocationName())) {
                    Location l = new Location();
                    l.setLocationName(loc.getLocationName());
                    l.setLatitude(loc.getLatitude());
                    l.setLongitude(loc.getLongitude());
                    locations_details_ontology.add(l);
                }
            }
           
            //to print locations_details_ontology
            for (Location location : locations_details_ontology) {
                System.out.println(location.getLocationName() + "----"
                        + location.getLatitude() + "----" + location.getLongitude());
                //System.out.println(location.getPoints());
            }

            //call the lagorithm to find out nearest locations to the first location in ontology array
            ArrayList<Route> routes = new RouteGenerator().RouteFinder(locations_details_ontology);

            // Loop all the routes to take the minimum distance of route.
            double min = 0;
            for (int k = 0; k < routes.size(); k++) {

                System.out.println(routes.get(k).getDistance());
                min = routes.get(0).getDistance();
                if (min >= routes.get(k).getDistance()) {
                    min = routes.get(k).getDistance();
                    r = routes.get(k);
                }
            }
            position++;
            r.setPosition(Integer.toString(position));

            boolean res = false;
            for (Route avail : finalRoutes) {

                if (r.getDestinationPlaceName().equals(avail.getDestinationPlaceName())) {
                    res = true;
                }

            }
            if (res == false) {
                finalRoutes.add(r);
            }
            
            //to print final routes array
            for (Route fr : finalRoutes) {
                System.out.println("FINAL ROUTES ARRAY SANDUNI :" + fr.getDestinationPlaceName());
            }

        }

        //get all location list from the database
        List<Location> allLocationList = new LocationDAOs().getAllLocationsList();
        // finalRoutes = new CustomizeRoute().DayPlanner(finalRoutes, allLocationList);

        //int m=0;
        //for (int es = 0; es <= m; es++) {
        for (int es = 0; es <= 4; es++) {
            finalRoutes = new CustomizeRoute().DayPlanner(finalRoutes, allLocationList);

            int estimatedDuration = Integer.parseInt(finalRoutes.get(finalRoutes.size() - 1).getDate());

            if (tourDuration < estimatedDuration) {
                finalRoutes.remove(finalRoutes.size() - 1);
                //m++;

            }
        }

        //print final routes array after customizing routes
        for (Route fr : finalRoutes) {
            System.out.println("FINAL ROUTES ARRAY ACCORDING TO DA PLAN :" + fr.getDestinationPlaceName() + " " + fr.getDate());
        }

        //add alternative route to db
        int res = new LocationRouteDAO().addAlternativeRoute(finalRoutes, alternativeRoute.getTourName());

        if (res == 1) {
            System.out.println("SUCCESS!");
        } else {
            System.out.println("FAILED!");
        }

    }
}
