package ad.practice.playground.solution.bst;

import java.util.*;

public class BST {
    private int value;
    private BST left;
    private BST right;

    public BST(int val){
        this.value = val;
        this.left = null;
        this.right = null;
    }

    public BST (int val, BST left, BST right){
        this.value = val;
        this.left = left;
        this.right = right;
    }
    public BST(){

    }




    public static void main(String[] a){
        BST root = new BST();
        root.value = 100;
        root.insert(root,120);
        root.insert(root,80);
        root.insert(root, 70);
        root.insert(root,90);
        root.insert(root,55);
        root.insert(root,60);
        System.out.println("Pre-Order : " + root.preOrder(root));

    }

    private BST insert(BST root,int val) {
        if(root == null) return new BST(val);

        if (val > root.value) {
            root.right = insert(root.right, val);
        } else if (val < root.value) {
           root.left = insert(root.left, val);
        } else {
            System.out.println("duplicate value found..");
        }
        return root;
    }

    private BST insertIter(BST root, int val){
        BST node = new BST(val);
        if(root == null) return  node;
        BST parent = null;
        BST current = root;
        while (current != null){
            parent = current;
            if(val < current.value){
                current = current.left;
            }
            else if(val > current.value){
                current = current.right;
            }
        }
        if(val < parent.value) parent.left = node;
        else parent.right = node;
        return root;
    }

    private boolean searchItr(BST root, int value){
        if(root == null) return  false;
        BST current = root;
        while (current != null){
            if(current.value == value) return true;
            if(value > current.value){
                current = current.right;
            }
            else{
                current = current.left;
            }
        }
        return false;
    }

    private boolean search(BST root, int value){
        if(root == null) return false;
        if(root.value == value) return true;
        return value > root.value ? search(root.right, value) : search(root.left, value);
    }

    private List<Integer> preOrder(BST root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return  ans;
        Stack<BST> st = new Stack<>();
        st.push(root);
        while (! st.isEmpty()){
            BST curr = st.pop();
            ans.add(curr.value);
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);

        }
        return ans;
    }
}
