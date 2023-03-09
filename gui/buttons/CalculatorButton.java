package gui.buttons;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.Calculator;

abstract class CalculatorButton extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;

	public CalculatorButton(String label) {
	super(label);
	this.setName(label);
	this.setForeground(Color.BLACK);

	this.setOpaque(true);
	this.setBorderPainted(false);
	this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	this.setFont(new Font("Courier", Font.PLAIN, 18));
	this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Calculator.appendToTextField(super.getName());
	System.out.println(super.getName());
    }
}