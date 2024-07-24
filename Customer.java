package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer 
{
	private String name;
	private String contactInformation;
	private ArrayList<String> artworkPurchases;
	private ArrayList<String> artistPreferences;
	
	public Customer(String name, String contactInformation, 
	ArrayList<String> artworkPurchases, ArrayList<String> artistPreferences)
	{
		this.name = name;
		this.contactInformation = contactInformation;
		this.artworkPurchases = artworkPurchases;
		this.artistPreferences = artistPreferences;
	}
	
	public void setName(String name)
	{
		this.name = name;
		print(0, "name");
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setContactInformation(String contactInformation)
	{
		this.contactInformation = contactInformation;
		print(0, "contact information");
	}
	
	public String getContactInformation()
	{
		return contactInformation;
	}
	
	public void addArtworkPurchases(String artwork)
	{
		artworkPurchases.add(artwork);
		print(1, "artwork");
	}
	
	public ArrayList<String> getArtworkPurchases()
	{
		return artworkPurchases;
	}
	
	public void removeArtworkPurchases(String artwork)
	{
		boolean chk = artworkPurchases.contains(artwork);
		if (chk)
		{
			artworkPurchases.remove(artwork);
			print(2,"artwork");
		}
		else
		{
			print(3,"artwork");
		}
		
	}
	
	public void addArtistPreferences(String artist)
	{
		artistPreferences.add(artist);
		print(1, "artist");
	}
	
	public ArrayList<String> getArtistPreferences()
	{
		return artistPreferences;
	}
	
	public void removeArtistPreferences(String artist)
	{
		boolean chk = artistPreferences.contains(artist);
		if (chk)
		{
			artistPreferences.remove(artist);
			print(2,"artist");
		}
		else
		{
			print(3,"artist");
		}
		
	}
	
	public String listArtworkPurchases() {
		String str = "";
		for(int i = 0; i < artworkPurchases.size(); i++) {
			str += artworkPurchases.get(i);
			if(i != artworkPurchases.size()-1) {
				str += ", ";
			}
		}
		return str;
	}
	
	public String listArtistPreferences() {
		String str = "";
		for(int i = 0; i < artistPreferences.size(); i++) {
			str += artistPreferences.get(i);
			if(i != artistPreferences.size()-1) {
				str += ", ";
			}
		}
		return str;
	}
	
	public String toFileString() {
		String sb = String.format("%s\n%s\n%s\n%s\n", getName(), getContactInformation(), listArtworkPurchases(), listArtistPreferences());
		return sb;
	}
	
	public String toString() {
    	return "Customer Name : " + getName() + "\nContact Info : " + getContactInformation() + "\nArtwork Puchase List : " + getArtworkPurchases() 
    			+ "\nArtist Prefernce List : " + getArtistPreferences() + "\n\n";
    }
	
	public void print(int v, String value)
	{
		Scanner input = new Scanner(System.in);
		if (v == 0)
		{
			System.out.println("\n\nNew " + value + " has been updated.");
		}
		
		if (v == 1)
		{
			System.out.println("\n\nNew " + value + " has been added to the list.");
		}
		
		if (v == 2)
		{
			System.out.println("\n\n"+ value +" has been remove from the list.");
		}
		
		if (v == 3)
		{
			System.out.println("\n\nInvalid " + value + " entered.");
		}
		System.out.print("Press enter to continue...");
        input.next();
		input.close();
	}
}

