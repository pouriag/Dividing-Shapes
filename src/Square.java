import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Square extends AbstractShape {
	
	protected List<Shape> shapes = new ArrayList<Shape>();
	public Square(int x, int y, int level,int height, int width) {
		
		
		super(x, y, level, height, width, color);
		this.level = level;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		
		xPoints = new int[4];
		yPoints = new int[4];
		
		//assigning the coordinations for each point of Square
		xPoints [0] = x; 		 yPoints [0] = y;
		xPoints [1] = x + width; yPoints [1] = y;
		xPoints [2] = x + width; yPoints [2] = y + height;
		xPoints [3] = x; 	     yPoints [3] = y + height;
		


	}
	
	@Override
	public void paint(Graphics g) {
		g.fillPolygon(xPoints,yPoints,4);
		g.drawPolygon(xPoints,yPoints,4);
	}


	@Override
	public List<Shape> getShapes() {
		return shapes;
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
	public int getY() {
		return this.y;
	}
	
	public int getLevel(){
		return this.level;
	}

	
	public List<Shape> addLevel(Shape s, int level) {
		
		if (s.getLevel() == level ) {
			shapes.add(s);
			return shapes;
		}		
		addLevel(new Square (s.getX(),s.getY(),s.getLevel()+1,s.getHeight()/3,s.getWidth()/3),level);
		addLevel(new Square (s.getX()+2*s.getWidth()/3,s.getY(),s.getLevel()+1,s.getHeight()/3,s.getWidth()/3),level);
		addLevel(new Square (s.getX()+s.getHeight()/3,s.getY()+s.getHeight()/3,s.getLevel()+1,s.getHeight()/3,s.getWidth()/3),level);
		addLevel(new Square (s.getX(),s.getY()+2*s.getHeight()/3,s.getLevel()+1,s.getHeight()/3,s.getWidth()/3),level);
		addLevel(new Square (s.getX()+2*s.getWidth()/3,s.getY()+2*s.getHeight()/3,s.getLevel()+1,s.getHeight()/3,s.getWidth()/3),level);
		
		return shapes;

	}
	

	public String toString () {
		return super.toString()+" level:" + level + ". ";
	}

	@Override
	public int getHeight() {
		
		return this.height;
	}

	@Override
	public int getWidth() {
		
		return this.width;
	}

	@Override
	public int setLevel(int level) {
		this.level = level;
		return this.level;
	}

}
