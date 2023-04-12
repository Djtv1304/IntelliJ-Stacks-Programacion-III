import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Browser extends JFrame {
    private JPanel BROWSER;
    private JTextField jTextURL;
    private JTextArea textArea1;
    private JButton enterButton;
    private JButton backwardButton;
    private JButton forwardButton;
    private JPanel JpanelPrincipal;
    private Stack<String> BackwardURL = new Stack<>();
    private Stack<String> ForwardURL = new Stack<>();
    private String nuevaURL;
    public Browser() {

        super("Browser");
        setContentPane(JpanelPrincipal);

        BackwardURL.push("Home");
        textArea1.setText("Actualmente te encuentras en Home");

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevaURL = jTextURL.getText();

                if (!ForwardURL.isEmpty()) {
                    if (ForwardURL.peek() != nuevaURL) {
                        ForwardURL.clear();
                        //ForwardURL.push(nuevaURL);
                    }
                }
                BackwardURL.push(nuevaURL);

                String actual = "Actualmente te encuentras en "+nuevaURL;

                textArea1.setText(actual);

                textArea1.insert("\nImpresión de la pila (Backward): " + BackwardURL,actual.length());

                forwardButton.setEnabled(false);
                backwardButton.setEnabled(true);
                jTextURL.setText("");
            }
        });

        backwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual = "";
                ForwardURL.push(BackwardURL.pop());
                forwardButton.setEnabled(true);

                if (BackwardURL.isEmpty()) {
                    actual = "Actualmente te encuentras en "+ForwardURL.peek();
                    textArea1.setText(actual);
                    backwardButton.setEnabled(false);

                } else if (BackwardURL.size() == 1) {
                    backwardButton.setEnabled(false);
                    textArea1.setText("\nActualmente te encuentras en Home");
                } else {
                    actual = "Actualmente te encuentras en "+BackwardURL.peek();
                    textArea1.setText(actual);
                }

                textArea1.insert("\nImpresión de la pila (Backward): " + BackwardURL,actual.length());
            }
        });

        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual = "";
                BackwardURL.push(ForwardURL.pop());
                backwardButton.setEnabled(true);
                if (ForwardURL.isEmpty()) {
                    actual = "Actualmente te encuentras en "+ BackwardURL.peek();
                    textArea1.setText(actual);
                    forwardButton.setEnabled(false);
                }else {
                    actual = "Actualmente te encuentras en "+ BackwardURL.peek();
                    textArea1.setText(actual);
                }

                textArea1.insert("\nImpresión de la pila (Backward): " + BackwardURL,actual.length());
                textArea1.insert("\nImpresión de la pila (Forward): " + ForwardURL,actual.length());
            }
        });
    }
}
