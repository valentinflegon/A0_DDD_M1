package com.company.domaine.Product;
import java.security.SecureRandom;


public class ProductReference {
    private String reference;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    private int sizeOfReference = 20;

    public ProductReference() {
        randomString(sizeOfReference);
    }

    private void randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        this.reference = sb.toString();
    }
    public String getReference(){
        return reference;
    }
}
