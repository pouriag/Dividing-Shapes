import java.awt.Color;
import java.awt.Graphics;

/*
 * an interface for shapes with all the data
 * that all of our shapes might need
 */
public interface Shape {
	
	int setLevel(int i);
	//needed methods 
	Color getColor();
	Shape getShape();
	int getX();
	int getY();
	int getHeight();
	int getWidth();
	int getLevel();
	void addLevel(Shape s);
	void removeLevel(Shape s);
	void paint(Graphics g);
	
}
