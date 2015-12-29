package fr.obeo.dsl.mindstorms.robots;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import fr.obeo.dsl.mindstorms.behaviors.AvoidObstacle;
import fr.obeo.dsl.mindstorms.behaviors.GoForward;
import fr.obeo.dsl.mindstorms.behaviors.GrabBottle;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Robot3 extends AbstractRobot {
	final static AbstractRobot robot = new Robot3(120000); // 2 minutes game time 

	public Robot3(int gameTime) {
		super(gameTime);
	}

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {

		definedSequenceOfActions();
		
		
		System.out.println("End of behaviors");
		definedSequenceOfActions();
		
	}
	
	public void definedSequenceOfActions() {
		// Go forward
		robot.goForward();
		// When the touch sensor detects something, try to grab it and return to its base
		boolean touchSensorIsPressed = false;
		while(touchSensorIsPressed == false) {
			touchSensorIsPressed = robot.touchSensorIsPressed();
			if (touchSensorIsPressed) {
				robot.grab();
				robot.returnToBase();
				while (robot.isMoving()) {
					Thread.yield();
				}
			}
		}
		// Release object in the base, backward on 20 cm, and then rotate randomly between 0 to 360 degrees.
		robot.release();
		robot.goBackward(20);
		robot.rotateRandomly();
	}
	
	public void behavior1() {
		List<Behavior> behaviors = new ArrayList<Behavior>();
		behaviors.add(new GoForward(robot));
		behaviors.add(new GrabBottle(robot));
		behaviors.add(new AvoidObstacle(robot));
		// If all behaviors are inactive, then arbitrator stops.
		Arbitrator arbitrator = new Arbitrator((Behavior[]) behaviors.toArray(new Behavior[behaviors.size()]), true);
		arbitrator.start();
	}
	
	public void behavior2() {
		List<Behavior> behaviors = new ArrayList<Behavior>();
		behaviors.add(new GoForward(robot));
		behaviors.add(new GrabBottle(robot));
		behaviors.add(new AvoidObstacle(robot));
		// If all behaviors are inactive, then arbitrator stops.
		Arbitrator arbitrator = new Arbitrator((Behavior[]) behaviors.toArray(new Behavior[behaviors.size()]), true);
		arbitrator.start();
	}

}
