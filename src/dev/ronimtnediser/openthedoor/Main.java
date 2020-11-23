package dev.ronimtnediser.openthedoor;

public class Main {

	public static void main(String[] args) {
		float tilesX = 8;
		float tilesY = 7;
		float width = 800;
		float height = width / tilesX * tilesY;
		Game game = new Game(width, height, "title");
		new Unit(game.getWidth(), game.getHeight(), tilesX, tilesY);
		
		game.start();
	}

}
