package dev.ronimtnediser.openthedoor.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteSheet extends ArrayList<BufferedImage> {

	private String path;

	private BufferedImage sheet;
	private int imageWidth, imageHeight;
	
	private int splits;

	public SpriteSheet(String path, int imageWidth, int imageHeight,int splits) {
		this.path = path;

		this.splits = splits;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;

		this.load();
	}

	public void load() {
		sheet = ImageLoader.load(path);
		if (sheet != null) {
			for (int i = 0; i < splits; i++) {
				this.add(sheet.getSubimage(i * imageWidth, 0, imageWidth, imageHeight));
			}
		}
	}

}
