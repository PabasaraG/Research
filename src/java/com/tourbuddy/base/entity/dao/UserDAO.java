/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.entity.dao;

import com.tourbuddy.base.entities.Profile;
import com.tourbuddy.base.entities.User;
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
public class UserDAO {

    ConnectionManager connectionManager;

    public UserDAO() {
        connectionManager = ConnectionManager.getInstance();
    }

    /**
     * user login
     *
     * @param user
     * @return
     */
    public User login(User user) {
        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;

        User userdao = null;
        try {
            String query = "select * from user where userName=? && password=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userdao = new User();
                userdao.setUserId(resultSet.getInt("userId"));
                userdao.setUsername(resultSet.getString("userName"));
                userdao.setFirstname(resultSet.getString("firstName"));
                userdao.setLastname(resultSet.getString("lastName"));
                userdao.setBirthdate(resultSet.getString("birthDate"));
                userdao.setGender(resultSet.getString("gender"));
                userdao.setCountry(resultSet.getString("country"));
                userdao.setUserImage(resultSet.getString("userImage"));
                System.out.println("SanduniDAO country" + userdao.getCountry());
            }
            resultSet.close();
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
        return userdao;
    }

    /**
     * user registration
     *
     * @param user
     * @return
     */
    public int addUser(User user) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {
            String query = "insert into user (userName, password, firstName, lastName, birthDate, gender, country, userImage) values(?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getBirthdate());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getCountry());
            preparedStatement.setString(8, user.getUserImage());
            System.out.println(query);
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
     * add update user profile info
     *
     * @param profile
     * @return
     */
    public int addUpdateProfile(Profile profile) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {
            String query = "select * from profile where userName=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, profile.getUsername());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                 //String query = "update  profile (userName, areYou, relationship, religious, aboutMe, concern, travelFor, visitedBefore,challenging,reason,often) values(?,?,?,?,?,?,?,?,?,?,?)";
            } else {
                //String query = "insert into profile (userName, areYou, relationship, religious, aboutMe, concern, travelFor, visitedBefore,challenging,reason,often) values(?,?,?,?,?,?,?,?,?,?,?)";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, profile.getUsername());
                preparedStatement.setString(2, profile.getAreYou());
                preparedStatement.setString(3, profile.getRelationship());
                preparedStatement.setString(4, profile.getReligious());
                preparedStatement.setString(5, profile.getAboutMe());
                preparedStatement.setString(6, profile.getConcern());
                preparedStatement.setString(7, profile.getTravelFor());
                preparedStatement.setString(8, profile.getVisitedBefore());
                preparedStatement.setString(9, profile.getChallenging());
                preparedStatement.setString(10, profile.getReason());
                preparedStatement.setString(11, profile.getOften());
                System.out.println(query);
                result = preparedStatement.executeUpdate();
                if (result > 0) {
                    result = 1;
                }
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
     * update user information
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {

        Connection conn = connectionManager.getConnection();
        PreparedStatement preparedStatement;
        int result = -1;
        try {
            String query = "update user (userName, password, firstName, lastName, birthDate, gender, country, userImage) values(?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getBirthdate());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getCountry());
            preparedStatement.setString(8, user.getUserImage());
            System.out.println(query);
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
