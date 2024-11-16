package ad.practice.playground.solution.binary_tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class BinaryTree {
    private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    public static Node root;


    public void insert(int value){
     root = insertRecursive(root, value);
     logger.info("Inserted->"+value);
    }
    private Node insertRecursive(Node current, int value){
        if(current == null){
            return new Node(value);
        }
        if(value < current.value){
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);

        }
        return current;
    }

    public boolean find(int val){
        return findRecursive(root, val);
    }

    private boolean findRecursive(Node root, int val) {
        if (root == null) return false;
        if (root.value == val) return true;
        return val < root.value ? findRecursive(root.left, val) : findRecursive(root.right, val);
    }


    public void preOrder(Node root){
        if(root == null) return;
        logger.info("{}", root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root == null) return;;
        inOrder(root.left);
        logger.info("{}", root.value);
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null) return;;
        postOrder(root.left);
        postOrder(root.right);
        logger.info("{}", root.value);
    }

    public List<List<Integer>> lavelOrderIterative(Node root){
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) return ls;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (! q.isEmpty()){
            List<Integer>subList = new ArrayList<>();
            int size = q.size();
            for(int i = 0;i<size;i++){
                Node node = q.poll();
                logger.info("Lvl_Itr + {}", node.value);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                subList.add(node.value);
            }
            ls.add(subList);
        }
        return ls;
    }

    public void inOrderIterative(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        Node current = root;
        while (! st.isEmpty() || current != null){
            while (current != null){
                st.push(current);
                current = current.left;
            }
            current = st.pop();
            logger.info("In_Itr {}", current.value);
            current = current.right;
        }
    }

    public void preOrderIterative(Node root){
        if(root == null) return;
        Queue<Node>q = new LinkedList<>();
        q.offer(root);
        while (! q.isEmpty()){
            Node node = q.poll();
            logger.info("Pre_itr {}", node.value);
            if (node.left != null){
                q.offer(node.left);
            }
        }
    }

}
