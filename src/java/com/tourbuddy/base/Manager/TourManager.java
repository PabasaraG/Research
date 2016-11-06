/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.Manager;

import com.tourbuddy.base.entities.Tour;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Nethumini
 */

    public class TourManager {

    private Map<Integer, List<Tour>> workingTourList;//<UserId,TourList>

    private static class TMLoader {
        private static final TourManager theInstance = new TourManager();
    }

    private TourManager() {
        workingTourList = new ConcurrentHashMap(20, 0.9f, 3);
    }

    public static TourManager getInstance() {
        return TMLoader.theInstance;
    }

    public void setTour(int userId, Tour tour) {
        List<Tour> temptourList;
        if (workingTourList.containsKey(userId)) {
            temptourList = this.workingTourList.get(userId);
            if (temptourList.contains(tour)) {
                for (Tour tempTour : temptourList) {
                    if (tempTour.getIdTour() == tour.getIdTour()) {
                        temptourList.remove(tempTour);
                    }
                }
                temptourList.add(tour);
            } else {
                temptourList.add(tour);
            }
        } else {
            temptourList = new ArrayList<Tour>();
            temptourList.add(tour);
        }
        workingTourList.put(userId, temptourList);
    }

    public List<Tour> getTour(int userId) {
        return workingTourList.get(userId);
    }

   /* public Tour getTour(int userId, long tourId) {
        Tour tempTour = null;
        for (Tour tour : workingTourList.get(userId)) {
            if (tour.getIdTour() == tourId) {
                tempTour = tour;
            }
        }
        return tempTour;
    }*/
}
    

