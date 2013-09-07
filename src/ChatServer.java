import java.io.*;
import java.net.*;

public class ChatServer {
	public static void main(String[] args) {
		boolean bIsStarted = false;
		
		try {
			ServerSocket ss = new ServerSocket(8888);
			bIsStarted = true;
			
			while(bIsStarted){
				Socket socket = ss.accept();
				System.out.println("a client connected!");
				
				boolean bIsconnected = true;
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				
				while(bIsconnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
				
				dis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
