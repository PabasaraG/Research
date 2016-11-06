/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.routegenerator;

import com.tourbuddy.base.entities.Location;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Sanduni
 */
public class RoutesServiceResource {

    //API Url
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/directions/json?";

    // KEY!
    private static final String API_KEY = "AIzaSyBrzT8bu0oHcilfGtBUJkaQBU-XJ441sWs";

    // take all the routes bteween specified places
    public JSONArray placesRoutes(String origin_longitude,
            String origin_latitude, String des_longitude, String des_latitude) {

        ArrayList<Location> resultList = null;
        double rate = 0;
        JSONArray legsArray = legsArray = new JSONArray();
        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE);
            sb.append("alternatives=" + true);
            sb.append("&origin=" + origin_latitude + "," + origin_longitude);
            sb.append("&destination=" + des_latitude + "," + des_longitude);
            sb.append("&key=" + API_KEY);

            URL url = new URL(sb.toString());

            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }

            try {
                JSONObject jsonObj = new JSONObject(jsonResults.toString());
                JSONArray routesArray = jsonObj.getJSONArray("routes");

                for (int n = 0; n < routesArray.length(); n++) {

                    JSONObject object = routesArray.getJSONObject(n);
                    // System.out.println(object.getJSONArray("legs"));

                    legsArray.put(object.getJSONArray("legs"));
                    // System.out.println(legsArray.get(0));

                }

                return legsArray;

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } catch (MalformedURLException e) {

            return null;
        } catch (IOException e) {

            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return legsArray;
    }
}
