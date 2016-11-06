package com.tourbuddy.base.Ontology;


import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import java.io.File;
import java.io.InputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nethumini
 */
public class OntologyModel {

    public static OntModel instance;
	static String OntologyFileNamePath = "E:\\4th year\\CDAP\\TourB.owl";
	public static long lastModified;
	
	
	public OntologyModel()
	{	
	}
	
	public static OntModel getOntoModel()
	{
		instance = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		InputStream in = FileManager.get().open(OntologyFileNamePath);
		instance.read(in,null);
		lastModified = new File(OntologyFileNamePath).lastModified();
		
		System.out.println("New Instance Created");
		
		return instance;
	}
	
	
    public static OntModel getInstance()
	{
    	
    	long lastModifiedFile =  new File(OntologyFileNamePath).lastModified();
    	if(instance==null || (lastModified != lastModifiedFile))
    	{
    	   OntologyModel.getOntoModel();
    		
    	}
 
    	return instance;

    		
	}
    
    
}
