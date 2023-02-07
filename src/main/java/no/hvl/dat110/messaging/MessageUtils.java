package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		data = message.getData();
		
		segment = new byte[SEGMENTSIZE];
		segment[0] = (byte) data.length;
		// TODO - START
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
			
		for(int i = 0; i < data.length; i++) {
			
			segment[i + 1] = data[i];
			
		}
		
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		int lengde = segment[0];
		
		byte[] data = new byte[lengde];
		
		// TODO - START
		// decapsulate segment and put received payload data into a message
		
		for(int i = 0; i < lengde; i++) {
			data[i] = segment[i + 1];
		}
		
		message = new Message(data);
		// TODO - END
		
		return message;
		
	}
	
}
