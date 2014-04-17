package applicationSimulateur;


public class Triangle2D {
	private Vector2D avant;
	private Vector2D ad;
	private Vector2D ag;
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
		this(longueur, largeur, 90, new Vector2D(100,100));
	}
	
	public Triangle2D(int longueur, int largeur, double angle, Vector2D position) {
		this.angle = angle;
		this.longueur = longueur;
		this.largeur = largeur;
		avant = new Vector2D();
		ad = new Vector2D();
		ag = new Vector2D();
		this.position = position;
		setRotate();
	}
	
	public Vector2D getAvant() {
		return avant;
	}

	public Vector2D getAd() {
		return ad;
	}

	public Vector2D getAg() {
		return ag;
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
		avant.setX( (int)(rotateX(longueur,0,angle)) + position.getX());
		avant.setY( (int)(rotateY(longueur,0,angle)) + position.getY());
		ad.setX(    (int)(rotateX(0,largeur,angle))  + position.getX());
		ad.setY(    (int)(rotateY(0,largeur,angle))  + position.getY());
		ag.setX(    (int)(rotateX(0,-largeur,angle)) + position.getX());
		ag.setY(    (int)(rotateY(0,-largeur,angle)) + position.getY());
	}
	
	private double toRadian(Double angle) {
		return (Math.PI * angle)/180;
	}
	
	private double rotateX(int x, int y, double angle) {
		Double xRetour = 0.;
		xRetour += x * Math.cos(toRadian(angle));
		xRetour += y * Math.sin(toRadian(angle));
		return xRetour;
	}
	
	private double rotateY(int x, int y, double angle) {		
		Double yRetour = 0.;
		yRetour -= x * Math.sin(toRadian(angle));
		yRetour += y * Math.cos(toRadian(angle));
		return yRetour;
	}
	

}
