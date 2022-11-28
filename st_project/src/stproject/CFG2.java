package stproject;

import java.util.*;
import java.util.Map.Entry;
 
// A binary tree node
class CFG2
{
    static class Node
    {
        int data; //data of the node
        int hd; //horizontal distance of the node
        Node left, right; //left and right references
     
        // Constructor of tree node
        public Node(int key)
        {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }

    }
    
    static int numNodes(Node root) 
    {
        // If tree is empty
        if (root==null)
        return 0; 
          
        // Initialize empty queue.
        Queue<Node> queue = new LinkedList<Node>();
          
        // Do level order traversal starting from root
        queue.add(root);
          
        int count=0; // Initialize count of full nodes
        while (!queue.isEmpty()) 
        {
  
            Node temp = queue.poll();
            count++;
            
            // Enqueue left child 
            if (temp.left != null) 
            {
                queue.add(temp.left);
            }
  
            // Enqueue right child 
            if (temp.right != null) 
            {
                queue.add(temp.right);
            }
        }
        return count;
    }

    static List<Integer> preOrderIterative(Node node)
    {
        if (node == null)
        {
            return null;
        }

        List<Integer> lst=new ArrayList<>();

        Stack<Node> st = new Stack<Node>();
        
        // Start from root node (set curr
        // node to root node)
        Node curr = node;

        
        // Run till stack is not empty or
        // current is not NULL
        while (curr != null || !st.isEmpty())
        {
            
            // Print left children while exist
            // and keep pushing right into the 
            // stack.
            while (curr != null)
            {
                lst.add(curr.data);
                
                if (curr.right != null)
                {

                    st.push(curr.right);
                }
                    
                curr = curr.left;
            }
            
            // We reach when curr is NULL, so We
            // take out a right child from stack
            if (!st.isEmpty())
            {

                curr = st.pop();
            }
        }

        return lst;

    }


    static List<Integer> postOrderIterative(Node root)
    {
        // Create two stacks
        if (root == null)
        {

            return null;
        }

        List<Integer> lst=new ArrayList<>();
        
        Stack<Node> s1, s2;
        
        s1 = new Stack<>();
        s2 = new Stack<>();
 
        // push root to first stack
        s1.push(root);
       
        // Run while first stack is not empty
        while (!s1.isEmpty()) 
        {
            // Pop an item from s1 and push it to s2
            Node temp = s1.pop();
            s2.push(temp);
 
            // Push left and right children of
            // removed item to s1
            if (temp.left != null)
            {
                s1.push(temp.left);
            }

            if (temp.right != null)
            {
                s1.push(temp.right);
            }    
        }
 
        // Print all elements of second stack
        while (!s2.isEmpty()) 
        {
            Node temp = s2.pop();
            lst.add(temp.data);
        }

        return lst;
    }


    static List<Integer> inOrderIterative(Node root)
    {
        if (root == null)
        {
            return null;
        }
 
        List<Integer> lst=new ArrayList<>();
        Stack<Node> s = new Stack<Node>();

        Node curr = root;
 
        // traverse the tree
        while (curr != null || s.size() > 0)
        {
 
            /* Reach the left 
            most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree 
                node on the stack 
                before traversing
                the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }
 
            /* Current must be NULL at this point */
            curr = s.pop();
 
            lst.add(curr.data);
 
            /* we have visited the node 
            and its left subtree.  
            Now, it's right
            subtree's turn */
            curr = curr.right;
        }

        return lst;
    }


    static List<Integer> levelOrderIterative(Node root)
    {
        if(root == null)
        {
        	return null;
        }
    	Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        List<Integer> lst=new ArrayList<>();
        
        while (!queue.isEmpty()) 
        {
 
            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/
            util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            lst.add(tempNode.data);
 
            /*Enqueue left child */
            if (tempNode.left != null) 
            {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) 
            {
                queue.add(tempNode.right);
            }
        }

        return lst;
    }


