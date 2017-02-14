package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

public class SimpleFootbalPlayerCollectionTest {

	public static void main(String[] args) {

		final int TEST_MAX_SIZE = 10;
		SimpleFootballPlayerCollection collection = new SimpleFootballPlayerCollectionImpl(TEST_MAX_SIZE);

		if (collection.size() != 0) {
			System.err.println("TEST FAILED: Check current collection size!!");
		}

		for (int i = 0; i < 2 * TEST_MAX_SIZE; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, "", 1, 1, PlayingPosition.GK);
				collection.add(sequentialPlayer);
		}
		if(collection.size() > TEST_MAX_SIZE){
			System.err.println("TEST FAILED: Check collection max size!!");
		}

		//ignore printed system errors displayed from another classes, as described in instructions.
		System.out.println("This is only valid message that should be displayed from this main!!!!");
	}

}
