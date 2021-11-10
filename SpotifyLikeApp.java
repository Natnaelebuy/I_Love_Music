import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SpotifyLikeApp {

    // global variables for the app
    String status;
    Long position;
    static Clip audioClip;
static HashMap<String, Song> song = new HashMap<>();
private static HashMap<String, Song> songs;
private static boolean Playing;


    
// "main" make this class a java app that can be executed
public static void main(String[] args) {
    Song s = new Song();
            s.setArtist("DJ Khaled ft. Nicki Minaj, Chris Brown, August Alsina, Jeremih, Future & Rick Ross");
            s.setTitle("Do You Mind");
            s.setYear("2016");
            s.setGenre("POP");
            s.setFilePath("./Song/DJ Khaled- Do You Mind.wav");

            s = new Song();
            s.setArtist("DJ Khaled ft. Chris Brown, August Alsina,Jermih, future");
            s.setTitle("Hold you down");
            s.setYear("2015");
            s.setGenre("POP");
            s.setFilePath("./Song/DJ Khaled-Hold you down.wav");

            s = new Song();
            s.setArtist("Drake ft. Lil Baby");
            s.setTitle("Girls Want Girls");
            s.setYear("2021");
            s.setGenre("Hip-Hop");
            s.setFilePath("./Song/Drake - Girls Want Girls.wav");

            s = new Song();
            s.setArtist("Ed - sheeran ");
            s.setTitle("shape of you");
            s.setYear("2017");
            s.setGenre("Pop");
            s.setFilePath("./Song/Ed -sheeran shape of you.wav");
        // create a scanner for user input
        Scanner input = new Scanner(System.in);

        String userInput = "";
        while (!userInput.equals("q")){

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

private static void menu() {

    System.out.println("---- SpotifyLikeApp ----");
        System.out.println("[H]ome");
        System.out.println("[S]earch by title");
        System.out.println("[L]ibrary");
        System.out.println("[P]lay");
        System.out.println("[Q]uit");
        System.out.println("");

        System.out.println("");
        System.out.print("Enter q to quit:");
}

private static void handleMenu(String userInput) {
    switch(userInput){
        case "h":
             System.out.println("-->Home<--");
             break;
        case "s":
            System.out.println("-->Search by title<--");
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the title:");
            String title = input.nextLine();
            Song song = songs.get(title);
        

            if (song !=null)
            {
                System.out.println("Your current selection is now playing");
                
                play(song.getFilePath());

            }else {
                System.out.println("sorry, please search again.");

                break;

            }
        case "l":
            System.out.println("-->Library<--");
            for(Map.Entry<String, Song> s : songs.entrySet()){
                System.out.println("Title: " + s.getValue().getTitle());
                System.out.println("Artist: " + s.getValue().getArtist());
                System.out.println("Gemre: " + s.getValue().getGenre());
                System.out.println("Year: " + s.getValue().getYear());
                System.out.println("");
            }
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

private static void play(String filePath) {
    // open the audio file
    File file = new File(filePath);
    try {
         if (Playing == true)
         {
             audioClip.stop();
             Playing = false;
         }

        // create clip 
        audioClip = AudioSystem.getClip();
        // get input stream
        final AudioInputStream in = getAudionInputStream(file);
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
    

private static AudioInputStream getAudionInputStream(File file) {
    return null;
}

    


}
