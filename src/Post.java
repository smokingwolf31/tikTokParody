

public class Post implements Comparable<Post>{
   public String title;
   public String video;
   public Integer likes;
   
   public Post(){}
   
   public Post(String title){
      this.title = title;
   }
   
   public Post(String title, String video, Integer likes){
      this.title = title;
      this.video = video;
      this.likes = likes;
   
   }
   
   public int compareTo(Post other){
      return this.title.compareTo(other.title);
   }
   
   public String toString(){
    return "Tittle: "+title+"\nVideo: "+video+"\nNumber of likes: "+likes+"\n";
   }

}
