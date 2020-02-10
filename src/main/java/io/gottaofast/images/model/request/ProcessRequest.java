package io.gottaofast.images.model.request;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.images.model.FilterConfig;

import java.util.List;

/**
 * The model class for a process request.
 * The information supplied in a request to /filters/process/ gets mapped in this class
 */
public class ProcessRequest {
    private final String image;
    private final Filters filterID;
    private final List<FilterConfig> filterSettings;

    /**
     * Create a ProcessRequest that contains all relevant information
     * @param image The base64 encoded image
     * @param filterID The filter to apply to the supplied image
     * @param filterSettings All FilterConfigs for the specified filter
     */
    public ProcessRequest(String image, Filters filterID, List<FilterConfig> filterSettings) {
        this.image = image;
        this.filterID = filterID;
        this.filterSettings = filterSettings;
    }

    public String getImage() {
        return image;
    }

    public Filters getFilterID() {
        return filterID;
    }

    public List<FilterConfig> getFilterSettings() {
        return filterSettings;
    }
}
