package io.gottaofast.images.controller;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.filters.filter.impl.Greyscale;
import io.gottaofast.filters.filter.impl.Jpegify;
import io.gottaofast.images.ImageProcessor;
import io.gottaofast.images.model.request.ProcessRequest;
import io.gottaofast.images.model.response.IDResponse;
import io.gottaofast.images.model.response.ProcessResponse;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.UUID;

/**
 * A REST Controller used for uploading images, configuring the filters and retrieving the final image
 */
@RestController
public class ImageController {
    private static final String FILE_SUFFIX_ORIGINAL = "_original";
    /**
     * The <code>@PostMapping</code> annotation ensures that HTTP POST requests to <code>/images/process</code>
     * are mapped to the <code>process()</code> method.
     * <p>
     *
     * @return a new <code>ProcessResponse</code> object with the <code>imgID</code> attribute.
     * The object data will be written directly to the HTTP response as JSON.
     */
    @PostMapping("/images/process")
    public ProcessResponse process(@RequestBody ProcessRequest payload) {

        // image UUID for retrieval later
        ProcessResponse response = new ProcessResponse(UUID.randomUUID());
        ImageProcessor.saveImageToFiles(payload.getImage(), response.getImgID().toString()+FILE_SUFFIX_ORIGINAL);

        Filters chosenFilter = payload.getFilterID();
        if (chosenFilter == Filters.GREYSCALE) {
            Greyscale g = new Greyscale();
            BufferedImage filteredImage = g.apply(ImageProcessor.loadImageFromFiles(response.getImgID().toString()+FILE_SUFFIX_ORIGINAL), null);
            ImageProcessor.saveImageToFiles(filteredImage, response.getImgID().toString());
        } else if (chosenFilter == Filters.JPEGIFY) {
            Jpegify g = new Jpegify();
            BufferedImage filteredImage = g.apply(ImageProcessor.loadImageFromFiles(response.getImgID().toString()+FILE_SUFFIX_ORIGINAL), null);
            ImageProcessor.saveImageToFiles(filteredImage, response.getImgID().toString());
        }

        return response;
    }

    /**
     * The <code>@GetMapping</code> annotation ensures that HTTP POST requests to <code>/images/id/{imageID}</code>
     * are mapped to the <code>process()</code> method.
     * <p>
     *
     * @return a new <code>IDResponse</code> object with the <code>image</code> attribute that stores the final image
     * as a base64 String.
     * The object data will be written directly to the HTTP response as JSON.
     */
    @GetMapping(value = "images/id/{imageID}")
    public IDResponse retrieve(@PathVariable String imageID) {
        return new IDResponse(ImageProcessor.loadBase64ImageFromFiles(imageID));
    }
}
