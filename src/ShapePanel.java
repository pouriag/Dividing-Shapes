import java.awt.Graphics;

import javax.swing.JPanel;
//A class to update and show the created panels
@SuppressWarnings("serial")
public class ShapePanel extends JPanel implements DrawingView{
	
	private DrawingModel model;
	
	protected void paintComponent (Graphics g){
		
		// check if the object is not empty
		if (model.shapes != null ){

			//draw shapes out of arraylist
			for (Shape s : model.shapes){
				
				//get the color of the copy and paint it
				g.setColor(s.getColor());
				s.paint(g);
				
			}
		}
	}
	
	
	//update the new model in the panel
	@Override
	public void update(DrawingModel model) {

		this.model = model;
		repaint();
	}

}
