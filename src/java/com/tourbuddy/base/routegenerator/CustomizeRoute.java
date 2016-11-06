/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.routegenerator;

import com.tourbuddy.base.entities.Location;
import com.tourbuddy.base.entities.Route;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanduni
 */
public class CustomizeRoute {
    
    
    public ArrayList<Route> DayPlanner(ArrayList<Route> finalRoutes, List<Location> allLocationList)
    {
        double totalDuration=0;
        int dateNumber=1;
        for(int r = 0 ; r<= finalRoutes.size()-1;r++)
        {
            totalDuration= totalDuration + finalRoutes.get(r).getDuration();
            
            for(Location l:allLocationList)
            {
                if(l.getLocationName().equalsIgnoreCase(finalRoutes.get(r).getDestinationPlaceName()))
                {
                    System.out.println("THIS IS DAY PLANNER :"+l.getLocationName()+" "+l.getApproxTime());
                    totalDuration= totalDuration +l.getApproxTime();
                }
                
            }
            if(totalDuration<=480)
            {
                finalRoutes.get(r).setDate(String.valueOf(dateNumber));
            }
            else
            {
                dateNumber++;
                finalRoutes.get(r).setDate(String.valueOf(dateNumber));
                totalDuration=0;
            }
            /*System.out.println("customize Route :"+ totalDuration);
            if(totalDuration<=480)
            {
                //locdate=1;
                finalRoutes.get(r).setDate("1");
            }
            else if(480<totalDuration && totalDuration<=960)
            {
                //locdate++;
                 finalRoutes.get(r).setDate("2");
            }
            else
            {
                //locdate++;
                 finalRoutes.get(r).setDate("3");
            }*/  
        }
        return finalRoutes;
    }   
}
