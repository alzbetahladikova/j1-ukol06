package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

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

        SpinnerNumberModel model = new SpinnerNumberModel(1, 0, 10000000, 1);
        SpinnerNumberModel model2 = new SpinnerNumberModel(1, 0, 10000000, 1);

        husyField = new JSpinner(model);
        JLabel husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);

        kraliciField = new JSpinner(model2);
        JLabel kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);

        add(createButtonBar(), "span");

        hlavyField = new JTextField();
        JLabel hlavyLabel = new JLabel("Počet hlav");
        hlavyLabel.setLabelFor(hlavyField);
        hlavyField.setHorizontalAlignment(JTextField.TRAILING);
        hlavyField.setEditable(false);
        add(hlavyLabel);
        add(hlavyField);

        nohyField = new JTextField();
        JLabel nohyLabel = new JLabel("Počet nohou");
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

        int pocetHlav = (pocetHus) + (pocetKraliku);
        String textHlavy = Integer.toString(pocetHlav);
        hlavyField.setText(textHlavy);

        int pocetNohou = (pocetHus * 2) + (pocetKraliku * 4);
        String textNohy = Integer.toString(pocetNohou);
        nohyField.setText(textNohy);
    }
}
