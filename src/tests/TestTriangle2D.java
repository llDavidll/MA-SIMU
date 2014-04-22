package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import applicationSimulateur.Triangle2D;
import applicationSimulateur.Vecteur2D;

public class TestTriangle2D {
	
	Triangle2D triangle2d;
	
	@Before
	public void init()
	{
		triangle2d = new Triangle2D();
	}

	@Test
	public void testSimpleConstructor() {
		assertEquals(80, triangle2d.getAvant().getX());
		assertEquals(50, triangle2d.getArriereDroit().getX());
		assertEquals(50, triangle2d.getArriereGauche().getX());
		assertEquals(50, triangle2d.getAvant().getY());
		assertEquals(60, triangle2d.getArriereDroit().getY());
		assertEquals(40, triangle2d.getArriereGauche().getY());
	}
	
	@Test
	public void testConstructor() {
		triangle2d = new Triangle2D(new Vecteur2D(100,120),90);
		assertEquals(100, triangle2d.getAvant().getX());
		assertEquals(110, triangle2d.getArriereDroit().getX());
		assertEquals(90, triangle2d.getArriereGauche().getX());
		assertEquals(90, triangle2d.getAvant().getY());
		assertEquals(120, triangle2d.getArriereDroit().getY());
		assertEquals(120, triangle2d.getArriereGauche().getY());
	}
	
	@Test
	public void testConstructorComplexeAngle() {
		triangle2d = new Triangle2D(new Vecteur2D(100,120),127);
		assertEquals(81, triangle2d.getAvant().getX());
		assertEquals(107, triangle2d.getArriereDroit().getX());
		assertEquals(92, triangle2d.getArriereGauche().getX());
		assertEquals(96, triangle2d.getAvant().getY());
		assertEquals(113, triangle2d.getArriereDroit().getY());
		assertEquals(126, triangle2d.getArriereGauche().getY());
	}

}
