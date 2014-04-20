package applicationSimulateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import domaineConduite.Voiture;

public class SimulateurVoiture {

	public static final int dureeEnMilliSecondes = 200;

	public static void main(String[] args) {
		final Voiture voiture = new Voiture(100, 900, 20);
		voiture.setAngle(75);
		new ControleurVoiture(voiture);
		voiture.avancerEnFonctionDeLaVitesse();
		Timer timerAvancer = new Timer(dureeEnMilliSecondes,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						voiture.avancerEnFonctionDeLaVitesse();

					}
				});

		timerAvancer.start();
	}
}
