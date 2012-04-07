package org.colormine.profile;

import java.awt.image.BufferedImage;

public class ColoredImage implements IColoredImage {

	private BufferedImage _image;

	public ColoredImage(BufferedImage image) {
		_image = image;
	}

	@Override
	public int getWidth() {
		return _image.getWidth();
	}

	@Override
	public int getHeight() {
		return _image.getHeight();
	}

	@Override
	public int getRGB(int x, int y) {
		return _image.getRGB(x, y);
	}

}