/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.entity.dao;

import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Tour;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanduni
 */
public class LocationDAO {

    ConnectionManager connectionManager;

    public LocationDAO() {
        connectionManager = ConnectionManager.getInstance();
    }

    public List<Location> changeBudget(Location accommodation) {
        // TODO Auto-generated method stub
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Location> accomList = null;
        int result = -1;
        try {

            String query = "select * from accommodation where category=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, accommodation.getCategory());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                Location a = new Location();
                a.setLocationId(resultSet.getString(1));
                a.setLocationName(resultSet.getString(2));
                a.setDescription(resultSet.getString(3));
                a.setCategory(resultSet.getString(4));
                a.setSubCategory(resultSet.getString(5));
                //a.setOpening(resultSet.getString(6));
                a.setProvince(resultSet.getString(7));
                a.setImage(resultSet.getString(8));
                //a.setLatitude(parseDouble(resultSet.getString(9)));
                //a.setLongitude(parseDouble(resultSet.getString(10)));
                accomList.add(a);

            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return accomList;
    }

    public List<Location> getLocationsList(Location location) {
        // TODO Auto-generated method stub
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        //Statement statement== conn.createStatement();;

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
                a.setLocationId(resultSet.getString("locationId"));
                a.setLocationName(resultSet.getString("locationName"));
                /*  a.setDescription(resultSet.getString(3));
                 a.setCategory(resultSet.getString(4));
                 a.setSubCategory(resultSet.getString(5));
                 a.setSeason(resultSet.getString(6));
                 a.setProvince(resultSet.getString(7));
                 a.setLatitude(resultSet.getString(8));
                 a.setLongitude(resultSet.getString(9));
                 a.setImage(resultSet.getString(10));
                 a.setApproxTime(Double.parseDouble(resultSet.getString(11)));
                 a.setApproxBudget(Double.parseDouble(resultSet.getString(12)));
                 a.setLocationType(resultSet.getString(13));*/

                locationList.add(a);
                System.out.println(a.getLocationName());

            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return locationList;
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
                a.setSubCategory(resultSet.getString("subCategory"));
                a.setSeason(resultSet.getString("season"));
                a.setProvince(resultSet.getString("province"));
                a.setLatitude(resultSet.getString("latitude"));
                a.setLongitude(resultSet.getString("longitude"));
                a.setImage(resultSet.getString("image"));
                a.setApproxTime(Double.parseDouble(resultSet.getString("approxTime")));
                a.setApproxBudget(Double.parseDouble(resultSet.getString("approxBudget")));
                a.setLocationType(resultSet.getString("locationType"));
                a.setAddress(resultSet.getString("address"));
                a.setContactNo(resultSet.getString("contactNo"));

                locationList.add(a);

            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return locationList;
    }

    /*
     //to add selected accommodation to tour table
     public int addSelectedAccom(Location location, int tourId) {
     // TODO Auto-generated method stub
     Connection conn = connectionManager.getConnection();
     PreparedStatement preparedStatement;
     int result = -1;
     try {
            
     String query = "update tour set accom_list=? where tourId=?)";
     preparedStatement = conn.prepareStatement(query);
     preparedStatement.setString(1, location.getSelectedLocations());
     preparedStatement.setString(2, tourId);
           
     System.out.println(query);
     result=preparedStatement.executeUpdate();
            
     if(result>0)
     {
     result=1;
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
     */
    public List<Location> getAllLocationsList() {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Location> allLocationList = new ArrayList();
        int result = -1;
        try {

            String query = "select * from location;";
            preparedStatement = conn.prepareStatement(query);
            //preparedStatement.setString(1, location.getCategory());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                Location a = new Location();
                a.setLocationId(resultSet.getString("locationId"));
                a.setLocationName(resultSet.getString("locationName"));
                a.setDescription(resultSet.getString("description"));
                a.setCategory(resultSet.getString("category"));
                a.setSubCategory(resultSet.getString("subCategory"));
                a.setSeason(resultSet.getString("season"));
                a.setProvince(resultSet.getString("province"));
                a.setLatitude(resultSet.getString("latitude"));
                a.setLongitude(resultSet.getString("longitude"));
                a.setImage(resultSet.getString("image"));
                a.setApproxTime(Double.parseDouble(resultSet.getString("approxTime")));
                a.setApproxBudget(Double.parseDouble(resultSet.getString("approxTime")));
                a.setLocationType(resultSet.getString("locationType"));

                allLocationList.add(a);
                //System.out.println(a.getLocationName());

            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocationDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return allLocationList;
    }
public List<Tour> getTours(String user) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        List<Tour> locationList = new ArrayList();
        int result = -1;
        try {

            String query = "select * from tour where userName=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,user);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                Tour a = new Tour();
                a.setTourName(resultSet.getString("tourName"));
                a.setStartDate(resultSet.getString("startDate"));
                a.setEndDate(resultSet.getString("endDate"));
                a.setAccType(resultSet.getString("accType"));
                a.setBudgetRange(resultSet.getString("budgetRange"));
                a.setTravelType(resultSet.getString("travelType"));
                a.setSelectedCategories(resultSet.getString("categories"));
                a.setSelectedRoute(resultSet.getString("selectedRoute"));
                a.setSelectedLocs(resultSet.getString("selectedLocs"));
                a.setSelectedAccom(resultSet.getString("selectedAccom"));
                locationList.add(a);
                System.out.println("in DAO :" + a.getTourName());
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
