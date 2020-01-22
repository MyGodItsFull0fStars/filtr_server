package io.gottaofast.images;

import io.gottaofast.filters.filter.Filters;

import java.util.List;

public class ProcessRequest {
    private final String image;
    private final Filters filterID;
    private final List<FilterConfig> filterSettings;

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
