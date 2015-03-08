package singing.audio;

import org.jfugue.Pattern;

import static singing.audio.NoteHelper.*;

/**
 *
 * @author StaNov
 */
public class ScoreCreator {
    
    public static Pattern createScore(String startingNote) {
        
        String note1 = startingNote;
        String note2 = getNoteTwoStepsUp(note1);
        String note3 = getNoteTwoStepsUp(note2);
        String note4 = getNoteStepUp(note3);
        String note5 = getNoteTwoStepsUp(note4);
        
        String pattern = String.format("%s %s %s %s %s %s %s %s %sh", note1, note2, note3, note4, note5, note4, note3, note2, note1);
        
        return new Pattern(pattern);
    }
}
