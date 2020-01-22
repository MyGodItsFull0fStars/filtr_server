package io.gottaofast.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageProcessor {
    private static final String IMAGE_DIRECTORY_PATH = "image_storage";
    private static final String IMAGE_FILE_TYPE = "jpg"; // use png internally to keep compression artifacts low

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
            ImageIO.write(image,IMAGE_FILE_TYPE,  bos);
            imageBytes = bos.toByteArray();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public static boolean saveImageToFiles(BufferedImage image, String imageID) {
        // TODO: Sanitize imageID so access to ../../../something/malicious is restricted
        File outFile = new File(String.format("%s/%s.%s", IMAGE_DIRECTORY_PATH, imageID, IMAGE_FILE_TYPE));
        try {
            ImageIO.write(image, IMAGE_FILE_TYPE, outFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static BufferedImage loadImageFromFiles(String imageID) {
        // TODO: Sanitize imageID so access to ../../../something/malicious is restricted
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(String.format("%s/%s.%s", IMAGE_DIRECTORY_PATH, imageID, IMAGE_FILE_TYPE)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static boolean saveImageToFiles(String base64Image, String imageID) {
        return saveImageToFiles(base64ToImage(base64Image), imageID);
    }

    public static String loadBase64ImageFromFiles(String imageID) {
        return imageToBase64(loadImageFromFiles(imageID));
    }
}
