package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import applicationSimulateur.ControleurVoiture;
import domaineConduite.Voiture;

public class TestControleurVoiture {

	private ControleurVoiture mTriangle;

	@Before
	public void setUp() throws Exception {

		Voiture voiture = new Voiture(0, 0);

		mTriangle = new ControleurVoiture(voiture);
	}

	@Test
	public void testTransformationMetrePixels() {

		assertEquals(400, mTriangle.transformerMetrePixel(800));
		assertEquals(100, mTriangle.transformerMetrePixel(201));
		assertEquals(50, mTriangle.transformerMetrePixel(100));
	}

}
