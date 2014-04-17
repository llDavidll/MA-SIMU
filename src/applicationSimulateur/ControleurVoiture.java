package applicationSimulateur;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import domaineConduite.Voiture;

public class ControleurVoiture implements Observer {

	private Voiture voiture;

	private VueVoiture ihm;

	public ControleurVoiture(Voiture voiture) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.ihm = new VueVoiture(this);
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
	
	public void inputs(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			voiture.acc();
			break;
		case KeyEvent.VK_DOWN:
			voiture.dec();
			break;
		case KeyEvent.VK_RIGHT:
			voiture.turnRight();
			break;
		case KeyEvent.VK_LEFT:
			voiture.turnLeft();
			break;
		}
	}

}
