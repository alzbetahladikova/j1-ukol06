package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;

    private JLabel hlavyLabel;
    private JLabel nohyLabel;
    private JSpinner husyField;
    private JSpinner kraliciField;
    private JTextField hlavyField;
    private JTextField nohyField;

    private JButton vypocitejButton;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));


        husyField= new JSpinner();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);


        kraliciField= new JSpinner();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);


        add(createButtonBar(), "span");

        hlavyField= new JTextField();
        hlavyLabel = new JLabel("Počet hlav");
        hlavyLabel.setDisplayedMnemonic('h');
        hlavyLabel.setLabelFor(hlavyField);
        hlavyField.setHorizontalAlignment(JTextField.TRAILING);
        hlavyField.setEditable(false);
        add(hlavyLabel);
        add(hlavyField);


        nohyField= new JTextField();
        nohyLabel = new JLabel("Počet nohou");
        nohyLabel.setDisplayedMnemonic('N');
        nohyLabel.setLabelFor(nohyField);
        nohyField.setHorizontalAlignment(JTextField.TRAILING);
        nohyField.setEditable(false);
        add(nohyLabel);
        add(nohyField);
        pack();

        vypocitejButton.addActionListener(this::handleVypocitej);

    }
    private JPanel createButtonBar() {
        vypocitejButton = new JButton("Vypočítej");
        vypocitejButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitejButton);
        return buttonBar;
    }

    private void handleVypocitej(ActionEvent actionEvent) {
        int pocetHus = (int) husyField.getValue();
        int pocetKraliku = (int) kraliciField.getValue();

        int pocetHlav;
        pocetHlav=(pocetHus*1)+(pocetKraliku*1);

        String textHlavy = Integer.toString(pocetHlav);
        hlavyField.setText(textHlavy);

        int pocetNohou;
        pocetNohou =(pocetHus*2)+(pocetKraliku*4);
        String textNohy = Integer.toString(pocetNohou);
        nohyField.setText(textNohy);



    }
}
