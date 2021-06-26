import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    BtnArea btnArea;
    TextPanel textPanel;

    MainFrame()
    {
        super("Calculator");

        btnArea = new BtnArea();
        textPanel = new TextPanel();

        btnArea.setAccess(new Access()
        {
            public void sendText(String text)
            {
                textPanel.textAppend(text);
            }

            @Override
            public void clearTextArea()
            {
                textPanel.cleanTextArea();
            }
        });

        setLayout(new BorderLayout());

        add(btnArea,BorderLayout.CENTER);
        add(textPanel,BorderLayout.NORTH);

        setSize(190,200);
        //setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
