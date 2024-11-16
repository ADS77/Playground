package ad.practice.playground.handler;

import ad.practice.playground.secure_messaging.SignatureFerififier;
import ad.practice.playground.solution.*;
import ad.practice.playground.solution.binary_tree.BinaryTree;
import ad.practice.playground.solution.sorting_algo.BubbleSort;
import ad.practice.playground.solution.sorting_algo.InsertionSort;
import ad.practice.playground.solution.sorting_algo.SelectionSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Handler {
    private static final Logger logger = LoggerFactory.getLogger(Handler.class);
    public static void handle(){
     /*   BinaryTree bt = new BinaryTree();
        bt.insert(6);
        bt.insert(4);
        bt.insert(5);
        bt.insert(3);
        bt.insert(8);
        bt.insert(2);
        bt.insert(1);
        bt.insert(9);
        bt.insert(7);

      */

        SignatureFerififier sf = new SignatureFerififier();
        sf.verifyRSASignature();
    }

}
