package dev.ronimtnediser.openthedoor.states;

import java.awt.Graphics;

import dev.ronimtnediser.openthedoor.Game;

public abstract class State {
	//CLASS
	
	public static State currentState;

	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State state) {
		currentState = state;
	}
	
	// ABSTRACT

	protected Game game;

	public State(Game game) {
		this.game = game;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}
