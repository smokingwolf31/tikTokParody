import java.util.ArrayList;

/**
 * The Account object is used to model a toktik account having an account name, account description and all the post the account
 * 12 April 2023
 * @author Nkabinde Mnqobi
 */
public class Account implements Comparable<Account>{
   /**Account name or the user name of the account.The account name is just one name*/
   public String accName;
   /**This is the account description or the bio.*/
   public String accDescription;
   /**This is a data stucture(BST) used to store Post objects. The posts variable is used to reference the data stucture*/
   public BinarySearchTree<Post> posts;
   /**This variable stores the posts titles of the videos ass they are added. Its used to help keep track of which posts are the most recent*/
   public ArrayList<String> postTitle;
   /**The number of post are incrimented depending on wheather the post are created or deleted. It is used to rougly calculate the amount of memoery required to display all posts*/
   public int numberOfPosts;
   /**The followers variable stores the accont names of the people this account is followed by. */
   public BinarySearchTree<Account> followers;
   
   /**
    * Default Account constuctor
    */
   public Account(){
      posts = new BinarySearchTree();
      postTitle = new ArrayList<>();
      followers = new BinarySearchTree<>();
   }
   /**
    * Account constuctor used to search a AVLTree using the account name i.e AVLtree.find(new Account(String accName)) accDesciption will be null.
    * @param accName pass in the account name of your new Account object.
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
      numberOfPosts = 0;
      
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
    * Can be aoutomatically invoked when concatinated with another String using the + operator
    * @return String representation of the Account object
    */
   public String toString(){
      return "Account name: "+accName.trim() +"\n";
   
   }
   /**
    * used to add a new Post to an Account object
    * @param newPost pass in the Post object 
    */
   public void addPost(Post newPost){
      posts.insert(newPost);
      postTitle.add(newPost.title);
      numberOfPosts++;
   }
   
   /**
   * can be used to increase the number of followers an specific account has.this followers the account passed in
   * @param accountToFollow in the Account object you want to follow.
   */
   public void followAcc(Account accountToFollow){
      accountToFollow.followers.insert(this);
   }
   
   /**
    * Used to list all the post on a Account from most recent to least recent
    * @return String representation of all the post in the current account showing the post title, the video name and the number of likes the post has.
    */
   public String getAllPosts(){
      String result = "";
      for (int index=postTitle.size()-1; index>-1; index--){
         Post tempPost = new Post(postTitle.get(index));
         String nextPost = posts.find(tempPost).data.toString();
         result += nextPost;
      }
      return result;
   }
}