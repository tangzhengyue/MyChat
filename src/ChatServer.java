import java.io.*;
import java.net.*;

public class ChatServer {
	public static void main(String[] args) {
		new ChatServer().Start();
	}
	
	public void Start() {
		boolean bIsStarted = false;
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket(8888);
			bIsStarted = true;
		}
		catch (BindException e) {
			System.out.println("端口正在使用中，请关掉相关程序！");
			bIsStarted = false;
			System.exit(0);
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
			
		try {
			while(bIsStarted){
				Socket socket = ss.accept();
				System.out.println("a client connected!");
				
				Client client = new Client(socket);
				new Thread(client).start();
			}
		} catch (IOException e) {
		}
		finally {
			try {
				if (ss != null) {
					ss.close();
				}
				
				System.out.println("Client disconnected!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Client implements Runnable {
		private Socket socket;
		private DataInputStream dis;
		private boolean bIsConnected = false;
		
		public Client(Socket socket) {
			this.socket = socket;
			try {
				this.dis = new DataInputStream(this.socket.getInputStream());
				bIsConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				while(bIsConnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
			} 
			catch (EOFException e) {
				System.out.println("Client disconnected!");
			}
			catch (IOException e) {
			}
			finally {
				try {
					if (dis != null) {
						dis.close();
					}
					
					if (socket != null) {
						socket.close();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
