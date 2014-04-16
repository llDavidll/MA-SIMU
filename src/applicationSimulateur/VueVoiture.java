package applicationSimulateur;

import java.util.Observable;
import java.util.Observer;

import domaineConduite.Voiture;

public class VueVoiture implements Observer {

	private Voiture voiture;

	private DessinVoiture ihm;

	public VueVoiture(Voiture voiture, DessinVoiture ihm) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.ihm = ihm;
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
		double angleVoiture = this.voiture.getAngle();

		int xPixelVoiture = this.transformerMetrePixel(xVoiture);
		int yPixelVoiture = this.transformerMetrePixel(yVoiture);

		ihm.setXPixelVoiture(xPixelVoiture);
		ihm.setYPixelVoiture(yPixelVoiture);
		ihm.setAngleDegreVoiture(angleVoiture);
		ihm.repaint();

	}

}
