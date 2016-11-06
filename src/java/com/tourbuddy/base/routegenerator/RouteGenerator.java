/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.routegenerator;

import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Route;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Sanduni
 */
public class RouteGenerator {

    /**
     * This method is to take the minimum route between the path To do this one
     * use the direction API and take all the paths between two directions and
     * take the minimum one Start from the source and check all the other nodes
     * to take the nearest one. ex : if we have the paths like 1 to 2 , 1 to 3 ,
     * 1 to 4 take 1 to 2 shortest path take 1 to 3 shortest path take 1 to 4
     * shortest path
     *
     * @param locations_details_ontology
     * @return
     * @throws JSONException
     */
    public ArrayList<Route> RouteFinder(ArrayList<Location> locations_details_ontology)
            throws JSONException {

        Route route = new Route();

        // Array to hold shortest routes with details
        ArrayList<Route> Original_route_List = new ArrayList<Route>();

        // Temporary route object to create route.
        Route TempRoute = new Route();
        RoutesServiceResource places_routes = new RoutesServiceResource();

        String origin_Longitude = locations_details_ontology.get(0).getLongitude();
        String origin_latitude = locations_details_ontology.get(0).getLatitude();

        System.out.println("origin lat and long :" + origin_Longitude + " " + origin_latitude);

        for (int k = 1; k <= locations_details_ontology.size() - 1; k++) {
            String des_longitude = locations_details_ontology.get(k)
                    .getLongitude();
            String des_latitude = locations_details_ontology.get(k).getLatitude();

            System.out.println("destination lat and long :" + des_longitude + " " + des_latitude);

            // get all the routes of the source and destination. (all legs)
            JSONArray result = places_routes.placesRoutes(origin_Longitude,
                    origin_latitude, des_longitude, des_latitude);

            System.out.println("JSON result :" + result);

            JSONObject distanceObject = null;
            JSONObject durationObject = null;
            JSONArray steps[] = null;
            double distance;
            int duration;
            double mindistance = 1440;

            // array to hold the each and every points in longitude and latitude
            ArrayList<String> points = null;
            // Array List to Store all the routes of source to
            // destination
            ArrayList<Route> Temp_route_List = new ArrayList<Route>();

            // loop all result (legs) to find the shortest path and take it.
            for (int n = 0; n < result.length(); n++) {
                TempRoute = new Route();
                points = new ArrayList<String>();
                JSONArray legarray = result.getJSONArray(n);
                /* System.out.println(legarray.getJSONObject(0)); */

                distanceObject = (JSONObject) legarray.getJSONObject(0).get(
                        "distance");
                System.out.println("distanceObject :" + distanceObject);

                durationObject = (JSONObject) legarray.getJSONObject(0).get(
                        "duration");
                System.out.println("durationObject :" + durationObject);

                String distanceTemp = distanceObject.get("text").toString()
                        .replace(" m", " km").replaceFirst(" km", "");
                System.out.println("distanceTemp :" + distanceTemp);
                // get distance
                distance = Double.parseDouble(distanceTemp);

                // get duration
                String hours = "0";
                String mins = "0";

                if (durationObject.get("text").toString().contains(" hour ")
                        || durationObject.get("text").toString()
                        .contains(" hours ")) {
                    String[] durationTemp = durationObject.get("text")
                            .toString().replace(" hour ", " hours ")
                            .split(" hours ");

                    hours = durationTemp[0];
                    mins = durationTemp[1].replace(" mins", "");
                    mins = mins.replace(" min", "");

                    System.out.println("Duration Temp :" + durationTemp[0]);
                } else if (durationObject.get("text").toString()
                        .contains(" min")
                        || durationObject.get("text").toString()
                        .contains(" mins ")) {
                    hours = "0";
                    String[] durationTemp = durationObject.get("text")
                            .toString().replace(" min", " mins ")
                            .split(" mins ");
                    mins = durationTemp[0];
                }

                // take whole duration in minutes
                duration = (Integer.parseInt(hours) * 60)
                        + Integer.parseInt(mins);

                // set the duration and distance of the route
                TempRoute.setDuration(duration);
                TempRoute.setDistance(distance);

                // set source to temp Route
                TempRoute.setSourcePlaceName(locations_details_ontology.get(0)
                        .getLocationName());
                TempRoute.setSourceLongitude(locations_details_ontology.get(0)
                        .getLongitude());
                TempRoute.setSourceLatitude(locations_details_ontology.get(0)
                        .getLatitude());

                // set Destination to temp Route
                TempRoute.setDestinationPlaceName(locations_details_ontology
                        .get(k).getLocationName());

                TempRoute.setDestinationLongitude(locations_details_ontology
                        .get(k).getLongitude());
                TempRoute.setDestinationLatitude(locations_details_ontology.get(k)
                        .getLatitude());
                // take all steps (points) with polly line
                JSONArray stepsArray = (JSONArray) legarray.getJSONObject(0)
                        .getJSONArray("steps");

                // take polyline from the legs array
                for (int l = 0; l < stepsArray.length(); l++) {
                    JSONObject end_Location = stepsArray.getJSONObject(l);

                    JSONObject p = end_Location.getJSONObject("polyline");

                    String ll = p.get("points").toString();

                    points.add(ll);

                }

                TempRoute.setPoints(points);

                Temp_route_List.add(TempRoute);

                if (mindistance > distance) {
                    mindistance = distance;

                }

            }

            for (int p = 0; p < Temp_route_List.size(); p++) {
                if (Temp_route_List.get(p).getDistance() == mindistance) {

                    Original_route_List.add(Temp_route_List.get(p));

                }

            }
        }

        for (int i = 0; i < Original_route_List.size(); i++) {
            System.out.println("-----------------------------------");
            System.out.println("duration"
                    + Original_route_List.get(i).getDuration());
            System.out.println("SAAAAAAA-----------------------------------");
        }
        for (Route rou : Original_route_List) {
            System.out.println("Final Original route list :" + rou.getDistance());
        }
        return Original_route_List;
    }
}
