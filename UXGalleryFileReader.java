package Assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UXGalleryFileReader {
	
	public UXGalleryFileReader(){
		
	}
	
	public static ArrayList<Customer> customerReader(String fileName)
	   {
		   ArrayList<Customer> customers = new ArrayList<>();
		   ArrayList<String>lines = read(fileName);
		   Customer customer;
		   String name,contactNumber;
		   ArrayList<String> artworkPur = new ArrayList<>();
		   ArrayList<String> artistPer = new ArrayList<>();
		   for (int i = 0; i < lines.size(); i ++)
		   {
			   name = lines.get(i);
			   contactNumber = lines.get(i+1);
			   artworkPur = new ArrayList<>(Arrays.asList(lines.get(i+2).replace("[", "").replace("]", "").split(", ")));
			   artistPer = new ArrayList<>(Arrays.asList(lines.get(i+3).replace("[", "").replace("]", "").split(", ")));
			   customer = new Customer(name,contactNumber,artistPer,artworkPur);
			   customers.add(customer);
			   artworkPur = new ArrayList<>();
			   artistPer = new ArrayList<>();
			   i+=4;
		   }
		   return customers;
	   }
	
    public static ArrayList<Artist> artistReader(String fileName) {
    	
    	ArrayList<Artist> artists = new ArrayList<>();
    	Artist artist;
    	ArrayList<String>lines = read(fileName);
    	String name, artPriceRange;
    	boolean vitalStatus;
    	ArrayList<String> specialty = new ArrayList<>();
    	for(int i = 0; i < lines.size(); i ++)
    	{
    		name = lines.get(i);
    		specialty = new ArrayList<>(Arrays.asList(lines.get(i+1).replace("[", "").replace("]", "").split(", ")));
    		vitalStatus = Boolean.parseBoolean(lines.get(i+2));
    		artPriceRange = lines.get(i+3);
    		i += 4;
    		artist = new Artist(name,specialty,vitalStatus,artPriceRange);
    		artists.add(artist);
    		specialty = new ArrayList<>();
    	}
    	return artists;
    }
	
    public static ArrayList<Artwork> artworkReader(String fileName)
    {
    	ArrayList<Artwork> artworks = new ArrayList<>();
    	Artwork artwork;
    	ArrayList<String>lines = read(fileName);
    	String name, datePur, dateSold, artist, customer;
    	double pricePur, priceSold;
    	for (int i = 0; i < lines.size(); i ++)
    	{
    		name = lines.get(i);
    		datePur = lines.get(i+1);
    		dateSold = lines.get(i+2);
    		artist = lines.get(i+3);
    		customer = lines.get(i+4);
    		pricePur = Double.parseDouble(lines.get(i+5));
    		priceSold = Double.parseDouble(lines.get(i+6));
    		artwork = new Artwork(name,datePur,dateSold,artist,customer,pricePur,priceSold);
    		artworks.add(artwork);
    		i+=7;
    	}
    	return artworks;
    }

    public static ArrayList<String> read(String file)
	{
		ArrayList<String> lines = new ArrayList<>();
	    String fileName = file; // Replace with the name of your text file

	   try (BufferedReader read = new BufferedReader(new FileReader(fileName))) 
	   {
	       String line;
	       while ((line = read.readLine()) != null) 
	       {
	           lines.add(line);
	       }
	   } 
	    
	   catch (IOException e) 
	   {
	       System.err.format("IOException: %s%n", e);
	   }
	   return lines;
	}
}
