package dev.ronimtnediser.openthedoor.managers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionManager implements MouseMotionListener {

	public int x = 0,y = 0;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

}
