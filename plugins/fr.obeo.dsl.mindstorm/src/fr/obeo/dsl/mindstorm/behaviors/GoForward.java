package fr.obeo.dsl.mindstorm.behaviors;

import fr.obeo.dsl.mindstorm.AbstractRobot;

public class GoForward extends RobotBehavior {

	public GoForward(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return stop == false && true;
	}

	@Override
	public void action() {
		suppressed = false;
		robot.goForward();
		while (robot.isMoving() && !suppressed) {
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
