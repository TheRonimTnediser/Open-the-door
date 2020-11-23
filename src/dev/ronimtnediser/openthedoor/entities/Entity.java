package dev.ronimtnediser.openthedoor.entities;

import java.awt.Graphics;

import dev.ronimtnediser.openthedoor.Game;

public abstract class Entity {
	//ABSTRACT
	protected Game game;
	
	public Entity(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
