package gui.buttons;

import java.awt.event.ActionEvent;

import gui.Calculator;

public class InitiateCalculationButton extends CalculatorButton {
    private static final long serialVersionUID = 1L;

	public InitiateCalculationButton() {
	super("=");
	this.setBackground(new java.awt.Color(250, 180, 57));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Calculator.initiateCalculation();
    }
}