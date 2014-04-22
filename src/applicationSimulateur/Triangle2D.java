package applicationSimulateur;

public class Triangle2D {
	private Vecteur2D avant;
	private Vecteur2D arriereDroit;
	private Vecteur2D arriereGauche;
	private Vecteur2D position;
	private double angle;
	private int longueur;
	private int largeur;

	public Triangle2D() {
		this(30, 10);
	}

	public Triangle2D(Vecteur2D position, double angle) {
		this(30, 10, angle, position);
	}

	public Triangle2D(int longueur, int largeur) {
		this(longueur, largeur, 90, new Vecteur2D(100, 100));
	}

	public Triangle2D(int longueur, int largeur, double angle,
			Vecteur2D position) {
		this.angle = angle;
		this.longueur = longueur;
		this.largeur = largeur;
		avant = new Vecteur2D();
		arriereDroit = new Vecteur2D();
		arriereGauche = new Vecteur2D();
		this.position = position;
		setRotate();
	}

	public Vecteur2D getAvant() {
		return avant;
	}

	public Vecteur2D getArriereDroit() {
		return arriereDroit;
	}

	public Vecteur2D getArriereGauche() {
		return arriereGauche;
	}

	public void setAngle(double angle) {
		this.angle = angle;
		setRotate();
	}

	public void setPosition(Vecteur2D position) {
		this.position = position;
		setRotate();
	}

	private void setRotate() {
		setRotationExtremiteDuTriangle(avant, longueur, 0, angle);
		setRotationExtremiteDuTriangle(arriereDroit, 0, largeur, angle);
		setRotationExtremiteDuTriangle(arriereGauche, 0, -largeur, angle);
	}

	private void setRotationExtremiteDuTriangle(Vecteur2D extremite, int x,
			int y, double angle) {
		extremite.setX(rotationX(x, y, angle));
		extremite.setY(rotationY(x, y, angle));
	}

	private int rotationX(int x, int y, double angle) {
		Double xRetour = 0.;
		xRetour += x * Math.cos(Math.toRadians(angle));
		xRetour += y * Math.sin(Math.toRadians(angle));
		return ((int) (xRetour + position.getX()));
	}

	private int rotationY(int x, int y, double angle) {
		Double yRetour = 0.;
		yRetour -= x * Math.sin(Math.toRadians(angle));
		yRetour += y * Math.cos(Math.toRadians(angle));
		return ((int) (yRetour + position.getY()));
	}

}
