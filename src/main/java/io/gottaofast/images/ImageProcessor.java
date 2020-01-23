package io.gottaofast.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

/**
 * A helper class that provides some useful methods for storing, retrieving, encoding and decoding images
 */
public class ImageProcessor {
    private static final String IMAGE_DIRECTORY_PATH = "image_storage";
    private static final String IMAGE_FILE_TYPE = "jpg"; // use png internally to keep compression artifacts low

    /**
     * Decodes a base64 String into a BufferedImage
     * @param image The base64 encoded image
     * @return  The decoded image or a BufferedImage of size 0x0 in case of an error
     */
    public static BufferedImage base64ToImage(String image) {
        BufferedImage bufferedImage = null;
        byte[] imageBytes;

        imageBytes = Base64.getDecoder().decode(image);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        try {
            bufferedImage = ImageIO.read(bis);
            bis.close();
        } catch (IOException e) {
            return new BufferedImage(0, 0, 0);
        }

        return bufferedImage;
    }

    /**
     * Encodes a BufferedImage into a base64 String
     * @param image The BufferedImage to encode
     * @return The base64 encoded image or an empty String in case of an error
     */
    public static String imageToBase64(BufferedImage image) {
        byte[] imageBytes = null;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, IMAGE_FILE_TYPE, bos);
            imageBytes = bos.toByteArray();
            bos.close();
        } catch (IOException e) {
            return "";
        }

        return Base64.getEncoder().encodeToString(imageBytes);
    }

    /**
     * Saves an image to the image storage with imageID as a file name
     * @param image The image to save
     * @param imageID The imageID
     * @return true if the image was saved correctly, false otherwise
     */
    public static boolean saveImageToFiles(BufferedImage image, String imageID) {
        // TODO: Sanitize imageID so access to ../../../something/malicious is restricted
        File outFile = new File(String.format("%s/%s.%s", IMAGE_DIRECTORY_PATH, imageID, IMAGE_FILE_TYPE));
        try {
            ImageIO.write(image, IMAGE_FILE_TYPE, outFile);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * Loads the image with the given imageID from the image storage
     * @param imageID The imageID of the desired image
     * @return The retrieved image or a new BufferedImage of size 0x0 in case the image was not found
     */
    public static BufferedImage loadImageFromFiles(String imageID) {
        // TODO: Sanitize imageID so access to ../../../something/malicious is restricted
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(String.format("%s/%s.%s", IMAGE_DIRECTORY_PATH, imageID, IMAGE_FILE_TYPE)));
        } catch (IOException e) {
            return new BufferedImage(0, 0, 0);
        }
        return image;
    }

    /**
     * Directly save a base64 encoded image to the file storage
     * @param base64Image The base64 encoded image
     * @param imageID The imageID to use
     * @return true if the image was written successfully, false otherwise
     */
    public static boolean saveImageToFiles(String base64Image, String imageID) {
        return saveImageToFiles(base64ToImage(base64Image), imageID);
    }

    /**
     * Directly load an image from the image storage as a base64 String
     * @param imageID The image to retrieve
     * @return the base64 encoded image, or an empty String in case of failure
     */
    public static String loadBase64ImageFromFiles(String imageID) {
        return imageToBase64(loadImageFromFiles(imageID));
    }
}
