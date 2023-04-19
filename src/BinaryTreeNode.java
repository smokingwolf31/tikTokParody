/**
 * Hussein's Binary Tree
 * 26 March 2017
 * @author Hussein Suleman
 */
public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
   
   /**
    * Constuctor for the BTNode
    * @param d pass in the dataType
    * @param l pass in the left BTNode
    * @param r pass in the right BTNode
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   /**
    * Get the left BTNode
    * @return the BTNode on the left
    */
   BinaryTreeNode<dataType> getLeft () { return left; }
   /**
    * Get the right BTNode
    * @return the BTNode on the right
    */
   BinaryTreeNode<dataType> getRight () { return right; }
}
