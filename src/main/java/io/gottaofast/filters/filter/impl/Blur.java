package io.gottaofast.filters.filter.impl;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.filters.filter.AbstractFilter;
import io.gottaofast.filters.model.FilterModel;
import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingSlider;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * A filter that blurs the input image
 */
public class Blur extends AbstractFilter {
    private static final String NAME = "Blur";
    private static final String PREVIEW_URL = "https://www.lunapic.com/editor/premade/blur.gif";

    public Blur() {
        FilterSettingSlider intensity = new FilterSettingSlider("Intensity", "0", "100", 0, 100, 50, 5);
        ArrayList<FilterSetting> settings = new ArrayList<>();
        settings.add(intensity);

        filterModel = new FilterModel(Filters.BLUR, NAME, PREVIEW_URL, settings);
    }

    @Override
    public BufferedImage apply(BufferedImage image, List<FilterSetting> settings) {
        return null;
    }
}
