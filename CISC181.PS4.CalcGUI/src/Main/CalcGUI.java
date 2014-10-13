package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalcGUI extends JFrame{
	
	private static final int Height=200;
	
	private static final int Width=100;
	
	
	private static JLabel PresentValue, AnnualRate, Years, FV, Blank;
	
	private static JTextField PresentValueText, AnnualRateText, YearsText, FVText;
	
	private static JButton CalcButton;
	
	
	private static CalculateButtonHandler CalcHandler;
	
	// Configures the window
	
	public static void CalcGUI(){
		
		//Labels
		PresentValue = new JLabel("Invesment: ", SwingConstants.RIGHT);
		
		AnnualRate = new JLabel("Interest: ", SwingConstants.RIGHT);
		
		Years = new JLabel("Years: ", SwingConstants.RIGHT);
		
		FV = new JLabel("Future Value: ",SwingConstants.RIGHT);
		
		Blank =  new JLabel("");
		
		// Text Fields
		PresentValueText = new JTextField(8);
		
		AnnualRateText = new JTextField(8);
		
		YearsText = new JTextField(8);
		
		FVText = new JTextField(8);
		
		// Calculation Button
		CalcButton = new JButton("Calculate");
		
		CalcHandler = new CalculateButtonHandler();
		
		CalcButton.addActionListener(CalcHandler);
		
		// Frame
		
		JFrame frame = new JFrame();
		
		frame.setBounds(Width, Width, Height, Height);
		
		frame.setTitle("Calculator");
		
		Container pane = frame.getContentPane();
		
		pane.setLayout(new GridLayout(5,2));
		
		//Panels		
		pane.add(PresentValue);
		
		pane.add(PresentValueText);
		
		pane.add(AnnualRate);
		
		pane.add(AnnualRateText);
		
		pane.add(Years);
		
		pane.add(YearsText);
		
		pane.add(FV);
		
		pane.add(FVText);
		
		pane.add(Blank);
		
		pane.add(CalcButton);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	// Reference the CalcEngine	
	private static class CalculateButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			CalcEngine engine = new CalcEngine();
			
			double FV, AnnualRate, PV, Years;
			
			PV=Double.parseDouble(PresentValueText.getText());
			
			AnnualRate=Double.parseDouble(AnnualRateText.getText());
			
			Years=Double.parseDouble(YearsText.getText());
			
			FV = engine.FutureValue(PV, Years, AnnualRate);
			
			FVText.setText(""+FV);
		}
	}
	
	
	public static void main(String[] args) {
		CalcGUI();

	}
	
}