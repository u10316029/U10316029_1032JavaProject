import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Game extends JFrame{
	int round = 1;
	int rand1,rand2,rand3,rand4;
	private static JLabel firstLabel,seccondLabel,thirdLabel,fourthLabel,resault;
	private static JButton higher, lower,equal;
	private JMenuBar menubar;
	private JMenu file;
	private JMenuItem reset,exit;
	
	public Game(){
		rand1 = (int)(Math.random() * 20 + 1);
		Font font = new Font("Serief",Font.BOLD,30);
		setLayout(new GridLayout(3,1));
		
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		file = new JMenu("File");
		menubar.add(file);
		
		reset = new JMenuItem("Restart");
		file.add(reset);
		
		exit = new JMenuItem("Quit");
		file.add(exit);
		
		systemClose s = new systemClose();
		exit.addActionListener(s);
		
		restartGame r = new restartGame();
		reset.addActionListener(r);
		
		Container pane = this.getContentPane();
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,4));
		
		firstLabel = new JLabel(""+rand1,SwingConstants.CENTER);
		firstLabel.setFont(font);
		top.add(firstLabel);
		
		seccondLabel = new JLabel("",SwingConstants.CENTER);
		seccondLabel.setFont(font);
		top.add(seccondLabel);
		
		thirdLabel = new JLabel("",SwingConstants.CENTER);
		thirdLabel.setFont(font);
		top.add(thirdLabel);
		
		fourthLabel = new JLabel("",SwingConstants.CENTER);
		fourthLabel.setFont(font);
		top.add(fourthLabel);
		pane.add(top);
		
		JPanel middle = new JPanel();
		middle.setLayout(new GridLayout(1,3));
		
		higher = new JButton("Higher");
		higher.setFont(new Font("Serief",Font.ITALIC,24));
		middle.add(higher);
		
		equal = new JButton("Equal");
		equal.setFont(new Font("Serief",Font.ITALIC,24));
		middle.add(equal);
		
		lower = new JButton("Lower");
		lower.setFont(new Font("Serief",Font.ITALIC,24));
		middle.add(lower);
		
		pane.add(middle);
		
		event e = new event();
		higher.addActionListener(e);
		lower.addActionListener(e);
		equal.addActionListener(e);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1,1));
		
		resault = new JLabel("",SwingConstants.CENTER);
		resault.setFont(font);
		bottom.add(resault);
		pane.add(bottom);
		
	}
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String option = e.getActionCommand();
			
			if(round==1){
				rand2 = (int)(Math.random()*20+1);
				seccondLabel.setText(""+rand2);
				
				if(rand2 > rand1 && option.equals("Higher")){
					resault.setText("Correct,2 More!");
				}
				else if(rand2 == rand1 && option.equals("Higher")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand2 == rand1 && option.equals("Lower")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand2 > rand1 && option.equals("Lower")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand2 < rand1 && option.equals("Higher")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand2 < rand1 && option.equals("Lower")){
					resault.setText("Correct,2 More!");
				}
				else if(rand2 == rand1 && option.equals("Equal")){
					resault.setText("Correct,2 More!");
				}
				else if(rand2 != rand1 && option.equals("Equal")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				round = 2;
			}
			else if(round==2){
				rand3 = (int)(Math.random()*20+1);
				thirdLabel.setText(""+rand3);

				if(rand3 > rand2 && option.equals("Higher")){
					resault.setText("Correct,1 More!");
				}
				else if(rand3 == rand2 && option.equals("Higher")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand3 == rand2 && option.equals("Lower")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand3 > rand2 && option.equals("Lower")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand3 < rand2 && option.equals("Higher")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand3 < rand2 && option.equals("Lower")){
					resault.setText("Correct,1 More!");
				}
				else if(rand3 == rand2 && option.equals("Equal")){
					resault.setText("Correct,1 More!");
				}
				else if(rand3 != rand2 && option.equals("Equal")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				round = 3;
			}
			else if(round==3){
				rand4 = (int)(Math.random()*20+1);
				fourthLabel.setText(""+rand4);

				if(rand4 > rand3 && option.equals("Higher")){
					resault.setText("You Win!");
				}
				else if(rand4 == rand3 && option.equals("Higher")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand4 == rand3 && option.equals("Lower")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand4 > rand3 && option.equals("Lower")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand4 < rand3 && option.equals("Higher")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
				else if(rand4 < rand3 && option.equals("Lower")){
					resault.setText("You Win!");
				}
				else if(rand4 == rand3 && option.equals("Equal")){
					resault.setText("You Win!");
				}
				else if(rand4 != rand3 && option.equals("Equal")){
					resault.setText("Wrong,You Lose.");
					higher.setEnabled(false);
					lower.setEnabled(false);
					equal.setEnabled(false);
				}
			}
		}
	}
	public class systemClose implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	public class restartGame implements ActionListener{
		public void actionPerformed(ActionEvent e){
			rand1 = (int)(Math.random()*20+1);
			round = 1;
			higher.setEnabled(true);
			lower.setEnabled(true);
			equal.setEnabled(true);
			firstLabel.setText(""+rand1);
			seccondLabel.setText("");
			thirdLabel.setText("");
			fourthLabel.setText("");
		}
	}
	public static void main(String[]args){
		Game guessGame = new Game();
		guessGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guessGame.setVisible(true);
		guessGame.setSize(500,500);
		guessGame.setResizable(false);
	}
}
