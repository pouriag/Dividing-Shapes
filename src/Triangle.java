import java.awt.Color;
import java.awt.Graphics;


public class Triangle extends AbstractShape {
	
	
	public Triangle(int x, int y,int level,int height, int width) {
		
		super(x, y, level, height, width, color);
		shapes = new Shape[3];
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

	public Shape getShape() {
		for (Shape s : shapes){
			if (s!= null){
				
				return s;
			}	
		}
		this.setLevel(this.getLevel()+1);
		return this;
	
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

	@Override
	public void addLevel(Shape s) {
		
		this.level = s.getLevel(); 
		if (level == 0) return;
		if (level == 1){
			
			this.shapes [0] = new Triangle (s.getX(),s.getY(),s.getLevel()+1,s.getHeight()/2,s.getWidth()/2);
			this.shapes [1] = new Triangle (s.getX() - s.getWidth()/4,s.getY()+s.getHeight()/2,s.getLevel()+1,s.getHeight()/2,s.getWidth()/2);
			this.shapes [2] = new Triangle (s.getX() + s.getWidth()/4,s.getY()+s.getHeight()/2,s.getLevel()+1,s.getHeight()/2,s.getWidth()/2);
			s.setLevel(s.getLevel()+1);
			
		}
		else {
			
			addLevel(shapes[0]);
			addLevel(shapes[1]);
			addLevel(shapes[2]);
			
		}
		
	}

	@Override
	public void removeLevel(Shape s) {
		
		this.level = s.getLevel(); 
		if (level == 0) return;
		if (level == 1){
			
			this.shapes [0] = new Triangle (s.getX(),s.getY(),s.getLevel()-1,s.getHeight()/2,s.getWidth()/2);
			this.shapes [1] = new Triangle (s.getX() - s.getWidth()*4,s.getY()+s.getHeight()*2,s.getLevel()-1,s.getHeight()*2,s.getWidth()*2);
			this.shapes [2] = new Triangle (s.getX() + s.getWidth()*4,s.getY()+s.getHeight()*2,s.getLevel()-1,s.getHeight()*2,s.getWidth()*2);
			s.setLevel(s.getLevel()-1);
		}
		else{
			
			removeLevel(shapes[0]);
			removeLevel(shapes[1]);
			removeLevel(shapes[2]);
		}
		
	}

	@Override
	public int getLevel() {
		return this.level;
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

	
	
	

}
