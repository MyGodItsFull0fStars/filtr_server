package io.gottaofast.filters.filter.impl;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.filters.filter.AbstractFilter;
import io.gottaofast.filters.model.FilterModel;
import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingCheckbox;
import io.gottaofast.filters.model.setting.FilterSettingSlider;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class EdgeDetection extends AbstractFilter {
    private static final String NAME = "Edge Detection";
    private static final String PREVIEW_URL = "http://www.ctralie.com/Teaching/EdgeCornerBlob/lenatl0.05/image.png";

    public EdgeDetection() {
        FilterSettingSlider intensity = new FilterSettingSlider("Intensity", "0", "100", 0, 100, 50, 5);
        FilterSettingCheckbox greyScale = new FilterSettingCheckbox("Greyscale", false);
        ArrayList<FilterSetting> settings = new ArrayList<>();
        settings.add(intensity);
        settings.add(greyScale);

        filterModel = new FilterModel(Filters.EDGEDETECTION, NAME, PREVIEW_URL, settings);
    }

    @Override
    public BufferedImage apply(BufferedImage image, List<FilterSetting> settings) {
        return null;
    }
}
