import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame{
    // Window size
    public static final int CANVAS_WIDTH = 1000;
    public static final int CANVAS_HEIGHT = 600;
    //Starting coordinates
    private int x = CANVAS_WIDTH / 2;
    private int y = (int)(CANVAS_HEIGHT * 0.6);

    private StickFigure sf;


    public GUI(){
        JPanel btnPanel = new JPanel(new FlowLayout());
        // JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel cbxPanel = new JPanel(new FlowLayout());

        /**
         * Checkboxes
         */
        JCheckBox back = new JCheckBox("Back", true);
        back.addItemListener( new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                if (evt.getStateChange() == ItemEvent.SELECTED) sf.backToggle(true);
                else sf.backToggle(false);
            }
        });
        cbxPanel.add(back);

        JCheckBox arms = new JCheckBox("Arms", true);
        arms.addItemListener( new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                if (evt.getStateChange() == ItemEvent.SELECTED) sf.armsToggle(true);
                else sf.armsToggle(false);
            }
        });
        cbxPanel.add(arms);

        JCheckBox legs = new JCheckBox("Legs", true);
        legs.addItemListener( new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                if (evt.getStateChange() == ItemEvent.SELECTED) sf.legsToggle(true);
                else sf.legsToggle(false);
            }
        });
        cbxPanel.add(legs);

        JCheckBox nose = new JCheckBox("Nose", true);
        nose.addItemListener( new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                if (evt.getStateChange() == ItemEvent.SELECTED) sf.noseToggle(true);
                else sf.noseToggle(false);
            }
        });
        cbxPanel.add(nose);

        JCheckBox eyes = new JCheckBox("Eyes", true);
        eyes.addItemListener( new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                if (evt.getStateChange() == ItemEvent.SELECTED) sf.eyesToggle(true);
                else sf.eyesToggle(false);
            }
        });
        cbxPanel.add(eyes);

        JCheckBox head = new JCheckBox("Head", true);
        head.addItemListener( new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                if (evt.getStateChange() == ItemEvent.SELECTED) sf.headToggle(true);
                else sf.headToggle(false);
            }
        });
        cbxPanel.add(head);

        /**
         * Sliders
         */
        JSlider slider = new JSlider(SwingConstants.VERTICAL, 0, 400, 100); // 0-400 starting:100
        slider.setPaintTicks(true);
        btnPanel.add(slider);
        slider.addChangeListener(new ChangeListener(){
                @Override
                public void stateChanged(ChangeEvent e){
                    sf.setScale(slider.getValue());
                }
            }
        );


        /**
         * Buttons
         */

        //Left button
        Timer timerLeft = new Timer(1000/80, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                sf.slideLeft();
            }
        });
        JButton btnLeft = new JButton("Move Left ");
        btnPanel.add(btnLeft);
        btnLeft.setBackground(Color.cyan);
        btnLeft.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                // sf.slideLeft();
                timerLeft.start();
                requestFocus(); // change the focus to Frame to receive keyevent
            }
        });

        // Right button
        Timer timerRight = new Timer(1000/80, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                sf.slideRight();
            }
        });
        JButton btnRight = new JButton("Move Right ");
        btnPanel.add(btnRight);
        btnRight.setBackground(Color.cyan);
        btnRight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                // sf.slideRight();
                timerRight.start();
                requestFocus(); // change the focus to Frame to receive keyevent
            }
        });

        // Stop button
        JButton stop = new JButton("STOP");
        stop.setBackground(Color.RED);
        btnPanel.add(stop);
        stop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                timerRight.stop();
                timerLeft.stop();
                requestFocus(); // change the focus to Frame to receive keyevent
            }
        });

        // Change direction button
        JButton changeDirection = new JButton("Change direction");
        changeDirection.setBackground(Color.YELLOW);
        btnPanel.add(changeDirection);
        changeDirection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                sf.changeDirection();
                if(timerRight.isRunning()) timerRight.restart();
                if(timerLeft.isRunning()) timerLeft.restart();
                requestFocus(); // change the focus to Frame to receive keyevent
            }
        });

        // Color chooser button
        JButton colorButton = new JButton("Choose color");
        colorButton.setBackground(Color.BLACK);
        colorButton.setForeground(Color.WHITE);
        colorButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
                sf.setColor(newColor);
            }
        });
        btnPanel.add(colorButton);

        //Stick Figure
        sf = new StickFigure(x, y, Color.BLACK, 150);
        sf.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(sf, BorderLayout.CENTER);
        cp.add(btnPanel, BorderLayout.SOUTH);
        cp.add(cbxPanel, BorderLayout.NORTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("My StickFigure");
        pack();
        setVisible(true);
        requestFocus();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new GUI();
            }
        });
    }

}
