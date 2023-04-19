/**
 * Hussein's Binary Tree
 * 26 March 2017
 * @author Hussein Suleman
 */
public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
   
   /**
    * Default contuctor for the BTQueue
    */
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   /**
    * used to get the next BinaryTreeNode on the queue
    * @return the BinaryTreeNode next on the queue
    */
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   /**
    * used for the BTQueue node
    * @param node pass in the node you are loking for
    */
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
