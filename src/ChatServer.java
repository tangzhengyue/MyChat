import java.io.*;
import java.net.*;

public class ChatServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			
			while(true){
				Socket socket = ss.accept();
				System.out.println("a client connected!");
				
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				
				String str = dis.readUTF();
				System.out.println(str);
				dis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
