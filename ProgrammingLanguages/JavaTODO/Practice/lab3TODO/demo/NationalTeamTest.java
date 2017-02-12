package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.NationalTeam;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

public class NationalTeamTest {

	public static void main(String[] args) {

		final double DELTA = 0.001;
		NationalTeam defaultTeam = new NationalTeam();

		FootballPlayer player = new FootballPlayer();
		defaultTeam.registerPlayer(player);
		if (!defaultTeam.isPlayerRegistered(player)) {
			System.err.println("TEST FAILED: Default national team county and default player county not match!!");
		}

		FootballPlayer foreignPlayer = new FootballPlayer("Foreigner", "Noland", 1, 1, PlayingPosition.DF);
		defaultTeam.registerPlayer(foreignPlayer);
		if (defaultTeam.isPlayerRegistered(foreignPlayer)) {
			System.err.println("TEST FAILED: Countries do not match!!! Check registration rules.");
		}

		NationalTeam ratingTeam = new NationalTeam();
		for (int i = 0; i < 20; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, Constants.DEFAULT_COUNTRY, 10, 100,
					PlayingPosition.GK);
			ratingTeam.registerPlayer(sequentialPlayer);
		}
		double expected = (10 * Constants.SEVENTY_PERCENT + 100 * Constants.THIRTY_PERCENT) * 20;
		if (Math.abs(ratingTeam.calculateRating() - expected) > DELTA) {
			System.err.println("TEST FAILED: Check rating calculation!!");
		}

		//ignore printed system errors displayed from another classes, as described in instructions.
		System.out.println("This is only valid message that should be displayed from this main!!!!");
	}

}
