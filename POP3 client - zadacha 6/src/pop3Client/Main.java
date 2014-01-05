package pop3Client;

import java.util.*;
import com.sun.xml.internal.ws.api.message.Message;

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
        System.out.println("--- Message num. " + index + " --- has");
        System.out.println((messages.get(index)) + "bytes"); // getBytes (of messages)
        }
        
        client.logout();
        client.disconnect();
    }
}