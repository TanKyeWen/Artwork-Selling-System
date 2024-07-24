package Assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UXGallery {

    private ArrayList<Customer> customers;
    private ArrayList<Artist> artists;
    private ArrayList<Artwork> inventory;

    private String customerFile;
    private String artistFile;
    private String inventoryFile;

    public UXGallery(String customerFile, String artistFile, String inventoryFile) {
        this.customerFile = customerFile;
        this.artistFile = artistFile;
        this.inventoryFile = inventoryFile;
        customers = new ArrayList<Customer>();
        artists = new ArrayList<Artist>();
        inventory = new ArrayList<Artwork>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void addArtwork(Artwork artwork) {
        inventory.add(artwork);
    }

    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }

    public void deleteArtist(Artist artist) {
        artists.remove(artist);
    }

    public void deleteArtwork(Artwork artwork) {
        inventory.remove(artwork);
    }

    public void modifyCustomer(Customer oCustomer, Customer nCustomer) {
        int index = customers.indexOf(oCustomer);
        customers.set(index, nCustomer);
    }

    public void modifyArtist(Artist oArtist, Artist nArtist) {
        int index = artists.indexOf(oArtist);
        artists.set(index, nArtist);
    }

    public void modifyArtwork(Artwork oArtwork, Artwork nArtwork) {
        int index = inventory.indexOf(oArtwork);
        inventory.set(index, nArtwork);
    }

    public ArrayList<Customer> searchCustomers(String str) {
        ArrayList<Customer> matchingCustomers = new ArrayList<Customer>();
        for (Customer c : customers) {
            if (c.getName().toLowerCase().contains(str.toLowerCase())) {
                matchingCustomers.add(c);
            }
        }
        return matchingCustomers;
    }

    public ArrayList<Artist> searchArtists(String str) {
        ArrayList<Artist> matchingArtists = new ArrayList<Artist>();
        for (Artist a : artists) {
            if (a.getName().toLowerCase().contains(str.toLowerCase())) {
                matchingArtists.add(a);
            }
        }
        return matchingArtists;
    }

    public ArrayList<Artwork> searchArtwork(String str) {
        ArrayList<Artwork> matchingArtwork = new ArrayList<Artwork>();
        for (Artwork art : inventory) {
            if (art.getTitle().toLowerCase().contains(str.toLowerCase())) {
                matchingArtwork.add(art);
            }
        }
        return matchingArtwork;
    }
    
    public ArrayList<Artwork> searchArtworkAvailability(){
    	ArrayList<Artwork> matchingArtwork = new ArrayList<Artwork>();
        for (Artwork art : inventory) {
            if (art.getDateSold().equals("-")) {
                matchingArtwork.add(art);
            }
        }
        return matchingArtwork;
    }

    public void listCustomers() {
    	System.out.println("\nName");
        for (Customer c : customers) {
            System.out.println(c.getName());
        }
    }

    public void listArtists() {
    	System.out.println("\nName");
        for (Artist a : artists) {
        	System.out.println(a.getName());
        }
    }
    
    public void listArtistsList() {
    	System.out.println("\nName");
        for (Artwork a : inventory) {
        	System.out.println(a.toString());
        }
    }
    
    public ArrayList<Artist> getArtist() {
    	return artists;
    }

    public void listArtwork() {
    	System.out.println("\nName");
        for (Artwork art : inventory) {
            System.out.println(art.getTitle());
        }
    }
    
    public void clearArtist() {
    	artists.clear();
    }
    
    public void clearCustomer() {
    	customers.clear();
    }
    
    public void clearArtwork() {
    	inventory.clear();
    }
    
    public String getArtistFile() {
    	return artistFile;
    }
    
    public String getCustomerFile() {
    	return customerFile;
    }
    
    public String getArtworkFile() {
    	return inventoryFile;
    }
    
    public void readInformationFromFile() {
    	
    	UXGalleryFileReader allInformation = new UXGalleryFileReader();
    	ArrayList<Artist> artistFromFile = allInformation.artistReader(getArtistFile());
    	for(Artist artist : artistFromFile) {
    		addArtist(artist);
    	}
    	
    	ArrayList<Customer> customerFromFile = allInformation.customerReader(getCustomerFile());
    	for(Customer customer : customerFromFile) {
    		addCustomer(customer);
    	}
    	
    	ArrayList<Artwork> artworkFromFile = allInformation.artworkReader(getArtworkFile());
    	for(Artwork artwork : artworkFromFile) {
    		addArtwork(artwork);
    	}
    	
    }

    public void saveData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(customerFile));
            for (Customer c : customers) {
                writer.write(c.toFileString());
                writer.newLine();
            }
            writer.close();
            writer = new BufferedWriter(new FileWriter(artistFile));
            for (Artist a : artists) {
                writer.write(a.toFileString());
                writer.newLine();
            }
            writer.close();
            writer = new BufferedWriter(new FileWriter(inventoryFile));
            for (Artwork artwork : inventory) {
            	writer.write(artwork.toFileString());
            	writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
}