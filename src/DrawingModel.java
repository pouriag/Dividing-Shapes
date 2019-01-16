import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// A drawing model to add shapes and view and get shapes if needed
public class DrawingModel {
	protected Queue<Shape> shapes = new LinkedList<Shape>();
	private DrawingView view;
	private int level = 0;
	
	
	public void createShapes(ShapePanel p){
		
		view = p;
		this.updateView();
	}
	
	public void levelUp(){
		
		if(level == 0) {
			addShape(new Square(100,100,0,200, 200));
		    addShape(new Triangle(400,300,0,200, 200));
		    level++;
		    return;
		}
		//number of expected shapes for the current level
		int count = (int) (Math.pow(3,level) + Math.pow(5, level));

		//increase the level to goal level
		level++;
		
		//add level to shapes and add them to view queue
		while (count > 0 ) {
			Shape cur = shapes.remove();
			for (Shape sh : cur.addLevel(cur, level)) {
				if(sh.getLevel() == level) addShape(sh);
			}
			count--;
		}
		
	}
	
	public void levelDown(){
		
		int goalLevel = level-1;
		level = 0 ;
		removeShape();
		for (int i = 0 ; i < goalLevel;i++) {
			levelUp();
		}
		
	}
	
	//add shapes to shape arraylist
	public void addShape(Shape p){
		
		shapes.add(p);
	}
	
	//empty the arraylist
	public void removeShape(){
		shapes.clear();
	
	}
	
	//add and update new views
	public void updateView(){
		
		view.update(this);
	}

}
