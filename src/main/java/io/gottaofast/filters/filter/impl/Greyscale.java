package io.gottaofast.filters.filter.impl;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.filters.filter.AbstractFilter;
import io.gottaofast.filters.model.FilterModel;
import io.gottaofast.filters.model.setting.FilterSetting;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Greyscale extends AbstractFilter {
    private static final String NAME = "Greyscale";
    private static final String PREVIEW_URL = "https://i.redd.it/cmi9z289res11.jpg";

    public Greyscale() {
        filterModel = new FilterModel(Filters.GREYSCALE, NAME, PREVIEW_URL, new ArrayList<>());
    }

    @Override
    public BufferedImage apply(BufferedImage image, List<FilterSetting> settings) {
        return null;
    }
}
