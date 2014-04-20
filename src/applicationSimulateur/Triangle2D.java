package applicationSimulateur;

public class Triangle2D {
	private Vector2D avant;
	private Vector2D arriereDroit;
	private Vector2D arriereGauche;
	private Vector2D position;
	private double angle;
	private int longueur;
	private int largeur;

	public Triangle2D() {
		this(30, 10);
	}

	public Triangle2D(Vector2D position, double angle) {
		this(30, 10, angle, position);
	}

	public Triangle2D(int longueur, int largeur) {
		this(longueur, largeur, 90, new Vector2D(100, 100));
	}

	public Triangle2D(int longueur, int largeur, double angle, Vector2D position) {
		this.angle = angle;
		this.longueur = longueur;
		this.largeur = largeur;
		avant = new Vector2D();
		arriereDroit = new Vector2D();
		arriereGauche = new Vector2D();
		this.position = position;
		setRotate();
	}

	public Vector2D getAvant() {
		return avant;
	}

	public Vector2D getArriereDroit() {
		return arriereDroit;
	}

	public Vector2D getArriereGauche() {
		return arriereGauche;
	}

	public void setAngle(double angle) {
		this.angle = angle;
		setRotate();
	}

	public void setPosition(Vector2D position) {
		this.position = position;
		setRotate();
	}

	private void setRotate() {
		setRotateExtremiteDuTriangle(avant, longueur, 0, angle);
		setRotateExtremiteDuTriangle(arriereDroit, 0, largeur, angle);
		setRotateExtremiteDuTriangle(arriereGauche, 0, -largeur, angle);
	}

	private void setRotateExtremiteDuTriangle(Vector2D extremite, int x, int y, double angle) {
		extremite.setX(rotateX(x, y, angle));
		extremite.setY(rotateY(x, y, angle));
	}

	private double toRadian(Double angle) {
		return (Math.PI * angle) / 180;
	}

	private int rotateX(int x, int y, double angle) {
		Double xRetour = 0.;
		xRetour += x * Math.cos(toRadian(angle));
		xRetour += y * Math.sin(toRadian(angle));
		return ((int) (xRetour + position.getX()));
	}

	private int rotateY(int x, int y, double angle) {
		Double yRetour = 0.;
		yRetour -= x * Math.sin(toRadian(angle));
		yRetour += y * Math.cos(toRadian(angle));
		return ((int) (yRetour + position.getY()));
	}

}
