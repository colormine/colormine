package org.colormine.image;

import java.awt.image.BufferedImage;

/**
 * Simple wrapper for BufferedImage that implements the Image interface.
 */

public class ColorImage implements Image {

	private BufferedImage _image;

	/**
	 * Create from BufferedImage.
	 * 
	 * @param image
	 */
	public ColorImage(BufferedImage image) {
		_image = image;
	}

	/**
	 * Get image width.
	 * 
	 * @return
	 */
	@Override
	public int getWidth() {
		return _image.getWidth();
	}

	/**
	 * Get image height.
	 * 
	 * @return
	 */
	@Override
	public int getHeight() {
		return _image.getHeight();
	}

	/**
	 * Get Rgb value of a pixel specified by it's x and y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	@Override
	public int getRGB(int x, int y) {
		return _image.getRGB(x, y);
	}

}