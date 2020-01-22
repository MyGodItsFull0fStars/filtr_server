package io.gottaofast.images.controller;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.images.ProcessRequest;
import io.gottaofast.images.ProcessResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class ImageController {
    String base64Image = "";
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
        base64Image = payload.getImage();
        // image UUID for retrieval later
        ProcessResponse response = new ProcessResponse(UUID.randomUUID());
        // TODO: send UUID back, get filter configuration, filter image, store filtered image at said uuid

        return response;
    }

    @GetMapping(value = "images/id/{imageID}")
    public String retrieve(@PathVariable String imageID) {
        return String.format("{\"b64\" : \"%s\"}", base64Image);
    }
}
