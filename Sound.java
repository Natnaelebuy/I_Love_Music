import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Sound {
	
	JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton soundButton;
	String clickSound;
	ButtonHandler bHandler = new ButtonHandler();
	SoundEffect se = new SoundEffect();
	

	public static void main(String[] args) {
		
		new Sound();

	}
	
	public Sound(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(300, 300, 200, 100);
		buttonPanel.setBackground(Color.black);
		con.add(buttonPanel);
		
		
		soundButton = new JButton("play");
		soundButton.setFocusPainted(false);
		soundButton.addActionListener(bHandler);
		soundButton.setActionCommand("soundB");
		buttonPanel.add(soundButton);
				
		window.setVisible(true);
			
        // Type your audio file name in the res folder
		clickSound = "./song/Nico  Vinz - Am I Wrong.wav";
		clickSound = "./song/DJ Khaled- Do You Mind.wav";


	}
	public static void menu() {

        System.out.println("---- SpotifyLikeApp ----");
        System.out.println("[H]ome");
        System.out.println("[S]earch by title");
        System.out.println("[L]ibrary");
        System.out.println("[P]lay");
        System.out.println("[Q]uit");
        System.out.println("[F]avorte");
        System.out.println("1, pause");
        

        System.out.println("");
        System.out.print("Enter q to quit:");

    }

    /*
     * handles the user input for the app
     */
    public static void handleMenu(String userInput) {

        switch(userInput) {

            case "h":
                System.out.println("-->Home<--");
                break;

            case "s":
                System.out.println("-->Search by title<--");
                Search();      
                break;

            case "l":
                System.out.println("-->Library<--");                                   
                break;

            case "q":
                System.out.println("-->Quit<--");
                break;
            case "f":
                System.out.println("-->favorite song<--");            
                Search();
                break;
            case "1":
            System.out.println("-->pause<--");
            pause();
				break;
            

            default:
                break;
        }

    }
	
	private static void pause() {
	}

	private static void Search() {
	}

	public class SoundEffect {
		
		Clip clip;
		
		public void setFile(String soundFileName){
			
			try{
				File file = new File(soundFileName);
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);	
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
			catch(Exception e){
				
			}
		}
		
		public void play(){
			
			clip.setFramePosition(0);
			clip.start();
		}

	}
	
	public class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			se.setFile(clickSound);
			se.play();							
		}
	}

}

    

