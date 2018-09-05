import java.util.ArrayList;


public class Profile { 
	String fullName;
	int age;
	String location;
	String relationship;	
	ArrayList<Profile> friends = new ArrayList<Profile> ();
	Profile parent;
	
	public Profile(Profile user1, Profile user2) { 
	    fullName = user1.fullName;
	    friends=user1.friends;
	    parent = user2;
	}
	public Profile(String name, int a, String loc) { 
		fullName = name;
		age = a;
		location = loc;
	}
    
    public void becomeString() { 
        System.out.println("Profile Name: "+ fullName);
        System.out.println("Age: "+age);
        System.out.println("Location: "+location);
        
        ArrayList<String> names = new ArrayList<String> ();
        for (int i = 0 ; i< friends.size();i++) {
            names.add(friends.get(i).fullName);
        }
        System.out.println("Friends List: "+names.toString());
    }


}