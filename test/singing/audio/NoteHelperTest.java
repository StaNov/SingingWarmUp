/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package singing.audio;

import org.junit.Test;

import static org.junit.Assert.*;
import static singing.audio.NoteHelper.*;

/**
 *
 * @author StaNov
 */
public class NoteHelperTest {
    
    /**
     * Up
     */
    @Test
    public void testGetNoteStepUp_nonHashToHash() {
        assertEquals("C#5", getNoteStepUp("C5"));
    }
    
    @Test
    public void testGetNoteStepUp_hashToNonHash() {
        assertEquals("E5", getNoteStepUp("D#5"));
    }
    
    @Test
    public void testGetNoteStepUp_nonHashToNonHash() {
        assertEquals("F6", getNoteStepUp("E6"));
    }
    
    @Test
    public void testGetNoteStepUp_overOctave() {
        assertEquals("C5", getNoteStepUp("B4"));
    }

    
    
    /*
     * Down
     */
    @Test
    public void testGetNoteStepDown_nonHashToHash() {
        assertEquals("C#5", getNoteStepDown("D5"));
    }
    
    @Test
    public void testGetNoteStepDown_hashToNonHash() {
        assertEquals("D5", getNoteStepDown("D#5"));
    }
    
    @Test
    public void testGetNoteStepDown_nonHashToNonHash() {
        assertEquals("E6", getNoteStepDown("F6"));
    }
    
    @Test
    public void testGetNoteStepDown_overOctave() {
        assertEquals("B3", getNoteStepDown("C4"));
    }
}
