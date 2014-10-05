import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kit on 10/5/2014.
 */
public class CalculatorGUI {


    private JTextField inputField = new JTextField(10);
    private JTextField resultField = new JTextField(10);

    private Calculator calculator;

    public CalculatorGUI(Calculator calculator) {
        this.calculator = calculator;

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        panel.add(inputField);
        panel.add(resultField);


        JPanel operationPanel = new JPanel();

        JButton plusButton = new JButton("+");
        operationPanel.add(plusButton);
        plusButton.addActionListener(new ButtonClickListener(Operation.PLUS));

        JButton resultButton = new JButton("=");
        operationPanel.add(resultButton);
        resultButton.addActionListener(new ButtonClickListener(Operation.EQUAL));

        JButton minusButton = new JButton("-");
        operationPanel.add(minusButton);
        minusButton.addActionListener(new ButtonClickListener(Operation.MINUS));

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, operationPanel);
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    class ButtonClickListener implements ActionListener {
        private Operation operation;

        public ButtonClickListener(Operation operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            int result = calculator.calculate(Integer.parseInt(inputField.getText()), operation);
            resultField.setText(String.valueOf(result));
        }
    }
}
