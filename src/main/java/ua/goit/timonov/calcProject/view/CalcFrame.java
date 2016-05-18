package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 15.05.2016.
 */
public class CalcFrame extends JFrame {

    private JMenuBar menuBar;
    private JTextField textField;
    private JPanel buttonPanel;

    public static final int WIDTH_DEFAULT = 250;
    public static final int HEIGHT_DEFAULT = 250;

    public CalcFrame()  {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

//        int screenWidth = screenSize.width;
//        int screenHeight = screenSize.height;
//        setSize(screenWidth / 3, screenHeight / 3);
//        setExtendedState(Frame.MAXIMIZED_BOTH);

        setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
        setResizable(false);
//        setLocationByPlatform(false);
        setLocationRelativeTo(null);
        Image img = new ImageIcon("resources/calcIcon.png").getImage();
        setIconImage(img);
        setTitle("Calculator Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

//        Container contentPane = getContentPane();
//        Component comp = new ;
//        contentPane.add(comp);
//        add(new TextComponent());

        /*// create buttons
        JButton buttonOne = new JButton("1");
        JButton buttonTwo = new JButton("2");
        JButton buttonThree = new JButton("3");
        JButton buttonFour = new JButton("4");*/

        menuBar = new MenuBar();
        textField = new JTextField();
        buttonPanel = new ButtonPanel(textField);

        setJMenuBar(menuBar);
        add(textField, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(buttonPanel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        pack();
        setVisible(true);
    }

    /* from frame
    // add buttons to panel
        buttonPanel.add(buttonOne);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);
        buttonPanel.add(buttonFour);

        // create button actions
        ButtonPressed buttonOneAction = new ButtonPressed('1');
        ButtonPressed buttonTwoAction = new ButtonPressed('2');
        ButtonPressed buttonThreeAction = new ButtonPressed('3');
        ButtonPressed buttonFourAction = new ButtonPressed('4');

        // associate actions with buttons
        buttonOne.addActionListener(buttonOneAction);
        buttonTwo.addActionListener(buttonTwoAction);
        buttonThree.addActionListener(buttonThreeAction);
        buttonFour.addActionListener(buttonFourAction);*/

//        pack();

   /* private class ButtonPressed implements ActionListener {
        private char symbol;

        public ButtonPressed(char symbol) {
            this.symbol = symbol;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            expression.append(symbol);
        }
    }*/
}
