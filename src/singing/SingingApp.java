/*
 * SingingApp.java
 */

package singing;

import javax.swing.SwingWorker;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import singing.audio.SamplePlayer;

/**
 * The main class of the application.
 */
public class SingingApp extends SingleFrameApplication {
    
    private SamplePlayer player = new SamplePlayer();
    
    private boolean isPlaying = false;

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new SingingView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of SingingApp
     */
    public static SingingApp getApplication() {
        return Application.getInstance(SingingApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(SingingApp.class, args);
    }

    @Action
    public void stepUpAction() {
        SwingWorker worker = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                if (isPlaying) {
                    return null;
                }
                
                isPlaying = true;
                player.stepUp();
                player.play();
                
                return null;
            }

            @Override
            protected void done() {
                isPlaying = false;
            }
        };
        
        worker.execute();
    }

    @Action
    public void replayAction() {
        SwingWorker worker = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                if (isPlaying) {
                    return null;
                }
                
                isPlaying = true;
                player.play();
                
                return null;
            }

            @Override
            protected void done() {
                isPlaying = false;
            }
        };
        
        worker.execute();
    }

    @Action
    public void stepDownAction() {
        SwingWorker worker = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                if (isPlaying) {
                    return null;
                }
                
                isPlaying = true;
                player.stepDown();
                player.play();
                
                return null;
            }

            @Override
            protected void done() {
                isPlaying = false;
            }
        };
        
        worker.execute();
    }
}
