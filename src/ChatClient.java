import java.awt.*;

public class ChatClient extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().LaunchFrame();
	}

	public void LaunchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.setVisible(true);
	}
}
