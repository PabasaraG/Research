/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.ontology;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;
import com.tourbuddy.base.entities.Location;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Anjana
 */
public class OntologyConnector_1 {

    private static final String OntologyURI = "http://www.semanticweb.org/anjana/ontologies/2016/4/test01#";
    private static final String OntologyFileNamePath = "C:/Users/Anjana/Desktop/test02.owl";
    OntModel model = null;

    public OntologyConnector_1() {
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        InputStream in = FileManager.get().open(OntologyFileNamePath);
        model.read(in, null);
    }

    public ArrayList<Location> getLocationDetail(String place01) {

        ArrayList<Location> p2 = new ArrayList<Location>();
        try {
            model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            InputStream in = FileManager.get().open(OntologyFileNamePath);
            model.read(in, null);
            System.out.println("pass");
            String query = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                    + "PREFIX t1: <http://www.semanticweb.org/anjana/ontologies/2016/4/test01#>"
                    + "SELECT ?places ?lat ?lon ?id "
                    + "WHERE {?places rdf:type t1:" + place01 + ". ?places t1:Latitude  ?lat. ?places t1:Longitude  ?lon}";

            Query q1 = QueryFactory.create(query);
            final QueryExecution qe = QueryExecutionFactory.create(q1, model);
            final ResultSet r1 = qe.execSelect();

            //  ResultSetFormatter.out(System.out, r1, q1);      
            for (; r1.hasNext();) {

                Location p = new Location();

                final QuerySolution rb = r1.nextSolution();

                // Get place name
                final RDFNode y = rb.get("places");
                String hasname = y.toString();
                String resultName[] = hasname.split("#");
                p.setLocationName(resultName[1].replaceAll("_", " "));

                /*final RDFNode id = rb.get("id");
				String I = id.toString();
				String resultid[] = I.split("\\^");
				p.setLocationId(resultid[0]);*/
                final RDFNode lat = rb.get("lat");
                String l = lat.toString();
                String resultlat[] = l.split("\\^");
                p.setLatitude(resultlat[0]);

                final RDFNode lon = rb.get("lon");
                String lo = lon.toString();
                String resultlot[] = lo.split("\\^");
                p.setLongitude(resultlot[0]);
                p.setLocationType(place01);

                //	System.out.println(p.getPlaceName());
                p2.add(p);

            }

        } catch (Exception e) {
            System.out.println("fail");
            return null;
        }

        return p2;
    }

    public ArrayList<Location> getLocationDetailByCity(String city, String place01) {

        ArrayList<Location> p2 = new ArrayList<Location>();
        try {
            model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            InputStream in = FileManager.get().open(OntologyFileNamePath);
            model.read(in, null);
            System.out.println("pass");
            String query = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                    + "PREFIX t1: <http://www.semanticweb.org/anjana/ontologies/2016/4/test01#>"
                    + "SELECT ?places ?lat ?lon ?id "
                    + "WHERE {?places rdf:type t1:" + city + ". ?places rdf:type t1:" + place01 + ". ?places t1:Latitude  ?lat. ?places t1:Longitude  ?lon}";

            Query q1 = QueryFactory.create(query);
            final QueryExecution qe = QueryExecutionFactory.create(q1, model);
            final ResultSet r1 = qe.execSelect();

            //  ResultSetFormatter.out(System.out, r1, q1);      
            for (; r1.hasNext();) {

                Location p = new Location();

                final QuerySolution rb = r1.nextSolution();

                // Get place name
                final RDFNode y = rb.get("places");
                String hasname = y.toString();
                String resultName[] = hasname.split("#");
                p.setLocationName(resultName[1].replaceAll("_", " "));

                /*	final RDFNode id = rb.get("id");
				String I = id.toString();
				String resultid[] = I.split("\\^");
				p.setLocationId(resultid[0]);*/
                final RDFNode lat = rb.get("lat");
                String l = lat.toString();
                String resultlat[] = l.split("\\^");
                p.setLatitude(resultlat[0]);

                final RDFNode lon = rb.get("lon");
                String lo = lon.toString();
                String resultlot[] = lo.split("\\^");
                p.setLongitude(resultlot[0]);

                p2.add(p);

            }

        } catch (Exception e) {
            System.out.println("fail");
            return null;
        }

        return p2;
    }

    public Location getLocationDetailByPlaceName(String city, String place01, String placeN) {

        Location p2 = new Location();
        try {
            model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            InputStream in = FileManager.get().open(OntologyFileNamePath);
            model.read(in, null);
            System.out.println("pass");
            String query = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                    + "PREFIX t1: <http://www.semanticweb.org/anjana/ontologies/2016/4/test01#>"
                    + "SELECT ?places ?lat ?lon ?id "
                    + "WHERE {?places rdf:type t1:" + city + ". ?places rdf:type t1:" + place01 + ". ?places t1:Latitude  ?lat. ?places t1:Longitude  ?lon}";

            Query q1 = QueryFactory.create(query);
            final QueryExecution qe = QueryExecutionFactory.create(q1, model);
            final ResultSet r1 = qe.execSelect();

            //  ResultSetFormatter.out(System.out, r1, q1);      
            for (; r1.hasNext();) {

                Location p = new Location();

                final QuerySolution rb = r1.nextSolution();
                final RDFNode y = rb.get("places");
                String hasname = y.toString();
                String resultName[] = hasname.split("#");
                String nam = (resultName[1]);

                if (nam.equals(placeN)) {
                    // Get place name

                    p.setLocationName(resultName[1].replaceAll("_", " "));

                    /*final RDFNode id = rb.get("id");
				String I = id.toString();
				String resultid[] = I.split("\\^");
				p.setLocationId(resultid[0]);*/
                    final RDFNode lat = rb.get("lat");
                    String l = lat.toString();
                    String resultlat[] = l.split("\\^");
                    p.setLatitude(resultlat[0]);

                    final RDFNode lon = rb.get("lon");
                    String lo = lon.toString();
                    String resultlot[] = lo.split("\\^");
                    p.setLongitude(resultlot[0]);

                    p2 = p;
                }

            }

        } catch (Exception e) {
            System.out.println("fail");
            return null;
        }

        return p2;
    }

}
