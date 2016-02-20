package com.csmckelvey.conway.util;

import java.util.Arrays;

public class ConwayConstants {

	//Constant Comment
	public static final int MAX_CELL_DISTANCE = 90;
	
	public static final int SLOW_SPEED_DELAY = 500;
	public static final int MEDIUM_SPEED_DELAY = 250;
	public static final int FAST_SPEED_DELAY = 50;
	public static final int NUCLEAR_SPEED_DELAY = 0;
	
	public static final int SMALLVIEW_NUM_ROWSCOLS = 40;
	public static final int NORMALVIEW_NUM_ROWSCOLS = 80;
	public static final int LARGEVIEW_NUM_ROWSCOLS = 160;
	
	public static final int SMALL_RANDOM_NUM_ROWSCOLS = 200;
	public static final int NORMAL_RANDOM_NUM_ROWSCOLS = 500;
	public static final int LARGE_RANDOM_NUM_ROWSCOLS = 2000;
	
	private static final String[] VIEWSIZES = { "Small", "Normal", "Large" };
	private static final String[] SHAPES = { "Glider", "Glider Gun", "Glider Cyclone", "Random" };
	private static final String[] SPEEDS = { "Slow         500ms", "Medium   250ms", "Fast           50ms", "Nuclear     0ms" };

	
	public static String[] getShapes() {
		return Arrays.copyOf(SHAPES, SHAPES.length);
	}
	
	public static String[] getSpeeds() {
		return Arrays.copyOf(SPEEDS, SPEEDS.length);
	}
	
	public static String[] getViewSizes() {
		return Arrays.copyOf(VIEWSIZES, VIEWSIZES.length);
	}
}
