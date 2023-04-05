package com.rclgroup.dolphin.web.utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class EncryptDecryptUtil{
    private Cipher ecipher;
    private Cipher dcipher;
    private String passPhrase;

    public void setPassPhrase(String passPhrase){
        this.passPhrase = passPhrase;
    }

    public String getPassPhrase(){
        return passPhrase;
    }
    
    public EncryptDecryptUtil(){
    }
    // Responsible for setting, initializing this object's encrypter and
    // decrypter Chipher instances

    /**
     * Constructor used to create this object.  Responsible for setting
     * and initializing this object's encrypter and decrypter Chipher instances
     * given a Secret Key and algorithm.
     * @param key        Secret Key used to initialize both the encrypter and
     *                   decrypter instances.
     * @param algorithm  Which algorithm to use for creating the encrypter and
     *                   decrypter instances.
     */
    public EncryptDecryptUtil(SecretKey key, String algorithm){
        try{
            ecipher = Cipher.getInstance(algorithm);
            dcipher = Cipher.getInstance(algorithm);

            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch(NoSuchPaddingException e){
            System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch(NoSuchAlgorithmException e){
            System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch(InvalidKeyException e){
            System.out.println("EXCEPTION: InvalidKeyException");
        }
    }

    public EncryptDecryptUtil(String passPhrase){
        KeySpec keySpec = null;
        SecretKey key = null;

        AlgorithmParameterSpec paramSpec = null;
        // 8-bytes Salt
        byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x34, (byte) 0xE3, 
            (byte) 0x03 };

        // Iteration count
        int iterationCount = 19;
        try{
            // Generate a temporary key. In practice, you would save this key
            // Encrypting with DES Using a Pass Phrase
            if(passPhrase == null){
                passPhrase = getPassPhrase();
                if(passPhrase==null){
                    passPhrase = ""; 
                }
            }
            setPassPhrase(passPhrase);
            
            keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());

            // Prepare the parameters to the cipthers
            paramSpec = new PBEParameterSpec(salt, iterationCount);

            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

        } catch(InvalidAlgorithmParameterException e){
            System.out.println("EXCEPTION: InvalidAlgorithmParameterException");
        } catch(InvalidKeySpecException e){
            System.out.println("EXCEPTION: InvalidKeySpecException");
        } catch(NoSuchPaddingException e){
            System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch(NoSuchAlgorithmException e){
            System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch(InvalidKeyException e){
            System.out.println("EXCEPTION: InvalidKeyException");
        }
    }

  
    public static String convertStringToHex(String str) throws Exception{
        StringBuffer hex = null;
        
        char[] chars = null;
        try{    
            hex = new StringBuffer();
            
            chars = str.toCharArray();
            for(char character: chars){
                hex.append(Integer.toHexString((int) character));
            }
        }catch(Exception ex){
            throw ex;
        }
        return hex.toString();
    }
     
    public static String convertHexToString(String hex) throws Exception {
        StringBuilder sb = null;
        StringBuilder temp = null;
        
        String output = null;
        
        int decimal = 0;
        try{
            sb = new StringBuilder();
            temp = new StringBuilder();
            //49204c6f7665204a617661 split into two characters 49, 20, 4c...
            for(int i=0; i<hex.length()-1; i+=2 ){
                //grab the hex in pairs
                output = hex.substring(i, (i + 2));
                //convert hex to decimal
                decimal = Integer.parseInt(output, 16);
                //convert the decimal to character
                sb.append((char)decimal);
            
                temp.append(decimal);
            }
           // System.out.println("Decimal : " + temp.toString());  
        }catch(Exception ex){
            throw ex;    
        }
        return sb.toString();
    }

    
    public static void main(String[] args){
//        testUsingSecretKey();
       // testUsingPassPhrase();
        try{
           // testConvertStringToHex();
            
        	
            //System.out.println("Result = "+convertHexToString("4E424850323032303131"));
            System.out.println("Result to hex= "+convertStringToHex("Nly8Q~nNooOdhaK_5QkzqKXEjojPGDYM~X8xCacw"));
           // System.out.println("Result to string = "+convertHexToString("52434c5f436f6e676e6973685465616d"));

        }catch(Exception ex){
            
        }
    }
}
