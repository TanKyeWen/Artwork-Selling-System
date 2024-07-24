package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Artist 
{
    private String name, priceRangeOfArtwork;
    private ArrayList<String> specialty;
    private boolean vital;

    public Artist(String name, ArrayList<String> specialty, boolean vital, String priceRangeOfArtwork) 
    {
        this.name = name;
        this.specialty = specialty;
        this.vital = vital;
        this.priceRangeOfArtwork = priceRangeOfArtwork;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
        print(0, "name");
    }

    public ArrayList<String> getSpecialty() 
    {
        return specialty;
    }

    public void setSpecialty()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to add new specialty.");
        System.out.println("Enter 2 to remove specialty.");
        System.out.println("Enter 3 to exit.");
        int enter = input.nextInt();
        
        if (enter == 1)
        {
            System.out.print("Enter new specialty : ");
            String special = input.next();
            this.specialty.add(special);
        }
        
        if (enter == 2)
        {
            for(String i : this.specialty)
            {
                System.out.println(i);
            }
            System.out.println("Enter the specialty needed to be removed");
            String special = input.next();
            this.specialty.remove(special);
        }
        input.close();
    }

    public boolean getVital() 
    {
        return vital;
    }

    public void setVital(boolean vital) 
    {
        this.vital = vital;
        print(0, "vital");
    }

    public String getPriceRangeOfArtwork() 
    {
        return priceRangeOfArtwork;
    }

    public void setPriceRangeOfArtwork(String priceRangeOfArtwork) 
    {
        this.priceRangeOfArtwork = priceRangeOfArtwork;
        print(0, "priceRangeOfArtwork");
    }
    
	public String listSpecialty() {
		String str = "";
		for(int i = 0; i < specialty.size(); i++) {
			str += specialty.get(i);
			if(i != specialty.size()-1) {
				str += ", ";
			}
		}
		return str;
	}
    
    public String toFileString() {
    	String sb = String.format("%s\n%s\n%s\n%s\n", getName(), getSpecialty(), getVital(), getPriceRangeOfArtwork());
    	return sb;
    }
    
    public String toString() {
        return "Name : " + getName() + "\nSpecialty : " + getSpecialty() + "\nVitals : " + getVital() + "\nRange of Prices : "+ getPriceRangeOfArtwork() + "\n\n";
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