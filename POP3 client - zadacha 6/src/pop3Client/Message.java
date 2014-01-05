package pop3Client;

import java.util.*;

public class Message {

	private final Map<String, List<String>> headers;
	
	private final String body;
	
	private byte[] bytes;
	
	protected Message(Map<String, List<String>> headers, String body) {
		this.headers = Collections.unmodifiableMap(headers);
		this.body = body;
		this.bytes = body.getBytes();
	}	

	public Map<String, List<String>> getHeaders() {
		return headers;
	}
	
	public String getBody() {
		return body;
	}
	
	public byte[] getBytes(){
		return this.bytes;
	}

}


