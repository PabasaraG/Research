package com.tourbuddy.base.Ontology;


import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nethumini
 */
public class Text {
    public String listOntologyRelationshipsInJson(String item, OntModel model, String OntologyURI)
	{
            String returnedArrayList=null;
		JSONObject relationshipJsonOnject = new JSONObject();
		
		//ArrayList<String> returnedArrayList = new ArrayList<String>();
		
		returnedArrayList = listOntologyRelationshipInArrayList(item, model, OntologyURI);
		
		if (returnedArrayList.length() > 0)
		{
			int relationshipCount = 1;
			
			
			
		}
		
		return returnedArrayList;
	}
	
	
	public String listOntologyRelationshipInArrayList(String item, OntModel model, String OntologyURI)
	{
            String ontoresult=null;
		ArrayList<String> relationshipArrayList = new ArrayList<String>();
		
		String internalItem = item.replaceAll(" ", "_").toLowerCase();
		
		Individual itemIndividual =  model.getIndividual(OntologyURI + internalItem);
		
		if (itemIndividual == null)
		{
			OntClass itemOntClass = model.getOntClass(OntologyURI + internalItem); 
			
			if (itemOntClass == null)
			{
				System.out.println("Item is not in the ontology");
			} else {
				
			ontoresult=recursionInOntology(itemOntClass,relationshipArrayList);
			}
			
		}else {
			
			ontoresult=recursionInOntology(itemIndividual,relationshipArrayList);
		}
		
		return ontoresult;
	}
	
	private String recursionInOntology(Object existingOntologyItem, ArrayList<String> relationshipArrayList)
	{
		
	        String OntClassLocalName=null;
		
		if (existingOntologyItem instanceof OntClass && existingOntologyItem != null)
		{
		        OntClassLocalName = ((OntClass)existingOntologyItem).getLocalName();
			System.out.println(OntClassLocalName);
			
			relationshipArrayList.add(OntClassLocalName);
			
			OntClass existingOntologyOntClassObject = ((OntClass) existingOntologyItem).getSuperClass();
			recursionInOntology(existingOntologyOntClassObject,relationshipArrayList);
		}
		return OntClassLocalName;
	}
    
    
}
