import java.awt.Color;
import java.awt.Graphics;

public class Square extends AbstractShape {
	

	public Square(int x, int y, int level,int height, int width) {
		
		
		super(x, y, level, height, width, color);
		shapes = new Shape [5];
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
	public int getY() {
		return this.y;
	}
	
	public int getLevel(){
		return this.level;
	}

	@Override
	public void addLevel(Shape s) {
		
		
		System.out.println(s.getLevel());
		if (level == 0) return;
		if (level == 1){
			
			shapes [0] = new Square (s.getX(),s.getY(),s.getLevel()+1,s.getHeight()/3,s.getWidth()/3);
			shapes [1] = new Square (s.getX()+2*s.getWidth()/3,s.getY(),s.getLevel()+1,s.getHeight()/3,s.getWidth()/3);
			shapes [2] = new Square (s.getX()+s.getHeight()/3,s.getY()+s.getHeight()/3,s.getLevel()+1,s.getHeight()/3,s.getWidth()/3);
			shapes [3] = new Square (s.getX(),s.getY()+2*s.getHeight()/3,s.getLevel()+1,s.getHeight()/3,s.getWidth()/3);
			shapes [4] = new Square (s.getX()+2*s.getWidth()/3,s.getY()+2*s.getHeight()/3,s.getLevel()+1,s.getHeight()/3,s.getWidth()/3);
			s.setLevel(s.getLevel()+1);
			
		}
		else {
			addLevel(shapes[0]);
			addLevel(shapes[1]);
			addLevel(shapes[2]);
			addLevel(shapes[3]);
			addLevel(shapes[4]);
		}
	}

	@Override
	public void removeLevel(Shape s){
		
		this.level = s.getLevel();
		if (level == 0) return;
		if (level == 1){
			
			shapes [0] = new Square (s.getX(),s.getY(),s.getLevel()-1,s.getHeight()*3,s.getWidth()*3);
			shapes [1] = new Square (s.getX()+s.getWidth()*3/2,s.getY(),s.getLevel()-1,s.getHeight()*3,s.getWidth()*3);
			shapes [2] = new Square (s.getX()+s.getHeight()*3,s.getY()+s.getHeight()*3,s.getLevel()-1,s.getHeight()*3,s.getWidth()*3);
			shapes [3] = new Square (s.getX(),s.getY()+s.getHeight()*3/2,s.getLevel()-1,s.getHeight()*3,s.getWidth()*3);
			shapes [4] = new Square (s.getX()+s.getWidth()*3/2,s.getY()+s.getHeight()*3/2,s.getLevel()-1,s.getHeight()*3,s.getWidth()*3);
			
			
			
		}
		else {
			
			removeLevel(shapes[0]);
			removeLevel(shapes[1]);
			removeLevel(shapes[2]);
			removeLevel(shapes[3]);
			removeLevel(shapes[4]);
		}
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
