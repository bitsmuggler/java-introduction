import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextArea textAreaHtml;
    private JButton HTMLEntfernenButton;
    private JTextArea textAreaWithoutHtml;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        HTMLEntfernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textAreaHtml.getText();
                String result = removeHtmlTags(input);
                textAreaWithoutHtml.setText(result);
            }
        });
    }

    /**
     * Entfernt aus HTML-Markup sämtliche HTML-Tags
     * @param input HTML-Markup
     * @return Inhalte (ohne HTML-Markup)
     */
    private String removeHtmlTags(String input) {
        return input.replaceAll("<[^>]*>", "")
                    .replaceAll("\\s{2,}", "");
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
