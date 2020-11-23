package dev.ronimtnediser.openthedoor.entities.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.ronimtnediser.openthedoor.Game;
import dev.ronimtnediser.openthedoor.gfx.Assets;

public class Room extends Object {

	private BufferedImage wall;
	private BufferedImage floor;

	private ArrayList<Object> objects = new ArrayList<>();

	public Room(Game game, float width, float height, BufferedImage wall, BufferedImage floor) {
		super(game, 0, 0, width, height);

		this.wall = wall;
		this.floor = floor;
	}

	public void setObjects(Object object, int index) {
		objects.set(index, object);
	}

	public void addObjects(Object object) {
		objects.add(object);
	}

	public ArrayList<Object> getObjects() {
		return objects;
	}

	// ADDING OBJECTS

	public void addWoodenDoor(float x, float y, float width, float height) {
		Door door = new Door(game, game.getWidth() * x, game.getHeight() * y, width, height, Assets.door);
		objects.add(door);
	}

	@Override
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).tick();
		}
	}

	@Override
	public void render(Graphics g) {
		for (int y = 0; y < 2; y++) {
			for (int x = 0; x < 4; x++) {
				g.drawImage(wall, (int) (this.x + width / 8 * x * 2), (int) (this.y + height / 7 * y * 2), 200, 200,
						null);
			}
		}
		for (int y = 0; y < 2; y++) {
			for (int x = 0; x < 4; x++) {
				g.drawImage(floor, (int) (this.x + width / 8 * x * 2),
						(int) (this.y + height / 7 * y * 2 + height / 7 * 3), 200, 200, null);
			}
		}
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g);
		}
	}
}
