/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.entity.dao;

import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Route;
import com.tourbuddy.base.entities.Tour;
import com.tourbuddy.base.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanduni
 */
public class LocationRouteDAO {

    ConnectionManager connectionManager;

    public LocationRouteDAO() {
        connectionManager = ConnectionManager.getInstance();
    }

    /**
     * add generated default route to the route table
     *
     * @param finalOrderedArray
     * @param finalRoutes
     * @param tour
     * @param user
     * @return
     */
    public int addRoute(ArrayList<Location> finalOrderedArray, ArrayList<Route> finalRoutes, Tour tour, User user) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {

            for (int i = 0; i <= finalOrderedArray.size() - 1; i++) {
                String query = "insert into route(tourId,source,destination,position,distance,time,date,pathType,sourceLatitude,sourceLongitude,destinationLatitude,destinationLongitude) values(?,?,?,?,?,?,?,?,?,?,?,?);";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, tour.getTourName());
                preparedStatement.setString(2, finalOrderedArray.get(i).getLocationName());
                preparedStatement.setString(3, finalOrderedArray.get(i + 1).getLocationName());
                preparedStatement.setString(4, finalOrderedArray.get(i + 1).getPosition());
                preparedStatement.setDouble(5, finalRoutes.get(i + 1).getDistance());
                preparedStatement.setDouble(6, finalRoutes.get(i + 1).getDuration());
                preparedStatement.setString(7, finalRoutes.get(i + 1).getDate());
                preparedStatement.setString(8, "Premium");
                preparedStatement.setString(9, finalOrderedArray.get(i).getLatitude());
                preparedStatement.setString(10, finalOrderedArray.get(i).getLongitude());
                preparedStatement.setString(11, finalOrderedArray.get(i + 1).getLatitude());
                preparedStatement.setString(12, finalOrderedArray.get(i + 1).getLongitude());

                System.out.println(query);
                result = preparedStatement.executeUpdate();
                if (result > 0) {
                    result = 1;
                }
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return result;
    }

    /**
     * get default route details from route table to draw directions
     *
     * @param route
     * @return
     */
    public List<Route> getDrawRouteLocations(Route route) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        List<Route> routeLocationList = new ArrayList();
        int result = -1;
        try {
            String query = "select * from route where tourId=? and pathType=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, route.getTourId());
            preparedStatement.setString(2, "premium");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                Route a = new Route();
                a.setTourId(resultSet.getString("tourId"));
                a.setSourcePlaceName(resultSet.getString("source"));
                a.setDestinationPlaceName(resultSet.getString("destination"));
                a.setSourceLatitude(resultSet.getString("sourceLatitude"));
                a.setSourceLongitude(resultSet.getString("sourceLongitude"));
                a.setDestinationLatitude(resultSet.getString("destinationLatitude"));
                a.setDestinationLongitude(resultSet.getString("destinationLongitude"));
                a.setPosition(resultSet.getString("position"));
                a.setDate(resultSet.getString("date"));
                a.setDistance(Double.parseDouble(resultSet.getString("distance")));
                a.setDuration(Integer.parseInt(resultSet.getString("time")));

                routeLocationList.add(a);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return routeLocationList;
    }

    /**
     * get selected route from the drop down
     *
     * @param route
     * @return
     */
    public List<Route> getSelectedRoute(Route route) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Route> routeLocationList = new ArrayList();
        int result = -1;
        try {

            String query = "select * from route where tourId=? and date=? and pathType=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, route.getTourId());
            preparedStatement.setString(2, route.getDate());
            preparedStatement.setString(3, "premium");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                Route a = new Route();
                a.setTourId(resultSet.getString("tourId"));
                a.setSourcePlaceName(resultSet.getString("source"));
                a.setDestinationPlaceName(resultSet.getString("destination"));
                a.setSourceLatitude(resultSet.getString("sourceLatitude"));
                a.setSourceLongitude(resultSet.getString("sourceLongitude"));
                a.setDestinationLatitude(resultSet.getString("destinationLatitude"));
                a.setDestinationLongitude(resultSet.getString("destinationLongitude"));
                a.setPosition(resultSet.getString("position"));
                a.setDate(resultSet.getString("date"));
                a.setDistance(Double.parseDouble(resultSet.getString("distance")));
                a.setDuration(Integer.parseInt(resultSet.getString("time")));
                routeLocationList.add(a);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return routeLocationList;
    }

    /**
     * get selected alternative route from the drop down
     *
     * @param route
     * @return
     */
    public List<Route> getSelectedAlternativeRoute(Route route) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Route> routeLocationList = new ArrayList();
        int result = -1;
        try {

            String query = "select * from route where tourId=? and date=? and pathType=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, route.getTourId());
            preparedStatement.setString(2, route.getDate());
            preparedStatement.setString(3, "Alternative");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                Route a = new Route();
                a.setTourId(resultSet.getString("tourId"));
                a.setSourcePlaceName(resultSet.getString("source"));
                a.setDestinationPlaceName(resultSet.getString("destination"));
                a.setSourceLatitude(resultSet.getString("sourceLatitude"));
                a.setSourceLongitude(resultSet.getString("sourceLongitude"));
                a.setDestinationLatitude(resultSet.getString("destinationLatitude"));
                a.setDestinationLongitude(resultSet.getString("destinationLongitude"));
                a.setPosition(resultSet.getString("position"));
                a.setDate(resultSet.getString("date"));
                a.setDistance(Double.parseDouble(resultSet.getString("distance")));
                a.setDuration(Integer.parseInt(resultSet.getString("time")));
                routeLocationList.add(a);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return routeLocationList;
    }

