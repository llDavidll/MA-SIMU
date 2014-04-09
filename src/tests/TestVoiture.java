package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domaineConduite.Voiture;



public class TestVoiture {
	
	@Test
	public void testGetX(){
		Voiture voiture = new Voiture(20,30) ;
		
		int xVoiture = voiture.getCoordXEnMetres() ;
		assertEquals(20, xVoiture);	
	}
	
	@Test
	public void testGetY(){
		Voiture voiture = new Voiture(20,30) ;
		
		int yVoiture = voiture.getCoordYEnMetres() ;
		assertEquals(30, yVoiture);
	}
	
	@Test
	public void testGetAngle(){
		Voiture voiture = new Voiture(20,30) ;
		double angle = voiture.getAngle();
		assertEquals(0, angle,0);
	}
	
	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20, 30, 150);
		
		assertEquals(150,voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		Voiture voiture = new Voiture(20, 30, 100);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}

	
}
