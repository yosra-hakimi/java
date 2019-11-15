
/*
package com.thp.project.vintud.config;

import org.jasypt.digest.StandardStringDigester;


public class SecureMyPassword {

    public void setConfiguration()
    {
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-512");   // optionally set the algorithm
        digester.setIterations(1);          // increase security by performing 50000 hashing iterations
    }

    public   String securePassword(String plaintextPassword)
    {
        StandardStringDigester digester = new StandardStringDigester();
        setConfiguration();
        String digest = digester.digest(plaintextPassword);
        System.out.println(digester.matches(plaintextPassword, digest));
        return  digest;
    }

    public   boolean checkMyPassword(String plainTextPasword, String encyptedPassword)
    {
        StandardStringDigester digester = new StandardStringDigester();
        return digester.matches(plainTextPasword, encyptedPassword);
    }
}
*/