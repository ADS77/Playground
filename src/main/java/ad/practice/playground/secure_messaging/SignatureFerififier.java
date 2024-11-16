package ad.practice.playground.secure_messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class SignatureFerififier {

    private static Logger logger = LoggerFactory.getLogger(SignatureFerififier.class);

public  boolean verifyRSASignature(){
    Scanner in  = new Scanner(System.in);
    String msg = in.nextLine();

    try {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        Signature signature = Signature.getInstance("SHA1withRSA");

        // sign the sig obj with private key
        signature.initSign(privateKey);
        // pass data to signature obj to sign by private key
        signature.update(msg.getBytes(StandardCharsets.UTF_8));


        //generate signature of msg
        byte[] digitalSignature = signature.sign();
        System.out.println("signature" + Base64.getEncoder().encodeToString(digitalSignature));

        //verify signature with public key
        signature.initVerify(publicKey);
        signature.update(msg.getBytes(StandardCharsets.UTF_8));

        boolean verified = signature.verify(digitalSignature);
        System.out.println(verified);
        return  verified;

    } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
        throw new RuntimeException(e);
    }

}

}
