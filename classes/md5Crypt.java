package classes;

import java.math.BigInteger;
import java.security.*; 

//this class has methodes to encrypt and check md5 hash 
// i m going to add access to this class so it can  check and update the sql  and crud the clientData db 


public class md5Crypt {


   


    public static String md5Encryption(String password ){
        String md5Hash ="";   
        
    try {
        MessageDigest md = MessageDigest.getInstance("MD5") ;
        md.update(password.getBytes(),0, password.length());
        md5Hash = new BigInteger(1,md.digest()).toString(16) ; 
        //System.out.println(md5Hash)  ;
        } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return md5Hash ; 
    
    
    }

    public static boolean  verifyHash(String pw , String hash  ){
        boolean result = false ; 
        if (md5Encryption(pw).equals(hash)){
            System.out.println("correct password "); 
            result=true; 
            return result ; 
        }else {
            System.out.println("incorrect password ") ; 
            return result; 

        }
        

    }

    
}
