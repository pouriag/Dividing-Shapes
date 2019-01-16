import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/*
 * an interface for shapes with all the data
 * that all of our shapes might need
 */
public interface Shape {
	
	int setLevel(int i);
	//needed methods 
	Color getColor();
	List<Shape> getShapes();
	int getX();
	int getY();
	int getHeight();
	int getWidth();
	int getLevel();
	List<Shape> addLevel(Shape s, int l);
	void paint(Graphics g);
	
}
