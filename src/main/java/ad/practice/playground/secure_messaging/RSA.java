package ad.practice.playground.secure_messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RSA {

    private static Logger logger = LoggerFactory.getLogger(RSA.class);

    public KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048, new SecureRandom());
        KeyPair keyPair = generator.generateKeyPair();
        return keyPair;
    }

    public String encrypt(String message, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] cipherText = encryptCipher.doFinal(message.getBytes(UTF_8));
        return Base64.getEncoder().encodeToString(cipherText);

    }

    public  String decrypt(String cipherText, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] bytes = Base64.getDecoder().decode(cipherText);

        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(decriptCipher.doFinal(bytes), UTF_8);
    }

    public String sign(String message, PrivateKey privateKey) throws SignatureException, InvalidKeyException, NoSuchAlgorithmException {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(message.getBytes(UTF_8));

        byte[] signature = privateSignature.sign();

        return Base64.getEncoder().encodeToString(signature);
    }

    public  boolean verify(String message, String signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(message.getBytes(UTF_8));

        byte[] signatureBytes = Base64.getDecoder().decode(signature);

        return publicSignature.verify(signatureBytes);
    }


    public void start() throws Exception {
        Scanner sc = new Scanner(System.in);
        logger.info("insert a message");
        String message = sc.nextLine();

        KeyPair keyPair = generateKeyPair();
        String cipherText = encrypt(message, keyPair.getPublic());
        String decryptedMessage = decrypt(cipherText,keyPair.getPrivate());

        String signature = sign(message, keyPair.getPrivate());
        boolean isVerified = verify(message,signature, keyPair.getPublic());
        logger.info("isVerified : "+ isVerified);
    }

}
