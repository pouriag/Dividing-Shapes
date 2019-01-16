import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Triangle extends AbstractShape {
	
	protected List<Shape> shapes = new ArrayList<Shape>();
	
	public Triangle(int x, int y,int level,int height, int width) {
		
		super(x, y, level, height, width, color);
		this.level = level;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		
		xPoints = new int[3];
		yPoints = new int[3];
		
		//assigning the coordinations for each point of Triangle
		xPoints [0] = x; 		   yPoints [0] = y;
		xPoints [1] = x + width/2; yPoints [1] = y + height;
		xPoints [2] = x - width/2; yPoints [2] = y + height;

	}

	@Override
	public void paint(Graphics g) {
		g.fillPolygon(xPoints,yPoints,3);
		g.drawPolygon(xPoints,yPoints,3);
	}
	
	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getX() {
		return this.x;
	}
	
	@Override
	public int getHeight() {
		return this.height;
	}
	

	@Override
	public int getY() {
		return this.y;
	}

	public List<Shape> addLevel(Shape s,int level) {
		
		if (s.getLevel() == level ) {
			shapes.add(s);
			return shapes;
		}

		addLevel (new Triangle (s.getX(),s.getY(),s.getLevel()+1,s.getHeight()/2,s.getWidth()/2),level);
		addLevel (new Triangle (s.getX() - s.getWidth()/4,s.getY()+s.getHeight()/2,s.getLevel()+1,s.getHeight()/2,s.getWidth()/2),level);
		addLevel (new Triangle (s.getX() + s.getWidth()/4,s.getY()+s.getHeight()/2,s.getLevel()+1,s.getHeight()/2,s.getWidth()/2),level);
		
		return shapes;
	}


	@Override
	public int getLevel() {
		return level;
	}
	
	public String toString () {
		return super.toString()+" level:" + level+ ". ";
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public int setLevel(int level) {
		this.level = level;
		return this.level;
	}

	@Override
	public List<Shape> getShapes() {
		// TODO Auto-generated method stub
		return shapes;
	}

	
	
	

}
