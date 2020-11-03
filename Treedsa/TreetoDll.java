import sun.jvm.hotspot.debugger.cdbg.BitType;

/**
 * TreetoDll
 */
public class TreetoDll {
   static  Node root;
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    //inorder transversal  
    static void printinorder(Node root){
        if(root==null){
            return;
        }
        printinorder(root.left);
        System.out.print(root.data+" ");
        printinorder(root.right);
    }
    
   Node prev=null;
   Node bToDLL(Node root)
   {
   //  Your code here	
  if(root==null){
      return root;
  }
 Node head=bToDLL(root.left);
  if(prev==null){
      head=root;
  }
  else{
      root.left=prev;
      prev.right=root;
      
  }
  prev=root;
  bToDLL(root.right);
  return head;
   }
   

    public static void main(String[] args) {
        
  if(root==null){
      root=new Node(1);
  }
  root.left=new Node(2);
  root.right=new Node(3);
  root.left.left=new Node(4);
  root.left.right=new Node(5);
  root.right.left=new Node(6);
  root.right.right=new Node(7);
  printinorder(root);

    }
}