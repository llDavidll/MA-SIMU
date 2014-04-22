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
	public void testGetCoordXEnMetres() {
		assertEquals(20, voiture.getCoordXEnMetres());
	}

	@Test
	public void testGetCoordYEnMetres() {
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
	public void testVitesseMetreParSecondes() {
		assertEquals(100, voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testAccelerer(){
		voiture.accelerer();
		assertEquals(110,voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testDecelerer(){
		voiture.decelerer();
		assertEquals(90,voiture.getVitesseMetreParSecondes());
	}
	

	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(50, voiture.getCoordXEnMetres());
		
		voiture = new Voiture(20, 30, 100);
		voiture.setAngle(-90);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(30, voiture.getCoordYEnMetres());
	}
	
	@Test
	public void testRebondSurBordLateralDuDomaine(){
		voiture.setAngle(-180);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(0,voiture.getAngle(),0);
		assertEquals(50,voiture.getCoordXEnMetres());
		
		voiture = new Voiture(980, 30, 100);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(-180,voiture.getAngle(),0);
		assertEquals(950,voiture.getCoordXEnMetres());
	}
	
	@Test
	public void testRebondSurBordSuperieurOuInferieurDuDomaine(){
		voiture = new Voiture(90, 20, 100);
		voiture.setAngle(90);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(-90, voiture.getAngle(), 0);
		assertEquals(50,voiture.getCoordYEnMetres());
		
		voiture = new Voiture(90, 980, 100);
		voiture.setAngle(-90);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(90, voiture.getAngle(), 0);
		assertEquals(900,voiture.getCoordYEnMetres());
	}
}