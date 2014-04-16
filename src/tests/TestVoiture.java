package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domaineConduite.Voiture;

public class TestVoiture {
	Voiture voiture;

	@Before
	public void setUp() {
		voiture = new Voiture(20, 30, 100);
	}

	@Test
	public void testGetX() {
		assertEquals(20, voiture.getCoordXEnMetres());
	}

	@Test
	public void testGetY() {
		assertEquals(30, voiture.getCoordYEnMetres());
	}

	@Test
	public void testGetAngle() {
		assertEquals(0, voiture.getAngle(), 0);
	}

	@Test
	public void testSetAngle() {
		voiture.setAngle(90f);
		assertEquals(90, voiture.getAngle(), 0);
	}

	@Test
	public void testVitesseX() {
		assertEquals(100, voiture.getVitesseMetreParSecondes());
	}

	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}

}
