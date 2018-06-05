/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Rabinson
 */
public class Hashing {
    public String Hashing(String textToHash) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
        byte[] hashedByteArray = digest.digest(byteOfTextToHash);
        String encoded = Base64.encode(hashedByteArray);
        return encoded;
    }
    
}
