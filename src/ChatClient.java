import java.awt.*;
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
		
		this.setVisible(true);
	}
}