    static List<Integer> leftView( Node root )
    {
        if (root == null)
        {
            return null;
        }

        List<Integer> lst=new ArrayList<>();
        
        Queue<Node> q = new LinkedList<Node>();
        // add root
        q.add(root);
    
        // Delimiter
        q.add(null);
    
        while (q.size() > 0)
        {
            Node temp = q.peek();
    
            if (temp != null)
            {
    
                // Prints first Node
                // of each level
                lst.add(temp.data);
    
                // add children of all Nodes at
                // current level
                while (q.peek() != null)
                {
    
                    // If left child is present
                    // add into queue
                    if (temp.left != null)
                    {

                        q.add(temp.left);
                    }
    
                    // If right child is present
                    // add into queue
                    if (temp.right != null)
                    {

                        q.add(temp.right);
                    }
    
                    // remove the current Node
                    q.remove();
    
                    temp = q.peek();
                }
    
                // add delimiter
                // for the next level
                q.add(null);
            }
    
            // remove the delimiter of
            // the previous level
            q.remove();
        }

        return lst;
    }


    static List<Integer> rightView(Node root)
    {
        if (root == null) 
        {
            return null;
        }
 
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        List<Integer> lst=new ArrayList<>();
        
        while (!q.isEmpty()) 
        {
 
            // get number of nodes for each level
            int n = q.size();
 
            // traverse all the nodes of the current level
            for (int i = 0; i < n; i++) 
            {
                Node curr = q.peek();
                q.remove();
 
                // print the last node of each level
                if (i == n - 1) 
                {
                  lst.add(curr.data);
                }
 
                // if left child is not null add it into
                // the
                // queue
                if (curr.left != null) 
                {
                    q.add(curr.left);
                }
 
                // if right child is not null add it into
                // the
                // queue
                if (curr.right != null) 
                {
                    q.add(curr.right);
                }
            }
        }

        return lst;
    }


    static List<Integer> topView(Node root)
    {
        class QueueObj 
        {
            Node node;
            int hd;
 
            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }

        List<Integer> lst=new ArrayList<>();
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        
        Map<Integer, Node> topViewMap
            = new TreeMap<Integer, Node>();
 
        if (root == null) 
        {
            return null;
        }

        else 
        {
            q.add(new QueueObj(root, 0));
        }
 
        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        
        while (!q.isEmpty()) 
        {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) 
            {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }
 
            if (tmpNode.node.left != null) 
            {
                q.add(new QueueObj(tmpNode.node.left,
                                   tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) 
            {
                q.add(new QueueObj(tmpNode.node.right,
                                   tmpNode.hd + 1));
            }
        }
        for (Map.Entry<Integer, Node> entry :
             topViewMap.entrySet()) 
        {
            lst.add(entry.getValue().data);
        }

        return lst;
    }


    static List<Integer> bottomView(Node root)
    {
        if (root == null)
        {
            return null;
        }
 
        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;

        List<Integer> lst=new ArrayList<>();

        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();
 
         // Queue to store tree nodes in level order traversal
        Queue<Node> queue = new LinkedList<Node>();
 
        // Assign initialized horizontal distance value to root
        // node and add it to the queue.
        root.hd = hd;
        queue.add(root);
 
        // Loop until the queue is empty (standard level order loop)
        while (!queue.isEmpty())
        {
            Node temp = queue.remove();
 
            // Extract the horizontal distance value from the
            // dequeued tree node.
            hd = temp.hd;
 
            // Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
            map.put(hd, temp.data);
 
            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a right child add it to the
            // queue with a horizontal distance hd+1.
            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }
 
        // Extract the entries of map into a set to traverse
        // an iterator over that.
        Set<Entry<Integer, Integer>> set = map.entrySet();
 
        // Make an iterator
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
 
        // Traverse the map elements using the iterator.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            lst.add(me.getValue());
        }

        return lst;
    }


