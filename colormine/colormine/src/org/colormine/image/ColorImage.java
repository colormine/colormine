package org.colormine.image;

import java.awt.image.BufferedImage;

/**
 * Simple wrapper for BufferedImage that implements Image
 */

public class ColorImage implements Image {

	private BufferedImage _image;

	public ColorImage(BufferedImage image) {
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