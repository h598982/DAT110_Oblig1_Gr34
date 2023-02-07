package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		int lengde = payload.length + 1;
		
		byte[] rpcmsg = new byte[lengde];
		
		rpcmsg[0] = rpcid;
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		
		for (int i = 0; i < payload.length; i++) {
			rpcmsg[i+1] = payload[i];
		}
		
		if(rpcmsg.length > 127) {
			return null;
		}
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = new byte[rpcmsg.length - 1];
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		for (int i = 0; i < rpcmsg.length - 1; i++) {
			payload[i] = rpcmsg[i + 1];
		} 
		
		
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = new byte[2];
		
		// TODO - START 
		
		encoded = str.getBytes();
		
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 
		
		decoded = new String(data);
		
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		

		return new byte [0];
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		// TODO - START 
		
		ByteBuffer bb = ByteBuffer.allocate(Integer.BYTES);
		bb.putInt(x);
		
		// TODO - END
		
		return bb.array();
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		
		// TODO - START 
		
		ByteBuffer bb = ByteBuffer.wrap(data);

		// TODO - END
		
		return bb.getInt();
		
	}
}