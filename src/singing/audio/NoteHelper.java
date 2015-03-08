package singing.audio;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author StaNov
 */
public class NoteHelper {
    
    private static final List<String> notes;
    
    static {
        String[] notesString = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        notes = new LinkedList<String>(Arrays.asList(notesString));
    }
        
    
    /**
     * Vrací notu o půltón vyšší, než je startingNote.
     * 
     * C5  -> C#5
     * D#5 -> E5
     * E6  -> F6
     * B4  -> C5
     */
    public static String getNoteStepUp(String startingNote) {
        String note = getNoteString(startingNote);
        int octave = getOctaveInt(startingNote);
        
        int noteIndex = notes.indexOf(note);
        
        if (noteIndex != notes.size() - 1) {
            // není poslední v oktávě
            String upperNote = notes.get(noteIndex + 1);
            return upperNote + octave;
        }
        
        // je poslední v oktávě
        return notes.get(0) + (octave + 1);
    }

    public static String getNoteStepDown(String startingNote) {
        String note = getNoteString(startingNote);
        int octave = getOctaveInt(startingNote);
        
        int noteIndex = notes.indexOf(note);
        
        if (noteIndex != 0) {
            // není poslední v oktávě
            String lowerNote = notes.get(noteIndex - 1);
            return lowerNote + octave;
        }
        
        // je poslední v oktávě
        return notes.get(notes.size() - 1) + (octave - 1);
    }
    
    
    
    private static String getNoteString(String note) {
        char[] chars = note.toCharArray();
        
        if (chars.length == 2) {
            // bez křížku
            return chars[0] + "";
        }
        
        if (chars.length == 3) {
            // s křížkem
            return chars[0] + (chars[1] + "");
        }
        
        throw new RuntimeException(String.format("Notový zápis %s se nepodařilo naparsovat.", note));
    }
    
    private static int getOctaveInt(String note) {
        char[] chars = note.toCharArray();
        
        return Integer.parseInt(chars[chars.length - 1] + "");
    }
    
    public static String getNoteTwoStepsUp(String startingNote) {
        return getNoteStepUp(getNoteStepUp(startingNote));
    }
        
    public static String getNoteTwoStepsDown(String startingNote) {
        return getNoteStepDown(getNoteStepDown(startingNote));
    }
}
