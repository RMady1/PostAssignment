package com.posts.postsManagement.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/***
 * Class to handle geneating the token which sent to the front end and used in the authorization process
 */
@Component
public class TokenGenerator {


    public String generateToken() {
        return getAlphaNumericString(6);
    }

    /**
     * extract the token from the request to get the user
     * @param request
     * @return
     */
    public String extractHeaderToken(HttpServletRequest request) {
        Enumeration headers = request.getHeaders("Authorization");
        if (headers != null && headers.hasMoreElements()) {
             return (String)headers.nextElement();
        }
    return null;
    }

    private String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
