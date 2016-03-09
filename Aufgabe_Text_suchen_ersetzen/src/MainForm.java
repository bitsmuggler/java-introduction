import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextArea textAreaText;
    private JTextField textFieldSearch;
    private JTextField textFieldReplace;
    private JButton buttonReplace;
    private JButton beendenButton;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonReplace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Ersetze Text
                String result = replaceText(
                        textAreaText.getText(),
                        textFieldSearch.getText(),
                        textFieldReplace.getText());

                //Setze den Text neu
                textAreaText.setText(result);

                //Eingabe-Felder zurücksetzen
                textFieldSearch.setText("");
                textFieldReplace.setText("");
            }
        });
    }

    /**
     * Such im übergebenen Text nach einem bestimmten Wort und ersetzt das Wort anschliessend.
     * @param currentText Aktueller Text
     * @param searchWord Gesuchtes Wort
     * @param replaceWord Ersetztes Wort
     * @return Text mit ersetztem Wort
     */
    private String replaceText(String currentText, String searchWord, String replaceWord) {

        //Überprüfe, ob das Wort im Text vorkommt.
        if(currentText.indexOf(searchWord) >= 0) {
            return currentText.replace(searchWord, replaceWord);
        }

        JOptionPane.showMessageDialog(null, "Der Text " + searchWord + " wurde nicht gefunden.");
        return currentText;
    }


    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
