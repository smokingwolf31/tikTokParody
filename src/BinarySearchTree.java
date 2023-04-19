/**
 * Hussein's Binary Search Tree
 * 27 March 2017
 * @author Suleman
 */
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{  
   /**
    * insert a dataTyepe into tree
    * @param d pass in the data type to insert
    */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   /**
    * Helping method for the insert method with one param
    * @param d insert a dataTyepe into tree
    * @param node node to start inserting at
    */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   /**
    * Used to find a specific data type in the tree
    * @param d pass in the data type you need to find
    * @return the BTNode where the datatye is and null if it s not in the tree
    */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   /**
    * Helping method for the find method with one param
    * @param d pass in the datatype you which to find
    * @param node pass in the BTNode you which to start searching at
    * @return the BTNode where the datatype is and null if it s not in the tree
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) == 0) 
         return node;
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   /**
    * Used to remove a dataTye from the tree
    * @param d pass in the datatype to remove
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   /**
    * Helping method for the delete method with one param
    * @param d pass in the data type to delete 
    * @param node pass in the BT node to start searching at
    * @return the BTNode where the datatype is and null if it s not in the tree
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   /**
    * Used to find the mininmum data type in the tree
    * @param node pass in the node to start searching at
    * @return the BTNode where the datatype is and null if it s not in the tree
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }
   /**
    * Used to remove the minimun data type in the tree
    * @param node pass in the node to start searching at
    * @return he BTNode where the datatype is and null if it s not in the tree
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   /**
    * print out the data types in the tree 
    */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   /**
    * Helping method for the treeOrder method with one param
    * @param node pass in the node to start searching at
    * @param level pass in the level to seach at
    */
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
         System.out.print("");
         treeOrder (node.left, level+1);
         System.out.println (node.data);
         treeOrder (node.right, level+1);
         
      }
   }
   /**
    * Used to get all the data types in the BStree
    * @return the string respesantation of all the data types in the tree
    */
   public String inOrderTree ()
   {
      return inOrderTree (root, 0);
   }
   /**
    * Used to remove the minimun data type in the tree
    * @param node pass in the node to start searching at
    * @param level pass in the level the node is at
    * @return he BTNode where the datatype is and null if it s not in the tree
    */
   public String inOrderTree ( BinaryTreeNode<dataType> node, int level )
   {  
      String result = "";
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print("");
            result = result + inOrderTree (node.left, level+1);
            result = node.data.toString() + result;
            result = result + inOrderTree (node.right, level+1);
      }
      return result;
   }
   /**
    * Used to determine if the tree is empty or not
    * @return booloean value true if the tree is empty and false if it.
    */
   public boolean isEmpty(){
      if (root==null){return true;}
      else{return false;}
   }
}
