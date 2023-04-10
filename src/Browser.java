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
        textArea1.setText("Actualmente te encuentras en home");

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

                textArea1.insert("\nImpresión de la pila (Backward): \n" + BackwardURL,actual.length());

            }
        });

        backwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual;
                ForwardURL.push(BackwardURL.pop());
                if (BackwardURL.isEmpty()) {
                    actual = "Actualmente te encuentras en "+ForwardURL.peek();
                    textArea1.setText(actual);
                    backwardButton.setEnabled(false);
                    forwardButton.setEnabled(true);
                }else {
                    actual = "Actualmente te encuentras en "+BackwardURL.peek();
                    textArea1.setText(actual);
                }

                textArea1.insert("\nImpresión de la pila (Backward): \n" + BackwardURL,actual.length());
            }
        });

        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual;
                BackwardURL.push(ForwardURL.pop());
                if (ForwardURL.isEmpty()) {
                    actual = "Actualmente te encuentras en "+BackwardURL.peek();
                    textArea1.setText(actual);
                    forwardButton.setEnabled(false);
                    backwardButton.setEnabled(true);
                }else {
                    actual = "Actualmente te encuentras en "+ForwardURL.peek();
                    textArea1.setText(actual);
                }

                textArea1.insert("\nImpresión de la pila (Backward): \n" + BackwardURL,actual.length());
                textArea1.insert("\nImpresión de la pila (Forward): \n" + ForwardURL,actual.length());
            }
        });
    }
}
