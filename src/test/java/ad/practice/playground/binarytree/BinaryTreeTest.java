package ad.practice.playground.binarytree;

import ad.practice.playground.solution.binary_tree.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BinaryTreeTest {
    @Test
    public void testBT(){
        BinaryTree bt = new BinaryTree();
        bt.insert(6);
        bt.insert(2);
        bt.insert(1);
        bt.insert(7);
        bt.insert(3);
        bt.insert(4);
        bt.insert(10);
        bt.insert(8);
        assertTrue(bt.find(6));
        assertTrue(bt.find(2));
        assertFalse(bt.find(10));
    }
}
