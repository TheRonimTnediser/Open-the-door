package dev.ronimtnediser.openthedoor.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static SpriteSheet door;
	public static BufferedImage stone_wall;
	public static BufferedImage wood_floor;
	
	//PICTURES
	public static BufferedImage beach_picture;
	
	public Assets() {
		door = new SpriteSheet("res/objects/door.png", 24, 32, 6);

		stone_wall = ImageLoader.load("res/tiles/stone_wall.png");
		wood_floor = ImageLoader.load("res/tiles/wood_floor.png");
		
		beach_picture = ImageLoader.load("res/objects/pictures/beach.png");
	}
}
