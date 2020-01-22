package io.gottaofast.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageProcessor {
    public static BufferedImage base64ToImage(String image) {
        BufferedImage bufferedImage = null;
        byte[] imageBytes;

        imageBytes = Base64.getDecoder().decode(image);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        try {
            bufferedImage = ImageIO.read(bis);
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedImage;
    }

    public static String imageToBase64(BufferedImage image) {
        byte[] imageBytes = null;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image,"jpg",  bos);
            imageBytes = bos.toByteArray();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
