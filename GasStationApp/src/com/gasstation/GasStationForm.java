package com.gasstation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GasStationForm extends JFrame {
    public JTextField nameField;
    public JTextField litersField;
    private JComboBox<String> fuelTypeComboBox;
    
    public GasStationForm() {
        setTitle("Бензозаправка");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
        
        JLabel nameLabel = new JLabel("Имя:");
        nameField = new JTextField();
        
        JLabel litersLabel = new JLabel("Количество литров:");
        litersField = new JTextField();
        
        JLabel fuelTypeLabel = new JLabel("Тип бензина:");
        String[] fuelTypes = {"92", "95", "98", "Дизель"};
        fuelTypeComboBox = new JComboBox<>(fuelTypes);
        
        JButton submitButton = new JButton("Отправить");
        submitButton.addActionListener(new SubmitButtonActionListener());
        
        add(nameLabel);
        add(nameField);
        add(litersLabel);
        add(litersField);
        add(fuelTypeLabel);
        add(fuelTypeComboBox);
        add(new JLabel());
        add(submitButton);
    }
    
    public String validateInput() {

        String name = nameField.getText().trim();
        String liters = litersField.getText().trim();


        if (name.isEmpty()) {
            return "Пожалуйста, введите ваше имя.";
        }

        if (liters.isEmpty()) {
            return "Пожалуйста, введите количество литров.";
        }


        try {
            double litersValue = Double.parseDouble(liters);
            if (litersValue <= 0) {
                return "Количество литров должно быть положительным числом.";
            }

        } catch (NumberFormatException ex) {
            return "Количество литров должно быть числом.";
        }

        return null; // No error
    }
    
    private class SubmitButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String liters = litersField.getText();
            String fuelType = (String) fuelTypeComboBox.getSelectedItem();
            
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(GasStationForm.this,
                        "Пожалуйста, введите ваше имя.",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Проверка на пустое поле "Количество литров"

            if (liters.isEmpty()) {
                JOptionPane.showMessageDialog(GasStationForm.this,
                        "Пожалуйста, введите количество литров.",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Проверка на валидность числа в "Количество литров"
            try {
                double litersValue = Double.parseDouble(liters);
                if (litersValue <= 0) {
                    throw new NumberFormatException();

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(GasStationForm.this,
                        "Введите корректное значение литров.",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            JOptionPane.showMessageDialog(GasStationForm.this,
                    "Имя: " + name + "\nКоличество литров: " + liters + "\nТип бензина: " + fuelType,
                    "Информация", JOptionPane.INFORMATION_MESSAGE);
    }
 }

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GasStationForm form = new GasStationForm();
            form.setVisible(true);
        });
	}

}
