package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.ClubTeam;
import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

public class ClubTeamTest {

	public static void main(String[] args) {

		final double DELTA = 0.001;
		ClubTeam defaultTeam = new ClubTeam();

		defaultTeam.setReputation(-1);
		if(defaultTeam.getReputation() != Constants.DEFAULT_REPUTATION){
			System.err.println("TEST FAILED: ClubTeam values must be in boundries!!");
		}
		defaultTeam.setReputation(101);
		if(defaultTeam.getReputation() != Constants.DEFAULT_REPUTATION){
			System.err.println("TEST FAILED: ClubTeam values must be in boundries!!");
		}
		

		FootballPlayer player = new FootballPlayer();
		defaultTeam.registerPlayer(player);
		if (!defaultTeam.isPlayerRegistered(player)) {
			System.err.println("TEST FAILED: Check player skill boundries!!");
		}

		FootballPlayer unskilledPlayer = new FootballPlayer("Slacker", Constants.DEFAULT_COUNTRY, 1, 1,
				PlayingPosition.DF);
		if (defaultTeam.isPlayerRegistered(unskilledPlayer)) {
			System.err.println("TEST FAILED: Check player skill boundries!!");
		}

		ClubTeam reputationTeam = new ClubTeam();
		for (int i = 0; i < 20; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, Constants.DEFAULT_COUNTRY, 10, 100,
					PlayingPosition.GK);
			reputationTeam.registerPlayer(sequentialPlayer);
		}
		double expected = (10 * Constants.THIRTY_PERCENT + 100 * Constants.SEVENTY_PERCENT) * 20;
		if (Math.abs(reputationTeam.calculateRating() - expected) > DELTA) {
			System.err.println("TEST FAILED: Team reputation is not calculating properly!!");
		}

		//ignore printed system errors displayed from another classes, as described in instructions.
		System.out.println("This is only valid message that should be displayed from this main!!!!");

	}
}
