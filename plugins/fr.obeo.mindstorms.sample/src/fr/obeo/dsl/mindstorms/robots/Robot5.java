package fr.obeo.dsl.mindstorms.robots;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import fr.obeo.dsl.mindstorms.behaviors.AvoidObstacle;
import fr.obeo.dsl.mindstorms.behaviors.GoRectangle;
import fr.obeo.dsl.mindstorms.behaviors.GrabBottle;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * Full behavior robot.
 */
public class Robot5 extends AbstractRobot {
	final static AbstractRobot robot = new Robot5(120000); // 2 minutes game time 

	public Robot5(int gameTime) {
		super(gameTime);
	}

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {
		List<Behavior> behaviors = new ArrayList<Behavior>();
		behaviors.add(new GoRectangle(robot));
		behaviors.add(new GrabBottle(robot));
		behaviors.add(new AvoidObstacle(robot));
		Arbitrator arbitrator = new Arbitrator((Behavior[]) behaviors.toArray(new Behavior[behaviors.size()]));
		arbitrator.start();
		
	}
}
