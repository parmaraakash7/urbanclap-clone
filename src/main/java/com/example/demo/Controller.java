package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.postgis.PGgeometry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class Controller {
	
	@GetMapping("/nyc1")
    public ResponseEntity<List<Temp>> getAll(){
    	List<Temp> temp = new ArrayList<Temp>();
    	 Connection c = null;
         Statement stmt = null;
         java.sql.Connection congeom = null;
         try {
            Class.forName("org.postgresql.Driver");
            
            c = DriverManager
               .getConnection("jdbc:postgresql://localhost:5432/nd",
               "postgres", "aakash@123");
            ((org.postgresql.PGConnection)c).addDataType("geometry",Class.forName("org.postgis.PGgeometry"));
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT id,name,ST_AsGeoJSON(shape) from temp;" );
            
            while ( rs.next() ) {
               int id = rs.getInt("id");
               String  name = rs.getString("name");
               //Geometry shape = (Geometry)rs.getObject("shape");
               //PGgeometry geom = (PGgeometry)rs.getObject("st_asgeojson");
               String geo = rs.getString("st_asgeojson");
               
               
               System.out.println( "ID = " + id );
               System.out.println( "NAME = " + name );
               System.out.println( "geom = " + geo );
               temp.add(new Temp(id,name,geo));
               System.out.println( "temp = " + temp);
               
               
            }
            rs.close();
            stmt.close();
            c.close();
            return new ResponseEntity<>(temp, HttpStatus.OK);
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
    }
	
	@GetMapping("/salon")
    public ResponseEntity<List<Salon>> getAllSalon(){
    	List<Salon> temp = new ArrayList<Salon>();
    	 Connection c = null;
         Statement stmt = null;
         java.sql.Connection congeom = null;
         try {
            Class.forName("org.postgresql.Driver");
            
            c = DriverManager
               .getConnection("jdbc:postgresql://ec2-3-221-100-217.compute-1.amazonaws.com:5432/d80ku9fq370r75",
               "bjsllzebpikvzj", "8e7e2d1d29eca08a88e9eb32115666186f8367aa26b4d7541dbb62fe0d6f4830");
            ((org.postgresql.PGConnection)c).addDataType("geometry",Class.forName("org.postgis.PGgeometry"));
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT id,name,rating,rating_count,address,"
            		+ "verified,ST_AsGeoJSON(location) from salons;" );
            
            while ( rs.next() ) {
               int id = rs.getInt("id");
               String  name = rs.getString("name");
               double rating = rs.getDouble("rating");
               int rating_count = rs.getInt("rating_count");
               String address = rs.getString("address");
               String verified = rs.getString("verified");
               String location = rs.getString("st_asgeojson");
               
               
               System.out.println( "ID = " + id );
               System.out.println( "NAME = " + name );
               temp.add(new Salon(id,name,rating,rating_count,address,verified,location));
               System.out.println( "temp = " + temp);
               
               
            }
            rs.close();
            stmt.close();
            c.close();
            return new ResponseEntity<>(temp, HttpStatus.OK);
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
    }
	
	
	@GetMapping("/electrician")
    public ResponseEntity<List<Salon>> getAllElectricians(){
    	List<Salon> temp = new ArrayList<Salon>();
    	 Connection c = null;
         Statement stmt = null;
         java.sql.Connection congeom = null;
         try {
            Class.forName("org.postgresql.Driver");
            
            c = DriverManager
               .getConnection("jdbc:postgresql://localhost:5432/nd",
               "postgres", "aakash@123");
            ((org.postgresql.PGConnection)c).addDataType("geometry",Class.forName("org.postgis.PGgeometry"));
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT id,name,rating,rating_count,address,"
            		+ "verified,ST_AsGeoJSON(location) from electricians;" );
            
            while ( rs.next() ) {
               int id = rs.getInt("id");
               String  name = rs.getString("name");
               double rating = rs.getDouble("rating");
               int rating_count = rs.getInt("rating_count");
               String address = rs.getString("address");
               String verified = rs.getString("verified");
               String location = rs.getString("st_asgeojson");
               
               
               System.out.println( "ID = " + id );
               System.out.println( "NAME = " + name );
               temp.add(new Salon(id,name,rating,rating_count,address,verified,location));
               System.out.println( "temp = " + temp);
               
               
            }
            rs.close();
            stmt.close();
            c.close();
            return new ResponseEntity<>(temp, HttpStatus.OK);
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
    }
	

}
