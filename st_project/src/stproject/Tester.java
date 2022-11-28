package stproject;

import java.util.*;
import stproject.CFG2.Node;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Tester
{
//    Node root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(3);
//    root.left.left = new Node(4);
//    root.left.right = new Node(5);
//    root.right.left = new Node(6);
//    root.right.right = new Node(7);
    @Test
    public void levelOrder_test1() {
        assertEquals(null,CFG2.levelOrderIterative(null));
    }
    
    @Test
    public void levelOrder_test2() {
        Node root = new Node(10);
        List<Integer> lst = new ArrayList<>(Arrays.asList(10));
        assertEquals(lst,CFG2.levelOrderIterative(root));
    }

    @Test
    public void levelOrder_test3() {
        Node root = new Node(1);
        root.right = new Node(3);
        root.right.left = new Node(6);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,3,6));
        assertEquals(lst,CFG2.levelOrderIterative(root));
    }
    
    @Test
    public void levelOrder_test4() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals(lst,CFG2.levelOrderIterative(root));
    }
    
    @Test
    public void levelOrder_test5() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        assertEquals(lst,CFG2.levelOrderIterative(root));
    }
    
    @Test
    public void levelOrder_test6() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(5);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2,5));
        assertEquals(lst,CFG2.levelOrderIterative(root));
    }
    
    
    @Test
    public void inOrder_test1() {
        assertEquals(null,CFG2.inOrderIterative(null));
    }
    
    @Test
    public void inOrder_test2() {
        Node root = new Node(1);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1));
        assertEquals(lst,CFG2.inOrderIterative(root));
    }
    
    @Test
    public void inOrder_test3() {
        Node root = new Node(1);
        root.left = new Node(2);
        List<Integer> lst = new ArrayList<>(Arrays.asList(2,1));
        assertEquals(lst,CFG2.inOrderIterative(root));
    }
    
    @Test
    public void inOrder_test4() {
        Node root = new Node(1);
        root.right = new Node(3);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,3));
        assertEquals(lst,CFG2.inOrderIterative(root));
    }
    
    
    @Test
    public void preOrder_test1() {
        assertEquals(null,CFG2.preOrderIterative(null));
    }
    
    @Test
    public void preOrder_test2() {
        Node root = new Node(1);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1));
        assertEquals(lst,CFG2.preOrderIterative(root));
    }
    
    @Test
    public void preOrder_test3() {
        Node root = new Node(1);
        root.right = new Node(3);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,3));
        assertEquals(lst,CFG2.preOrderIterative(root));
    }
    
    @Test
    public void preOrder_test4() {
        Node root = new Node(1);
        root.left = new Node(2);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2));
        assertEquals(lst,CFG2.preOrderIterative(root));
    }
    
    @Test
    public void preOrder_test5() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2,4,5,3));
        assertEquals(lst,CFG2.preOrderIterative(root));
    }

    
    @Test
    public void postOrder_test1() {
        assertEquals(null,CFG2.postOrderIterative(null));
    }
    
    @Test
    public void postOrder_test2() {
        Node root = new Node(1);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1));
        assertEquals(lst,CFG2.postOrderIterative(root));
    }

    @Test
    public void postOrder_test3() {
        Node root = new Node(1);
        root.left = new Node(2);
        List<Integer> lst = new ArrayList<>(Arrays.asList(2,1));
        assertEquals(lst,CFG2.postOrderIterative(root));
    }
    
    @Test
    public void postOrder_test4() {
        Node root = new Node(1);
        root.right = new Node(3);
        List<Integer> lst = new ArrayList<>(Arrays.asList(3,1));
        assertEquals(lst,CFG2.postOrderIterative(root));
    }
    
    @Test
    public void postOrder_test5() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> lst = new ArrayList<>(Arrays.asList(4,5,2,6,7,3,1));
        assertEquals(lst,CFG2.postOrderIterative(root));
    }

    
    @Test
    public void isSymmetric_test1() {
        assertEquals(true,CFG2.isSymmetric(null));
    }
    
    @Test
    public void isSymmetric_test2() {
        Node root = new Node(1);
        assertEquals(true,CFG2.isSymmetric(root));
    }
    
    @Test
    public void isSymmetric_test3() {
        Node root = new Node(1);
        root.left = new Node(2);
        assertEquals(false,CFG2.isSymmetric(root));
    }
    
    @Test
    public void isSymmetric_test4() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        assertEquals(false,CFG2.isSymmetric(root));
    }
    
    @Test
    public void isSymmetric_test5() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        assertEquals(false,CFG2.isSymmetric(root));
    }
    
    @Test
    public void isSymmetric_test6() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(4);
        assertEquals(false,CFG2.isSymmetric(root));
    }
    
    @Test
    public void isSymmetric_test7() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        assertEquals(false,CFG2.isSymmetric(root));
    }
    
    @Test
    public void isSymmetric_test8() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.right = new Node(3);
        root.right.left = new Node(3);
        assertEquals(true,CFG2.isSymmetric(root));
    }
    
    @Test
    public void isSymmetric_test9() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.right.left = new Node(3);
        assertEquals(false,CFG2.isSymmetric(root));
    }
    
    
    @Test
    public void bottomView_test1() {
        assertEquals(null,CFG2.bottomView(null));
    }

    @Test
    public void bottomView_test2() {
        Node root = new Node(1); 
        List<Integer> lst = new ArrayList<>(Arrays.asList(1));
        assertEquals(lst,CFG2.bottomView(root));
    }
        
    @Test
    public void bottomView_test3() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        List<Integer> lst = new ArrayList<>(Arrays.asList(2,1,3));
        assertEquals(lst,CFG2.bottomView(root));
    }
    
    @Test
    public void bottomView_test4() {
        Node root = new Node(1); 
        root.left = new Node(2);
        List<Integer> lst = new ArrayList<>(Arrays.asList(2,1));
        assertEquals(lst,CFG2.bottomView(root));
    }
    
    @Test
    public void bottomView_test5() {
        Node root = new Node(1); 
        root.right = new Node(3);
        root.right.right = new Node(7);
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,3,7));
        assertEquals(lst,CFG2.bottomView(root));
    }
    
    @Test
    public void bottomView_test6() {
        Node root = new Node(1); 
        root.left = new Node(2);
        root.left.left = new Node(4);
        List<Integer> lst = new ArrayList<>(Arrays.asList(4,2,1));
        assertEquals(lst,CFG2.bottomView(root));
    }
    
    
    @Test
    public void areMirrors_test1() {
        assertEquals(true,CFG2.areMirrors(null,null));
    }
    
    @Test
    public void areMirrors_test2() {
        Node root1 = new Node(1);
        assertEquals(false,CFG2.areMirrors(root1,null));
    }
    
    @Test
    public void areMirrors_test3() {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        assertEquals(false,CFG2.areMirrors(root1,root2));
    }
    
    @Test
    public void areMirrors_test4() {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        Node root2 = new Node(1);
        assertEquals(false,CFG2.areMirrors(root1,root2));
    }

    @Test
    public void areMirrors_test5() {
        Node root1 = new Node(1);
        Node root2 = new Node(1);
        assertEquals(true,CFG2.areMirrors(root1,root2));
    }

    
    @Test
    public void height_test1() {
        Node root = null;
        int result = 0;
        assertEquals(result, CFG2.height(root));
    }
    
    @Test
    public void height_test2() {
        Node root = new Node(6);
        int result = 1;
        assertEquals(result, CFG2.height(root));
    }
    
    @Test
    public void height_test3() {
        Node root = new Node(6);
        root.left = new Node(4);
        int result = 2;
        assertEquals(result, CFG2.height(root));
    }
    
    @Test
    public void height_test4() {
        Node root = new Node(6);
        root.right = new Node(4);
        int result = 2;
        assertEquals(result, CFG2.height(root));
    }
    
    @Test
    public void height_test5() {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(7);
        int result = 2;
        assertEquals(result, CFG2.height(root));
    }
    
    // @Test
    // public void height_test6() {
    //     Node root = new Node(5);
    //     root.left = new Node(2);
    //     root.right = new Node(3);
    //     root.left.left = new Node(4);
    //     root.left.right = new Node(5);
    //     int result = 3;
    //     assertEquals(result, CFG2.height(root));
    // }
    
    @Test
    public void CheckChildrenSum_test1() {
        assertEquals(true,CFG2.CheckChildrenSum(null));
    }
    
    @Test
    public void CheckChildrenSum_test2() {
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(3);
        assertEquals(false,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void CheckChildrenSum_test3() {
        Node root = new Node(6);
        assertEquals(true,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void CheckChildrenSum_test4() {
        Node root = new Node(6);
        root.right = new Node(6);
        root.right.right = new Node(7);
        assertEquals(false,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void CheckChildrenSum_test5() {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        assertEquals(false,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void CheckChildrenSum_test6() {
        Node root = new Node(5);
        root.right = new Node(3);
        assertEquals(false,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void CheckChildrenSum_test7() {
        Node root = new Node(5);
        root.left = new Node(2);
        assertEquals(false,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void CheckChildrenSum_test8() {
        Node root = new Node(5);
        root.left = new Node(5);
        root.left.left = new Node(4);
        assertEquals(false,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void CheckChildrenSum_test9() {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        assertEquals(false,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void CheckChildrenSum_test10() {
        Node root = new Node(5);
        root.right = new Node(5);
        root.right.left = new Node(3);
        assertEquals(false,CFG2.CheckChildrenSum(root));
    }
    
    @Test
    public void numNodes_test1() {
        assertEquals(0,CFG2.numNodes(null));
    }
    
    @Test
    public void numNodes_test2() {
        Node root = new Node(1);
        root.left = new Node(2);
        assertEquals(2,CFG2.numNodes(root));
    }
    
    @Test
    public void numNodes_test3() {
        Node root = new Node(1);
        root.right = new Node(3);
        assertEquals(2,CFG2.numNodes(root));
    }
    
    
    
}