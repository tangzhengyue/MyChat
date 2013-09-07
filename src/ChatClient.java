import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ChatClient extends Frame{
	private static final long serialVersionUID = 1L;
	
	Socket socket;
	
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
	
	public void Connect(){
		try {
			socket = new Socket("192.168.1.90", 8888);
			System.out.println("Connected!");
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
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(str);
				dos.flush();
				dos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
