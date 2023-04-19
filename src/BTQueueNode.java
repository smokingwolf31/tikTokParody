/**
 * Hussein's Binary Tree
 * 26 March 2017
 * @author Hussein Suleman
 */
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   /**
    * Public constuctor for the BTQueueNode 
    * @param n pass in the dataType on the node
    * @param nxt the next node on the BTQueue on the queue
    */
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
