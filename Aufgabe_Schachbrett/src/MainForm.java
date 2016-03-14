import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextArea textAreaSchachbrett;
    private JButton buttonChess;
    private JButton buttonDelete;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonChess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = getChessBoard();
                textAreaSchachbrett.setText(result);
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaSchachbrett.setText("");
            }
        });
    }

    /**
     * Gibt die Felder des Schachbretts zurück.
     * @return Array mit den Feldern
     */
    private char[] getFields() {
        return "ABCDEFGH".toCharArray();
    }

    /**
     * Gibt den String für eine Line im Schachfeld zurück.
     * @param field Feld
     * @param number Nummer
     * @return Linie
     */
    private String getLine(char field, int number) {
        return field + "" + number + "\t";
    }

    /**
     * Gibt das Schachbrett zurück.
     * @return Schachbrett als String
     */
    private String getChessBoard() {
        char[] fields = getFields();
        String board = "";

        for(int i = 1; i < 9; i++) {
            for(char field : fields) {
                board += getLine(field, i);
            }

            board += "\n";
        }

        return board;
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
