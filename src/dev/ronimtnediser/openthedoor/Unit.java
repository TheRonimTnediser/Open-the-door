package dev.ronimtnediser.openthedoor;

public class Unit {
	public static float x;
	public static float y;

	public Unit(float width, float height, float tilesX, float tilesY) {
		x = width / tilesX;
		y = height / tilesY;
	}

}
