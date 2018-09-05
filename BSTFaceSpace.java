import java.util.ArrayDeque;
import java.util.ArrayList;

public class BSTFaceSpace {

    private Node root; 

    private class Node { 

        private String key;  

        private Profile element;  

        private Node left, right;

        public Node(String key, Profile element) { 

            this.key = key;

            this.element = element;

        }

    }

    ArrayList<Profile> delete = new ArrayList<Profile> (); 

    public BSTFaceSpace() { 

        root = null;

    }

    public void insert(Profile data) { 
        if(search(data.fullName)==null)
            delete.add(data); 
        root = insert(root, data.fullName, data); 
    }

    private Node insert(Node x, String key, Profile data) { 

        if ( x == null ) return new Node (data.fullName, data);  

        int current = key.compareToIgnoreCase(x.key);  

        if (current < 0)

            x.left = insert(x.left, key, data);

        else if (current > 0)

            x.right = insert(x.right, key, data);

        else

            x.element = data;

        return x;

    }

    public Profile search(String key) { 

        Node x = root;

        while ( x != null) {

            int current = key.compareToIgnoreCase(x.key);

            if (current < 0) 

                x = x.left;

            else if (current > 0) 

                x = x.right;

            else  
                return x.element;

        }

        return null;

    }


    public void addFriend(String user1, String user2) { 
        for(int i=0; i<search(user1).friends.size(); i++) {   
        	if(search(user1).friends.get(i)==search(user2)) { 
                System.out.println("The user is already friends with the person.");
                return;
            }
        }
        search(user1).friends.add(search(user2));
        search(user2).friends.add(search(user1)); 
    }
    
    public void removeFriend(String user1, String user2) { 
        for(int i=0; i<search(user1).friends.size(); i++) {
            if(search(user1).friends.get(i)==search(user2)) {  
                search(user1).friends.remove(search(user2));
                search(user2).friends.remove(search(user1));
                System.out.println(user1+" and "+user2+" are no longer friends.");
                return;
            }
        }
        System.out.println("The user does not have them in their friends list.");            
    }
    
    public void updateName(String oldname, String newname) { 
        String relation;
        relation = search(oldname).relationship;
        if (relation != null) search(relation).relationship = newname; 
        search(oldname).fullName = newname;
        root = new Node(delete.get(0).fullName,delete.get(0));
        for (int i=1; i<delete.size(); i++)
            insert(delete.get(i));
    }
    
    public void updateAge(String name, int newAge) { 
        search(name).age = newAge;
    }
    
    public void updateLocation(String name, String newLoc) { 
        search(name).location = newLoc;
    }
    
    
    
    public int degreeSeperation(String user1, String user2) { 
        int counter = 0;
        ArrayList<Profile> path = new ArrayList<Profile> ();
        ArrayDeque<Profile> queue = new ArrayDeque<Profile> ();
        ArrayDeque<String> names = new ArrayDeque<String> ();
        queue.add(search(user1));
        path.add(search(user1));
        while(!queue.isEmpty()) { 
             Profile initial = queue.remove();
             if(initial.fullName == search(user2).fullName) {
            	 Profile x;
                 for (x=initial; x.parent!=null; x=x.parent) {
                    names.push(x.fullName);
                     counter++;
                 }
                 names.push(x.fullName);
                 System.out.println("The path to connect the two users is: ");
                 while(!names.isEmpty()) {
                    System.out.print(names.pop());
                    if (!names.isEmpty()) System.out.print(" to ");
                 }
                 return counter;
             }
             else {
             boolean existence = false;
                 for(int i=0; i<initial.friends.size(); i++) {
                	 existence = false; 
                         for(int a=0; a<path.size(); a++) {
                             if(initial.friends.get(i).fullName.equals(path.get(a).fullName))
                                 existence = true;
                         }
                         if (!existence){
                             queue.add(new Profile(initial.friends.get(i), initial));
                             path.add(new Profile(initial.friends.get(i), initial));
                         }
                 }
             }
        }
        return -1;
    }
    
    public void removeProfile(String user1) { 
        delete.remove(search(user1));  
        while(search(user1).friends.size()!=0)  
            removeFriend(search(user1).fullName,search(user1).friends.get(0).fullName);
        
        if (delete.size()!=0) root = new Node(delete.get(0).fullName, delete.get(0));  
        else root = null; 
        for (int i=0; i<delete.size(); i++)  
            insert(delete.get(i));
        }
    }