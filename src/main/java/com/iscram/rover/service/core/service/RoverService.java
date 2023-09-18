package com.iscram.rover.service.core.service;

import com.iscram.rover.service.core.domain.Rover;
import com.iscram.rover.service.core.domain.RoverCommand;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;



@ApplicationScoped
public class RoverService {
	public static final Logger LOGGER = LoggerFactory.getLogger(RoverService.class);

	public static final double ROTATION_ANGLE_WIDTH = 360.0 / 12;
	public static final double MOVE_STEP_WIDTH = 1.0;
	public static final double ACCURACY = 1.0;

	public static final BiFunction<Double, Double, Double> ADD_VALUES = (value, change) -> value + change;
	public static final BiFunction<Double, Double, Double> SUBTRACT_VALUES = (value, change) -> value - change;

	public Rover executeCommand(Rover roverState, RoverCommand roverCommand) {

		if (roverCommand == RoverCommand.ROTATE_LEFT) {
			return rotateLeft(roverState);
		} else if (roverCommand == RoverCommand.ROTATE_RIGHT) {
			return rotateRight(roverState);
		} else if (roverCommand == RoverCommand.MOVE_FORWARD) {
			return moveForward(roverState);
		} else if (roverCommand == RoverCommand.MOVE_BACKWARD) {
			return moveBackward(roverState);
		}

		return roverState;
	}

	private Rover rotateRight(Rover roverState) {
		return rotate(roverState, ADD_VALUES);
	}

	private Rover rotateLeft(Rover roverState) {
		return rotate(roverState, SUBTRACT_VALUES);
	}

	private Rover rotate(Rover roverState, BiFunction<Double, Double, Double> applyRotation) {

		Rover newRoverState = new Rover();

		newRoverState.setPositionHorizontal(roverState.getPositionHorizontal());
		newRoverState.setPositionVertical(roverState.getPositionVertical());
		newRoverState.setOrientationAngle(applyRotation.apply(roverState.getOrientationAngle(), ROTATION_ANGLE_WIDTH));

		LOGGER.info("rotate {} results in {}", reflectionToString(roverState), reflectionToString(newRoverState));

		return newRoverState;
	}

	private Rover moveForward(Rover roverState) {
		return move(roverState, ADD_VALUES);
	}

	private Rover moveBackward(Rover roverState) {
		return move(roverState, SUBTRACT_VALUES);
	}

	private Rover move(Rover roverState, BiFunction<Double, Double, Double> applyMovement) {

		double radianMeasure = roverState.getOrientationAngle() / 180.0 * Math.PI;
		double horizontalMovement = round(Math.sin(radianMeasure) * MOVE_STEP_WIDTH, ACCURACY);
		double verticalMovement = round(Math.cos(radianMeasure) * MOVE_STEP_WIDTH, ACCURACY);

		Rover newRoverState = new Rover();
		newRoverState
				.setPositionHorizontal(applyMovement.apply(roverState.getPositionHorizontal(), horizontalMovement));
		newRoverState.setPositionVertical(applyMovement.apply(roverState.getPositionVertical(), verticalMovement));
		newRoverState.setOrientationAngle(roverState.getOrientationAngle());

		LOGGER.info("move {} results in {}", reflectionToString(roverState), reflectionToString(newRoverState));

		return newRoverState;
	}

	private double round(double value, double scale) {
		double scaleFactor = Math.pow(10, scale);
		return Math.round(value * scaleFactor) / Math.pow(10, scale);
	}
}
