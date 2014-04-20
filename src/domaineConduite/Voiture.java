package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {

	private int coordXEnMetres;
	private int coordYEnMetres;
	private double angle;

	private int vitesseMetreParSecondes;

	public static final int largeurDomaine = 1000;

	public Voiture(int coordXEnMetres, int coordYEnMetres) {
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseMetreParSecondes = 0;
		this.angle = 0.0;
	}

	public Voiture(int coordXEnMetres, int coordYEnMetres,
			int vitesseMetreParSecondes) {
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
		this.angle = 0.0;
	}

	public int getCoordXEnMetres() {
		return this.coordXEnMetres;
	}

	public int getCoordYEnMetres() {
		return this.coordYEnMetres;
	}

	public double getAngle() {
		return this.angle;
	}

	public void setAngle(double nouvelAngle) {
		this.angle = nouvelAngle % 360;
	}

	public int getVitesseMetreParSecondes() {
		return vitesseMetreParSecondes;
	}

	public void tournerDroite() {
		angle -= 5;
	}

	public void tournerGauche() {
		angle += 5;
	}

	public void accelerer() {
		vitesseMetreParSecondes += 10;
	}

	public void decelerer() {
		vitesseMetreParSecondes -= 10;
	}

	private boolean procheDuBordGaucheDuDomaine() {
		return (coordXEnMetres < 50);
	}

	private boolean procheDuBordDroitDuDomaine() {
		return (coordXEnMetres > largeurDomaine - 50);
	}

	private boolean procheDuBordSuperieurDuDomaine() {
		return (coordYEnMetres > largeurDomaine - 100);
	}

	private boolean procheDuBordInferieurDuDomaine() {
		return (coordYEnMetres < 50);
	}

	private void rebondSurBordLateralDuDomaine() {
		if (procheDuBordGaucheDuDomaine()) {
			coordXEnMetres = 50;
		} else {
			coordXEnMetres = largeurDomaine-50;
		}
		angle = -(angle + 180) % 360;
	}

	private void rebondSurBordSuperieurOuInferieurDuDomaine() {
		if (procheDuBordInferieurDuDomaine()) {
			coordYEnMetres = 50;
		} else {
			coordYEnMetres = largeurDomaine-100;
		}
		angle = -angle;
	}

	public void avancerEnFonctionDeLaVitesse() {
		coordXEnMetres += vitesseMetreParSecondes
				* Math.cos(Math.toRadians(angle));
		coordYEnMetres -= vitesseMetreParSecondes
				* Math.sin(Math.toRadians(angle));
		
		if (procheDuBordGaucheDuDomaine() || procheDuBordDroitDuDomaine()) {
			rebondSurBordLateralDuDomaine();
		} else {
			if (procheDuBordInferieurDuDomaine() || procheDuBordSuperieurDuDomaine()) {
				rebondSurBordSuperieurOuInferieurDuDomaine();
			}
		}

		notificationObservateurs();
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}
}
