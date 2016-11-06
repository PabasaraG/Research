/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.dataminner;

import com.tourbuddy.base.entities.Survey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nethumini
 */
public class Datamine {
    public String[] dmResult(Survey sv)
    {
         String probabi=null;
         String preditResult=null;
         String probabi1=null;
         String preditResult1=null;
          String preditResult2=null;
    try {  
            String Q1 = sv.getQ1();
            String Q2= sv.getQ2();
            String Q3 = sv.getQ3();
            String Q4 = sv.getQ4();
            String Q5  =sv.getQ5();
            String Q6 =sv.getQ6();  
            String Q7=sv.getQ7();
            String Q8=sv.getQ8(); 
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
            String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
            Properties prop=new Properties();  
            prop.setProperty("user","dmuser"); 
            prop.setProperty("password","123");
            Connection conn= DriverManager.getConnection(url,prop);    
 
 String sql ="select prediction(CLAS_SVM_1_2 using '"+ Q1+"' as Q1,'"+Q2+"' as Q2, '"+Q3+"' as Q3, '"+Q4+"' as Q4,'"+Q5+"' as Q5,'"+Q6+"' as Q6,'"+Q7+"' as Q7,'"+Q8+"' as Q8), prediction_probability(CLAS_SVM_1_2 using '"+Q1+"' as Q1,'"+Q2+"' as Q2,'"+Q3+"' as Q3,'"+Q4+"' as Q4,'"+Q5+"' as Q5,'"+Q6+"' as Q6,'"+Q7+"' as Q7,'"+Q8+"' as Q8) from SURVEY1 where rownum<2";                 
 PreparedStatement preStatement = conn.prepareStatement(sql);    
 ResultSet result = preStatement.executeQuery();                   
 while (result.next()) {     
     System.out.println("haveeeeeeee");
    preditResult = result.getString(1);               
     double prob = result.getDouble(2);                 
     probabi = Double.toString(prob);          
 }
 
 String sql2="select prediction(CLAS_SVM_1_3 using '"+ Q1+"' as Q1,'"+Q2+"' as Q2, '"+Q3+"' as Q3, '"+Q4+"' as Q4,  '"+Q5+"' as Q5,'"+Q6+"' as Q6,   '"+Q7+"' as Q7,'"+Q8+"' as Q8), prediction_probability(CLAS_SVM_1_3 using '"+Q1+"' as Q1,'"+Q2+"' as Q2,'"+Q3+"' as Q3,'"+Q4+"' as Q4,'"+Q5+"' as Q5,'"+Q6+"' as Q6,'"+Q7+"' as Q7,'"+Q8+"' as Q8) from SURVEY where rownum<2";                 
 PreparedStatement preStatement2 = conn.prepareStatement(sql2);    
 ResultSet result1 = preStatement2.executeQuery();                   
 while (result1.next()) {     
     System.out.println("haveeeeeeee2");
    preditResult1 = result1.getString(1);               
     double prob = result1.getDouble(2);                 
     probabi1 = Double.toString(prob);          
 }
 
 
  String sql3 ="select prediction(CLAS_SVM_1_4 using '"+ Q1+"' as Q1,'"+Q2+"' as Q2, '"+Q3+"' as Q3, '"+Q4+"' as Q4,  '"+Q5+"' as Q5,'"+Q6+"' as Q6,   '"+Q7+"' as Q7,'"+Q8+"' as Q8), prediction_probability(CLAS_SVM_1_4 using '"+Q1+"' as Q1,'"+Q2+"' as Q2,'"+Q3+"' as Q3,'"+Q4+"' as Q4,'"+Q5+"' as Q5,'"+Q6+"' as Q6,'"+Q7+"' as Q7,'"+Q8+"' as Q8) from SURVEY2 where rownum<2";                 
 PreparedStatement preStatement3 = conn.prepareStatement(sql3);    
 ResultSet result2 = preStatement3.executeQuery();                   
 while (result2.next()) {     
     System.out.println("haveeeeeeee2");
    preditResult2 = result2.getString(1);               
     double prob = result2.getDouble(2);                 
     probabi1 = Double.toString(prob);          
 }
    } catch (SQLException ex) {                    
        System.out.println("Invalid oracle connection"+ex);
    }
    
    String[] predictArray = new String[3];
    predictArray[0]=preditResult;
    predictArray[1]=preditResult1;
    predictArray[2]=preditResult2;
    return predictArray ;
    }
}

    


