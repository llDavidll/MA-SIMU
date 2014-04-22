package applicationSimulateur;

public class Triangle2D {
	private Vecteur2D avant;
	private Vecteur2D arriereDroit;
	private Vecteur2D arriereGauche;
	private Vecteur2D position;

	public Triangle2D() {
		this(new Vecteur2D(50, 50), 0);
	}

	public Triangle2D(Vecteur2D position, double angle) {
		this(30, 10, angle, position);
	}

	public Triangle2D(int longueur, int largeur, double angle,
			Vecteur2D position) {
		avant = new Vecteur2D();
		arriereDroit = new Vecteur2D();
		arriereGauche = new Vecteur2D();
		this.position = position;
		setRotate(longueur, largeur, angle);
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

	private void setRotate(int longueur, int largeur, double angle) {
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
