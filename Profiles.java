import java.util.ArrayList;


public class Profiles { // Profile class
	String fullName;
	int age;
	String location;
	String relationship;	
	ArrayList<Profile> friends = new ArrayList<Profile> ();
	Profile parent;
	
	public Profiles(Profile user1, Profile user2) { // constructor to find the degree separation
	    fullName = user1.fullName;
	    friends=user1.friends;
	    parent = user2;
	}
	public Profiles(String name, String loc) { // constructor
		fullName = name;
		
		location = loc;
	}
    
    public void becomeString() { // for printing purposes
        System.out.println("Profile Name: "+ fullName);
       
        System.out.println("Location: "+location);
        ArrayList<String> names = new ArrayList<String> ();
        for (int i = 0 ; i< friends.size();i++) {
            names.add(friends.get(i).fullName);
        }
        System.out.println("Friends List: "+names.toString());
    }


}