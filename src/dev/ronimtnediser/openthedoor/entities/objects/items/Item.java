package dev.ronimtnediser.openthedoor.entities.objects.items;

import java.awt.Graphics;

import dev.ronimtnediser.openthedoor.Game;
import dev.ronimtnediser.openthedoor.entities.objects.Object;

public abstract class Item extends Object{
	
	protected boolean interactable;
	protected boolean used;
	
	public Item(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
	}

}
