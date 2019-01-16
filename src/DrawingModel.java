import java.util.ArrayList;

// A drawing model to add shapes and view and get shapes if needed
public class DrawingModel {
	protected ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<DrawingView> views = new ArrayList<DrawingView>();
	protected Square s = new Square(100,100,1,200, 200);
	protected Triangle t = new Triangle(350,300,1,200, 200);
	
	public void createShapes(ShapePanel p){
		
	
		this.addView(p);
		
	
	}
	
	public void levelUp(){
		
		removeShape();
		
		s.addLevel(s);
		t.addLevel(t);
		if (s.level != 0 && t.level!=0){
			for (Shape s: s.shapes){
				addShape(s.getShape());
				}
			for (Shape t: t.shapes){
				addShape(t.getShape());
			}
			}
			else{
				addShape(s.getShape());
				addShape(t.getShape());
			}
		
	}
	
	public void levelDown(){
		removeShape();
		
		s.removeLevel(s);
		t.removeLevel(t);
		if (s.level != 0 && t.level!=0){
			for (Shape s: s.shapes){
				addShape(s.getShape());
				}
			for (Shape t: t.shapes){
				addShape(t.getShape());
			}
			}
			else{
				addShape(s.getShape());
				addShape(t.getShape());
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
	public void updateView(DrawingView view){
		
		for (DrawingView v : views){
			views.add(view);
			v.update(this);
		}
	}

	// Adds a new view to the model
	public void addView(DrawingView view) {
		
		views.add(view);
		view.update(this);
		
	}
}
