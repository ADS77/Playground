package ad.practice.playground.handler;

import ad.practice.playground.secure_messaging.RSA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        try {
            RSA rsa = new RSA();
            rsa.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
