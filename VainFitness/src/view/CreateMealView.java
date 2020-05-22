package view;

import javax.swing.JFrame;

public class CreateMealView {

	private JFrame frame;
	
	/**
	 * Create the application.
	 */
	public CreateMealView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Create Meal");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
