package io.gottaofast.images.model.response;

import java.util.UUID;

public class ProcessResponse {
    UUID imgID;

    public ProcessResponse(UUID imgID) {
        this.imgID = imgID;
    }

    public UUID getImgID() {
        return imgID;
    }
}
