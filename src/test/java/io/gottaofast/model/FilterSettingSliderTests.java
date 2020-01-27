package io.gottaofast.model;

import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingSlider;
import io.gottaofast.filters.model.setting.SettingTypes;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilterSettingSliderTests {

    @Test
    public void testConstructor_basicInitialization() {
        FilterSetting filterSetting = new FilterSettingSlider("Name", "min", "max", 0, 100, 50, 3);
        // object must not be null and of correct SettingTypes type
        assertNotNull(filterSetting);
        assertEquals(SettingTypes.SLIDER, filterSetting.getType());
    }

    @Test
    public void testGetter_returnCorrectValue() {
        // given
        String name = "name";
        String minText = "min";
        String maxText = "max";
        int minValue = 0;
        int maxValue = 100;
        int actValue = 50;
        double steps = 1;

        // when
        FilterSettingSlider slider = new FilterSettingSlider(name, minText, maxText, minValue, maxValue, actValue, steps);

        // then
        // object not null
        assertNotNull(slider);

        // name not null and same as in given name
        assertNotNull(slider.getName());
        assertEquals(name, slider.getName());

        // minText of object not null and equal to given minText
        assertNotNull(slider.getMinText());
        assertEquals(minText, slider.getMinText());

        // maxText of object not null and equal to given maxText
        assertNotNull(slider.getMaxText());
        assertEquals(maxText, slider.getMaxText());

        // minValue of object not null and equal to given minValue
        assertNotNull(slider.getMinValue());
        assertEquals(minValue, slider.getMinValue());

        // maxValue of object not null and equal to given maxValue
        assertNotNull(slider.getMaxValue());
        assertEquals(maxValue, slider.getMaxValue());

        // actValue of object not null and equal to given actValue
        assertNotNull(slider.getActValue());
        assertEquals(actValue, slider.getActValue());

        // steps of object not null and equal to given steps
        assertNotNull(slider.getSteps());
        assertEquals(steps, slider.getSteps());
    }
}
