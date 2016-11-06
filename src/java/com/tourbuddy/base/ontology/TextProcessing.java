/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.ontology;

import com.hp.hpl.jena.ontology.OntModel;
import java.util.Random;
import twitter4j.ResponseList;
import twitter4j.Status;

/**
 *
 * @author Nethumini
 */
public class TextProcessing {
   public String[] getCategory(ResponseList<Status> status1 )
    { 
        int arr[]=new int[7];
        int w=0;
        int en=0;
        int edu=0;
        int a=0;
        int h=0;
        int ayu=0;
        int b=0;
       String stat=null; 
        String result= null;
        String category[]=new String[3];
                                                                                                                    String category1="Wildlife & Nature";
                                                                                                                    String category2="Entertainment";
                                                                                                                    String category3="Education";
        
        
        
      
        OntModel model = com.tourbuddy.base.Ontology.OntologyModel.getInstance();
        String ontologyURI = "http://www.semanticweb.org/nethumini/ontologies/2016/20/untitled-ontology-10#";
        
        com.tourbuddy.base.Ontology.Text n1 = new com.tourbuddy.base.Ontology.Text();
        
        for (Status status : status1) {
                stat=status.getText();
           String[] splited = stat.split("\\s+");
        
           for(int i=0;i<splited.length;i++)
           {
            result=n1.listOntologyRelationshipInArrayList(stat, model, ontologyURI);
            if(result.equalsIgnoreCase("Wildlife & Nature"))
            {
            w++;
            }
            if(result.equalsIgnoreCase("Historical & Cultural"))
            {
            h++;
            }
             if(result.equalsIgnoreCase("Education"))
            {
            edu++;
            }
              if(result.equalsIgnoreCase("Entertainment"))
            {
            en++;
            }
               if(result.equalsIgnoreCase("Adventure"))
            {
            w++;
            }
                if(result.equalsIgnoreCase("Beach"))
            {
            b++;
            }
                 if(result.equalsIgnoreCase("Ayurveda & Spa"))
            {
            ayu++;
            }
           }
        
 int max1 = Integer.MIN_VALUE;
int max2 = Integer.MIN_VALUE;
int max3 = Integer.MIN_VALUE; 

for (int i = 0; i < arr.length; i++)
{
    if (arr[i] > max1)
    {
        max3 = max2; max2 = max1; max1 = arr[i];
    }
    else if (arr[i] > max2)
    {
        max3 = max2; max2 = arr[i];
    }
    else if (arr[i] > max3)
    {
        max3 = arr[i];
    }
    
 category[0]=category1;
  category[1]=category2;
   category[2]=category3;
 
}      
                
                
                
        }
        
        
        return category;
    
    }
    
    
    public String[] getcategory()
    {
    String[] cats = {"Wildlife & Nature","Historical & Cultural","Adventure","Beach","Entertainment","Education","Ayurveda & Spa"};
    
    int idx1 = new Random().nextInt(cats.length);
    int idx2 = new Random().nextInt(cats.length);
    int idx3 = new Random().nextInt(cats.length);
    if(idx1==idx2)
    {
    idx2=new Random().nextInt(cats.length);
    if(idx2==idx3)
    {
    idx3=new Random().nextInt(cats.length);
    }
    if(idx3==idx1)
    {
    idx1=new Random().nextInt(cats.length);
    }
    }




 String random1 = (cats[idx1]);
 String random2 = (cats[idx2]);
  String random3 = (cats[idx3]);
    
  String cato[]={random1,random2,random3};
    
  return cato;
    }

}
