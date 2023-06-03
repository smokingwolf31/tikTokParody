import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.channels.SocketChannel;
import java.io.FileInputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;


/**
 * The toktik class imitates a social media platform where users can create accounts and add posts to those accounts
 * , users can follow one another and like each others post.
 */
public class toktik {
    static BinarySearchTree<Account> accounts;
    String accName = " ";
    Account tempAcc;
    private JFrame frame;
    private JButton accDescB,listAccB,createAccB,deleteAccB,viewPostsB,playVideoB,createPostB,likePostB,deletePostB,loadB,exitB,;
    private int numberOfAccounts;

    /**
     * The toktik default constructor is only used in the main class. It creates the graphical user interface.
     */
    public toktik() {
        ImageIcon toktikIcon = new ImageIcon("src//toktikBlue.png");
        numberOfAccounts=0;
        accounts = new BinarySearchTree<Account>();
        frame = new JFrame("toktik");
        frame.setIconImage(toktikIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        GridLayout layOut = new GridLayout(6, 20);
        layOut.setHgap(6);
        layOut.setVgap(10);
        frame.setLayout(layOut);
        frame.getContentPane().setBackground( Color.DARK_GRAY );
        frame.setSize(1800, 800);
        
        
        accDescB = createButton("Get Account Description");
        accDescB.setIcon(new ImageIcon("src//images//accDescriptionImage.png"));
        accDescB.setBackground(Color.LIGHT_GRAY);
        listAccB = createButton("List All Accounts");
        listAccB.setBackground(Color.LIGHT_GRAY);
        listAccB.setIcon(new ImageIcon("src//images//listAccImage.png"));
        createAccB = createButton("Create An Account");
        createAccB.setBackground(Color.LIGHT_GRAY);
        createAccB.setIcon( new ImageIcon("src//images//addAccImage.png"));
        deleteAccB = createButton("Delete Account");
        deleteAccB.setIcon(new ImageIcon("src//images//deleteAccImage.png"));
        deleteAccB.setBackground(Color.LIGHT_GRAY);
        viewPostsB = createButton("Get Account Feed");
        viewPostsB.setBackground(Color.LIGHT_GRAY);
        viewPostsB.setIcon(new ImageIcon("src//images//viewPostImage.png"));
        createPostB = createButton("Create A Post");
        createPostB.setBackground(Color.LIGHT_GRAY);
        playVideoB = createButton("Play Video");
        playVideoB.setIcon(new ImageIcon("src//images//accDescriptionImage.png"));
        playVideoB.setBackground(Color.LIGHT_GRAY);
        createPostB.setIcon(new ImageIcon("src//images//createPostImage.png"));
        likePostB = createButton("Like A Post");
        likePostB.setIcon(new ImageIcon("src//images//likePostImage.png"));
        likePostB.setBackground(Color.LIGHT_GRAY);
        deletePostB = createButton("Delete A Post");
        deletePostB.setIcon(new ImageIcon("src//images//deletePostImage.png"));
        deletePostB.setBackground(Color.LIGHT_GRAY);
        loadB = createButton("Load Text File");
        loadB.setBackground(Color.LIGHT_GRAY);
        loadB.setIcon(new ImageIcon("src//images//uploadFileImage.png"));
        exitB = createButton("");
        exitB.setIcon(new ImageIcon("src//images//exitImage.png"));
        exitB.setBackground(Color.LIGHT_GRAY);
        
        frame.add(accDescB);
        frame.add(listAccB);
        frame.add(createAccB);
        frame.add(deleteAccB);
        frame.add(viewPostsB);
        frame.add(playVideoB);
        frame.add(createPostB);
        frame.add(likePostB);
        frame.add(deletePostB);
        frame.add(loadB);
        frame.add(exitB);

        frame.setVisible(true);
    }
        /**
     * the main class only calls the toktik() constructor
     * @param args main args parameter --unused
     */    
    public static void main(String[] args) {
        new toktik();
    }
    /**
     * Used to create a Jbutton and an action listener to it. Each button as specific functions depending on the lable it has and performs as intended when clicked.
     * @param label pass in the text that must be displayed on the JButton object.
     * @return JButton object that adds the ActionListener method.
     */
    private JButton createButton(String label){ 
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //Validate Initaial User Input
                while (true){
                   if(toktik.needAtLeastOneAcc(label) & accounts.isEmpty()){
                     JOptionPane.showMessageDialog(frame, "There are not accounts\n Be the first user by creating an account. ^_^");
                     break;
                     
                   }
                   else if(toktik.needsAccName(label)){
                       accName = JOptionPane.showInputDialog(frame, "Please enter the Account name:","");
                       
                       if(accName==null){
                          break;
                       }
                       else if(accName==""){
                           JOptionPane.showMessageDialog(frame, "Enter the account name in the text field provided");
                       }
                       else if(accName != null & toktik.isValidAccName(accName)){
                           tempAcc = new Account(accName);
                           if (label.equals("Create An Account")){
                              if(accounts.find(tempAcc)!=null){
                                 while(true){
                                    Random random = new Random();
                                    Integer randomNum = random.nextInt(500);
                                    if(accounts.find(new Account(accName+randomNum))==null){
                                       JOptionPane.showMessageDialog(frame, "Account named "+accName+" already exists. You can try "+accName+randomNum);
                                       break;
                                    }
                                 }
                                 
                              }
                              else{break;}
                           }
                           else if(accounts.find(tempAcc)==null){
                              JOptionPane.showMessageDialog(frame, "Account named "+accName+" does not exist.");
                           }
                           else{break;}
                       }
                       else{
                          JOptionPane.showMessageDialog(frame, "Please enter a valid account name (no space)");
                          continue;
                       }
                     
                   }
                   else{break;}
                }
                
                // Get Account Description
                if(!accounts.isEmpty() & accName!=null & label.equals("Get Account Description")) {
                   JOptionPane.showMessageDialog(frame,"Desciption: "+accounts.find(tempAcc).data.getAccDescription());
                }

                // list All Accounts 
                else if(!accounts.isEmpty() & label.equals("List All Accounts")){
                   if (numberOfAccounts<2000){
                     JTextArea textArea = new JTextArea(accounts.inOrderTree()); 
                     textArea.setWrapStyleWord(false);
                     JScrollPane scrollPane = new JScrollPane(textArea);  
                     scrollPane.setPreferredSize( new Dimension( 450, 500 ) );
                     JOptionPane.showMessageDialog(null, scrollPane, "All toktik Accounts", JOptionPane.YES_NO_OPTION); 
                   
                   }
                   else{
                     JOptionPane.showMessageDialog(frame, "There are too many accounts and your current operating system can not handle the memory requirements\n Please Check the Terminal for the complete list of accounts");
                     accounts.treeOrder();
                   }

                
                }

                // Create An Account
                else if (accName!=null & label.equals("Create An Account")) {
                    String accDescription = JOptionPane.showInputDialog(frame, "Please enter your account description:"); 
                    if(accDescription==null){
                       JOptionPane.showMessageDialog(frame, "Please make sure that the account description field is complited");
                    }
                    else if(accDescription.trim().equals("Please enter something not just spaces")){
                    }
                    else{
                       accounts.insert(new Account(accName, accDescription));
                       numberOfAccounts = numberOfAccounts+1;
                       JOptionPane.showMessageDialog(frame, "Congratulations on your new account");
                    }
                } 

                // Delete An Account
                else if (!accounts.isEmpty() & accName!=null & label.equals("Delete Account")) {
                     while(true){
                     String decision = JOptionPane.showConfirmDialog(frame,"Are you sure?")+"";
                     if(decision.equals("0")){
                        accounts.delete(tempAcc);
                        numberOfAccounts--;
                        JOptionPane.showMessageDialog(frame, "Account Deleted Successfully");
                        
                     }
                     break;
                     }
                } 

                // list All Posts
                else if(accName!=null & !accounts.isEmpty() & label.equals("Get Account Feed")){
                  Account accToView = accounts.find(tempAcc).data;
                  if (accToView.getPosts().isEmpty()){
                     JOptionPane.showMessageDialog(frame, accName+" account does not have any posts yet");
                  }
                  
                  else if(accToView.numberOfPosts<999){
                     JTextArea textArea = new JTextArea(accToView.getAllPosts()); 
                     textArea.setWrapStyleWord(false);
                     JScrollPane scrollPane = new JScrollPane(textArea);  
                     scrollPane.setPreferredSize( new Dimension( 450, 500 ) );
                     JOptionPane.showMessageDialog(null, scrollPane, "Posts By "+accToView.getAccName(), JOptionPane.YES_NO_OPTION); 
                                       
                  
                  }
                  else{
                    JOptionPane.showMessageDialog(frame, "There are too many posts and your current operating system can not handle the memory requirements\n Please Check the Terminal for the complete list of posts");
                    accToView.getPosts().treeOrder();
                  }
               }
                
                //Create A New Post
                else if (accName!=null & !accounts.isEmpty() & label.equals("Create A Post")) {
                    String title = "";
                    String video = "";
                    Integer likes = 0;
                    
                    getTitle:
                    while(true){
                       title = JOptionPane.showInputDialog(frame, "What would you wish to title your post");
                       if(title==null){break;}
                       else if(accounts.find(tempAcc).data.getPosts().find(new Post(title))!=null){
                          JOptionPane.showMessageDialog(frame,"You already have a video with the same title.\nThis is toktik ^_^. Get more creative. <3");
                          continue;
                       }
                       else{
                          getVideo:
                          while(true){
                             video = JOptionPane.showInputDialog(frame, "Enter the name of the video in full (i.e., include .mpg)");
                             if(video==null){break getTitle;}
                             else if(!toktik.isValidVideo(video)){
                                JOptionPane.showMessageDialog(frame, "Please make sure the .mpg is included in your naming convention");
                             }
                             else{
                               accounts.find(tempAcc).data.getPosts().insert(new Post(title, video, 0));
                               accounts.find(tempAcc).data.getPostTitle().add(title);
                               JOptionPane.showMessageDialog(frame, "Post Uploaded Successfully. We hope eveyone likes it");
                               break getTitle;
                               
                             }
                          }
                       }
                    }
                } 
                
                //Delete A post Or Like A Post or Play A video
                else if(accName!=null & !accounts.isEmpty() & (label.equals("Play Video") |label.equals("Delete A Post") | label.equals("Like A Post"))){
                  while(true){
                     Account accToManage = accounts.find(tempAcc).data;
                     if(accToManage.getPosts().isEmpty()){
                        JOptionPane.showMessageDialog(frame, accName+" account does not have any posts yet");
                        break;
                     }
                     String videoTitle = JOptionPane.showInputDialog(frame, "Enter the video title of the video");
                     if(videoTitle == null){
                        break;
                     }
                     else if (accToManage.getPosts().isEmpty()){
                        JOptionPane.showMessageDialog(frame, "This account does not have any posts yet");
                     }
                     else if(accToManage.getPosts().find(new Post(videoTitle)) == null){
                        JOptionPane.showMessageDialog(frame, "That video/Post deos not exist try listing the posts on "+accName+" to find the exact name");
                     }
                     else if (label.equals("Like A Post")){
                        accToManage.getPosts().find(new Post(videoTitle)).data.likePost();
                        JOptionPane.showMessageDialog(frame, "Post Liked.. We will show more post like this going forward");
                        break;
                     }
                     else if(label.equals("Delete A Post")){
                        accToManage.deletePost(new Post(videoTitle));
                        JOptionPane.showMessageDialog(frame, "Post Deleted.. We wont tell anyone if you dont");
                        break;
                     }
                     else if(label.equals("Play Video")){
                        // need to use fx scene builder    
                     }
                  } 
                  

                }

                // Loading the txt file
                else if (label.equals("Load Text File")) {
                Scanner fileIn = new Scanner(System.in);
                String fileName;
                gettingFileName:
                while(true){
                  fileName = JOptionPane.showInputDialog(frame, "Please enter the txt file name (i.e name.txt)");
                  if(fileName==null){//Accounts for pressing cancel
                     break;
                  }
                  else if(fileName.length()<=4){//Makes sure the file is not too short
                     JOptionPane.showMessageDialog(frame, "Invalid file name. File name is too short.");
                     continue;
                  }
                  else if(!fileName.substring(fileName.length()-4).equals(".txt")){// makes sure thr file name ends with .txt
                     JOptionPane.showMessageDialog(frame, "File name must end with .txt");
                     continue;
                  }
                  else{break;}//everything is in order we break the loop
                  }
                  
               if(fileName!=null){//if the user pressed cancel this wont be executed
                  try{
                     fileIn = new Scanner(new FileInputStream(fileName));  
                  }
                  catch(Exception eee){
                     JOptionPane.showMessageDialog(frame, "File Not Found.");
                     fileIn = null;
                  
                  }
               }
               if(fileName!=null & fileIn!=null){//if the
                   while(fileIn.hasNextLine()){
                      String command = fileIn.nextLine();
                      if(command.substring(0,6).equals("Create")){
                         command = command.substring(command.indexOf(" ")+1);
                         String name = command.substring(0, command.indexOf(" "));
                         String description = command.substring(command.indexOf(" ")+1);
                         if(accounts.find(new Account(name))==null){
                           accounts.insert(new Account(name, description));  
                           numberOfAccounts++;
                         }             
                      }
                      else if(command.substring(0,3).equals("Add")){
                         command = command.substring(command.indexOf(" ")+1);
                         accName = command.substring(0,command.indexOf(" "));
                         command = command.substring(command.indexOf(" ")+1);
                         String videoToAdd = command.substring(0,command.indexOf(" "));
                         command = command.substring(command.indexOf(" ")+1);
                         Integer likesOfVideo = Integer.parseInt(command.substring(0,command.indexOf(" ")));
                         String titleOfVideo = command.substring(command.indexOf(" ")+1);
                         Post newPostToAdd = new Post(titleOfVideo, videoToAdd , likesOfVideo);
                         Account accToPostOn = accounts.find(new Account(accName)).data;
                         accToPostOn.getPosts().insert(newPostToAdd);
                         accToPostOn.getPostTitle().add(newPostToAdd.getTitle());
                         accToPostOn.numberOfPosts++;
                     }
                  }
                  JOptionPane.showMessageDialog(frame, "All account creation and or uploads succesuful");
               }
               
             } 
             // Exiting the toktik Application
             if (label.equals("")) {
                while(true){
                  String decision = JOptionPane.showConfirmDialog(frame,"Are you sure?")+"";
                  if(decision.equals("0")){
                     JOptionPane.showMessageDialog(frame, "Thank you for using tiktok 😊");
                     System.exit(0);
                  }
                  else{break;}
                  
                  }   
             }
         }
        });
        return button;
    } 
    
    /**
     * Used to determine if the a String end with .mpg and is atleast 5 characters long.
     * @param name pass in the word that needs to be checked.
     * @return boolean value based on the structure of the name parameter passed in.
     */
    public static boolean isValidVideo(String name){
       if(name.length()<=4){return false;}
       else if(!name.substring(name.length()-4).equals(".mpg")){
          return false;
       }
       else{return true;}
    }

    /**
     * Used to check if an account name contains any space cgaracters
     * @param name pass in the name you wish to validate
     * @return returns a true booloen if the name does not contain any space characters else it returns false
     */
    public static boolean isValidAccName(String name){
      if(name==null || name.indexOf(" ")>=0){return false;}
      else{return true;}
    }
    
    /**
     * Used to decide if a particular button option needs at laeast one account
     * @param label pass in the label of the button
     * @return returns true if the button needs at least one account already created else it returns false.
     */
    public static boolean needAtLeastOneAcc(String label){
      String[] labels = new String[] {"Get Account Description","List All Accounts","Delete Account", "Create A Post","Get Account Feed", "Play Video","Delete A Post","Like A Post"};
      for(String index: labels){
         if(index.equals(label)){return true;}
      }
      return false;
   }

   /**
    * Used to decide if a particular button option needs to ask the user for an account name
    * @param label pass in the button label
    * @return boolean value , true if the button needs an account name and false if it does not
    */
   public static boolean needsAccName(String label){
      String[] labels = new String[] {"Create An Account","Get Account Description", "Delete Account", "Create A Post", "Get Account Feed", "Play Video","Delete A Post","Like A Post"};
      for(String index: labels){
         if(index.equals(label)){return true;}
      }
      return false;
   }
}
