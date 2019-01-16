import java.awt.Color;
import java.util.Random;

public abstract class AbstractShape implements Shape{
	
	//to use later for Coordinations
	protected Shape[] shapes = null;
	protected int x,y,height,width,level ;
	protected int [] xPoints,yPoints;

	// the height and width of the shapes that we are creating
	
	
	//Random
	static Random rnd = new Random();
	
	//Color for shapes 
	protected static Color color = new Color (rnd.nextInt(), true);
	
	
	

	public AbstractShape(int x, int y, int level,int height, int width,Color Color) {
	
	}

	public String toString () {
		return ("X: "+ x+", Y: "+ y  + ", Color = "+ color);
	}
	
}
