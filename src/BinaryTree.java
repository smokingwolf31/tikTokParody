/**
 * Hussein's Binary Tree
 * 26 March 2017
 * @author Hussein Suleman
 */
public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   /**
    * default constuctor for the binary tree
    */
   public BinaryTree ()
   {
      root = null;
   }
   
   /**
    * Used to get the height of the tree
    * @return the int which represents the height of the tree
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   /**
    * Helper method for the getHeght method with one no parameter
    * @param node pass in the node to start counting at
    * @return the int which represents the height of the tree
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   /**
    * Used to get the size of the tree
    * @return the int which represents the size of the tree
    */
   public int getSize ()
   {
      return getSize (root);
   }  
   /**
    * Helper method for the getSize method with one no parameter
    * @param node pass in the node to start counting at
    * @return the int which represents the size of the tree
    */ 
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**
    * Used to print out the data type at a specific node
    * @param node pass in the node to print out
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
   /**
    * prints out the node on the tree from current node to the subnodes
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   /**
    * Helper method to the preOrder method without any parameters
    * @param node pass in the current node
    */
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }

   /**
    * prints out the node on the tree from the subnodes to the current node
    */
   public void postOrder ()
   {
      postOrder (root);
   }

   /**
    * Helper method to the postOrder method without any parameters
    * @param node pass in the current node
    */
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   /**
    * prints out the node on the tree from the left subnode to cueernt node then right subnode
    */
   public void inOrder ()
   {
      inOrder (root);
   }

   /**
    * Helper method to the inOrder method without any parameters
    * @param node pass in the current node
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

   /**
    * prints out the node on the tree from on a specific level from left to right
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
