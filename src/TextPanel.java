import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel
{
    private JTextArea textArea;

    TextPanel()
    {
        textArea = new JTextArea();
        textArea.setEditable(false);

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea),BorderLayout.NORTH);
    }

    public void textAppend(String text)
    {
        textArea.append(text);
    }

    public void cleanTextArea()
    {
        textArea.setText("");
    }
}
