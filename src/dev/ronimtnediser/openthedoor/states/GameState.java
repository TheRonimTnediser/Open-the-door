package dev.ronimtnediser.openthedoor.states;

import java.awt.Graphics;

import dev.ronimtnediser.openthedoor.Game;
import dev.ronimtnediser.openthedoor.entities.objects.Door;
import dev.ronimtnediser.openthedoor.entities.objects.Picture;
import dev.ronimtnediser.openthedoor.entities.objects.Room;
import dev.ronimtnediser.openthedoor.gfx.Assets;
import dev.ronimtnediser.openthedoor.gfx.ImageLoader;

public class GameState extends State {

	private Room room;

	public GameState(Game game) {
		super(game);
		
		room = new Room(game, game.getWidth(), game.getHeight(), Assets.stone_wall,Assets.wood_floor);
		
		room.addObjects(new Door(game, game.getWidth() / 8 * 1F, game.getHeight() / 7 * 1, game.getWidth() / 8 * 2,
				game.getHeight() / 7 * 2, Assets.door));
		
		room.addObjects(new Door(game, game.getWidth() / 8 * 5F, game.getHeight() / 7 * 1, game.getWidth() / 8 * 2,
				game.getHeight() / 7 * 2, Assets.door));
		
		room.addObjects(new Picture(game, (3 + 1F/16*8), (1 + 1F/16*2), 1, 1, Assets.beach_picture));
	}

	@Override
	public void tick() {
		room.tick();
	}

	@Override
	public void render(Graphics g) {
		room.render(g);

		if(room.getObjects().get(0).collided(room.getObjects().get(1))) {
			System.out.println("Col");
		}
		
//		for (int i = 0; i < 8; i++) {
//			g.drawLine((int) game.getWidth() / 8 * i, 0, (int) game.getWidth() / 8 * i, (int) game.getHeight());
//			g.drawLine(0, (int) game.getHeight() / 7 * i, (int) game.getWidth(), (int) game.getHeight() / 7 * i);
//		}
	}
}
