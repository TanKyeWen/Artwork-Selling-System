package Assignment3;

import java.io.IOException;
import java.util.*;

public class UXGalleryInterface
{
	public UXGalleryInterface(){
		mainInterface();
	}
	
    public void mainInterface()
    { 
    	Scanner scan = new Scanner(System.in);
        String opt;
        System.out.println("*Welcome to UX Gallery Database*");
        
        boolean end = false;
        do
        {
        	//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.print("A - Add\nD - Delete\nM - Modify\nS - Search\nL - List\nQ - Quit\nOption (A, D, M, S, L, Q)\n");
            System.out.print("Enter option: ");
            opt = scan.next().toUpperCase();
            
            String customerFile = "C:\\Users\\Asus\\Downloads\\Code\\Code\\Customer.txt";
    		String artistFile = "C:\\Users\\Asus\\Downloads\\Code\\Code\\Artist.txt";
    		String artworkFile = "C:\\Users\\Asus\\Downloads\\Code\\Code\\Artwork.txt";
            
            UXGallery gallery = new UXGallery(customerFile, artistFile, artworkFile);
            
            switch (opt)
            {
            case "A":
                add(gallery);
                break;
            case "D":
                delete(gallery);
                break; 
            case "M":
                modify(gallery);
                break;
            case "S":          
                search(gallery);
                break;
            case "L":          
                list(gallery);
                break;
            case "Q":         
                System.out.println("\nProgram close. Bye bye\n");
                end = true;
                break;
            default:
                System.out.println("\nError in choice, Please only enter choices listed.");
                con();
                break;
            }
        }while (!end);
        scan.close();
    }
    
