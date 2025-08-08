package ad.practice.playground.solution.binary_tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class BinaryTree {
    private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);

    public static Node root;


    public void insert(int value){
     root = insertRecursive(root, value);
     logger.info("Inserted->"+value);
    }

    private Node insertRecursive(Node current, int value){
        if(current == null){
            return new Node(value);
        }
        if(value < current.getValue()){
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));

        }
        return current;
    }

    public boolean find(int val){
        return findRecursive(root, val);
    }

    private boolean findRecursive(Node root, int val) {
        if (root == null) return false;
        if (root.getValue() == val) return true;
        return val < root.getValue() ? findRecursive(root.getLeft(), val) : findRecursive(root.getRight(), val);
    }


    public void preOrder(Node root){
        if(root == null) return;
        logger.info("{}", root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(Node root){
        if(root == null) return;;
        inOrder(root.getLeft());
        logger.info("{}", root.getValue());
        inOrder(root.getRight());
    }

    public void postOrder(Node root){
        if(root == null) return;;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        logger.info("{}", root.getValue());
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
                logger.info("Lvl_Itr + {}", node.getValue());
                if(node.getLeft() != null) q.offer(node.getLeft());
                if(node.getRight() != null) q.offer(node.getRight());
                subList.add(node.getValue());
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
                current = current.getLeft();
            }
            current = st.pop();
            logger.info("In_Itr {}", current.getValue());
            current = current.getRight();
        }
    }

    public List<Integer> preOrderIterative(Node root){
        // root -> left -> right
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (! st.isEmpty()){
            Node curr = st.pop();
            ans.add(curr.getValue());
            if(curr.getRight() != null) st.push(curr.getRight());
            if(curr.getLeft() != null) st.push(curr.getLeft());
        }
        return ans;
    }

    public int maxPathSum(Node root){
        int ans = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<>();
        if(root != null) q.offer(root);
        while (! q.isEmpty()){
            Node curr = q.poll();
            if(curr.getLeft() == null && curr.getRight() == null){
                logger.info("curr val : {}", curr.getValue());
                ans = Math.max(ans, curr.getValue());

            }
            if(curr.getLeft() != null){
                curr.getLeft().value += curr.getValue();
                q.offer(curr.getLeft());
            }
            if(curr.getRight() != null){
                curr.getRight().value += curr.value;
                q.offer(curr.getRight());
            }
        }
        return  ans;
    }

    List<Node> twoSum(Node root, int target){
        List<Node> ans = new ArrayList<>();
        Map<Integer, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if(root != null)q.offer(root);
        while (! q.isEmpty()){
            Node curr = q.poll();
            if(mp.containsKey(target - curr.getValue())){
                ans.addAll(List.of(curr, mp.get(target- curr.getValue())));
                break;
            }
            mp.put(curr.getValue(), curr);
            if(curr.getLeft() != null) q.offer(curr.getLeft());
            if(curr.getRight() != null) q.offer(curr.getRight());
        }
        return ans;
    }

}
