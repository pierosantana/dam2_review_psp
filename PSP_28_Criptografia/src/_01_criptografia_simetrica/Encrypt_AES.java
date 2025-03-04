package _01_criptografia_simetrica;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encrypt_AES {
    public static void main(String[] args) {
        //KeyGenerator
        //SecretKey
        //Cipher

        try {
            //Con DES es exactamente igual, solo debemos cambiar el parametro.
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecretKey key = keygen.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,key);

            byte[] bytesMensaje = "Piero S.".getBytes();
            byte[] bytesMensajeEncriptado = cipher.doFinal(bytesMensaje);

            System.out.println(new String(bytesMensajeEncriptado));

            Cipher decryptCipher = Cipher.getInstance("AES");
            decryptCipher.init(Cipher.DECRYPT_MODE,key);

            byte[] bytesDesencriptado = decryptCipher.doFinal(bytesMensajeEncriptado);

            System.out.println(new String(bytesDesencriptado));




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
