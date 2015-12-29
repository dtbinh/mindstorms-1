package fr.obeo.dsl.mindstorms.behaviors;

import java.util.concurrent.ThreadLocalRandom;

import fr.obeo.dsl.mindstorms.AbstractRobot;

public class AvoidObstacle extends RobotBehavior {

	public AvoidObstacle(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return stop == false && robot.obstacleDetected();
	}

	@Override
	public void action() {
		suppressed = false;
		robot.goBackward(20);
		robot.rotate(ThreadLocalRandom.current().nextDouble(0, 360 + 1));
		while (robot.isMoving() && !suppressed) {
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}