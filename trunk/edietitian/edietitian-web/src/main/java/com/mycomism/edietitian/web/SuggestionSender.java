package com.mycomism.edietitian.web;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
 
// Send a simple, single part, text/plain e-mail
public class SuggestionSender {
	// SUBSTITUTE EMAIL ADDRESSES OF WHO WILL RECEIVE SUGGESTION HERE
    private final String to = "roboo.jack@gmail.com";
	// SUBSTITUTE THE FROM EMAIL USER
    private final String from = "suggestions";
    // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE
    private final String host = "localhost";
 
    public boolean sendSuggestion(String name, String email, String suggestion) {
 
 
        // Create properties, get Session
        Properties props = new Properties();
 
        // If using static Transport.send(),
        // need to specify which host to send it to
        props.put("mail.smtp.host", host);
        // To see what is going on behind the scene
        props.put("mail.debug", "true");
        Session session = Session.getInstance(props);
 
        try {
            // Instantiate a message
            Message msg = new MimeMessage(session);
 
            //Set message attributes
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("eDietitian Suggestion");
            msg.setSentDate(new Date());
 
            // Set message content
            msg.setText(
            		"NAME: " + name + "\n\n" +
            		"FROM: " + email + "\n\n" +
            		"SUGGESTION: " + suggestion
            );
 
            //Send the message
            Transport.send(msg);
            return true;
        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
            return false;
        }
    }
}//End of class