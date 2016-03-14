import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldPath;
    private JButton buttonExtractFilename;
    private JTextField textFieldFilename;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonExtractFilename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldFilename.setText(stripExtension(textFieldPath.getText()));
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
     * Dateiname ohne Endung herausschälen
     * @param filename Voller Name der Datei
     * @return
     */
    static String stripExtension (String filename) {
        String fileName = new File(filename).getName();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }

        return fileName;
    }
}
