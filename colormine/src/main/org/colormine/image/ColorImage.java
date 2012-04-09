package org.colormine.image;

import java.awt.image.BufferedImage;

/**
 * Simple wrapper for BufferedImage that implements the Image interface.
 */

public class ColorImage implements Image {

	private BufferedImage _image;

	/**
	 * Create from BufferedImage
	 * 
	 * @param image
	 */
	public ColorImage(BufferedImage image) {
		_image = image;
	}

	/**
	 * Gets image width
	 * 
	 * @return image width
	 */
	@Override
	public int getWidth() {
		return _image.getWidth();
	}

	/**
	 * Gets image height
	 * 
	 * @return image height
	 */
	@Override
	public int getHeight() {
		return _image.getHeight();
	}

	/**
	 * Gets Rgb value of the pixel located at the position specified by x, y
	 * 
	 * @param x
	 * @param y
	 * @return integer representation of the rgb value
	 */
	@Override
	public int getRGB(int x, int y) {
		return _image.getRGB(x, y);
	}

}