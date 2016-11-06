/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.entity.dao;

import com.tourbuddy.base.entities.Tour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanduni
 */
public class TourDAOs {

    ConnectionManager connectionManager;

    public TourDAOs() {
        connectionManager = ConnectionManager.getInstance();
    }

    //get particular tour object
    public Tour getTour(String tourName) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        Tour a = null;
        int result = -1;
        try {
            String query = "select * from tour where tourName=?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, tourName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = 1;
                a = new Tour();
                a.setTourId(Integer.parseInt(resultSet.getString("tourId")));
                a.setTourName(resultSet.getString("tourName"));
                a.setUserName(resultSet.getString("userName"));
                a.setStartDate(resultSet.getString("startDate"));
                a.setEndDate(resultSet.getString("endDate"));
                a.setBudgetRange(resultSet.getString("budgetRange"));
                a.setAccType(resultSet.getString("accType"));
                a.setTravelType(resultSet.getString("travelType"));
                a.setComments(resultSet.getString("comments"));
                a.setSelectedCategories(resultSet.getString("selectedCategories"));
                a.setSelectedLocs(resultSet.getString("selectedLocations"));
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

    public int addSelectedRoute(Tour sroute) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {
            String query = "update  tour set selectedRoute=? where tourName=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, sroute.getTourName());
            preparedStatement.setString(2, sroute.getSelectedRoute());
            System.out.println(query);
            result = preparedStatement.executeUpdate();

            if (result > 0) {
                result = 1;
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TourDAOs.class.getName()).log(Level.WARNING, null, ex);
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
