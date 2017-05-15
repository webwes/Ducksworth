import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class cardgamegraphics extends JFrame {
	private static final long serialVersionUID = 1L;
		
	public JFrame global;
	
	public static void main(String[] args){
		
		cardgamegraphics x = new cardgamegraphics();
		x.setVisible(true);
		
		
	
		
		}
	public void launchNormalGame(){
		Game step = new Game();
		step.shuffle();
		
		boolean i = step.stillPlaying();
		while(i){
			
			step.phase1();
			step.DrawBoard();
			i = step.stillPlaying();
			
			
			JPanel holdGame = new JPanel();
			ArrayList<Card> inplay = step.getInPlay();
			ArrayList<Card> inplay2 = step.getInPlay2();
			
			
			
			}
	}
	
	public cardgamegraphics(){
		super("Ducksworth");
		// System.out.println("here");
		setSize(900,900);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		//---------------------------------------------------------------------------------------------------------
		JButton Start = new JButton("Start");
		Start.setBounds(600,800,300,100);
		this.add(Start);
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				gamemodes();
			}
		});
		
		//action goes here
		// --------------------------------------------------------------------------------------------------------
		JButton Exit = new JButton("Exit");
		Exit.setBounds(300,800,300,100);
		this.add(Exit);
		Exit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			};
		});
		//---------------------------------------------------------------------------------------------------------
		JTextField NameOfTheGame = new JTextField ("Ducksworth: The Get Togethering");
		NameOfTheGame.setBounds(350, 100, 200, 50);
		this.add(NameOfTheGame);
		NameOfTheGame.setEditable(false);
		//----------------------------------------------------------------------------------------------------------
		JButton Rules = new JButton ("Click for Rules");
		this.add(Rules);
		Rules.setBounds(0,800,300,100);
		Rules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				rules();
			}
		});
		//action goes here	
	}
	

	public void rules(){
		// cardgamegraphics.dispose();
		JFrame test = new JFrame("rules");
		// new frame 
		test.setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		test.getContentPane().setBackground(Color.white);
		test.setLayout(null);
		// frame defaults
		try {
			Image img = ImageIO.read(getClass().getResource("rulesbruh.png"));
			JLabel b = new JLabel(new ImageIcon(img));
			b.setBounds(175,200, 500, 500);
			test.add(b);

		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		//image of rules
		
		try {
			Image img1 = ImageIO.read(getClass().getResource("rules.png"));
			JLabel b = new JLabel(new ImageIcon(img1));
			b.setBounds(300, 10, 200, 200);
			test.add(b);			
			
			//test.add(new JLabel(new ImageIcon(img1)));

		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		//image of rules banner
	
		test.setVisible(true);
		}
	public void gamemodes(){
		JFrame test1 = new JFrame("game modes");
		test1.setSize(900,900);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		//new frame and frame defaults
		// -----------------------------------------------------------------------------------------------------------
		JButton Normal = new JButton("Normal Mode");
		Normal.setBounds(675,800,225,100);
		test1.add(Normal);
		Normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				launchNormalGame();
			}
		});
		//------------------------------------------------------------------------------------------------------------
		JButton AcesOnly = new JButton("Aces Only Mode");
		AcesOnly.setBounds(450,800,225,100);
		test1.add(AcesOnly);
		//------------------------------------------------------------------------------------------------------------
		JButton OnlyFighters = new JButton("Only Fighters Mode");
		OnlyFighters.setBounds(225,800,225,100);
		test1.add(OnlyFighters);
		//------------------------------------------------------------------------------------------------------------
		JButton ClassicAces = new JButton("Classic Aces Mode");
		ClassicAces.setBounds(0,800,225,100);
		test1.add(ClassicAces);
		//------------------------------------------------------------------------------------------------------------
		JTextField GameModesPage = new JTextField("Game Modes");
		GameModesPage.setEditable(false);
		GameModesPage.setBounds(400, 100, 100, 50);
		test1.add(GameModesPage);
		//------------------------------------------------------------------------------------------------------------
		try {
			Image img1 = ImageIO.read(getClass().getResource("gamedmodesbruh.png"));
			test1.add(new JLabel(new ImageIcon(img1)));

		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		test1.setVisible(true);
		
		
	}
	public void GameState(){
	JFrame MainFrame = new JFrame("Ducksworth");
	MainFrame.setSize(1280,900);
	MainFrame.setResizable(false);
	MainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	MainFrame.setVisible(true);
	this.setLayout(null);
	
	try {
		Image img = ImageIO.read(getClass().getResource("background.png"));
	MainFrame.add(new JLabel(new ImageIcon(img)));

	} catch (IOException e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
	
	}
	
	
	

}
