package org.colorMine.profile;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public interface IColoredImage
{
	int getWidth();
	int getHeight();
	int getRGB(int x,int y);
}
	
