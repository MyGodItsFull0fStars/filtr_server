package io.gottaofast.filters.filter;

import io.gottaofast.filters.model.FilterModel;
import io.gottaofast.filters.model.setting.FilterSetting;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Abstract class with some common methods all filters will inherit from
 */
public abstract class AbstractFilter {

    protected FilterModel filterModel;

    /**
     * Returns the filter-specific FilterModel
     * @return the FilterModel
     */
    public FilterModel getFilterModel() {
        return filterModel;
    }

    /**
     * Apply the filter with its settings
     * @param image The Buffered image the filter will be applied to
     * @param settings The settings for the filter
     * @return The image with the filter applied
     */
    public abstract BufferedImage apply(BufferedImage image, List<FilterSetting> settings);
}
