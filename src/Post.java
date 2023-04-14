/**
 * The post object stores the title of a video and the video name along with the number of likes the Post has.
 * @Date 12 April 2023
 * @author Nkabinde Mnqobi
 */

public class Post implements Comparable<Post>{
   public String title;
   public String video;
   public Integer likes;
   

   /**
    * Default Post constuctor
    */
   public Post(){}

   /**
    * Post constuctor used to search a AVLTree i.e AVLTree.find(new Post(String title))
    * @param title pass in the tittle of the video
    */
   public Post(String title){
      this.title = title;
   }
   /**
    * Post constuctor 
    * @param title Place in the title of the video
    * @param video This would be the video name (Preferably ends with .mpg)
    * @param likes The number of likes the video has.
    */
   public Post(String title, String video, Integer likes){
      this.title = title;
      this.video = video;
      this.likes = likes;
   
   }

   /**
    * When called on a Post object it adds one like to the post
    */
   public void likePost(){
      likes +=1;
   }

   /**
    * Used to compare two diffrent Post titles relative to the alphabets
    * @param other pass in the other Post object to compare
    * @return int -1 if this. is less then other, 0 if both are equal and 1 if this is greater than other (relative to the alphabets)
    */
   public int compareTo(Post other){
      return this.title.compareTo(other.title);
   }

   /**
    *  
    *@return String representaion of the Post in the form:
    * Tittle: titleName 
    * Video: videoName
    * Likes: numberOfLikes
    */
   public String toString(){
    return "\nTitle: "+title+"\nVideo: "+video+"\nNumber of likes: "+likes;
   }
   

}
