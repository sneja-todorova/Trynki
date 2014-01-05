package pop3Client;

import java.util.*;

import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        POP3Client client = new POP3Client();
        //client.setDebug(true);
        client.connect("pop3.myserver.com");
        client.login("name@myserver.com", "password");
        
        System.out.println("Number of new emails: " + client.getNumberOfNewMessages());
        
        LinkedList<Message> messages = client.getMessages();
        for (int index = 0; index < messages.size(); index++) {
	        System.out.println("--- Message num. " + index + " --- has ");
	        System.out.println((messages.get(index)).getBytes() + "bytes");
	       // System.out.println("That message is: " + (messages.get(index)).getBody()); 
        }
        
        client.logout();
        client.disconnect();
    }
}