package org.example.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    public Frame(){
        setTitle("Sistema");
        setSize(600, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(null);

        //Textfield primi
        JTextField a1 = new JTextField();
        JTextField b1 = new JTextField();
        JTextField c1 = new JTextField();
        a1.setBounds(40, 50, 100, 35);
        panel.add(a1);

        b1.setBounds(180, 50, 100, 35);
        panel.add(b1);

        c1.setBounds(320, 50, 100, 35);
        panel.add(c1);

        //Textfiled secondi
        JTextField a2 = new JTextField();
        JTextField b2 = new JTextField();
        JTextField c2 = new JTextField();

        a2.setBounds(a1.getX(), a1.getY() + 50, 100, 35);
        panel.add(a2);

        b2.setBounds(b1.getX(), b1.getY() + 50, 100, 35);
        panel.add(b2);

        c2.setBounds(c1.getX(), c1.getY() + 50, 100, 35);
        panel.add(c2);

        //TextField Risultato
        JTextField xRis = new JTextField();
        JTextField yRis = new JTextField();

        xRis.setBounds(80, a2.getY() + 100, 150, 35);
        xRis.setEditable(false);
        panel.add(xRis);

        yRis.setBounds(80, b2.getY() + 150, 150, 35);
        yRis.setEditable(false);
        panel.add(yRis);

        //label
        JLabel xLabel = new JLabel("x + ");
        JLabel yLabel = new JLabel("y = ");
        JLabel xLabel2 = new JLabel("x + ");
        JLabel yLabel2 = new JLabel("y = ");
        JLabel xLabelRis = new JLabel("x = ");
        JLabel yLabelRis = new JLabel("y = ");
        JLabel delta = new JLabel("D = ");
        JLabel deltaX = new JLabel("Dx = ");
        JLabel deltaY = new JLabel("Dy = ");

        xLabel.setBounds(a1.getX() + 110, 55, xLabel.getPreferredSize().width, xLabel.getPreferredSize().height);
        panel.add(xLabel);
        yLabel.setBounds(b1.getX() + 110, 55, yLabel.getPreferredSize().width, yLabel.getPreferredSize().height);
        panel.add(yLabel);

        xLabel2.setBounds(a2.getX() + 110, 105, xLabel.getPreferredSize().width, xLabel.getPreferredSize().height);
        panel.add(xLabel2);
        yLabel2.setBounds(b2.getX() + 110, 105, yLabel.getPreferredSize().width, yLabel.getPreferredSize().height);
        panel.add(yLabel2);

        delta.setBounds(40, 160, 150, delta.getPreferredSize().height);
        panel.add(delta);
        deltaX.setBounds(160, 160, 150, deltaX.getPreferredSize().height);
        panel.add(deltaX);
        deltaY.setBounds(280, 160, 150, deltaY.getPreferredSize().height);
        panel.add(deltaY);

        xLabelRis.setBounds(40, 210, xLabel.getPreferredSize().width, xLabel.getPreferredSize().height);
        panel.add(xLabelRis);
        yLabelRis.setBounds(40, 260, yLabel.getPreferredSize().width, yLabel.getPreferredSize().height);
        panel.add(yLabelRis);



        //Bottoni
        JButton reset = new JButton("Reset");
        reset.setBounds(350, 300, reset.getPreferredSize().width, reset.getPreferredSize().height);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a1.setText("");
                b1.setText("");
                c1.setText("");
                a2.setText("");
                b2.setText("");
                c2.setText("");
                xRis.setText("");
                yRis.setText("");
                delta.setText("D = ");
                deltaX.setText("Dx = ");
                deltaY.setText("Dy = ");
            }
        });
        panel.add(reset);
        JButton calcola = new JButton("Calcola");

        calcola.setBounds(430, 300, calcola.getPreferredSize().width, calcola.getPreferredSize().height);
        panel.add(calcola);
        calcola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Double.parseDouble(a1.getText());
                    Double.parseDouble(b1.getText());
                    Double.parseDouble(c1.getText());
                    Double.parseDouble(a2.getText());
                    Double.parseDouble(b2.getText());
                    Double.parseDouble(c2.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Presenti lettere o valori nulli", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                Sistema sistema = new Sistema(Double.parseDouble(a1.getText()), Double.parseDouble(b1.getText()), Double.parseDouble(c1.getText()),
                                        Double.parseDouble(a2.getText()), Double.parseDouble(b2.getText()), Double.parseDouble(c2.getText()));

                sistema.calcolaD();
                sistema.calcolaDx();
                sistema.calcolaDy();
                System.out.println(sistema);
                delta.setText("D = " + sistema.getD());
                deltaX.setText("Dx = " + sistema.getDx());
                deltaY.setText("Dy = " + sistema.getDy());

                if (sistema.getD() != 0){
                    xRis.setText("" + sistema.getDx() / sistema.getD());
                    yRis.setText("" + sistema.getDy() / sistema.getD());
                    JOptionPane.showMessageDialog(null, "Sistema Determinato");
                } else if (sistema.getD() == 0 && sistema.getDx() == 0 && sistema.getDy() == 0){
                    xRis.setText("Infinite Soluzioni");
                    yRis.setText("Infinite Soluzioni");
                    JOptionPane.showMessageDialog(null, "Sistema Indeterminato");
                } else {
                    xRis.setText("Impossibile");
                    yRis.setText("Impossibile");
                    JOptionPane.showMessageDialog(null, "Sistema Impossibile");
                }

            }
        });



        add(panel);
        setVisible(true);
    }
}
