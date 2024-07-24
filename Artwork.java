package Assignment3;

import java.util.*;
public class Artwork
{
	private String title, datePur, dateSold, artist, customer;
	private double pricePur, priceSold;
	
	public Artwork(String title, String datePur, String dateSold, 
			String artist, String customer, double pricePur, double priceSold) 
	{
		this.title = title;
		this.datePur = datePur;
		this.dateSold = dateSold;
		this.artist = artist;
		this.customer = customer;
		this.pricePur = pricePur;
		this.priceSold = priceSold;
	}
	
	public Artwork(String title, String datePur, 
			String artist, double pricePur) 
	{
		this.title = title;
		this.datePur = datePur;
		dateSold = "null";
		this.artist = artist;
		this.pricePur = pricePur;
		priceSold = pricePur;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public String getDatePur() 
	{
		return datePur;
	}
	
	public String getDateSold() 
	{
		return dateSold;
	}
	
	public String getArtist() {
	    return artist;
	}

	public void setArtist(String artist) {
	    this.artist = artist;
	    print(0, "artist");
	}
	
	public String getCustomer() {
	    return customer;
	}

	public void setCustomer(String customer) {
	    this.customer = customer;
	}
	
	public double getPricePur() 
	{
		return pricePur;
	}
	
	public double getPriceSold() 
	{
		return priceSold;
	}


	public void setTitle(String title) 
	{
		this.title = title;
        print(0, "title");
	}
	
	public void setDatePur(String datePur) 
	{
		this.datePur = datePur;
        print(0, "datePur");
	}
	
	public void setDateSold(String dateSold) 
	{
		this.dateSold = dateSold;
        print(0, "dateSold");
	}
	
	
	public void setPricePur(double pricePur) 
	{
		this.pricePur = pricePur;
        print(0, "pricePur");
	}
	
	public void setPriceSold(double priceSold) 
	{
		this.priceSold = priceSold;
        print(0, "priceSold");
	} 
	
    public void print(String value)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\n\nNew " + value + " has been updated.");
		System.out.print("Press enter to continue...");
        input.nextLine();
		input.close();
    }
    
    public String toFileString() {
        String sb = String.format("%s\n%s\n%s\n%s\n%s\n%s\n", getTitle(), getDatePur(), getDateSold(), getArtist(), getCustomer(), getPricePur(), getPriceSold());
        return sb;
    }
    
    public String toString() {
        return "Title : " + getTitle() + "\nDate of Purchase : " + getDatePur() + "\nDate Sold : " + getDateSold() + 
        		"\nArtist : "+ getArtist() + "\nCustomer : " + getCustomer() + "\nPrice of Purchase : " + getPricePur() + 
        		"\nPrice Sold : " + getPriceSold() + "\n\n";
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
			System.out.println("\n\n"+ value +" has been remove from the list");
		}
		
		if (v == 3)
		{
			System.out.println("\n\nInvalid " + value + " entered");
		}
		System.out.print("Press enter to continue...");
        input.next();
		input.close();
	}
}