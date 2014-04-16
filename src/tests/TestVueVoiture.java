package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import applicationSimulateur.DessinVoiture;
import applicationSimulateur.VueVoiture;
import domaineConduite.Voiture;

public class TestVueVoiture {

	private VueVoiture mTriangle;

	@Before
	public void setUp() throws Exception {

		Voiture voiture = new Voiture(0, 0);
		DessinVoiture dessin = new DessinVoiture();

		mTriangle = new VueVoiture(voiture, dessin);
	}

	@Test
	public void testTransformationMetrePixels() {

		assertEquals(400, mTriangle.transformerMetrePixel(800));
		assertEquals(100, mTriangle.transformerMetrePixel(201));
		assertEquals(50, mTriangle.transformerMetrePixel(100));
	}

	@Test
	public void testSetAngle() {

		double angle = 25;

		assertEquals(0, mTriangle.getAngle(), 0.01);

		mTriangle.setAngle(angle);

		assertEquals(25, mTriangle.getAngle(), 0.01);

		angle = 400.6;
		mTriangle.setAngle(angle);

		assertEquals(40.6, mTriangle.getAngle(), 0.01);
	}

}
