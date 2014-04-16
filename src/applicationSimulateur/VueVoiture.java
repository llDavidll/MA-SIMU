package applicationSimulateur;

import java.util.Observable;
import java.util.Observer;

import domaineConduite.Voiture;

public class VueVoiture implements Observer {

	private Voiture voiture;

	private DessinVoiture ihm;

	private double angle;

	public VueVoiture(Voiture voiture, DessinVoiture ihm) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.ihm = ihm;
		this.angle = 0;
	}

	public int transformerMetrePixel(int coordonneeXEnMetre) {

		int ratioDomaineFenetre = Voiture.largeurDomaine
				/ DessinVoiture.TailleFenetreEnPixels;

		int coordonneeXEnPixels = coordonneeXEnMetre / ratioDomaineFenetre;

		return coordonneeXEnPixels;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		int xVoiture = this.voiture.getCoordXEnMetres();
		int yVoiture = this.voiture.getCoordXEnMetres();
		this.angle = this.voiture.getAngle();

		int xPixelVoiture = this.transformerMetrePixel(xVoiture);
		int yPixelVoiture = this.transformerMetrePixel(yVoiture);

		ihm.setXPixelVoiture(xPixelVoiture);
		ihm.setYPixelVoiture(yPixelVoiture);
		ihm.repaint();

	}

	public void setAngle(double angle) {

		this.angle = angle % 360;
	}

	public double getAngle() {

		return this.angle;
	}

}
