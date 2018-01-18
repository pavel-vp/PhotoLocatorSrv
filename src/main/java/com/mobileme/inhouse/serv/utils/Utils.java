package com.mobileme.inhouse.serv.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

import net.coobird.thumbnailator.Thumbnails;

public class Utils {

	public static void rescale(ByteArrayInputStream input, ByteArrayOutputStream output, int tw, int th) throws IOException {
		Thumbnails.of(input)
		        .size(tw, th)
		        .toOutputStream(output);
    }	

	public static void rescale2(ByteArrayInputStream input, ByteArrayOutputStream output, int tw, int th) throws IOException {
	
		BufferedImage img = ImageIO.read(input);
		
		BufferedImage thumbImg = Scalr.resize(img, Method.QUALITY,Mode.AUTOMATIC, 
            tw,
                  th, Scalr.OP_ANTIALIAS);
		ImageIO.write( thumbImg, "jpg", output );
		output.flush();
	}
}
