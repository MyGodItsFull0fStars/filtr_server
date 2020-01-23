package io.gottaofast.filters.filter.impl;

import io.gottaofast.filters.filter.AbstractFilter;
import io.gottaofast.filters.filter.Filters;
import io.gottaofast.filters.model.FilterModel;
import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingSlider;
import io.gottaofast.images.model.FilterConfig;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jpegify extends AbstractFilter {

    private static final String NAME = "JPEG-ify";
    private static final String PREVIEW_URL = "https://upload.wikimedia.org/wikipedia/commons/b/b4/Asterisk_with_jpg-artefacts.png";

    public Jpegify() {

        filterModel = new FilterModel(Filters.JPEGIFY, NAME, PREVIEW_URL, new ArrayList<>());
    }

    @Override
    public BufferedImage apply(BufferedImage image, List<FilterSetting> settings) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter writer = iter.next();
        ImageWriteParam iwp = writer.getDefaultWriteParam();
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        iwp.setCompressionQuality(0.1f);

        try {
            writer.setOutput(ImageIO.createImageOutputStream(bos));
            writer.write(null, new IIOImage(image ,null,null),iwp);
            return ImageIO.read(new ByteArrayInputStream(bos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.dispose();

        return new BufferedImage(0, 0, 0);
    }
}
