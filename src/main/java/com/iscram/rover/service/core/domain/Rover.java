package com.iscram.rover.service.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rover {

	private double positionHorizontal;
	private double positionVertical;
	private double orientationAngle;

	public double getPositionHorizontal() {
		return positionHorizontal;
	}

	public void setPositionHorizontal(double positionHorizontal) {
		this.positionHorizontal = positionHorizontal;
	}

	public double getPositionVertical() {
		return positionVertical;
	}

	public void setPositionVertical(double positionVertical) {
		this.positionVertical = positionVertical;
	}

	public double getOrientationAngle() {
		return orientationAngle;
	}

	public void setOrientationAngle(double orientationAngle) {
		this.orientationAngle = orientationAngle;
	}

}
