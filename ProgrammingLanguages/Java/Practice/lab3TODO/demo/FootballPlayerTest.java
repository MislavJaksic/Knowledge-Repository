package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

public class FootballPlayerTest {

	public static void main(String[] args) {

		FootballPlayer defaultPlayer = new FootballPlayer();

		if (defaultPlayer.equals(null)) {
			System.err.println("TEST FAILED: Player is null!!");
		}
		
		FootballPlayer unemotinoalPlayer = new FootballPlayer("Player", Constants.DEFAULT_COUNTRY, -10, 110,
					PlayingPosition.FW);
		if(unemotinoalPlayer.getEmotion() < 0 || unemotinoalPlayer.getPlayingSkill() > 100){
			System.err.println("TEST FAILED: Football player values must be in boundries!!");
		}
		
		FootballPlayer emotionalPlayer = new FootballPlayer("Player", Constants.DEFAULT_COUNTRY, 110, -10,
					PlayingPosition.GK);
		if(emotionalPlayer.getEmotion() > 100 || emotionalPlayer.getPlayingSkill() < 0){
			System.err.println("TEST FAILED: Football player values must be in boundries!!");
		}
		
		FootballPlayer waterBoy = new FootballPlayer("Player", Constants.DEFAULT_COUNTRY, 100, 100, null);
		if(waterBoy.getPlayingPosition() == null){
			System.err.println("TEST FAILED: Football player values must be in boundries!!");
		}
			
		//ignore printed system errors displayed from another classes, as described in instructions.
		System.out.println("This is only valid message that should be displayed from this main!!!!");
	}
}
