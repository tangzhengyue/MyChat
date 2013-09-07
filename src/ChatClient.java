import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ChatClient extends Frame{
	private static final long serialVersionUID = 1L;
	
	Socket socket;
	DataOutputStream dos;
	
	TextField txText = new TextField();
	TextArea taContent = new TextArea();
	
	public static void main(String[] args) {
		new ChatClient().LaunchFrame();
	}

	public void LaunchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		
		this.add(txText, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		this.pack();
		
		// 添加关闭窗口的功能
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DisConnect();
				System.exit(0);
			}
		});
		
		// 添加发送消息的功能
		// Send Message
		txText.addActionListener(new TFListener());
		
		this.setVisible(true);
	
		// 连接到服务端
		// Connect to server
		Connect();
	}
	
	public void Connect() {
		try {
			socket = new Socket("192.168.1.90", 8888);
			System.out.println("Connected!");
			
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void DisConnect() {
		try {
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class TFListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = txText.getText().trim();
			
			taContent.setText(str);
			txText.setText("");
			
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
