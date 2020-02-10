package io.gottaofast.images.model.response;

import java.util.UUID;

/**
 * The response for a request to /filters/process that returns the generated ID of the image.
 */
public class ProcessResponse {
    UUID imgID;

    /**
     * Create a new ProcessResponse.
     * @param imgID The ID the client can use to retrieve the image
     */
    public ProcessResponse(UUID imgID) {
        this.imgID = imgID;
    }

    public UUID getImgID() {
        return imgID;
    }
}