    public void add(UXGallery gallery)
    {
    	boolean loop = true;
    	Scanner classInput = new Scanner(System.in);
    	gallery.readInformationFromFile();
    	
    	while(loop) 
    	{
    		String name;
    		System.out.println("\nSelect an option to add to \nT - Artist\nW - Artwork\nC - Customer\nQ - Quit\nEnter Option:");
    		String opt = classInput.nextLine().toUpperCase();
    		switch(opt)
    		{
    		case "T":
    			boolean loopArtist = true, loopArtistSpeciality = true, loopArtistVital = true;
    			while(loopArtist) {
    				Artist artist;
    				String stepArtist = "0";
    				
    				if(stepArtist.equals("0")) {
    				
    	    			System.out.println("Do you wish to add to the artist list? (Y/N)");
    	    			String optQuit = classInput.nextLine().toUpperCase();
    	    			
    	    			if(optQuit.equals("N")) {
    	    				stepArtist = "99";
    	    			}else {
    	    				stepArtist = "1";
    	    			}
    				}
    	    		
    				if(stepArtist.equals("1")) {
    					
    					System.out.println("Enter artist name: ");
    	    			name = classInput.nextLine();
    	    			
    	    			ArrayList<String> artistSpeciality = new ArrayList<>();
    	    			
    	    			while(loopArtistSpeciality) {
    	    				System.out.println("\nEnter the artist's speciality(Q to Quit): ");
    	    				String specialityNameInput = classInput.nextLine();
    	    				
    	    				if(specialityNameInput.toUpperCase().equals("Q")) {
    	    					loopArtistSpeciality = false;
    	    				}else {
    	    					artistSpeciality.add(specialityNameInput);
    	    				}
    	    			}
    	    			
    	    			boolean artistVitalBool = false;
    	    			while(loopArtistVital) {
    	    				System.out.println("\n Alive = 1 \n Dead = 0\nEnter the artist's vitals: ");
    	    				String artistVitalInput = classInput.nextLine();
    	    				
    	    				switch(artistVitalInput) {
    	    					case "1":
    	    						artistVitalBool = true;
    	    						loopArtistVital = false;
    	    						break;
    	    					
    	    					case "0":
    	    						artistVitalBool = false;
    	    						loopArtistVital = false;
    	    						break;
    	    						
    	    					default:
    	    						System.out.println("Invalid Option entered.");
    	    		    			con();
    	    		    			break;
    	    				}
    	    				System.out.println("\nEnter the artist's range of artwork's prices: ");
    	        			String priceRangeofArtworkInput = classInput.nextLine();
    	        			
    	        			artist = new Artist(name, artistSpeciality, artistVitalBool, priceRangeofArtworkInput);
    	        			//System.out.println(artist);
    	        			gallery.addArtist(artist);
    	        			stepArtist = "0";
    	    			}
    				}

	    			if(stepArtist.equals("99")) {
	    				loopArtist = false;
	    			}
    			}
    			break;
    				
    		case "W":
    			boolean loopArtwork = true, loopArtworkStatus = true; 
    			while(loopArtwork) {
    				Artwork artwork;
    				ArrayList<Artist> artist = gallery.searchArtists("");
    				ArrayList<Customer> customer = gallery.searchCustomers("");
    				String stepArtwork = "0";
    				
    				if(stepArtwork.equals("0")){
    					System.out.println("Do you wish to add to the artwork list? (Y/N)");
    					String optQuit = classInput.nextLine();
    	    			
    	    			if(optQuit.toUpperCase().equals("N")) {
    	    				stepArtwork = "99";
    	    			}else {
    	    				stepArtwork = "1";
    	    			}
    				}
    				
    				if(stepArtwork.equals("1")) {
	    				System.out.println("\nEnter the artwork's title: ");
	    				name = classInput.nextLine();
	    				
	    				String artworkStatusInput, datePur, dateSold;
	    				
	    				while(loopArtworkStatus) {
	    					System.out.println("\nIs the artwork sold(Y/N): ");
	    					artworkStatusInput= classInput.nextLine().toUpperCase();
	    					
	    					boolean loopArtworkArtist = true, loopArtworkCustomer = true, loopArtworkPrice = true;
	    					String artworkDatePur, artworkDateSold;
	    					double artworkPurPriceDouble = 0, artworkSoldPriceDouble = 0;
	    					
	    					switch(artworkStatusInput) {
	    						case "Y":
	    						
	    							System.out.println("\nEnter date of purchase for the artwork: ");
	    							artworkDatePur = classInput.nextLine();
	    							
	    							System.out.println("\nEnter date sold for the artwork: ");
	    							artworkDateSold = classInput.nextLine();
	    							
	    							do {
	    								gallery.listArtists();
	    								System.out.println("\nEnter the artist's name: ");
	    								String artistName = classInput.nextLine();
	    								
	    								ArrayList<Artist> matchingArtist = gallery.searchArtists(artistName);
	    								
	    								if (matchingArtist.isEmpty()) {
	    									System.out.println("\nArtist not in the list. Please enter the right name.");
	    									con();
	    								} else {
	    									artist = matchingArtist;
	    									loopArtworkArtist = false;
	    								}
	    								
	    							}while(loopArtworkArtist);
	    							
	    							do {
	    								gallery.listCustomers();
	    								System.out.println("\nEnter the customer's name: ");
	    								String customerName = classInput.nextLine();
	    								
	    								ArrayList<Customer> matchingCustomer = gallery.searchCustomers(customerName);
	    								if (matchingCustomer.isEmpty()) {
	    									System.out.println("\nCustomer not in the list. Please enter the right name.");
	    									con();
	    								} else {
	    									customer = matchingCustomer;
	    									loopArtworkCustomer = false;
	    								}
	    								
	    							}while(loopArtworkCustomer);
	    							
	    							do {
	    								try {
	    									System.out.println("\nEnter the price of purchase for the artwork: ");
	    									String artworkPurPrice = classInput.nextLine();
	    									artworkPurPriceDouble = Double.parseDouble(artworkPurPrice);
	    									
	    									System.out.println("\nEnter the price sold for the artwork: ");
	    									String artworkSoldPrice = classInput.nextLine();
	    									artworkSoldPriceDouble = Double.parseDouble(artworkSoldPrice);
	    									
	    									loopArtworkPrice = false;
	    									
	    								}catch(NumberFormatException e) {
	    									System.out.println("\nEnter a number value.");
	    									con();
	    								}
	    								
	    								loopArtworkPrice = false;
	    								
	    							}while(loopArtworkPrice);
	    							
	    							artwork = new Artwork(name, artworkDatePur, artworkDateSold, artist.get(0).getName(), customer.get(0).getName(), artworkPurPriceDouble, artworkSoldPriceDouble);
	    							gallery.addArtwork(artwork);
	    							
	    							break;
	    							
	    						case "N":
	    							//gallery.listArtwork();
	    							System.out.println("\nEnter date of purchase for the artwork: ");
	    							artworkDatePur = classInput.nextLine();
	    							
	    							do {
	    								gallery.listArtists();
	    								System.out.println("\nEnter the artist's name: ");
	    								String artistName = classInput.nextLine();
	    								
	    								ArrayList<Artist> matchingArtist = gallery.searchArtists(artistName);
	    								if (matchingArtist.isEmpty()) {
	    									System.out.println("\nArtist not in the list. Please enter the right name.");
	    									con();
	    								} else {
	    									artist = matchingArtist;
	    									loopArtworkArtist = false;
	    								}
	    								
	    							}while(loopArtworkArtist);
	    							
	    							do {
	    								try {
	    									System.out.println("\nEnter the price of purchase for the artwork: ");
	    									String artworkPurPrice = classInput.nextLine();
	    									artworkPurPriceDouble = Double.parseDouble(artworkPurPrice);
	    									
	    								}catch(NumberFormatException e) {
	    									System.out.println("\nEnter a number value.");
	    									con();
	    								}
	    								
	    								loopArtworkPrice = false;
	    								
	    							}while(loopArtworkPrice);
	    							
	    							artwork = new Artwork(name, artworkDatePur, artist.get(0).getName(), artworkPurPriceDouble);
	    							gallery.addArtwork(artwork);
	    							
	    							stepArtwork = "0";
	    							break;
	    							
	    						default:
	    							System.out.println("Invalid Option entered.");
	    			    			con();
	    			    			break;
	    					}
	    					loopArtworkStatus = false;
	    				}
	    				
    				}
    				
    				if(stepArtwork.equals("99")) {
    					loopArtwork = false;
    				}

    			}
    			break;
    			
    		case "C":
    			boolean loopCustomer = true, loopArtworkPurchases = true, loopCustomerPreference = true;
    			while(loopCustomer) {
        			Customer customer;
        			String stepCustomer = "0";
        			
    				if(stepCustomer.equals("0")) {
    					System.out.println("Do you wish to add to the customer list? (Y/N)");
    					String optQuit = classInput.nextLine().toUpperCase();
    	    			
    	    			if(optQuit.equals("N")) {
    	    				stepCustomer = "99";
    	    			}else {
    	    				stepCustomer = "1";
    	    			}
    				}
    				
    				if(stepCustomer.equals("1")) {
    					System.out.println("\nEnter a customer's name: ");
    					name = classInput.nextLine();
    					
    					System.out.println("\nEnter the contact information: ");
    					String customerContactInfo = classInput.nextLine();
    					
    					ArrayList<String> customerPurchases = new ArrayList<>();
    					ArrayList<String> artistPreferenceName = new ArrayList<>();
    					
    					while(loopArtworkPurchases) {
    						System.out.println("\nEnter the artwork purchases(Q to Quit): ");
    						String customerPurchasesInput = classInput.nextLine();
    						
    						if(customerPurchasesInput.toUpperCase().equals("Q")) {
    							loopArtworkPurchases = false;
    						}else {
    							customerPurchases.add(customerPurchasesInput);
    						}
    						
    					}
    					
    					while(loopCustomerPreference) {
    						System.out.println("\nEnter the artist preference name(Q to Quit): ");
    						String customerPreferenceInput = classInput.nextLine();
    						
    						if(customerPreferenceInput.toUpperCase().equals("Q")) {
    							loopCustomerPreference = false;
    						}else {
    							artistPreferenceName.add(customerPreferenceInput);
    						}
    						
    					}
    					customer = new Customer(name, customerContactInfo, customerPurchases, artistPreferenceName);
    					gallery.addCustomer(customer);
    					
    					stepCustomer = "0";
    				}
    				
    				if(stepCustomer.equals("99")) {
    					loopCustomer = false;
    				}
    			}
    			
    			
    			break;
    		case "Q":
    			System.out.println("Exiting adding program");
    			loop = false;
    			break;
    		default:
    			System.out.println("Invalid Option entered.");
    			con();
    			break;
    		}
    	}
    	gallery.saveData();
    }

