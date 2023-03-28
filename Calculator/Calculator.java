
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class main {
	private static JFrame frame;
	private static JLabel label;
	private static ArrayList<JButton> buttons;
	private static int j2 = 0;
	private static double j = 1;
	private static int i = 0;
	public static void main(String args[]) {
		mainView();
	}

	public static void mainView() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(415, 440);
		frame.setTitle("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		label = new JLabel("jkdhkj");
		label.setBounds(0, 0, 400, 100);
		calcView();
	}

	public static void calcView() {
		label = new JLabel("", SwingConstants.CENTER);
		label.setBounds(0, 0, 400, 100);
		buttons = new ArrayList<>();
		frame.add(label);
		while (i < 12) {
			if (i == 3) {
				buttons.add(new JButton("+"));
				justamethod(i, j, true);
				final int j3 = i;
				buttons.get(i).addActionListener(e -> label.setText(label.getText() + buttons.get(j3).getText()));
			} else if (i == 7) {
				buttons.add(new JButton("-"));
				justamethod(i, j, true);
				final int j3 = i;
				buttons.get(i).addActionListener(e -> label.setText(label.getText() + buttons.get(j3).getText()));
			} else if (i == 11) {
				buttons.add(new JButton("="));
				justamethod(i, j, true);
				final int j3 = i;
				buttons.get(i).addActionListener(e -> calculate());
			} else {
				buttons.add(new JButton(Integer.toString((i + 1) - j2)));
				justamethod(i, j, false);
				final int j3 = i;
				buttons.get(i).addActionListener(e -> label.setText(label.getText() + buttons.get(j3).getText()));
			}
			i++;
		}
	}

	public static void justamethod(int i, double j3, boolean lol) {
		buttons.get(i).setBounds((i % 4) * 100, ((int) (j / 1) * 100), 100, 100);
		frame.add(buttons.get(i));
		j = j + 0.25;
		i++;
		if (lol) {
			j2 = j2 + 1;
		}
	}
	public static void calculate(){
		String lol = label.getText();
	
		for(int z = 0;z<lol.length();z++){
			if(lol.substring(z,z+1).equals("+")){
				justanothermethod(Integer.parseInt(lol.substring(0,z)),Integer.parseInt(lol.substring(z+1,lol.length())),true);
			}
			else if(lol.substring(z,z+1).equals("-")){
				justanothermethod(Integer.parseInt(lol.substring(0,z)),Integer.parseInt(lol.substring(z+1,lol.length())),false);
			}	
		}
	}
	public static void justanothermethod(int one,int two,boolean lol){
		int result = 0;
		if(lol){
			result = one + two;
		}
		else{
			result = one - two;
		}
		JOptionPane.showMessageDialog(null,result, "result", JOptionPane.PLAIN_MESSAGE);
		label.setText("");
	}
	

}
