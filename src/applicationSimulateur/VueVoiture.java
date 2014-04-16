package applicationSimulateur;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class VueVoiture extends JFrame {

	public static final int TailleFenetreEnPixels = 500;

	private int xPixelVoiture;
	private int yPixelVoiture;
	private double angle;

	public VueVoiture() {
		super();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = 0;
		this.yPixelVoiture = 480;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(graphics);

	}

	public void dessinerVoiture(Graphics graphics) {

		Graphics2D g2d = (Graphics2D) graphics;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.rotate(Math.toRadians(angle), xPixelVoiture, yPixelVoiture);

		int[] xPoints = { xPixelVoiture, xPixelVoiture, xPixelVoiture + 20 };
		int[] yPoints = { yPixelVoiture - 10, yPixelVoiture + 10, yPixelVoiture };
		graphics.fillPolygon(xPoints, yPoints, 3);

		g2d.rotate(Math.toRadians(-angle), xPixelVoiture, yPixelVoiture);
	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}

	public void setYPixelVoiture(int yPixelVoiture) {
		this.yPixelVoiture = yPixelVoiture;
	}

	public void setAngleDegreVoiture(double angleDegreVoiture) {
		this.angle = angleDegreVoiture;
	}

}