    public void delete(UXGallery gallery) {
    	boolean loop = true;
    	Scanner classInput = new Scanner(System.in);
    	gallery.readInformationFromFile();
    	
    	do 
    	{
    		System.out.println("\nSelect an option to delete from \nT - Artist\nW - Artwork\nC - Customer\nQ - Quit\nEnter Option:");
    		String opt = classInput.nextLine().toUpperCase();
    		
    		switch(opt)
    		{
    		case "T":
    			boolean loopArtistDelete = true;
    			do {
    				System.out.println("\nEnter the artist's name to delete(Q to Quit): ");
        			String artistName = classInput.nextLine();
                                
        			
        			if(artistName.toUpperCase().equals("Q")) {
        				loopArtistDelete = false;
        				
        			}else if(gallery.searchArtists(artistName).size() == 0) {
        				System.out.println("\nPlease enter the correct artist's name.");
        				con();
        				
        			}else {
        				gallery.deleteArtist(gallery.searchArtists(artistName).get(0));
        				System.out.println("\nThe artist has been deleted. ");
        			}
        			
    			}while(loopArtistDelete);
    			break;
    			
    		case "W":
    			boolean loopArtworkDelete = true;
    			do {
    				System.out.println("\nEnter the artwork's name(Q to Quit): ");
        			String artworkName = classInput.nextLine();
                                
        			
        			if(artworkName.toUpperCase().equals("Q")) {
        				loopArtworkDelete = false;
        				
        			}else if(gallery.searchArtwork(artworkName).size() == 0) {
        				System.out.println("\nPlease enter the correct artwork's name.");
        				con();
        				
        			}else {
        				gallery.deleteArtwork(gallery.searchArtwork(artworkName).get(0));
        				System.out.println("\nThe artwork has been deleted. ");
        			}
        			
    			}while(loopArtworkDelete);
    			break;
    			
    		case "C":
    			boolean loopCustomerDelete = true;
    			do {
    				System.out.println("\nEnter the customer's name(Q to Quit): ");
        			String customerName = classInput.nextLine();
        			
        			if(customerName.toUpperCase().equals("Q")) {
        				loopCustomerDelete = false;
        				
        			}else if(gallery.searchCustomers(customerName).size() == 0) {
        				System.out.println("\nPlease enter the correct customer's name.");
        				con();
        			}else {
        				gallery.deleteCustomer(gallery.searchCustomers(customerName).get(0));
                                        System.out.println("\nThe customer has been deleted. ");
        			}
        			
    			}while(loopCustomerDelete);
    			break;
    			
    		case "Q":
    			System.out.println("Exiting delete program");
    			loop = false;
    			con();
    			break;
    			
    		default:
    			System.out.println("Invalid Option entered.");
    			con();
    			break;
    			
    		}
    	}while(loop);

		gallery.saveData();
    }
    
