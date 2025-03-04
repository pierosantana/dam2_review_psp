package _03_resumen_hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ResumenHash {
    public static void main(String[] args) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] mensaje = "Bye World".getBytes();

            md.update(mensaje);

            byte[] resumenHash = md.digest();

            System.out.println(new String(resumenHash));
            System.out.println(Base64.getEncoder().encodeToString(resumenHash));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }
}
