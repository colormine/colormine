package org.colormine.image;

/**
 * Defines a common interface for dealing with different types of images
 * 
 */
public interface Image {
	/**
	 * Gets image width
	 * 
	 * @return image width
	 */
	int getWidth();

	/**
	 * Gets image height
	 * 
	 * @return image height
	 */
	int getHeight();

	/**
	 * Get Rgbs value of the pixel located at the position specified by x, y
	 * 
	 * @param x
	 * @param y
	 * @return integer representation of the rgb value
	 */
	int getRGB(int x, int y);
}
