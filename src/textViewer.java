import javax.swing.JPanel;

public class textViewer implements DrawingView {
	
	private DrawingModel model;
	
	@Override
	public void update(DrawingModel model) {
		this.model = model;
		//System.out.println(this.model.shapes.toString());
	}

}
