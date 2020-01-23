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
 * LMAO YEET *dabs on dem haters*
 */
public class DeepFry extends AbstractFilter {
    private static final String NAME = "Deep Fry";
    private static final String PREVIEW_URL = "https://i.redd.it/9bz79emmb1z31.jpg";

    public DeepFry() {
        FilterSettingSlider jpegRepetitions = new FilterSettingSlider("JPEG Repetitions", "0", "10", 0, 10, 2, 1);
        FilterSettingSlider jpegQuality = new FilterSettingSlider("JPEG Quality", "0", "100", 0, 100, 50, 5);
        FilterSettingSlider sharpen = new FilterSettingSlider("Sharpen", "0", "100", 0, 100, 50, 5);

        ArrayList<FilterSetting> settings = new ArrayList<>();
        settings.add(jpegQuality);
        settings.add(jpegRepetitions);
        settings.add(sharpen);

        filterModel = new FilterModel(Filters.DEEPFRY, NAME, PREVIEW_URL, settings);
    }

    @Override
    public BufferedImage apply(BufferedImage image, List<FilterSetting> settings) {
        return null;
    }
}
