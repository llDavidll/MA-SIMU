package applicationSimulateur;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import domaineConduite.Voiture;

public class ControleurVoiture implements Observer {

	private Voiture voiture;

	private VueVoiture vueVoiture;

	public ControleurVoiture(Voiture voiture) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.vueVoiture = new VueVoiture(this);
	}

	public int transformerMetrePixel(int coordonneeXEnMetre) {
		int ratioDomaineFenetre = Voiture.largeurDomaine
				/ VueVoiture.TailleFenetreEnPixels;

		int coordonneeXEnPixels = coordonneeXEnMetre / ratioDomaineFenetre;

		return coordonneeXEnPixels;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int xVoiture = this.voiture.getCoordXEnMetres();
		int yVoiture = this.voiture.getCoordYEnMetres();

		double angleVoiture = this.voiture.getAngle();

		int xPixelVoiture = this.transformerMetrePixel(xVoiture);
		int yPixelVoiture = this.transformerMetrePixel(yVoiture);

		vueVoiture.setVoiture(xPixelVoiture, yPixelVoiture, angleVoiture);
		vueVoiture.repaint();

	}

	public void inputs(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			voiture.accelerer();
			break;
		case KeyEvent.VK_DOWN:
			voiture.decelerer();
			break;
		case KeyEvent.VK_RIGHT:
			voiture.tournerDroite();
			break;
		case KeyEvent.VK_LEFT:
			voiture.tournerGauche();
			break;
		default:
			break;
		}
	}

}
