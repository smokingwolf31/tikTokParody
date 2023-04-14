import java.util.ArrayList;

/**
 * The Account object is used to model a toktik account having an account name, account description and all the post the account
 * @date 12 April 2023
 * @author Nkabinde Mnqobi
 */
public class Account implements Comparable<Account>{
   public String accName;
   public String accDescription;
   public BinarySearchTree<Post> posts;
   public ArrayList<String> postTitle;
   
   /**
    * Default Account constuctor
    */
   public Account(){
      posts = new BinarySearchTree();
      postTitle = new ArrayList<>();
   }
   /**
    * Account constuctor used to search a AVLTree using the account name i.e AVLtree.find(new Account(String accName)) accDesciption will be null
    * @param accName pass in the account name of your new Account object
    */
   public Account(String accName){
      posts = new BinarySearchTree();
      postTitle = new ArrayList<>();
      this.accName = accName;
   }
   
   /**
    * Account constuctor to make a complete Account with accName and acDescription not null
    * @param accName pass in the account name
    * @param accDescription pass in the account description 
    */
   public Account(String accName, String accDescription){
      posts = new BinarySearchTree();
      postTitle = new ArrayList<>();
      this.accName = accName;
      this.accDescription = accDescription;
      
   }
   
   /**
    * Used to compare two Account object using the accName relative to the alphabet
    * @param other pass in the other Account object to compare
    * @return int -1 if this is less that other, 0 if both objects are equal and 1 if this. is greater than other
    */
   public int compareTo(Account other){
      return this.accName.compareTo(other.accName);
   }
   
   /**
    * 
    * @return String representation of the Account object
    */
   public String toString(){
      return "Account name: "+accName +"\nAccount Description: "+accDescription+"\n";
   
   }
   /**
    * used to add a new Post to an Account object
    * @param newPost pass in the Post object 
    */
   public void addPost(Post newPost){
      posts.insert(newPost);
      postTitle.add(newPost.title);
   }
   /**
    * Used to list all the post on a Account from most recent to least recent
    * @return String representation of all the post in the current account showing the post title, the video name and the number of likes the post has.
    */
   public String getAllPost(){
      String result = "";
      for (int index=postTitle.size()-1; index>=0; index--){
         Post tempPost = new Post(postTitle.get(index));
         String nextPost = posts.find(tempPost).data.toString();
         result += nextPost;
      }
      return result;
   }
}