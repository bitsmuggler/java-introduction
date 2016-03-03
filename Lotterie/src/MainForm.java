import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldNumber;
    private JButton überprüfenButton;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        überprüfenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int losNr = Integer.parseInt(textFieldNumber.getText());

                    if(losNr % 13 == 0) {
                        JOptionPane.showMessageDialog(null, "Das Los gewinnt 100 Franken.");
                    } else {
                        if(losNr % 7 == 0) {
                            JOptionPane.showMessageDialog(null, "Das Los gewinnt einen Franken.");
                        }
                    }

                } catch(NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Bitte eine Ganzzahl eingeben.");
                }
            }
        });
    }



    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
