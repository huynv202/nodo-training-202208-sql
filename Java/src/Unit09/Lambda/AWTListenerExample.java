package Unit09.Lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTListenerExample {
    public static void main(String[] args) {
        Frame screen = new Frame();
//        screen.addWindowListener();
        Button button = new Button("Press me");
        screen.add(button);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null,"Welcome to Java by Example",
//                        "Java Sample",JOptionPane.INFORMATION_MESSAGE);
//            }
//        });

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Info box: Welcome to Java by Example",
                    "Java Sample",JOptionPane.INFORMATION_MESSAGE);
        });
        screen.setSize(250,400);
        screen.setVisible(true);
    }
    interface WindowClosing extends WindowListener{
        public default void windowOpened(WindowEvent e){}
        public default void windowlconified(WindowEvent e){}
        public default void windowDeiconified(WindowEvent e){}
        public default void windowActive(WindowEvent e){}
        public default void windowDeactive(WindowEvent e){}
        public default void windowClosed(WindowEvent e){}

    }
}
