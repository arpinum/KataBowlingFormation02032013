package KataBowlingFormation02032013;

import java.util.List;

import com.google.common.collect.Lists;

public class Partie {
	public void ajouteLancer(int nombreQuilles) {
		lancers.add(nombreQuilles);
	}

	public int calculeScore() {
		int score = 0;
		int lancerCourant = 0;
		for (int i = 0; i < NOMBRE_CARREAUX; i++) {
			if (estUnStrike(lancerCourant)) {
				score += 10 + bonusStrike(lancerCourant);
				lancerCourant++;
			} else {
				score += scoreCarreauADeuxLancers(lancerCourant);
				if (estUnSpare(lancerCourant)) {
					score += bonusSpare(lancerCourant);
				}
				lancerCourant += 2;
			}
		}
		return score;
	}

	private boolean estUnStrike(int lancerCourant) {
		return lancers.get(lancerCourant) == 10;
	}

	private int bonusStrike(int lancerCourant) {
		return lancers.get(lancerCourant + 1) + lancers.get(lancerCourant + 2);
	}

	private boolean estUnSpare(int lancerCourant) {
		return scoreCarreauADeuxLancers(lancerCourant) == 10;
	}

	private Integer bonusSpare(int lancerCourant) {
		return lancers.get(lancerCourant + 2);
	}

	private int scoreCarreauADeuxLancers(int lancerCourant) {
		return lancers.get(lancerCourant) + lancers.get(lancerCourant + 1);
	}

	public static final int NOMBRE_CARREAUX = 10;

	private List<Integer> lancers = Lists.newArrayList();
}
