/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.entity.dao;

import com.tourbuddy.base.entities.Loca;
import com.tourbuddy.base.entities.Tour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanduni
 */
public class TourDAO {

    ConnectionManager connectionManager;

    public TourDAO() {
        connectionManager = ConnectionManager.getInstance();
    }

    public Tour getSelectedLocationsList(Tour tour) {
        // TODO Auto-generated method stub
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        //Statement statement== conn.createStatement();;

        //List<Tour> selectedLocs = new ArrayList();
        Tour a = null;
        int result = -1;
        try {

            String query = "select * from tour where tourId=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, tour.getTourId());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;

                a = new Tour();
                a.setSelectedLocs(resultSet.getString("selectedLocs"));

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
        return a;
    }

    public int addData(Tour tour) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        int result = -1;
        try {
            String query = "insert into tour(tourName, startDate, endDate, accType,budgetRange,travelType,userName) values (?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, tour.getTourName());
            preparedStatement.setString(2, tour.getStartDate());
            preparedStatement.setString(3, tour.getEndDate());
            preparedStatement.setString(4, tour.getAccType());
            preparedStatement.setString(5, tour.getBudgetRange());
            preparedStatement.setString(6, tour.getTravelType());
            preparedStatement.setString(7, "Saman");
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("DAo done");
//            result = 1;
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.WARNING, null, ex);
            System.out.println("DAo not done");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TourDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return result;
    }

    public int addData(Tour tour, long userId) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        int result = -1;
        try {

            String query1 = "select * from user where userId=?";
            preparedStatement = conn.prepareStatement(query1);
            preparedStatement.setLong(1, userId);
            String username = null;

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                username = resultSet.getString("userName");
            }

            String query = "insert into tour(tourName, startDate, endDate, accType,budgetRange,travelType,userName) values (?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, tour.getTourName());
            preparedStatement.setString(2, tour.getStartDate());
            preparedStatement.setString(3, tour.getEndDate());
            preparedStatement.setString(4, tour.getAccType());
            preparedStatement.setString(5, tour.getBudgetRange());
            preparedStatement.setString(6, tour.getTravelType());
            preparedStatement.setString(7, username);
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("DAo done");
//            result = 1;
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.WARNING, null, ex);
            System.out.println("DAo not done");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TourDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return result;

    }

    public int updateData(String tour, List<String> catList) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        String a = null;
        StringBuilder buffer = new StringBuilder();
        Iterator iterator = catList.iterator();
        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            buffer.append(",");
            buffer.append(element);
        }
        a = buffer.toString();
        System.out.println(a);
        int result = -1;
        try {

            String query1 = "UPDATE tour SET categories = ? WHERE tourName = ?";
            preparedStatement = conn.prepareStatement(query1);
            preparedStatement.setString(1, a);
            preparedStatement.setString(2, tour);

            result = preparedStatement.executeUpdate();
            if (result > 0) {
                result = 1;
            }
            preparedStatement.close();
            System.out.println("DAo done");
           
        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.WARNING, null, ex);
            System.out.println("DAo not done");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TourDAO.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return result;

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////

    public Map<String, List<Loca>> getCategoryList(List<String> catList) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        Loca loca = null;
        List<Loca> loc = null;
        Map<String, List<Loca>> catMap = new HashMap<String, List<Loca>>();
        try {

            for (int i = 0; i < catList.size(); i++) {
                // loca=new Loca();
                String query = "select * from loca where category=? ";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, catList.get(i));
                System.out.println("CATLIST" + catList.get(i));
                ResultSet resultSet = preparedStatement.executeQuery();
                loc = new ArrayList<Loca>();
                while (resultSet.next()) {
                    loca = new Loca();
                    loca.setLname(resultSet.getString("locationName"));
                    loca.setLdescription(resultSet.getString("description"));
                    loca.setLcategory(resultSet.getString("category"));
                    loca.setLimage(resultSet.getString("image"));
                    System.out.println(resultSet.getString("locationName"));
                    System.out.println(resultSet.getString("description"));
                    System.out.println(resultSet.getString("category"));
                    System.out.println(resultSet.getString("image"));
                    loc.add(loca);
                    System.out.println(loca);

                }
                catMap.put(catList.get(i), loc);
                Set set = catMap.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry mentry = (Map.Entry) iterator.next();
                    System.out.print("key is: " + mentry.getKey() + " & Value is: ");
                    System.out.println(mentry.getValue());
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.WARNING, null, ex);

        }
        return catMap;
    }

}
