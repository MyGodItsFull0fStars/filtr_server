package io.gottaofast.images.controller;

import io.gottaofast.images.ImageProcessor;
import io.gottaofast.images.model.request.ProcessRequest;
import io.gottaofast.images.model.response.IDResponse;
import io.gottaofast.images.model.response.ProcessResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ImageController {
    /**
     * The <code>@GetMapping</code> annotation ensures that HTTP GET requests to <code>/filters</code>
     * are mapped to the <code>filters()</code> method.
     * <p>
     *
     * @return a new <code>FilterModel</code> object with <code>id</code>, <code>name</code> and <code>settings</code> attributes.
     * The object data will be written directly to the HTTP response as JSON.
     */
    @PostMapping("/images/process")
    public ProcessResponse process(@RequestBody ProcessRequest payload) {

        // image UUID for retrieval later
        ProcessResponse response = new ProcessResponse(UUID.randomUUID());
        ImageProcessor.saveImageToFiles(payload.getImage(), response.getImgID().toString());

        return response;
    }

    @GetMapping(value = "images/id/{imageID}")
    public IDResponse retrieve(@PathVariable String imageID) {
        return new IDResponse(ImageProcessor.loadBase64ImageFromFiles(imageID));
    }
}
