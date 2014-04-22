package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import applicationSimulateur.Vecteur2D;

public class TestVecteur2D {
	
	Vecteur2D vecteur2D;

	@Before
	public void setUp(){
		vecteur2D = new Vecteur2D(10, 23);
	}

	@Test
	public void testGetX() {
		assertEquals(10,vecteur2D.getX());
	}
	
	@Test
	public void testSetX(){
		vecteur2D.setX(15);
		assertEquals(15, vecteur2D.getX());
	}
	
	@Test
	public void testGetY(){
		assertEquals(23,vecteur2D.getY());
	}
	
	@Test
	public void testSetY(){
		vecteur2D.setY(42);
		assertEquals(42,vecteur2D.getY());
	}

}
