/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.routegenerator;

import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Route;
import com.tourbuddy.base.entities.Tour;
import com.tourbuddy.base.entities.User;
import com.tourbuddy.base.entity.dao.LocationDAOs;
import com.tourbuddy.base.entity.dao.LocationRouteDAO;
import com.tourbuddy.base.entity.dao.TourDAOs;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author Sanduni
 */
public class RouteGeneratorCaller {

    public void routeOrderFinder(String tourName) {

        //get all location list from the database
        List<Location> allLocationList = new LocationDAOs().getAllLocationsList();

        for (Location location : allLocationList) {
            System.out.println(location.getLocationName() + "----"
                    + location.getDescription());
            //System.out.println(location.getPoints());
        }

        //get user selected location list from tour table
        Tour tour = new Tour();
        tour.setTourName(tourName);//newwwwwwwwwwwwwwww codeeeeeee
        Tour selectedLocationList = new LocationDAOs().getSelectedLocationsList(tour);

        System.out.println("selected Locs for tour: " + selectedLocationList.getSelectedLocs());
        String[] selectedAccomArray = selectedLocationList.getSelectedAccom().split(",");
        String[] all = selectedLocationList.getSelectedLocs().split(",");
        String[] selectedLocsArray = (String[]) ArrayUtils.addAll(selectedAccomArray, all);//all selected location and accommodation

        //print array after splitting
        for (String loc : selectedLocsArray) {
            System.out.println("After Splitting ALL ARRAY:" + loc);
        }

        //to hold the location info of accommodation to set index 0 after ordering
        Location accom = new Location();
        for (int i = 0; i < selectedLocsArray.length; i++) {
            for (Location location : allLocationList) {
                if (selectedLocsArray[0].equalsIgnoreCase(location.getLocId())) {
                    accom.setLocationId(location.getLocationId());
                    accom.setLocationName(location.getLocationName());
                    accom.setLatitude(location.getLatitude());
                    accom.setLongitude(location.getLongitude());
                }
            }
        }

        //to hold the accommodation for final route array
        Route raccom = new Route();
        raccom.setDestinationPlaceName(accom.getLocationName());

        //take all the details from allLocationList for the selected Locs to ontology array list to send algo
        ArrayList<Location> locations_details_ontology = new ArrayList();
        for (int i = 0; i < selectedLocsArray.length; i++) {
            for (Location location : allLocationList) {
                if (selectedLocsArray[i].equalsIgnoreCase(location.getLocId())) {
                    Location l = new Location();
                    l.setLocationId(location.getLocationId());
                    l.setLocationName(location.getLocationName());
                    l.setLatitude(location.getLatitude());
                    l.setLongitude(location.getLongitude());
                    locations_details_ontology.add(l);
                }
            }
        }

        //to print locations_details_ontology
        for (Location location : locations_details_ontology) {
            System.out.println(location.getLocationName() + "----"
                    + location.getLatitude() + "----" + location.getLongitude());
        }

        ArrayList<Location> finalOrderedArray = new ArrayList<Location>();
        ArrayList<Route> finalRoutes = new ArrayList<Route>();
        int position = 0;

        try {
            for (int i = 0; i < locations_details_ontology.size(); i++) {

                ArrayList<Route> routes = new RouteGenerator().RouteFinder(locations_details_ontology);//call algo
                Route r = new Route();

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

                finalRoutes.add(r);

                for (int j = 0; j < locations_details_ontology.size(); j++) {
                    if (locations_details_ontology.get(j).getLocationName()
                            .equals(r.getDestinationPlaceName())) {
                        System.out.println("lol");

                        locations_details_ontology.set(0,
                                locations_details_ontology.get(j));

                        if (!(locations_details_ontology.get(j).equals("lol"))) {
                            locations_details_ontology.get(j).setPosition(Integer.toString(position));
                            finalOrderedArray.add(locations_details_ontology
                                    .get(j));
                        }

                        locations_details_ontology.remove(j);

                    }
                    // to start for loop begin again
                    i = 0;
                }
            }
            accom.setPosition("0");
            for (Location location : finalOrderedArray) {
                System.out.println("Final Ordered Array :" + location.getLocationName() + " " + location.getPosition()
                );
            }
            raccom.setDistance(0);
            raccom.setDuration(0);
            raccom.setDate("1");

            for (Route r : finalRoutes) {
                System.out.println("Final Ordered  ROUTE Array :" + r.getDistance() + " " + r.getDuration() + " " + r.getDestinationPlaceName()
                );
            }

            Tour to = new Tour();
            to.setTourName(tourName);
            User us = new User();
            us.setUserId(1);

            finalRoutes = new CustomizeRoute().DayPlanner(finalRoutes, allLocationList);

            ArrayList<Location> finalOrderedArrayDb = new ArrayList<Location>();
            finalOrderedArrayDb.add(accom);
            for (Location fl : finalOrderedArray) {
                finalOrderedArrayDb.add(fl);
            }

            ArrayList<Route> finalRoutesDb = new ArrayList<Route>();

            finalRoutesDb.add(raccom);
            System.out.println("raccom valur :" + raccom.getDestinationPlaceName());
            for (Route r : finalRoutes) {
                finalRoutesDb.add(r);
            }

            for (Route r : finalRoutesDb) {
                System.out.println("Bfore going to db final Routes db array :" + r.getDestinationPlaceName());
            }
            for (Location lo : finalOrderedArrayDb) {
                System.out.println("Bfore going to db final Ordered db array :" + lo.getLocationName());
            }

            int res = new LocationRouteDAO().addRoute(finalOrderedArrayDb, finalRoutesDb, to, us);

            if (res == 1) {
                System.out.println("SUCCESS!");
            } else {
                System.out.println("FAILED!");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
