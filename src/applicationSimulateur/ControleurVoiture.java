package applicationSimulateur;

import java.util.Observable;
import java.util.Observer;

import domaineConduite.Voiture;

public class ControleurVoiture implements Observer {

	private Voiture voiture;

	private VueVoiture ihm;

	public ControleurVoiture(Voiture voiture, VueVoiture ihm) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.ihm = ihm;
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

		ihm.setVoiture(xPixelVoiture, yPixelVoiture, angleVoiture);
		ihm.repaint();

	}

}