    public void modify(UXGallery gallery) {
    	boolean loop = true;
    	Scanner classInput = new Scanner(System.in);
    	gallery.readInformationFromFile();
    	
    	do 
    	{
    		System.out.println("\nSelect an option to modify from \nT - Artist\nW - Artwork\nC - Customer\nQ - Quit\nEnter Option:");
    		String opt = classInput.nextLine().toUpperCase();
    		
    		switch(opt)
    		{
    		case "T":
    			boolean loopOldArtistModify = true;
    			
    			do {
    				System.out.println("\n\n");
    				gallery.listArtists();
	    			System.out.print("Enter the name of the artist to be modified: ");
	    			String artistName = classInput.nextLine();
	    			ArrayList<Artist> matchingArtist = gallery.searchArtists(artistName);
	    			String stepArtistModify = "0";
	    			
	    			if(artistName.toUpperCase().equals("Q")) {
	    				stepArtistModify = "99";
	    				
	    			}else if(matchingArtist.size() == 0) {
	    				System.out.println("\nPlease enter a valid artist name.");
	    				con();
	    				
	    			}else {
	    				stepArtistModify ="1";
	    				
	    			}
	    			
	    			if(stepArtistModify.equals("1")) {
	    			
		    			Artist oldArtist = matchingArtist.get(0);
		    			Artist newArtist;
		    			
		    			boolean loopNewArtistModify = true;
		    			
		    			do {
			    			System.out.println("\nSelect an option to modify(Enter numerical values) \n1. Artist Name\n2.Artist Speciality\n3. Vital Status\n4. Price of artwork range\n5. Quit");
			    			String artistModifyOpt = classInput.nextLine();
			    			switch(artistModifyOpt) {
			    			case "1":
			    				System.out.print("Enter the new name of the artist: ");
				    		    String newName = classInput.nextLine();
				    		    
				    		    newArtist = new Artist(newName, oldArtist.getSpecialty(), oldArtist.getVital(), oldArtist.getPriceRangeOfArtwork());
				    		    gallery.modifyArtist(oldArtist, newArtist);
				    		    
				    		    break;
				    		
			    			case "2":
			    				ArrayList<String> newSpecialties = new ArrayList<String>();
				    		    
				    		    boolean loopArtistSpecialtyModify = true;
				    		    do {
					    		    System.out.print("Enter the artist's specialties(Q to Quit): ");
					    		    String specialtiesString = classInput.nextLine();
					    		    
					    		    if(specialtiesString.toUpperCase().equals("Q")) {
					    		    	loopArtistSpecialtyModify = false;
					    		    	
					    		    }else {
					    		    	newSpecialties.add(specialtiesString);
					    		    	
					    		    }
					    		    
				    		    }while(loopArtistSpecialtyModify);
				    		    
				    		    newArtist = new Artist(oldArtist.getName(), newSpecialties, oldArtist.getVital(), oldArtist.getPriceRangeOfArtwork());
				    		    gallery.modifyArtist(oldArtist, newArtist);
					    		
				    		    break;
				    		
			    			case "3":
			    				boolean newVital;
				    		    do {
				    		        System.out.println("Alive = 1, Dead = 0");
				    		        System.out.print("Enter the artist's vital status: ");
				    		        String vitalInput = classInput.nextLine();
				    		        if (vitalInput.equals("1")) {
				    		            newVital = true;
				    		            break;
				    		            
				    		        } else if (vitalInput.equals("0")) {
				    		            newVital = false;
				    		            break;
				    		            
				    		        } else {
				    		            System.out.println("Invalid input. Please try again.");
				    		            
				    		        }
				    		    } while(true);
				    		    
				    		    newArtist = new Artist(oldArtist.getName(), oldArtist.getSpecialty(), newVital, oldArtist.getPriceRangeOfArtwork());
				    		    gallery.modifyArtist(oldArtist, newArtist);
				    		    
				    		    break;
				    		    
			    			case "4":
			    				System.out.print("Enter the artist's price range of artwork: ");
				    		    String newPriceRange = classInput.nextLine();
				    		    
				    		    newArtist = new Artist(oldArtist.getName(), oldArtist.getSpecialty(), oldArtist.getVital(), newPriceRange);
				    		    gallery.modifyArtist(oldArtist, newArtist);
				    		    
				    		    break;
				    		    
			    			case "5":
			    				System.out.println("Exiting Modify Artist program");
			        			loop = false;
			        			break;
				    		    
			    			default:
			    				System.out.println("\nPlease Select a valid option.");
			    				con();
			    				break;
			    			}
			    			loopNewArtistModify = false;
			    			
		    			}while(loopNewArtistModify);
	    			}
    			
	    			if(stepArtistModify.equals("99")) {
	    				loopOldArtistModify = false;
	    			}
    			
    			}while(loopOldArtistModify);
    			
    			break;
    			
    		case "W":
    			boolean loopOldArtworkModify = true;
    			
    			do {
    				System.out.println("\n\n");
    				gallery.listArtwork();
	    			System.out.print("Enter the name of the artwork to be modified(Q to quit): ");
	    			String artworkName = classInput.nextLine();
	    			ArrayList<Artwork> matchingArtwork = gallery.searchArtwork(artworkName);
	    			String stepArtworkModify = "0";
	    			
	    			if(artworkName.toUpperCase().equals("Q")) {
	    				stepArtworkModify = "99";
	    			}else if(matchingArtwork.size() == 0) {
	    				System.out.println("\nPlease enter a valid artwork name.");
	    				con();
	    			}else {
	    				stepArtworkModify = "1";
	    			}
	    			
	    			if(stepArtworkModify.equals("1")) {
			    			Artwork oldArtwork = matchingArtwork.get(0);
			    			Artwork newArtwork;
			    			
			    			
			    			boolean loopNewArtworkModify = true;
			    			
			    			do {
			    				System.out.println("\nSelect an option to modify(Enter numerical values) \n1. Artwork Name\n2. Date Purchase\n3. Date Sold\n4. Artist's Name\n5. Customer's Name\n6. Price purchased\n7. Price Sold\n8. Quit");
				    			String artworkModifyOpt = classInput.nextLine();
				    			
				    			switch(artworkModifyOpt) {
				    			case "1":
				    				System.out.println("\nEnter the new artwork name/title: ");
				    				String newName = classInput.nextLine();
					    		    
					    		    newArtwork = new Artwork(newName, oldArtwork.getDatePur(), oldArtwork.getDateSold(), oldArtwork.getArtist(), oldArtwork.getCustomer(), oldArtwork.getPricePur(), oldArtwork.getPriceSold());
					    		    gallery.modifyArtwork(oldArtwork, newArtwork);
					    		    
                                                            break;
                                                            
				    			case "2":
				    				System.out.println("\nEnter the date of purchase for the artwork: ");
				    				String newDatePur = classInput.nextLine();
				    				
                                                            newArtwork = new Artwork(oldArtwork.getTitle(), newDatePur, oldArtwork.getDateSold(), oldArtwork.getArtist(), oldArtwork.getCustomer(), oldArtwork.getPricePur(), oldArtwork.getPriceSold());
					    		    gallery.modifyArtwork(oldArtwork, newArtwork);
					    		    
					    		    break;
					    		    
				    			case "3":
				    				
				    				System.out.println("\nEnter the date sold for the artwork: ");
				    				String newDateSold = classInput.nextLine();
				    				
				    				newArtwork = new Artwork(oldArtwork.getTitle(), oldArtwork.getDatePur(), newDateSold, oldArtwork.getArtist(), oldArtwork.getCustomer(), oldArtwork.getPricePur(), oldArtwork.getPriceSold());
					    		    gallery.modifyArtwork(oldArtwork, newArtwork);
					    		    
					    		    break;
					    		    
				    			case "4":
					    		    
					    		    ArrayList<Artist> newArtist = new ArrayList<>();
					    		    
					    		    boolean loopNewArtworkArtist = true;
				    				do {
		    							gallery.listArtists();
		    							System.out.println("\nEnter the artist's name: ");
		    							String artistName = classInput.nextLine();
		    							
		    							ArrayList<Artist> matchingArtist = gallery.searchArtists(artistName);
		    							if (matchingArtist.isEmpty()) {
		    								System.out.println("\nArtist not in the list. Please enter the right name.");
		    								con();
		    							} else {
		    								newArtist = matchingArtist;
		    								newArtwork = new Artwork(oldArtwork.getTitle(), oldArtwork.getDatePur(), oldArtwork.getDateSold(), newArtist.get(0).getName(), oldArtwork.getCustomer(), oldArtwork.getPricePur(), oldArtwork.getPriceSold());
							    		    gallery.modifyArtwork(oldArtwork, newArtwork);
							    		    loopNewArtworkArtist = false;
		    							}
		    							
		    						}while(loopNewArtworkArtist);
				    			
					    		    break;
					    		    
				    			case "5":
	
					    		    ArrayList<Customer> newCustomer = new ArrayList<>();
					    		    
					    		    boolean loopNewArtworkCustomer = true;
				    				do {
		    							gallery.listCustomers();
		    							System.out.println("\nEnter the customer's name: ");
		    							String customerName = classInput.nextLine();
		    							
		    							ArrayList<Customer> matchingCustomer = gallery.searchCustomers(customerName);
		    							if (matchingCustomer.isEmpty()) {
		    								System.out.println("\nCustomer not in the list. Please enter the right name.");
		    								con();
		    							} else {
		    								newCustomer = matchingCustomer;
		    								newArtwork = new Artwork(oldArtwork.getTitle(), oldArtwork.getDatePur(), oldArtwork.getDateSold(), oldArtwork.getArtist(), newCustomer.get(0).getName(), oldArtwork.getPricePur(), oldArtwork.getPriceSold());
							    		    gallery.modifyArtwork(oldArtwork, newArtwork);
							    		    loopNewArtworkCustomer = false;
		    							}
		    							
		    						}while(loopNewArtworkCustomer);
				    				
					    		    break;
					    		    
				    			case "6":
				    				
				    				boolean loopNewPriceofPurchase = true;
				    				do {
				    					try {
				    						
				    						System.out.println("\nEnter the price of purchase: ");
				    						String newPriceofPur = classInput.nextLine();
				    						double newPriceofPurDouble = Double.parseDouble(newPriceofPur);
				    						
				    						newArtwork = new Artwork(oldArtwork.getTitle(), oldArtwork.getDatePur(), oldArtwork.getDateSold(), oldArtwork.getArtist(), oldArtwork.getCustomer(), newPriceofPurDouble, oldArtwork.getPriceSold());
							    		    gallery.modifyArtwork(oldArtwork, newArtwork);
							    		    loopNewPriceofPurchase = false;
				    						
				    					}catch(NumberFormatException e) {
				    						System.out.println("\nEnter a numerical value\nExample : 13.69\n");
				    						con();
				    					}
				    					
				    				}while(loopNewPriceofPurchase);
				    				
				    				break;
				    				
				    			case "7":
				    				
				    				boolean loopNewPriceofSelling = true;
				    				do {
				    					try {
				    						
				    						System.out.println("\nEnter the price sold: ");
				    						String newPriceSold = classInput.nextLine();
				    						double newPriceSoldDouble = Double.parseDouble(newPriceSold);
				    						
				    						newArtwork = new Artwork(oldArtwork.getTitle(), oldArtwork.getDatePur(), oldArtwork.getDateSold(), oldArtwork.getArtist(), oldArtwork.getCustomer(), oldArtwork.getPricePur(), newPriceSoldDouble);
							    		    gallery.modifyArtwork(oldArtwork, newArtwork);
							    		    loopNewPriceofSelling = false;
				    						
				    					}catch(NumberFormatException e) {
				    						System.out.println("\nEnter a numerical value\nExample : 13.69\n");
				    						con();
				    					}
				    					
				    				}while(loopNewPriceofSelling);
				    				
				    				break;
				    				
				    			case "8":
				    				System.out.println("Exiting Modify Artwork program");
				        			loop = false;
				        			break;
				    				
				    			default:
				    				System.out.println("\nPlease Select a valid option.");
				    				con();
				    				break;
				    				
				    			}
				    			loopNewArtworkModify = false;
				    			
			    			}while(loopNewArtworkModify);
		    			}
	    			
	    			if(stepArtworkModify.equals("99")) {
	    				loopOldArtworkModify = false;
	    			}
	    			
    			}while(loopOldArtworkModify);
    			
    			break;
    			
    		case "C":
    			boolean loopOldCustomerModify = true;
    			
    			do {
    				System.out.println("\n\n");
    				gallery.listCustomers();
	    			System.out.print("Enter the name of the customer name to be modified(Q to Quit): ");
	    			String customerName = classInput.nextLine();
	    			ArrayList<Customer> matchingCustomer = gallery.searchCustomers(customerName);
	    			String stepCustomerModify = "0";
	    			
	    			if(customerName.toUpperCase().equals("Q")) {
	    				stepCustomerModify = "99";
	    				
	    			}else if(matchingCustomer.size() == 0) {
	    				System.out.println("\nPlease enter a valid customer name.");
	    				con();
	    				
	    			}else {
	    				stepCustomerModify = "1";
	    			}
	    				
	    			if(stepCustomerModify.equals("1")) {
		    			
		    				Customer oldCustomer = matchingCustomer.get(0);
		    				Customer newCustomer;
		    				
		    				boolean loopNewCustomerModify = true;
		    				do {
		    					System.out.println("\nSelect an option to modify(Enter numerical values) \n1. Customer's Name\n2. Contact Information\n3. Artwork Purchases\n4. Artist Preferences\n5. Quit\n");
				    			String customerModifyOpt = classInput.nextLine();
				    			
				    			switch(customerModifyOpt) {
				    			case "1":
				    				System.out.println("\nEnter the new customer name: ");
				    				String newName = classInput.nextLine();
				    				
				    				newCustomer = new Customer(newName, oldCustomer.getContactInformation(), oldCustomer.getArtworkPurchases(), oldCustomer.getArtistPreferences());
					    		    gallery.modifyCustomer(oldCustomer, newCustomer);
					    		    
					    		    break;
					    		    
				    			case "2":
				    				
				    				System.out.println("\nEnter the new customer's contact information:");
				    				String newContactInformation = classInput.nextLine();
				    				
				    				newCustomer = new Customer(oldCustomer.getName(), newContactInformation, oldCustomer.getArtworkPurchases(), oldCustomer.getArtistPreferences());
					    		    gallery.modifyCustomer(oldCustomer, newCustomer);
					    		    
					    		    break;
				    			case "3":
				    				
				    				ArrayList<String> newArtworkPurchases = new ArrayList<String>();
					    		    
					    		    boolean loopArtworkPurchasesModify = true;
					    		    newArtworkPurchases.clear();
					    		    
					    		    do {
						    		    System.out.print("Enter the customer's artwork puchases(Q to Quit): ");
						    		    String ArtworkPurchasesString = classInput.nextLine();
						    		    
						    		    if(ArtworkPurchasesString.toUpperCase().equals("Q")) {
						    		    	loopArtworkPurchasesModify = false;
						    		    }else{
                                                                        newArtworkPurchases.add(ArtworkPurchasesString);
						    		    
                                                                    }
						    		    
					    		    }while(loopArtworkPurchasesModify);
					    		    
					    		    newCustomer = new Customer(oldCustomer.getName(), oldCustomer.getContactInformation(), newArtworkPurchases, oldCustomer.getArtistPreferences());
					    		    gallery.modifyCustomer(oldCustomer, newCustomer);
						    		
					    		    break;
					    		    
				    			case "4":
				    				
				    				ArrayList<String> newArtistPreferences = new ArrayList<String>();
					    		    
					    		    boolean loopArtistPreferencesModify = true;
					    		    newArtistPreferences.clear();
					    		    
					    		    do {
						    		    System.out.print("Enter the customer's artist preferences(Q to Quit): ");
						    		    String ArtistPreferenceString = classInput.nextLine();
						    		    
						    		    if(ArtistPreferenceString.toUpperCase().equals("Q")) {
						    		    	loopArtistPreferencesModify = false;
						    		    }else {
                                                                        newArtistPreferences.add(ArtistPreferenceString);
						    		    
                                                                    }
						    		    
					    		    }while(loopArtistPreferencesModify);
					    		    
					    		    newCustomer = new Customer(oldCustomer.getName(), oldCustomer.getContactInformation(), oldCustomer.getArtworkPurchases(), newArtistPreferences);
					    		    gallery.modifyCustomer(oldCustomer, newCustomer);
						    		
					    		    break;
					    		    
				    			case "5":
				    				System.out.println("Exiting Modify Customer program");
				        			loop = false;
				        			break;
				        			
				    			default:
				    				System.out.println("\nPlease Select a valid option.");
				    				con();
				    				break;
				    			}
		    					loopNewCustomerModify = false;
				    			
		    				}while(loopNewCustomerModify);
		    				
		    			}
	    			
	    			if(stepCustomerModify.equals("99")) {
	    				loopOldCustomerModify = false;
	    			}
	    			
    			}while(loopOldCustomerModify);
    			
    			break;
    			
    		case "Q":
    			System.out.println("Exiting modify program");
    			loop = false;
    			con();
    			break;
    			
    		default:
    			System.out.println("Invalid Option entered.");
    			con();
    			break;
    			
    		}
    	}while(loop);

		gallery.saveData();
    }
    
