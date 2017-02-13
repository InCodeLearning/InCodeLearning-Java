package org.incodelearning.gui.swing;

import javax.swing.*;

/**
 * Create the GUI and show it.
 *
 * @author Jesse Zhuang.
 */
public class HelloWorldSwing {

    /**
     * For thread safety, this method should be invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // create and set up the window
        JFrame frame = new JFrame("Hello World Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add label
        JLabel label = new JLabel("Hello World from Jesse.");
        frame.getContentPane().add(label);

        // display window
        frame.pack(); //fit preferred size and subcomponents
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // schedule a job for event-dispatching thread. Queue the runnable, update GUI after all pending AWT events.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
