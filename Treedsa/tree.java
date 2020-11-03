package Tree;

/**
 * tree
 */

 //we are doing binary search tree of the depth search
import java.util.*;

import org.w3c.dom.Node;

import java.io.*;
 class tree {
//first of all we have to create a node
static Node root;

static class Node{
   Node left;
   Node right;
   int data;
   public Node(int n){
    this.data=n;
   } 

}

    


static void insert(Node node,int data){
         //depth first search inorder Transversal
    if(node==null){
        node=new Node(data);

    }
    if(data>node.data){
        if(node.right==null){
            node.right=new Node(data);
        }
        else
        insert(node.right,data);
    }
    else{
        if(node.left==null){
            node.left=new Node(data);
        }
        else
        insert(node.left,data);
    }
}

//printing the elements of the node
static void print(Node root){
  //we have two methods to print
  //first is recursion other is iteration 
  //inorder transversal
    if(root==null){
        return ;
    } 
    print(root.left);
    System.out.print(root.data+" ");
    print(root.right);

}
static int sizetree(Node node){
if(node==null){
    return 0; 
}
return 1+sizetree(node.left)+sizetree(node.right);
}
    
//printing preorder Transversal
static void preorderTransvesal(Node root){
    if(root==null){
        return ;
    }
    System.out.print(root.data+" ");
    preorderTransvesal(root.left);
    preorderTransvesal(root.right);
}
static void levelorder(Node node){
    if(node==null){
        return ;
    }
    else{
        Queue<Node>Q=new LinkedList<>();
        Q.add(node);
        while(!Q.isEmpty()){
            Node temp=Q.peek();
            System.out.print(temp.data+" ");
            Q.poll();
           if(temp.left!=null){
               Q.add(temp.left);
           }
           if(temp.right!=null){
               Q.add(temp.right);
           }
        }
    }
}

static int maxvalue(Node node){
    if(node==null){
        return Integer.MIN_VALUE;
    }
    return Math.max(node.data,Math.max(maxvalue(node.left),maxvalue(node.right)));
}

public static void main(String[] args) {
  //Enter the node
 Scanner scan=new Scanner(System.in);
  int t=scan.nextInt();
  while(t-->0){
  int i=scan.nextInt();
      if(root==null){
          root=new Node(i);
          root.left=null;
          root.right=null;
      }
      else{
          //we 
       insert(root,i);
      }
  
}
//System.out.println(maxvalue(root));
printLinebyline(root);


}
static ArrayList<ArrayList<Integer>> printLinebyLine(Node node){
    ArrayList<ArrayList<Integer>>A=new ArrayList<>();
    Queue<Node>Q=new LinkedList<>();
    Q.add(node);
    while(Q.size()!=0){
        Node temp=Q.peek();
        Q.remove();
         ArrayList<Integer>temp1=new ArrayList<>();
         temp1.add(temp.data);
         A.add(temp1);
         if(temp.left!=null){
             Q.add(temp.left);

         }
         if(temp.rigth!=null){
             Q.add(temp.right);
         }

    }


}
//check whether the tree contains sum=node.left+node.right;


//print the nodes of the tree line by line 
static void printLine(Node node){
    ArrayList<ArrayList<Integer>>A=new ArrayList<>();
    Queue<Node>Q=new ArrayList<>();
    Q.add(node);
    Q.add(null);
    ArrayList<Integer>temp=new ArrayList<>();
    while(Q.size()>1){
        if(Q.peek()==null){
            temp.clear();
            Q.add(null);
            
        }
        Node temp1=Q.peek();
        Q.remove();
        temp.add(Q.data);
        A.add(temp);
        if(temp1.left!=null){
            Q.add(temp1.left);
        }
        if(temp1.right!=null){
            Q.add(temp1.right);
        }
        
    
        
        
    }
}

}