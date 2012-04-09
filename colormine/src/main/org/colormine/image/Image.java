package org.colormine.image;

/**
 * Defines a common interface for dealing with different types of images
 * 
 */
public interface Image {
	/**
	 * Get image width.
	 * 
	 * @return
	 */
	int getWidth();

	/**
	 * Get image height;
	 * 
	 * @return
	 */
	int getHeight();

	/**
	 * Get Rgb value of a pixel specified by it's x and y coordinates.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int getRGB(int x, int y);
}
