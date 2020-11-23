package dev.ronimtnediser.openthedoor.managers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener{

	public int button;
	public boolean pressed = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		button = e.getButton();
		pressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		button = e.getButton();
		pressed = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
