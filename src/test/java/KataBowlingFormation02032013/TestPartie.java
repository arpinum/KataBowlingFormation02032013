package KataBowlingFormation02032013;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class TestPartie {
	@Before
	public void avantChaqueTest() {
		partie = new Partie();
	}

	@Test
	public void peutCalculerLeScoreDUnePartieGouttière() {
		ajouteLancers(20, 0);

		int score = partie.calculeScore();

		assertThat(score).isEqualTo(0);
	}

	@Test
	public void peutCalculerLeScoreDUnePartieQuandOnFaitTomberUneQuilleAChaqueLancer() {
		ajouteLancers(20, 1);

		int score = partie.calculeScore();

		assertThat(score).isEqualTo(20);
	}

	@Test
	public void peutCalculerLeScoreAvecUnSpare() {
		ajouteSpare();
		partie.ajouteLancer(1);
		ajouteLancers(17, 0);

		int score = partie.calculeScore();

		assertThat(score).isEqualTo(12);
	}

	@Test
	public void peutCalculerLeScoreAvecUnStrike() {
		ajouteStrike();
		partie.ajouteLancer(1);
		partie.ajouteLancer(2);
		ajouteLancers(16, 0);

		int score = partie.calculeScore();

		assertThat(score).isEqualTo(16);
	}

	@Test
	public void peutCalculerLeScoreMaximal() {
		ajouteLancers(12, 10);

		int score = partie.calculeScore();

		assertThat(score).isEqualTo(300);
	}

	private void ajouteStrike() {
		partie.ajouteLancer(10);
	}

	private void ajouteSpare() {
		partie.ajouteLancer(3);
		partie.ajouteLancer(7);
	}

	private void ajouteLancers(int nombreLancers, int nombreQuilles) {
		for (int i = 0; i < nombreLancers; i++) {
			partie.ajouteLancer(nombreQuilles);
		}
	}

	private Partie partie;
}
