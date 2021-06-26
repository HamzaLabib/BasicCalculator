import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BtnArea extends JPanel implements ActionListener
{
    String operand1 = "";
    String operator = "";
    String operand2 = "";

    Double result;

    int operation = 0;

    private ArrayList <JButton> btns = new ArrayList<>();
    private Access access;

    private JButton one = new JButton("1");
    private JButton two = new JButton("2");
    private JButton three = new JButton("3");
    private JButton four = new JButton("4");
    private JButton five = new JButton("5");
    private JButton six = new JButton("6");
    private JButton seven = new JButton("7");
    private JButton eight = new JButton("8");
    private JButton nine = new JButton("9");
    private JButton zero = new JButton("0");
    private JButton add = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton div = new JButton("/");
    private JButton multi = new JButton("x");
    private JButton equal = new JButton("=");
    private JButton clear = new JButton("c");


    BtnArea()
    {
        addToArray();
        addBtn();
    }

    private void addToArray()
    {
        btns.add(one);
        btns.add(two);
        btns.add(three);
        btns.add(four);
        btns.add(five);
        btns.add(six);
        btns.add(seven);
        btns.add(eight);
        btns.add(nine);
        btns.add(zero);
        btns.add(equal);
        btns.add(add);
        btns.add(sub);
        btns.add(div);
        btns.add(multi);
        btns.add(clear);
    }


    private void addBtn()
    {
        for (JButton n: btns)
        {
            n.addActionListener(this);
            //add(n);
            //setLayout(new FlowLayout(FlowLayout.CENTER));
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        add(seven, gc);

        gc.gridx++;
        add(eight,gc);

        gc.gridx++;
        add(nine, gc);

        gc.gridx++;
        add(clear, gc);

        gc.gridx = 0;
        gc.gridy++;
        add(four, gc);

        gc.gridx++;
        add(five,gc);

        gc.gridx++;
        add(six, gc);

        gc.gridx++;
        add(div,gc);

        gc.gridx = 0;
        gc.gridy++;
        add(one, gc);

        gc.gridx++;
        add(two,gc);

        gc.gridx++;
        add(three, gc);

        gc.gridx++;
        add(multi, gc);

        gc.gridy++;
        add(sub, gc);

        gc.gridx--;
        add(add,gc);

        gc.gridx--;
        add(zero, gc);
    }


    public void setAccess(Access access)
    {
        this.access = access;
    }


    public void actionPerformed(ActionEvent e)
    {
        JButton click = (JButton) e.getSource();

        if(this.access != null)
        {
            if(click.getText() == "x" || click.getText() == "/" || click.getText() == "+" || click.getText() == "-")
                operator = click.getText();

            else if(click.getText() == "=")
            {
                switch(operation)
                {
                    case 1: result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
                        break;
                    case 2: result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
                        break;
                    case 3: result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
                        break;
                    case 4: result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
                        break;
                    default: result = 0.0;
                }
                this.access.sendText(" = " + Double.toString(result));

                operand1 = result.toString();
                operand2 = "";
                operator = "";
            }

            else
            if(operator == "")
            {
                operand1 += click.getText();
            }
            else
            {
                operand2 += click.getText();
            }


            switch (click.getText())
            {
                case "1":
                    this.access.sendText("1");
                    break;
                case "2":
                    this.access.sendText("2");
                    break;
                case "3":
                    this.access.sendText("3");
                    break;
                case "4":
                    this.access.sendText("4");
                    break;
                case "5":
                    this.access.sendText("5");
                    break;
                case "6":
                    this.access.sendText("6");
                    break;
                case "7":
                    this.access.sendText("7");
                    break;
                case "8":
                    this.access.sendText("8");
                    break;
                case "9":
                    this.access.sendText("9");
                    break;
                case "0":
                    this.access.sendText("0");
                    break;
                case "c":
                    this.access.clearTextArea();
                    operator = operand1 = operand2 = "";
                    break;
                case "+":
                    this.access.sendText("+");
                    operation = 1;
                    break;
                case "-":
                    this.access.sendText("-");
                    operation = 2;
                    break;
                case "/":
                    this.access.sendText("/");
                    operation = 3;
                    break;
                case "x":
                    this.access.sendText("x");
                    operation = 4;
                    break;
            }
        }
    }
}

