package applicationSimulateur;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VueVoiture extends JFrame {

	public static final int TailleFenetreEnPixels = 500;

	private Triangle2D voiture;
	private ControleurVoiture controleurVoiture;

	public VueVoiture(final ControleurVoiture controleurVoiture) {
		super();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.voiture = new Triangle2D();
		this.controleurVoiture = controleurVoiture;
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controleurVoiture.inputs(e);
				
			}
		});
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

		int[] xPoints = { voiture.getAvant().getX(), voiture.getAd().getX(), voiture.getAg().getX() };
		int[] yPoints = { voiture.getAvant().getY(), voiture.getAd().getY(), voiture.getAg().getY() };
		graphics.fillPolygon(xPoints, yPoints, 3);
	}

	public void setVoiture(int xVoiture, int yVoiture, double angle) {
		this.voiture = new Triangle2D(new Vector2D(xVoiture,yVoiture),angle);
	}
}
