import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureApp extends JFrame {
    private JTextField inputField;
    private JComboBox<String> unitComboBox;
    private JTextArea resultArea;

    public TemperatureApp() {
        setTitle("Temperature Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel inputLabel = new JLabel("Enter temperature value:");
        inputField = new JTextField(10);

        JLabel unitLabel = new JLabel("Select unit:");
        String[] units = { "Celsius", "Fahrenheit", "Kelvin" };
        unitComboBox = new JComboBox<>(units);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertAndDisplay();
            }
        });

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputLabel)
                        .addComponent(unitLabel)
                        .addComponent(convertButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputField)
                        .addComponent(unitComboBox)
                        .addComponent(resultArea)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(inputLabel)
                        .addComponent(inputField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(unitLabel)
                        .addComponent(unitComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(convertButton)
                        .addComponent(resultArea)));

        add(panel);
    }

    private void convertAndDisplay() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            String originalUnit = (String) unitComboBox.getSelectedItem();

            String convertedValues = convertTemperature(temperature, originalUnit);

            resultArea.setText(String.format("%.2f %s is equal to:\n%s",
                    temperature, originalUnit, convertedValues));

        } catch (NumberFormatException e) {
            resultArea.setText("Invalid input. Please enter a valid number.");
        }
    }

    private String convertTemperature(double temperature, String originalUnit) {
        double convertedValue;

        switch (originalUnit) {
            case "Celsius":
                convertedValue = (temperature * 9 / 5) + 32;
                return String.format("%.2f Fahrenheit\n%.2f Kelvin", convertedValue, temperature + 273.15);
            case "Fahrenheit":
                convertedValue = (temperature - 32) * 5 / 9;
                return String.format("%.2f Celsius\n%.2f Kelvin", convertedValue, (temperature - 32) * 5 / 9 + 273.15);
            case "Kelvin":
                convertedValue = temperature - 273.15;
                return String.format("%.2f Celsius\n%.2f Fahrenheit", convertedValue,
                        (temperature - 273.15) * 9 / 5 + 32);
            default:
                return "Invalid unit. Please enter Celsius, Fahrenheit, or Kelvin.";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureApp converterGUI = new TemperatureApp();
            converterGUI.setVisible(true);
        });
    }
}
