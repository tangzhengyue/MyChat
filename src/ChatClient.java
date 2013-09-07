import java.awt.*;

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
		
		this.setVisible(true);
	}
}