    public void search(UXGallery gallery) {
    	boolean loop = true;
    	Scanner classInput = new Scanner(System.in);
    	gallery.readInformationFromFile();
    	
    	do 
    	{
    		System.out.println("\nSelect an option to search from \nT - Artist\nW - Artwork\nC - Customer\nQ - Quit\nEnter Option:");
    		String opt = classInput.nextLine().toUpperCase();
    		
    		switch(opt)
    		{
    		case "T":
    			boolean loopArtistSearch = true;
    			do {
    				System.out.println("\n\n");
    				gallery.listArtists();
    				
    				System.out.println("\nEnter the artist's name(Q to Quit): ");
        			String artistName = classInput.nextLine();
        			
        			if(artistName.toUpperCase().equals("Q")) {
        				loopArtistSearch = false;
        				
        			}else if(gallery.searchArtists(artistName).size() == 0) {
        				System.out.println("\nPlease enter the correct artist's name.");
        				con();
        				
        			}else {
        				ArrayList<Artist> artistDetail = gallery.searchArtists(artistName);
        				System.out.println(artistDetail);
        				
        			}
    			}while(loopArtistSearch);
    			
    			break;
    			
    		case "W":
    			boolean loopArtworkSearch = true;
    			do {
    				System.out.println("\n\n");
    				gallery.listArtwork();
    				
    				System.out.println("\nEnter the artwork's name(Q to Quit): ");
        			String artworkName = classInput.nextLine();
        			
        			if(artworkName.toUpperCase().equals("Q")) {
        				loopArtworkSearch = false;
        				
        			}else if(gallery.searchArtwork(artworkName).size() == 0) {
        				System.out.println("\nPlease enter the correct artwork's name.");
        				con();
        				
        			}else {
        				ArrayList<Artwork> artworkDetail = gallery.searchArtwork(artworkName);
        				System.out.println(artworkDetail);
        				
        			}
    			}while(loopArtworkSearch);
    			
    			break;
    			
    		case "C":
    			boolean loopCustomerSearch = true;
    			do {
    				System.out.println("\n\n");
    				gallery.listCustomers();
    				
    				System.out.println("\nEnter the customer's name(Q to Quit): ");
        			String customerName = classInput.nextLine();
        			
        			if(customerName.toUpperCase().equals("Q")) {
        				loopCustomerSearch = false;
        				
        			}else if(gallery.searchCustomers(customerName).size() == 0) {
        				System.out.println("\nPlease enter the correct customer's name.");
        				con();
        				
        			}else {
        				ArrayList<Customer> customerDetail = gallery.searchCustomers(customerName);
        				System.out.println(customerDetail);
        				
        			}
    			}while(loopCustomerSearch);
    			
    			break;
    			
    		case "Q":
    			System.out.println("Exiting searching program");
    			loop = false;
    			break;
    			
    		default:
    			System.out.println("Invalid Option entered.");
    			con();
    			break;
    		}
    	}while(loop);
    }
    
