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
public class Location {

    private String locationId;
    private String locationName;
    private String description;
    private String category;
    private String subCategory;
    private String season;
    private String province;
    private String latitude;
    private String longitude;
    private String position;
    private double approxTime;
    private double approxBudget;
    private String image;
    private String locationType;
    private String[] selectedLocations;
    private String address;
    private String contactNo;
    private String locId;
    

    public Location() {
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public double getApproxTime() {
        return approxTime;
    }

    public void setApproxTime(double approxTime) {
        this.approxTime = approxTime;
    }

    public double getApproxBudget() {
        return approxBudget;
    }

    public void setApproxBudget(double approxBudget) {
        this.approxBudget = approxBudget;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String[] getSelectedLocations() {
        return selectedLocations;
    }

    public void setSelectedLocations(String[] selectedLocations) {
        this.selectedLocations = selectedLocations;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }
}
