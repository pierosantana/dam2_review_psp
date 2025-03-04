package _02_criptografia_asimetrica;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class Encrypt_RSA {
    public static void main(String[] args) {

        //KeyPairGenerator
        //KeyPair
        //PrivateKey
        //PublicKey
        //Cipher

        //Para confidencialidad, ciframos con PublicKey y desiframos con PrivateKey.
        //Para autenticidad, ciframos con PrivateKey y desiframos con PublicKey.

        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyGen.generateKeyPair();

            PrivateKey privKey = keyPair.getPrivate();
            PublicKey pubKey = keyPair.getPublic();

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,pubKey);

            byte[] bytesMensaje = "Mensaje privado".getBytes();

            byte[] bytesMensajeEncriptado = cipher.doFinal(bytesMensaje);

            System.out.println(new String(bytesMensajeEncriptado));

            Cipher decryptCipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,privKey);

            byte[] bytesMensajeDecriptado = cipher.doFinal(bytesMensajeEncriptado);
            System.out.println(new String(bytesMensajeDecriptado));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }

    }
}