    static List<Integer> zigZagTraversal(Node root) {
     
        // if null then return
        if (root == null) 
        {
            return null;
        }

        List<Integer> lst=new ArrayList<>();
        // declare two stacks
        Stack<Node> currentLevel = new Stack<>();

        Stack<Node> nextLevel = new Stack<>();
     
        // push the root
        currentLevel.push(root);
        
        boolean leftToRight = true;
     
        // check if stack is empty
        while (!currentLevel.isEmpty()) 
        {
     
            // pop out of stack
            Node node = currentLevel.pop();
            
            // print the data in it
            lst.add(node.data);
        
            // store data according to current
            // order.
            if (leftToRight) 
            {
                if (node.left != null) 
                {
                    nextLevel.push(node.left);
                }
                
                if (node.right != null) 
                {
                    nextLevel.push(node.right);
                }
            }

            else 
            {
                if (node.right != null) 
                {
                    nextLevel.push(node.right);
                }
                
                if (node.left != null) 
                {
                    nextLevel.push(node.left);
                }
            }
        
            if (currentLevel.isEmpty()) 
            {
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return lst;
    }


    static boolean areMirrors(Node root1, Node root2) 
    { 
        Stack<Node> st1 = new Stack<Node> ();
        Stack<Node> st2  = new Stack<Node> (); 

        while (true) 
        { 
            // iterative inorder traversal of 1st tree and 
            // reverse inorder traversal of 2nd tree 
            while (root1 != null && root2 != null) 
            { 
                // if the corresponding nodes in the two traversal 
                // have different data values, then they are not 
                // mirrors of each other. 
                if (root1.data != root2.data) 
                {
                    System.out.println("Both the Binary trees are not Mirrors to each other"); 
                    return false;
                }
                    
                st1.push(root1); 
                st2.push(root2); 
                root1 = root1.left; 
                root2 = root2.right;     
            } 
            
            // if at any point one root becomes null and 
            // the other root is not null, then they are 
            // not mirrors. This condition verifies that 
            // structures of tree are mirrors of each other. 
            if (!(root1 == null && root2 == null)) 
            {
                System.out.println("Both the Binary trees are not Mirrors to each other"); 
                return false;
            } 
                
            if (!st1.isEmpty() && !st2.isEmpty()) 
            { 
                root1 = st1.peek(); 
                root2 = st2.peek(); 
                st1.pop(); 
                st2.pop(); 
                
                /* we have visited the node and its left subtree. 
                Now, it's right subtree's turn */
                root1 = root1.right; 
                
                /* we have visited the node and its right subtree. 
                Now, it's left subtree's turn */
                root2 = root2.left; 
            }     
            
            // both the trees have been completely traversed 
            else
            {
                break; 
            }
        } 
        
        // trees are mirrors of each other 
    
        System.out.println("Both the Binary trees are Mirrors to each other"); 
        return true;
        
    } 


    static boolean  CheckChildrenSum(Node root)
    {
    	if(root == null)
    	{
    		return true;
    	}
    	
        Queue<Node> q = new LinkedList<Node>();
    
        // add the root node
        q.add(root);
    
        while (q.size() > 0)
        {
            Node temp = q.peek();
            q.remove();
    
            // If the current node has both left and right children
            if (temp.left != null && temp.right != null)
            {
                // If the current node is not equal to
                // the sum of its left and right children
                // return false
                if (temp.data != temp.left.data + temp.right.data)
                {
                    System.out.println("Children Sum Property is not valid for this Binary Tree");
                    return false;
                }
    
                q.add(temp.left);
                q.add(temp.right);
            }
    
            // If the current node has right child
            else if (temp.left == null && temp.right != null)
            {
                // If the current node is not equal to
                // its right child return false
                if (temp.data != temp.right.data)
                {
                    System.out.println("Children Sum Property is not valid for this Binary Tree");
                    return false;
                }
    
                q.add(temp.right);
            }
    
            // If the current node has left child
            else if (temp.right == null && temp.left != null)
            {
                // If the current node is not equal to
                // its left child return false
                if (temp.data != temp.left.data)
                {
                    System.out.println("Children Sum Property is not valid for this Binary Tree");
                    return false;
                }
    
                q.add(temp.left);
            }
        }
    
        // If the given tree has children
        // sum property return true
        
        System.out.println("Children Sum Property is valid for this Binary Tree");

        return true;
        
    }


    static boolean isSymmetric(Node root)
    {
    	if(root == null)
    	{
    		return true;
    	}
        /* This allows adding null elements to the queue */
        Queue<Node> q = new LinkedList<Node>();
    
        /* Initially, add left and right nodes of root */
        q.add(root.left);
        q.add(root.right);
    
        while (!q.isEmpty())
        {
            /* remove the front 2 nodes to
              check for equality */
            Node tempLeft = q.remove();
            Node tempRight = q.remove();
    
            /* if both are null, continue and check
               for further elements */
            if (tempLeft==null && tempRight==null)
            {
                continue;
            }
    
            /* if only one is null---inequality, return false */
            if ((tempLeft==null && tempRight!=null) ||
                (tempLeft!=null && tempRight==null))
            {
                System.out.println("Binary Tree is not Symmetric");
                return false;
            }
            /* if both left and right nodes exist, but
               have different values-- inequality,
               return false*/
            if (tempLeft.data != tempRight.data)
            {
                System.out.println("Binary Tree is not Symmetric");
                return false;
            }
    
            /* Note the order of insertion of elements
               to the queue :
               1) left child of left subtree
               2) right child of right subtree
               3) right child of left subtree
               4) left child of right subtree */
            q.add(tempLeft.left);
    
            q.add(tempRight.right);
            
            q.add(tempLeft.right);
            
            q.add(tempRight.left);
        }
    
        /* if the flow reaches here, return true*/
        System.out.println("Binary Tree is Symmetric");
        return true;
    }

    
    static int height(Node root)
    {
        // Base Case
        if (root == null)
            return 0;

        // Create an empty queue for level order traversal
        Queue<Node> q = new LinkedList<Node>();

        // Enqueue Root and initialize height
        q.add(root);
        int height = 0;

        while (1 == 1)
        {
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0)
            {
                Node newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }


    }

    
    public static void main(String[] args)
    {
        // Let us construct the tree
        // shown in above figure
 
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        Node flat = new Node(1);
        flat.left = new Node(2);
        flat.right = new Node(3);
        flat.left.left = new Node(4);
        flat.left.right = new Node(5);
        flat.right.left = new Node(6);
        flat.right.right = new Node(7);
     
        Scanner scan = new Scanner(System.in);

        boolean running = true;
        int chocie;
        
        do {
            System.out.println();
            System.out.println("***************************************************************************************");
            System.out.println("Binary Tree operations Menu\n");
            System.out.println("1.) PreOrder Traversal of Binary tree\n");
            System.out.println("2.) InOrder Traversal of Binary tree\n");
            System.out.println("3.) PostOrder Traversal of Binary tree\n");
            System.out.println("4.) Level Order Traversal of Binary tree\n");
            System.out.println("5.) Zig-zag Traversal of Binary tree\n");
            System.out.println("6.) Check if the Binary Tree is Symmetric\n");
            System.out.println("7.) Top View of a Binary Tree\n");
            System.out.println("8.) Bottom View of a Binary Tree\n");
            System.out.println("9.) Left View of a Binary Tree\n");
            System.out.println("10.) Right View of a Binary Tree\n");
            System.out.println("11.) Check the Children Sum Property in a Binary Tree\n");
            System.out.println("12.) Check if two Binary Trees are Mirrors of each other\n");
            System.out.println("0.) Exit\n");
            System.out.println("***************************************************************************************");
            System.out.println();


            System.out.print("Enter a number: ");
            chocie = scan.nextInt();

            switch (chocie) {
                
            case 1: {
                System.out.print("The Pre order Traversal is ");
                System.out.println(preOrderIterative(root));
                break;
            }
            
            case 2: {
                System.out.print("The InOrder Traversal is ");
                System.out.println(inOrderIterative(root));
                break;
            }
            
            case 3: {
                System.out.print("The PostOrder Traversal is ");
                System.out.println(postOrderIterative(root));
                break;
            }
            
            case 4: {
                System.out.print("The Level Order Traversal is ");
                System.out.println(levelOrderIterative(root));
                break;
            }
            
            case 5: {
                System.out.print("The Zig-Zag Traversal is ");
                System.out.println( zigZagTraversal(root));
                break;
            }
            
            case 6: {
                System.out.println(isSymmetric(root));
                break;
            }
            
            case 7: {
                System.out.print("The top View of the Binary tree is ");
                System.out.println( topView(root));
                break;
            }
            
            case 8: {
                System.out.print("The bottom View of the Binary tree is ");
                System.out.println(bottomView(root));
                break;
            }

            case 9: {
                System.out.print("The left View of the Binary tree is ");
                System.out.println(leftView(root));
                break;
            }

            case 10: {
                System.out.print("The right View of the Binary tree is ");
                System.out.println( rightView(root));
                break;
            }

            case 11: {
                System.out.println(CheckChildrenSum(root));
               break;
            }

            case 12: {
                System.out.println(areMirrors(root, root2));
                break;
            }

            
            case 0: {
                System.out.println("Exit");
                running = false;
                break;
            }

            default:
                break;
            }

            System.out.println();

        } while (running);
        scan.close();
        System.out.println("Good Bye :) ");

    }

}