import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldKrone;
    private JTextField textFieldStammbreite;
    private JTextField textFieldStammhoehe;
    private JTextArea textAreaTannenbaum;
    private JButton tanneZeichnenButton;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        tanneZeichnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTannenbaum.setText("");

                int treeRootWidth = Integer.parseInt(textFieldStammhoehe.getText());
                int treeRootHeight = Integer.parseInt(textFieldStammbreite.getText());
                int headHeight = Integer.parseInt(textFieldKrone.getText());

                drawTreeHead(headHeight);
                drawTreeRoot(treeRootWidth, treeRootHeight, headHeight);

            }
        });
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    /**
     * Zeichnet den Baumkopf
     * @param height Höhe des Kopfes
     */
    private void drawTreeHead(int height) {

        int whitespaces, numberOfStars = 1;
        String stars = "";

        for(int i = 1; i < height; i++) {

            stars = "";

            whitespaces = height - i;

            for(int whitespace = 0; whitespace < whitespaces; whitespace++) {
                stars += " ";
            }

            if(i == 1) {
                stars += "*";
            } else {
                numberOfStars = numberOfStars + 2;
                for(int star = 0; star < numberOfStars; star++) {
                    stars += "*";
                }
            }

            textAreaTannenbaum.append(stars + "\n");
            System.out.println(stars);
        }
    }

    /**
     * Zeichnet den Stamm
     * @param width Breite
     * @param height Höhe
     * @param headheight Kopfhöhe
     */
    private void drawTreeRoot(int width, int height, int headheight) {

        //Zeilen durchgehen
        for(int r = 0; r < height; r++) {
            String stars = "";

            for(int w = 0; w < headheight-2; w++) {
                stars += " ";
            }

            //Kolonnen durchgen
            for(int c = 0; c < width; c++) {
                stars += "*";
            }

            //Zeile für Zeile ausgeben
            textAreaTannenbaum.append(stars + "\n");
            System.out.println(stars);
        }
    }
}
