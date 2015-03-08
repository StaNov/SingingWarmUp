package singing.audio;

import org.jfugue.Pattern;
import org.jfugue.Player;

import static singing.audio.NoteHelper.*;
import static singing.audio.ScoreCreator.*;

/**
 *
 * @author StaNov
 */
public class SamplePlayer {
    public static final String STARTING_NOTE = "C5";

    private Player player;
    private String startingNote;

    public SamplePlayer() {
        player = new Player();
        startingNote = STARTING_NOTE;
    }
    
    public void stepUp() {
        startingNote = getNoteStepUp(startingNote);
    }
    
    public void stepDown() {
        startingNote = getNoteStepDown(startingNote);
    }
    
    public void play() {
        Pattern pattern = createScore(startingNote);
        player.play(pattern);
    }
}
