package io.gottaofast.filters.model;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.filters.model.setting.FilterSetting;

import java.util.ArrayList;
import java.util.List;

/**
 * A model that contains all information for a filter
 */
public class FilterModel {
    private final Filters id;
    private final String name;
    private final String imgUrl;
    private List<FilterSetting> filterSettings;


    /**
     * Create a FilterModel that contains all relevant information for a filter
     * @param id The Filters ID that identifies the filter type
     * @param name The filter name
     * @param imgUrl The URL for the preview image
     * @param filterSettings A list containing all relevant settings for the filter
     */
    public FilterModel(Filters id, String name, String imgUrl, List<FilterSetting> filterSettings) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.filterSettings = filterSettings;
    }

    /**
     * Create a FilterModel that contains all relevant information for a filter.
     * This creates an empty settings list, in case the filter has no additional settings
     * @param id The Filters ID that identifies the filter type
     * @param name The filter name
     * @param imgUrl The URL for the preview image
     */
    public FilterModel(Filters id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.filterSettings = new ArrayList<>();
    }

    public Filters getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<FilterSetting> getFilterSettings() {
        return filterSettings;
    }

    public void addFilterSetting(FilterSetting filterSetting) {
        filterSettings.add(filterSetting);
    }
}
