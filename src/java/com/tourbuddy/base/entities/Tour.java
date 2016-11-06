/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.entities;

/**
 *
 * @author Sanduni
 */
public class Tour {
    
    private long tourId;
    private String tourName;
    private String userName;
    private String startDate;
    private String endDate;
    private String budgetRange;
    private String accType;
    private String travelType;
    private String comments;
    private String selectedCategories;
    private String selectedLocs;
    private String selectedAccom;
    private String selectedRoute;

    public Tour() {
    }

    public long getTourId() {
        return tourId;
    }

    public void setTourId(long tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBudgetRange() {
        return budgetRange;
    }

    public void setBudgetRange(String budgetRange) {
        this.budgetRange = budgetRange;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(String selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public String getSelectedLocs() {
        return selectedLocs;
    }

    public void setSelectedLocs(String selectedLocs) {
        this.selectedLocs = selectedLocs;
    }

    public String getSelectedAccom() {
        return selectedAccom;
    }

    public void setSelectedAccom(String selectedAccom) {
        this.selectedAccom = selectedAccom;
    }

    public boolean getIdTour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(String selectedRoute) {
        this.selectedRoute = selectedRoute;
    }
    
    
    
    
    
    
            
    
    
}