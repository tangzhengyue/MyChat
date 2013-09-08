import java.io.*;
import java.net.*;

public class ChatServer {
	public static void main(String[] args) {
		boolean bIsStarted = false;
		
		ServerSocket ss = null;
		Socket socket = null;
		DataInputStream dis = null;
		
		try {
			ss = new ServerSocket(8888);
		}
		catch (BindException e) {
			System.out.println("端口正在使用中，请关掉相关程序！");
			System.exit(0);
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
			
		try {
			bIsStarted = true;
			
			while(bIsStarted){
				socket = ss.accept();
				System.out.println("a client connected!");
				
				boolean bIsconnected = true;
				dis = new DataInputStream(socket.getInputStream());
				
				while(bIsconnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
			}
		} catch (IOException e) {
		}
		finally {
			try {
				if (dis != null) {
					dis.close();
				}
				
				if (socket != null) {
					socket.close();
				}
				
				System.out.println("Client disconnected!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
