package com.gasstation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class JUnitTest {
    private GasStationForm form;
    @BeforeEach

    public void setUp() {
        form = new GasStationForm();
    }

    @Test
    public void testValidateNameEmpty() {
        form.nameField.setText("");
        form.litersField.setText("10");
        assertEquals("Пожалуйста, введите ваше имя.", form.validateInput());
    }

    @Test
    public void testValidateLitersEmpty() {
        form.nameField.setText("Иван");
        form.litersField.setText("");
        assertEquals("Пожалуйста, введите количество литров.", form.validateInput());
    }

    @Test
    public void testValidateLitersNotNumber() {
        form.nameField.setText("Иван");
        form.litersField.setText("abc");
        assertEquals("Количество литров должно быть числом.", form.validateInput());
    }

    @Test
    public void testValidateLitersNegative() {
        form.nameField.setText("Иван");
        form.litersField.setText("-5");
        assertEquals("Количество литров должно быть положительным числом.", form.validateInput());
    }

    @Test
    public void testValidateLitersValid() {
        form.nameField.setText("Иван");
        form.litersField.setText("10");
        assertNull(form.validateInput());

    }

}
