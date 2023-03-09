package gui.buttons;

import java.awt.event.ActionEvent;

import gui.Calculator;

public class ClearDisplayButton extends CalculatorButton {
  
	private static final long serialVersionUID = 1L;

	public ClearDisplayButton() {
	super("C");
	this.setBackground(new java.awt.Color(245, 190, 190));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Calculator.clearTextField();
    }
}

