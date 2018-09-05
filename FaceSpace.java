import java.util.Scanner;

public class FaceSpace {

	public static void main( String [ ] args )
	{
		BSTFaceSpace t = new BSTFaceSpace( );		
		

		Scanner input = new Scanner(System.in);
		
		while(true){ 
		    System.out.println("List of Commands:");
		    System.out.println(" a) Add Account");
		    System.out.println(" b) Update Account");
		    System.out.println(" c) Add Friend to a user");
		    System.out.println(" d) Remove Friend from a user");
		    System.out.println(" e) Search for a user");
		    System.out.println(" f) Find the Shortest Path Between profiles");
		    System.out.println(" g) Remove a User Profile");
		    System.out.println(" h) Quit");
		    System.out.println("Enter option:");
			String choice = input.nextLine().trim().toLowerCase();

	
			if(choice.equals("a)")||choice.equals("a")) { 
			    String name, location;
			    int age=0;
			    System.out.println("Enter account name: " );
			    name = input.nextLine().trim();
			    
			    Profile temp = t.search(name);
			    boolean quit = false;
			    while(temp!= null) { 
			        System.out.println("The account name already exists!");
			        System.out.println("Enter a new account name, or enter q to return to the main menu.");
			        name = input.nextLine().trim();
			        if (name.toLowerCase().equals("q")) { 
			            quit = true;
			            break;
			        }
			        temp = t.search(name);
			    }
			    while (quit==false) {
    			    System.out.println("Enter Age: ");
    			    while(!input.hasNextInt()) { 
    			    	System.out.println("This is not an int, input an int.");
    			    	input.next();
    			    }
    			    age = input.nextInt();	    			    
    			    System.out.println("Enter Location: ");
    			    input.nextLine();
    			    location = input.nextLine().trim(); 
    			    t.insert(new Profile(name, age, location)); 
    			    System.out.println(name+" has been added to the system!");
    			    System.out.println("The Account has been created! Press any key to continue");
    		        input.nextLine();
    			    break;
			    }
			}

			if(choice.equals("b)")||choice.equals("b")) { 
			    boolean quit = false;
			    String name, location, tempName, tempChoice;
			    int age;
			    System.out.println("Input the name of the profile you would like to update.");
			    name = input.nextLine().trim();
			    Profile temp;
			    temp = t.search(name);  
			    while(temp==null){ 
			        System.out.println("The profile you have entered does not exist!");
			        System.out.println("Enter an existing profile, or press q to return to the main menu");
			        name=input.nextLine().trim();
			        if (name.toLowerCase().equals("q")){
			            quit = true;
			            break;
			        }
			        temp = t.search(name);
			    }
			   
			    while(quit == false) { 
			       
		           System.out.println("\t a) Change name ");
		           System.out.println("\t b) Change Age ");
		           System.out.println("\t c) Change Location ");
		           System.out.println("Enter option:");
		           tempChoice=input.nextLine().trim().toLowerCase();
		          
		           		if(tempChoice.equals("a)")||tempChoice.equals("a")) {
			                System.out.println("What is the new name for the account?");
			                tempName = input.nextLine().trim();
			                temp=t.search(tempName);
			                while(temp!= null) {
			                    System.out.println("The account name you are trying to create already exists!");
			                    System.out.println("Enter a new name, or enter q to return to the main menu.");
			                    tempName = input.nextLine().trim();
			                    if (tempName.toLowerCase().equals("q")) {
			                        quit = true;
			                        break;
			                    }
			                    temp=t.search(tempName);
			                }
			                if (quit == false) { 
			                	t.updateName(name,tempName);
			                	System.out.println("Name Updated: Press any key to continue");
			                }
			               
		            	}
		           
		           		if(tempChoice.equals("b)")||tempChoice.equals("b")) {
			                System.out.println("Enter age");
		    			    while(!input.hasNextInt()) {  
		    			    	System.out.println("This is not an integer, please input an int.");
		    			    	input.next();
		    			    }
			                age = input.nextInt();
			                t.updateAge(name, age); 
			                input.nextLine();
			                System.out.println("Age Updated: Press any key to continue");
    		        		input.nextLine();
		            	}
		           
		           		if(tempChoice.equals("c)")||tempChoice.equals("c")) {
			                System.out.println("Enter location");
			                location = input.nextLine().trim();
			                t.updateLocation(name, location);  
			                System.out.println("Location Updated: Press any key to continue");
    		        		input.nextLine();
		            	}
		           
			    }
			    
			}

			if(choice.equals("c)")||choice.equals("c")) { 
			    String firstUser, secondUser;
			    Profile temp;
			    boolean quit =false;
			    
				System.out.println("Please input the name of the name of the profile you want to add a friend to!");
			    firstUser=input.nextLine().trim();
			    temp=t.search(firstUser);
			    
                while(temp== null) {  
                    System.out.println("This account does not exist!");
                    System.out.println("Please enter a new account name, or enter q to return to the main menu.");
                    firstUser = input.nextLine().trim();
                    if (firstUser.toLowerCase().equals("q")) {
                        quit = true;
                        break;
                    }
                    temp = t.search(firstUser);
                }

                while(quit==false){
				    System.out.println("Please input the name of the person who should be his/her friend!");
				    secondUser=input.nextLine().trim();
				    
				    temp=t.search(secondUser);
				
	                while(temp== null) {
	                    System.out.println("This account does not exist");
	                    System.out.println("Please enter a new account name, or enter q to return to the main menu.");
	                    secondUser = input.nextLine().trim();
	                    if (secondUser.toLowerCase().equals("q")) {
	                        quit = true;
	                        break;
	                    }
	                    temp = t.search(secondUser);
	                }
	                if (quit == true) break;
	                t.addFriend(firstUser, secondUser); 
	                System.out.println(firstUser+" and "+secondUser +" are friends!");
	                System.out.println("Press any key to continue");
    		        input.nextLine();
	                break;
                }
                
			    
			}
			if(choice.equals("d)")||choice.equals("d")) { 
			    System.out.println("Enter name of profile: ");
			    String firstUser, secondUser;
			    Profile temp;
			    boolean quit =false;
			    firstUser=input.nextLine().trim();
			    temp=t.search(firstUser);
			    
                while(temp== null) {  
                    System.out.println("This account does not exist!");
                    System.out.println("Enter a new account, or enter q to return to the main menu.");
                    firstUser = input.nextLine().trim();
                    if (firstUser.toLowerCase().equals("q")) {
                        quit = true;
                        break;
                    }
                    temp = t.search(firstUser);
                }
                while(quit==false){
				    System.out.println("Input account");
				    secondUser=input.nextLine().trim();
				    
				    temp=t.search(secondUser);
				
	                while(temp== null) { 
	                    System.out.println("This account does not exist");
	                    System.out.println("Enter another name, or enter q to return to the main menu.");
	                    secondUser = input.nextLine().trim();
	                    if (secondUser.toLowerCase().equals("q")) {
	                        quit = true;
	                        break;
	                    }
	                    temp = t.search(secondUser);
	                }
	                if (quit == true) break;
	                t.removeFriend(firstUser, secondUser); 
	                System.out.println("Press any key to continue");
    		        input.nextLine();
	                break;
                }
			    
			    
			}

			if(choice.equals("e)")||choice.equals("e")) { 
			    String key;
			    Profile temp;
			    System.out.println("Enter name of profile");
			    key = input.nextLine().trim();
			    temp = t.search(key); 
			    System.out.println();
			
			    if (temp == null) System.out.println("Account does not exist.");
			    else temp.becomeString();
			   	System.out.println("Press any key to continue");
    		    input.nextLine();
			}

			if(choice.equals("f)")||choice.equals("f")) { 
			    String firstUser, secondUser;
			    boolean quit = false;
			    Profile temp;
				System.out.println("Please input the first user: ");
				firstUser=input.nextLine().trim();
				temp = t.search(firstUser);
                while(temp== null) { 
                    System.out.println("This account does not exist!");
                    System.out.println("Enter a new name, or enter q to return to the main menu.");
                    firstUser = input.nextLine().trim();
                    if (firstUser.toLowerCase().equals("q")) {
                        quit = true;
                        break;
                    }
                    temp = t.search(firstUser);
                }
                if(!quit){
					System.out.println("Please input the second user: ");
					secondUser=input.nextLine().trim();
					System.out.println();
			    	while(firstUser.equals(secondUser)) { 
	                    System.out.println("Enter another name, or enter q to return to the main menu.");
	                    secondUser = input.nextLine().trim();
	                    if (secondUser.toLowerCase().equals("q")) {
	                        quit = true;
	                        break;
	                    }
	                    temp = t.search(secondUser);
	                }
			    	if(!quit) {
			    		temp = t.search(secondUser);
			    		while(temp== null) {
		                    System.out.println("This account does not exist!");
		                    System.out.println("Enter a new name, or enter q to return to the main menu.");
		                    secondUser = input.nextLine().trim();
		                    if (secondUser.toLowerCase().equals("q")) {
		                        quit = true;
		                        break;
		                    }
		                    temp = t.search(secondUser);
			    		}
		                if (!quit){
							int deg = t.degreeSeperation(firstUser,secondUser);  
							System.out.println();
							
							if (deg<0) System.out.println("Users are not connected by friends.");
							else if (deg == 1) System.out.println("These users are currently friends, so they have no degree of seperation.");
							else System.out.println("The users are sepereated by "+ (deg-1)+" friends.");
		                }
			    	}
                }
                System.out.println("Press any key to continue");
    		    input.nextLine();
			}

			if(choice.equals("g)")||choice.equals("g")) {
			    String removeUser;
			    boolean quit = false;
			    Profile temp;
				System.out.println("input profile name: ");
				removeUser=input.nextLine().trim();
				temp = t.search(removeUser);
                while(temp== null) {  
                    System.out.println("This account does not exist!");
                    System.out.println("Please enter an existing account to delete, or enter q to return to the main menu.");
                    removeUser = input.nextLine().trim();
                    if (removeUser.toLowerCase().equals("q")) {
                        quit = true;
                        break;
                    }
                    temp = t.search(removeUser);
                }
                if(!quit){  
			    	t.removeProfile(removeUser);
			    	System.out.println(removeUser+" has been removed. ");
                }
                System.out.println("Press any key to continue");
    		    input.nextLine();
			}

			if(choice.equals("h)")||choice.equals("h")) { 
			    break;
			}
		}
		
		
	}
}