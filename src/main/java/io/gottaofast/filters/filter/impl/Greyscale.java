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
    private static final String PREVIEW_URL = "https://qph.fs.quoracdn.net/main-qimg-28267274974ef4445d4e0464e2d382f1.webp";

    public Greyscale() {
        filterModel = new FilterModel(Filters.GREYSCALE, NAME, PREVIEW_URL, new ArrayList<>());
    }

    @Override
    public BufferedImage apply(BufferedImage image, List<FilterSetting> settings) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int currentPixel = image.getRGB(x, y);

                int alpha = (currentPixel >> 24) & 0xff;
                int red = (currentPixel >> 16) & 0xff;
                int green = (currentPixel >> 8) & 0xff;
                int blue = currentPixel & 0xff;

                // get average over all color channels
                int avg = (red + green + blue) / 3;

                //replace RGB value with avg
                currentPixel = (alpha << 24) | (avg << 16) | (avg << 8) | avg;

                image.setRGB(x, y, currentPixel);
            }
        }

        return image;
    }
}