    public void list(UXGallery gallery) {
    	boolean loop = true;
    	Scanner classInput = new Scanner(System.in);
    	gallery.readInformationFromFile();
    	
    	do 
    	{
    		System.out.println("\nSelect to list Artwork or Quit from\nW - Artwork\nQ - Quit\nEnter Option:");
    		String opt = classInput.nextLine().toUpperCase();
    		
    		switch(opt.toUpperCase())
    		{
    		case "W":
    			boolean loopArtworkList = true;
    			do {
    				//String displayFormat = String.format();
    				System.out.println("The Avaialble Artworks: ");
    				ArrayList<Artwork> artworkAvailability = gallery.searchArtworkAvailability();
    				
    				for(Artwork aList: artworkAvailability) {
    					System.out.println(aList.toString());
    				}
    				
    				System.out.println("\n\nQ to Quit");
    				String quitScanner = classInput.nextLine();
    				if(quitScanner.toUpperCase().equals("Q")) {
    					loopArtworkList = false;
    				}
    				
    			}while(loopArtworkList);
    			
    			break;

    		case "Q":
    			System.out.println("Exiting adding program");
    			loop = false;
    			con();
    			break;
    			
    		default:
    			System.out.println("Invalid Option entered.");
    			con();
    			break;
    		}
    	}while(loop);
    }
    
    public void con()
    {
    	Scanner continueInput = new Scanner(System.in);
    	System.out.println("Press Enter to continue...");
    	continueInput.nextLine();
    	System.out.println("\n\n\n\n");
    	//continueInput.close();
    }
}
