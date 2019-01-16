import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainClass {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame ("Shapes Viewer");
		frame.setSize (600,600);
		frame.setBackground(Color.lightGray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Draw a model and a panel
		DrawingModel model = new DrawingModel();
		ShapePanel p = new ShapePanel();
		
		//textViewer
		textViewer txt = new textViewer();
		
	
		//Button(s)
		JButton button = new JButton("Draw Levels");
		JPanel southPanel = new JPanel();
		southPanel.add(button);
		
		
		
		Controller controller = new Controller(model,p,txt);
		southPanel.add(controller.upButton);
		southPanel.add(controller.downButton);
		button.addActionListener(controller);

		frame.add(southPanel, BorderLayout.SOUTH);
	
		
		frame.add(p);
		
		//controller
		
		p.addComponentListener(controller);
		frame.addMouseListener(controller);
		
		
		
		
		frame.setVisible(true);
		model.createShapes(p);
	}

}
