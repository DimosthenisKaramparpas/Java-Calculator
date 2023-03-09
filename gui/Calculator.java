package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import operations.*;
import javax.swing.*;
import gui.buttons.*;

public class Calculator extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final Color DARK_PINK = new java.awt.Color(245, 190, 190);
    private static final Color LIGHT_PINK = new java.awt.Color(240, 220, 220);
    private static final Color YELLOW = new java.awt.Color(250, 180, 57);
    private static final Color DARK_RED_BG = new java.awt.Color(245, 168, 168);
	JPanel p = new JPanel();
	protected static JTextField text = new JTextField("");
	public Calculator(int width,int height) {
		
		
		this.setTitle("Calculator");
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		p.setLayout(new GridLayout(5,4));
		
		String numbers="C()/789*456-123+0.^=";
		
		char[] charArray = numbers.toCharArray();
		
		this.setLayout(new BorderLayout());
		this.add(text,BorderLayout.NORTH);
		
		for(char output:charArray) {

			
			if (output=='C')
				p.add(new ClearDisplayButton());
			else if(output=='=')
				p.add(new InitiateCalculationButton());
			else if(output==')'||output=='('||output=='+'||output=='-'||output=='*'||output=='/')
				p.add(new OperatorButton(output+""));
			else
				p.add(new OperandButton(output+""));
			}
		
		this.add(p);
		setResizable(false);
		this.setVisible(true);
	}
	public static void appendToTextField(String append) {
		text.setText(text.getText() + append);
	}

	    public static void clearTextField() {
		text.setText("");
	    }

	    public static void initiateCalculation() {
		String str = text.getText()+"";
		
		
		
		text.setText("");
		InfixConverter In = new InfixConverter(str);
		In.printInfo();
		PostFixConverter Post = new PostFixConverter(In.postFix);
		Post.printInfo();
	    }
}
