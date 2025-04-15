package ad.practice.playground.solution.binary_tree;

import java.util.List;

public class Handler {
    public static void main(String[]arge){
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node root = new BinaryTree.Node(-1);
        BinaryTree.Node a = new BinaryTree.Node(-6);
        BinaryTree.Node b = new BinaryTree.Node(-5);
        BinaryTree.Node c = new BinaryTree.Node(-3);
        BinaryTree.Node d = new BinaryTree.Node(0);
        BinaryTree.Node e = new BinaryTree.Node(-13);
        BinaryTree.Node f = new BinaryTree.Node(-1);
        BinaryTree.Node g = new BinaryTree.Node(-2);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;
        d.left = f;
        e.right = g;
        List<BinaryTree.Node> ls = bt.twoSum(root, -6);
        for(BinaryTree.Node t : ls)
            System.out.println(t.value);
    }
}
