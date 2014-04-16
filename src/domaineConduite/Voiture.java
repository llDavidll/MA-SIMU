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

	public void avancerEnFonctionDeLaVitesse() {
		coordXEnMetres += vitesseMetreParSecondes * Math.cos(angle);
		coordYEnMetres += vitesseMetreParSecondes * Math.sin(angle);
		notificationObservateurs();
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}
}
