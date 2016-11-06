/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.entity.dao;

import com.tourbuddy.base.entities.Loca;
import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Tour;
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
public class LocationDAOs {

    ConnectionManager connectionManager;

    public LocationDAOs() {
        connectionManager = ConnectionManager.getInstance();
    }

    /**
     * method to get the accommodation list for selected category
     *
     * @param location
     * @return
     */
    public List<Location> getLocationsList(Location location) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Location> locationList = new ArrayList();
        int result = -1;
        try {
            String query = "select * from location where category=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, location.getCategory());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                Location a = new Location();
                a.setLocId(resultSet.getString("locId"));
                a.setLocationId(resultSet.getString("locationId"));
                a.setLocationName(resultSet.getString("locationName"));
                a.setImage(resultSet.getString("image"));
                a.setCategory(resultSet.getString("category"));
                locationList.add(a);
                System.out.println(a.getLocationName());

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
        return locationList;
    }

    /**
     * add selected accommodation to tour table
     *
     * @param tour
     * @return
     */
    public int addSelectedAccom(Tour tour) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {
            String query = "update tour set selectedAccom=? where tourName=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, tour.getSelectedAccom());
            preparedStatement.setString(2, tour.getTourName());

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

    /**
     * get all location list from the location table
     *
     * @return
     */
    public List<Location> getAllLocationsList() {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        List<Location> allLocationList = new ArrayList();
        int result = -1;

        try {

            String query = "select * from location;";
            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                Location a = new Location();
                a.setLocationId(resultSet.getString("locationId"));
                a.setLocationName(resultSet.getString("locationName"));
                a.setLocId(resultSet.getString("locId"));
                a.setLatitude(resultSet.getString("latitude"));
                a.setLongitude(resultSet.getString("longitude"));
                a.setApproxTime(Double.parseDouble(resultSet.getString("approxTime")));
                allLocationList.add(a);
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
        return allLocationList;
    }

    /**
     * get user selected location list from the tour table
     *
     * @param tour
     * @return
     */
    public Tour getSelectedLocationsList(Tour tour) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        Tour a = null;
        int result = -1;
        try {
            String query = "select * from tour where tourName=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, tour.getTourId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                a = new Tour();
                a.setSelectedLocs(resultSet.getString("selectedLocs"));
                a.setSelectedAccom(resultSet.getString("selectedAccom"));
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
        return a;
    }

    /**
     * get particular locations details from its location name
     *
     * @param location
     * @return
     */
    public List<Location> getLocation(Location location) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Location> locationList = new ArrayList();
        int result = -1;
        try {

            String query = "select * from location where locationName=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, location.getLocationName());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                Location a = new Location();
                a.setLocationId(resultSet.getString("locationId"));
                a.setLocationName(resultSet.getString("locationName"));
                a.setDescription(resultSet.getString("description"));
                a.setCategory(resultSet.getString("category"));
                a.setImage(resultSet.getString("image"));
                a.setAddress(resultSet.getString("address"));
                a.setContactNo(resultSet.getString("contactNo"));
                locationList.add(a);
                System.out.println("in DAO :" + a.getLocationName());
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
        return locationList;
    }

    public List<Location> getAccomList(Location accomLocation) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Location> locationList = new ArrayList();
        int result = -1;
        try {
            String query = "select * from location where category=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, accomLocation.getCategory());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                Location a = new Location();
                a.setLocationId(resultSet.getString("locationId"));
                a.setLocationName(resultSet.getString("locationName"));
                a.setLatitude(resultSet.getString("latitude"));
                a.setLongitude(resultSet.getString("longitude"));
                a.setLocId(resultSet.getString("locId"));
                locationList.add(a);
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
        return locationList;
    }

    //get Category of a location when gives the location name
    public String getCategoryLocName(String locName) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Location> accomList = null;
        int result = -1;
        String categoryLocName = null;
        try {

            String query = "select category from location where locationName=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, locName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                categoryLocName = resultSet.getString(1);
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
        return categoryLocName;
    }

    //get all the locations details that belongs to one particular category
    //get Category of a location when gives the lovcation name
    public List<Location> getAllLocationsCategory(String locNameCategory) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        int result = -1;
        List<Location> categoryLocList = new ArrayList();
        try {
            String query = "select * from location where category=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, locNameCategory);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                Location a = new Location();
                a.setLocationId(resultSet.getString("locationId"));
                a.setLocationName(resultSet.getString("locationName"));
                a.setImage(resultSet.getString("image"));
                a.setLatitude(resultSet.getString("latitude"));
                a.setLongitude(resultSet.getString("longitude"));
                a.setCategory(resultSet.getString("category"));
                categoryLocList.add(a);
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
        return categoryLocList;
    }

    public int addSelectedLocs(Tour plcTour) {
       Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {
            String query = "update tour set selectedLocs=? where tourName=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, plcTour.getSelectedLocs());
            preparedStatement.setString(2, plcTour.getTourName());

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

    public List<Loca> getLocations(String lname) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Loca> locationList = new ArrayList();
        int result = -1;
        try {

            String query = "select * from loca where locationName=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, lname);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                Loca a = new Loca();
                a.setLname(resultSet.getString("locationName"));
                a.setLcategory(resultSet.getString("category"));
                a.setLdescription(resultSet.getString("description"));
                a.setLimage(resultSet.getString("image"));
               
                locationList.add(a);
                
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
        return locationList;
        
    }

    

   
}