    /**
     * add generated alternative route to db
     *
     * @param finalRoutes
     * @param tourName
     * @return
     */
    public int addAlternativeRoute(ArrayList<Route> finalRoutes, String tourName) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {
            for (int i = 0; i <= finalRoutes.size(); i++) {
                String query = "insert into route(tourId, source,destination,position,distance,time,date,pathType,sourceLatitude,sourceLongitude,destinationLatitude,destinationLongitude) values(?,?,?,?,?,?,?,?,?,?,?,?);";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, tourName);
                preparedStatement.setString(2, finalRoutes.get(i).getDestinationPlaceName());
                preparedStatement.setString(3, finalRoutes.get(i + 1).getDestinationPlaceName());
                preparedStatement.setString(4, finalRoutes.get(i + 1).getPosition());
                preparedStatement.setDouble(5, finalRoutes.get(i + 1).getDistance());
                preparedStatement.setDouble(6, finalRoutes.get(i + 1).getDuration());
                preparedStatement.setString(7, finalRoutes.get(i + 1).getDate());
                preparedStatement.setString(8, "Alternative");
                preparedStatement.setString(9, finalRoutes.get(i).getDestinationLatitude());
                preparedStatement.setString(10, finalRoutes.get(i).getDestinationLongitude());
                preparedStatement.setString(11, finalRoutes.get(i + 1).getDestinationLatitude());
                preparedStatement.setString(12, finalRoutes.get(i + 1).getDestinationLongitude());

                System.out.println(query);
                result = preparedStatement.executeUpdate();
                if (result > 0) {
                    result = 1;
                }
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return result;
    }

    /**
     * get alternative route for selected tour from db
     *
     * @param routeAl
     * @return
     */
    public List<Route> getAlternativeRoute(Route routeAl) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Route> routeLocationList = new ArrayList();
        int result = -1;
        try {
            String query = "select * from route where tourId=? and pathType=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, routeAl.getTourId());
            preparedStatement.setString(2, "Alternative");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                Route a = new Route();
                a.setTourId(resultSet.getString("tourId"));
                a.setSourcePlaceName(resultSet.getString("source"));
                a.setDestinationPlaceName(resultSet.getString("destination"));
                a.setSourceLatitude(resultSet.getString("sourceLatitude"));
                a.setSourceLongitude(resultSet.getString("sourceLongitude"));
                a.setDestinationLatitude(resultSet.getString("destinationLatitude"));
                a.setDestinationLongitude(resultSet.getString("destinationLongitude"));
                a.setPosition(resultSet.getString("position"));
                a.setDate(resultSet.getString("date"));
                a.setDistance(Double.parseDouble(resultSet.getString("distance")));
                a.setDuration(Integer.parseInt(resultSet.getString("time")));
                routeLocationList.add(a);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return routeLocationList;
    }

    /**
     * get default route from db
     *
     * @param tourId
     * @return
     */
    public List<Route> getDefaultRoute(String tourId) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        List<Route> routeLocationList = new ArrayList();
        int result = -1;
        try {
            String query = "select * from route where tourId=? and pathType=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, tourId);
            preparedStatement.setString(2, "Premium");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                Route a = new Route();
                a.setTourId(resultSet.getString("tourId"));
                a.setSourcePlaceName(resultSet.getString("source"));
                a.setDestinationPlaceName(resultSet.getString("destination"));
                a.setSourceLatitude(resultSet.getString("sourceLatitude"));
                a.setSourceLongitude(resultSet.getString("sourceLongitude"));
                a.setDestinationLatitude(resultSet.getString("destinationLatitude"));
                a.setDestinationLongitude(resultSet.getString("destinationLongitude"));
                a.setPosition(resultSet.getString("position"));
                a.setDate(resultSet.getString("date"));
                routeLocationList.add(a);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return routeLocationList;
    }

    /**
     * get summary route Info from db
     *
     * @param routeAl
     * @return
     */
    public List<Tour> getSummary(Route routeAl) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Tour> routeLocationList = new ArrayList();
        int result = -1;
        try {
            String query = "select * from tour where tourName=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, routeAl.getTourId());
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                Tour a = new Tour();
                a.setTourName(resultSet.getString("tourName"));
                a.setStartDate(resultSet.getString("startDate"));
                a.setEndDate(resultSet.getString("endDate"));
                a.setBudgetRange(resultSet.getString("budgetRange"));
                a.setAccType(resultSet.getString("accType"));
                a.setTravelType(resultSet.getString("travelType"));
                a.setSelectedCategories(resultSet.getString("selectedCategories"));
                a.setSelectedLocs(resultSet.getString("selectedLocs"));
                a.setSelectedAccom(resultSet.getString("selectedAccom"));
                routeLocationList.add(a);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAOs.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return routeLocationList;
    }

    public int updateTourDates(Tour updatetourdates) {
        
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {
            String query = "update tour set endDate=? where tourName=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, updatetourdates.getEndDate());
            preparedStatement.setString(2, updatetourdates.getTourName());

            result = preparedStatement.executeUpdate();
            if (result > 0) {
                result = 1;
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return result;
         }
}
