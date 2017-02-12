package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.Coach;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;

public class CoachTest {

	public static void main(String[] args) {

		Coach defaultCoach = new Coach();
		Coach mainCoach = new Coach("Main", Constants.DEFAULT_COUNTRY, 1, 1, Formation.F352);
		Coach helpCoach = new Coach();

		if (defaultCoach.equals(null)) {
			System.err.println("TEST FAILED: Coach is null");
		}

		if (mainCoach.equals(defaultCoach)) {
			System.err.println("TEST FAILED: Default and Main coach must be different");
		}

		helpCoach.setCoachingSkill(10);
		helpCoach.setEmotion(10);
		if (!defaultCoach.equals(helpCoach)) {
			System.err.println("TEST FAILED: Wrong comparison of coaches.");
		}
		
		Coach wrongCoach = new Coach(null, null, -5, 150, Formation.F541);
		if(wrongCoach.getName()==null || 
				wrongCoach.getCountry() == null || 
				wrongCoach.getEmotion() <0 ||
				wrongCoach.getCoachingSkill() > 100){
			System.err.println("TEST FAILED: Coach values must be in boundries!!");
		}

		//ignore printed system errors displayed from another classes, as described in instructions.
		System.out.println("This is only valid message that should be displayed from this main!!!!");


	}
}
