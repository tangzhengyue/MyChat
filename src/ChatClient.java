import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame{
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
	}
	
	private class TFListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = txText.getText().trim();
			
			taContent.setText(s);
			txText.setText("");
		}
	}
}
