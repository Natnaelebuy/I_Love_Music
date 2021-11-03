import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import javax.swing.JButton;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

/*
    To compile: javac SpotifyLikeApp.java
    To run: java SpotifyLikeApp
 */

// declares a class for the app
public class SpotifyLikeApp {

    // global variables for the app
    String status;
    Long position;
    static Clip audioClip;
    static String song = "./Mysong/Drake - No Friends In The Industry.wav";
    static Boolean Playing = false;
    //private static Clip clip;
   // private static Object name;
    //private static Object artist;
    //private static Object image;

    // "main" makes this class a java app that can be executed
    public static void main(final String[] args) {

        // create a scanner for user input
        Scanner input = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("q")) {

            menu();

            // get input
            userInput = input.nextLine();
            // accept upper or lower case commands
            userInput.toLowerCase();
            // do something
            handleMenu(userInput);

        }

        // close the scanner
        input.close();

    }

    /*
     * displays the menu for the app
     */
    public static void menu() {

        System.out.println("---- SpotifyLikeApp ----");
        System.out.println("[H]ome");
        System.out.println("[S]earch by title");
        System.out.println("[L]ibrary");
        System.out.println("[P]lay");
        System.out.println("[Q]uit");
        

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
                
            case "p":
                System.out.println("-->Play<--");
                break;

            case "q":
                System.out.println("-->Quit<--");
                break;
            

            default:
                break;
        }

    }

    /*
     * plays an audio file
     */
    public static void play(String Song) {
        // open the audio file
        final File file = new File(song);
        try {
             if (Playing = true)
             {
                 audioClip.stop();
                 Playing = false;
             }
            // create clip 
            audioClip = AudioSystem.getClip();
            // get input stream
            final AudioInputStream in = getAudioInputStream(file);
            audioClip.open(in);
            audioClip.setMicrosecondPosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            Playing = true;
        } catch(Exception e) {
            e.printStackTrace(); 
        
        }
        
        
            
        
    }
    public static void Rewind() 
    {
        Scanner input = new Scanner(System.in);
        audioClip.stop();
        System.out.println(audioClip.getMicrosecondPosition());
        System.out.println("How far back would you like to go? + \n");
        Long Rewound = (input.nextLong()*1000);
        Long CurrentTime = audioClip.getMicrosecondPosition();
        Long NewTime = CurrentTime - Rewound;
        audioClip.setMicrosecondPosition(NewTime);
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println(audioClip.getMicrosecondPosition());
    }

    public static void Search() {
        String[] Songlist;
        Songlist = new String[2];
        Songlist[0] = "./Mysong/Drake - No Friends In The Industry.wav";
        Songlist[1] = "./Mysong/Dee_Yan-Key_-_10_-_vacaciones_salsa.wav";

        for(int k = 0; k < Songlist.length; k++)
        {
            int a = k+1;
            System.out.println(a + Songlist[k]);
        }
        
        System.out.println("Please choose a song");
        Scanner Selection = new Scanner(System.in);
        int Choice;
        Choice = Selection.nextInt() - 1;
        song = Songlist[Choice];
        
    }




}

