package tests;

import org.junit.Before;
import org.junit.Test;

import domaineConduite.Voiture;
import applicationSimulateur.ControleurVoiture;
import applicationSimulateur.VueVoiture;

public class TestVueVoiture {

	VueVoiture vueVoiture;
	
	@Before
	public void setUp() throws Exception {
		Voiture voiture = new Voiture(100, 900, 20);
		ControleurVoiture controleurVoiture;

		controleurVoiture = new ControleurVoiture(voiture);
		vueVoiture = new VueVoiture(controleurVoiture);
	}

	@Test
	public void testSetVoiture() {
	}

}
