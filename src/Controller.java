import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class Controller implements ActionListener, ComponentListener,
MouseListener{
	private DrawingModel model;
	private ShapePanel panel;
	protected JRadioButton upButton,downButton;
	protected textViewer txt;
	protected Square s = new Square(100,100,0,200, 200);
	protected Triangle t = new Triangle(350,300,0,200, 200);
	
	public Controller(DrawingModel model,ShapePanel panel,textViewer txt) {
		this.model = model;
		this.panel = panel;
		this.txt = txt;
		
		
		upButton = new JRadioButton("Level up");
	
		upButton.setSelected(true);
		
		downButton = new JRadioButton("Level Down");
		
		downButton.setSelected(false);
		
		//ButtonGroup
		ButtonGroup bg = new ButtonGroup();
		bg.add(upButton);
		bg.add(downButton);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
	
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.createShapes(panel);
		txt.update(model);
		if (upButton.isSelected()){
			 model.levelUp();
			}
		else {
			model.levelDown();
		}
		}

}
