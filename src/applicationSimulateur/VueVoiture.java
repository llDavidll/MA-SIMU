package applicationSimulateur;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		this.add(new VueVoiturePanel());
		this.voiture = new Triangle2D();
		this.controleurVoiture = controleurVoiture;
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				VueVoiture.this.controleurVoiture.inputs(e);

			}
		});
	}

	public void setVoiture(int xVoiture, int yVoiture, double angle) {
		this.voiture = new Triangle2D(new Vecteur2D(xVoiture, yVoiture), angle);
	}

	private class VueVoiturePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			dessinerVoiture(graphics);
		}

		public void dessinerVoiture(Graphics graphics) {

			Graphics2D g2d = (Graphics2D) graphics;

			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			int[] xPoints = { voiture.getAvant().getX(),
					voiture.getArriereDroit().getX(), voiture.getArriereGauche().getX() };
			int[] yPoints = { voiture.getAvant().getY(),
					voiture.getArriereDroit().getY(), voiture.getArriereGauche().getY() };
			graphics.fillPolygon(xPoints, yPoints, 3);
		}
	}
}
