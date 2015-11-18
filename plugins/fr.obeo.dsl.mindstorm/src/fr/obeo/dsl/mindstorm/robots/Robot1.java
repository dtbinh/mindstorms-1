package fr.obeo.dsl.mindstorm.robots;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.mindstorm.AbstractRobot;
import fr.obeo.dsl.mindstorm.behaviors.BringBackPoint;
import fr.obeo.dsl.mindstorm.behaviors.SearchForPoint;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Robot1 extends AbstractRobot {
	final static Robot1 robot = new Robot1();

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {
		List<Behavior> behaviors = new ArrayList<Behavior>();
		behaviors.add(new SearchForPoint(robot));
		behaviors.add(new BringBackPoint(robot));
		Arbitrator arbitrator = new Arbitrator((Behavior[]) behaviors.toArray(new Behavior[behaviors.size()]));
		arbitrator.start();
	}
}
