package io.gottaofast.images.model.response;

/**
 * The response for a request to /images/id/{imageID} that sends the encoded image back to the client
 */
public class IDResponse {
    private final String image;

    /**
     * Create a new IDResponse
     * @param image The base64 encoded image
     */
    public IDResponse(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
