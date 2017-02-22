//Hersh Bhadra: This program creates a simple GUI calculator

import java.awt.EventQueue;/*platform-independent class that queues events, 
both from the underlying peer classes and from trusted application classes*/
import javax.swing.ButtonGroup;//create a multiple-exclusion scope for a set of buttons. If 1 button 'on', all other buttons 'off' 
import javax.swing.JFrame;//adds support for the JFC/Swing component architecture
import javax.swing.JLabel;//display area for a short text string
import javax.swing.JOptionPane;//pop up a standard dialog box that prompts users for a value or informs them of something
import javax.swing.JTextField;//allows the editing of a single line of text
import javax.swing.JRadioButton;//an item that can be selected or deselected, and which displays its state to the user. Used with ButtonGroup
import javax.swing.JButton;//this component has a label and generates an event when pressed
import java.awt.event.ActionListener;//when the action event occurs, that object's actionPerformed method is invoked
import java.awt.event.ActionEvent;/*event which indicates that a component-defined action occurred. 
event is passed to every ActionListener object that registered to receive such events using the component's addActionListener method*/

public class CalculatorForm 
{
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ButtonGroup buttonGroup;

	public static void main(String[] args) //Launch application
	{
		EventQueue.invokeLater(new Runnable() //invokeLate will run after all pending requests are processed
		{
			public void run()//if this thread object was instantiated using a separate Runnable target, the run() method is invoked on that Runnable
			{
				try 
				{
					CalculatorForm window = new CalculatorForm();
					window.frame.setVisible(true);
					}//end try
				
				catch (Exception e) 
				{
					e.printStackTrace(System.out);
					}//end catch
				}//end run()
			});
		}//end main

	public CalculatorForm()//Create application 
	{
		initialize();
		}//end CalculatorForm
	
	private void initialize()//Initialize the contents of the frame 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Number: ");
		lblNewLabel.setBounds(107, 35, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(222, 32, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("add");//ADD button
		rdbtnNewRadioButton_1.setActionCommand("add");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBounds(185, 94, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("subtract");//SUBTRACT button
		rdbtnNewRadioButton_2.setActionCommand("subtract");
		rdbtnNewRadioButton_2.setBounds(185, 124, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("multiply");//MULTIPLY button
		rdbtnNewRadioButton_3.setActionCommand("multiply");
		rdbtnNewRadioButton_3.setBounds(185, 150, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("divide");//DIVIDE button
		rdbtnNewRadioButton.setActionCommand("divide");
		rdbtnNewRadioButton.setBounds(185, 70, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		buttonGroup = new ButtonGroup();//turning "on" one of the buttons turns off all other buttons in the group
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_3);
		buttonGroup.add(rdbtnNewRadioButton);
		
		JLabel lblOperation = new JLabel("Operation:");
		lblOperation.setBounds(107, 113, 68, 14);
		frame.getContentPane().add(lblOperation);
		
		JLabel label = new JLabel("Second Number: ");
		label.setBounds(78, 183, 115, 14);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(222, 180, 86, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("Answer: ");
		label_1.setBounds(89, 213, 86, 14);
		frame.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(222, 211, 86, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)//CALCULATIONS 
			{
				int result;
				if(textField.getText().equals("")||textField_1.getText().equals(""))//if no numbers entered
				{
					JOptionPane.showMessageDialog (null, "    No number entered", null, JOptionPane.INFORMATION_MESSAGE);
					}//end if
				else
				{
					int frstno = Integer.parseInt(textField.getText());
					int scndno = Integer.parseInt(textField_1.getText());
					
					if(buttonGroup.getSelection().getActionCommand()=="add")
					{
						result = frstno+scndno;
						String out = String.valueOf(result);
						textField_2.setText(out);
						}//end if
					
					else if(buttonGroup.getSelection().getActionCommand()=="subtract")
					{
						result = frstno-scndno;
						String out = String.valueOf(result);
						textField_2.setText(out);
						}//end else if
					
					else if(buttonGroup.getSelection().getActionCommand()=="multiply")
					{
						result = frstno*scndno;
						String out = String.valueOf(result);
						textField_2.setText(out);
						}//end else if
				
					else if(buttonGroup.getSelection().getActionCommand()=="divide")
					{
						if(scndno == 0)
						{
							JOptionPane.showMessageDialog (null, "             Invalid entry", null, JOptionPane.INFORMATION_MESSAGE);	
							}//end if
						
						else
						{
							result = frstno/scndno;
							String out = String.valueOf(result);
							textField_2.setText(out);
							}//end else
						}//end else if
					}//end else
				}//end actionPerformed
			});//end btnCalculate
		
		btnCalculate.setBounds(78, 239, 89, 23);
		frame.getContentPane().add(btnCalculate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
				}//end actionPerformed
			});//end btnExit
		
		btnExit.setBounds(206, 239, 89, 23);
		frame.getContentPane().add(btnExit);
		}//end initialize
	}//end class CalculatorForm
