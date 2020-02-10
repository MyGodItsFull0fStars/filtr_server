package io.gottaofast.model;

import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingSlider;
import io.gottaofast.filters.model.setting.SettingTypes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilterSettingSliderTests {

    String defaultName;
    String defaultMinText;
    String defaultMaxText;
    double defaultMinValue;
    double defaultMaxValue;
    double defaultActValue;
    double defaultSteps;

    @Before
    public void setup() {
        // default settings
        defaultName = "name";
        defaultMinText = "min";
        defaultMaxText = "max";
        defaultMinValue = 0;
        defaultMaxValue = 100;
        defaultActValue = 50;
        defaultSteps = 1;
    }

    @Test(expected = Test.None.class) /* no exception expected */
    public void testConstructor_basicInitialization() {
        FilterSetting filterSetting = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        // object must not be null and of correct SettingTypes type
        assertNotNull(filterSetting);
        assertEquals(SettingTypes.SLIDER, filterSetting.getType());
    }


    @Test(expected = Test.None.class) /* no exception expected */
    public void testConstructor_invalidValuesYieldDefaultValues() {
        FilterSettingSlider filterSetting = new FilterSettingSlider(null, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotNull(filterSetting);
        assertEquals("", filterSetting.getName());

        filterSetting = new FilterSettingSlider(defaultName, null, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotNull(filterSetting);
        assertEquals("min", filterSetting.getMinText());

        filterSetting = new FilterSettingSlider(defaultName, defaultMinText, null, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotNull(filterSetting);
        assertEquals("max", filterSetting.getMaxText());

        filterSetting = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, -1, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotNull(filterSetting);
        assertEquals(defaultMinText, filterSetting.getMinText());
        assertEquals(defaultMaxText, filterSetting.getMaxText());
        assertEquals(defaultMinValue, filterSetting.getMinValue());
        assertEquals(defaultMaxValue, filterSetting.getMaxValue());
        assertEquals(defaultActValue, filterSetting.getActValue());

        filterSetting = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, -1, defaultActValue, defaultSteps);
        assertNotNull(filterSetting);
        assertEquals(defaultMinText, filterSetting.getMinText());
        assertEquals(defaultMaxText, filterSetting.getMaxText());
        assertEquals(defaultMinValue, filterSetting.getMinValue());
        assertEquals(defaultMaxValue, filterSetting.getMaxValue());
        assertEquals(defaultActValue, filterSetting.getActValue());

        filterSetting = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, -defaultMaxValue, defaultMinValue - 1, defaultSteps);
        assertNotNull(filterSetting);
        assertEquals(defaultMinText, filterSetting.getMinText());
        assertEquals(defaultMaxText, filterSetting.getMaxText());
        assertEquals(defaultMinValue, filterSetting.getMinValue());
        assertEquals(defaultMaxValue, filterSetting.getMaxValue());
        assertEquals(defaultActValue, filterSetting.getActValue());

        filterSetting = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, -defaultMaxValue, defaultMaxValue + 1, defaultSteps);
        assertNotNull(filterSetting);
        assertEquals(defaultMinText, filterSetting.getMinText());
        assertEquals(defaultMaxText, filterSetting.getMaxText());
        assertEquals(defaultMinValue, filterSetting.getMinValue());
        assertEquals(defaultMaxValue, filterSetting.getMaxValue());
        assertEquals(defaultActValue, filterSetting.getActValue());
    }

    @Test(expected = Test.None.class) /* no exception expected */
    public void testGetter_returnCorrectValue() {
        // when
        FilterSettingSlider slider = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);

        // then
        // object not null
        assertNotNull(slider);

        // name not null and same as in given name
        assertNotNull(slider.getName());
        assertEquals(defaultName, slider.getName());

        // minText of object not null and equal to given minText
        assertNotNull(slider.getMinText());
        assertEquals(defaultMinText, slider.getMinText());

        // maxText of object not null and equal to given maxText
        assertNotNull(slider.getMaxText());
        assertEquals(defaultMaxText, slider.getMaxText());

        // minValue of object not null and equal to given minValue
        assertEquals(defaultMinValue, slider.getMinValue());

        // maxValue of object not null and equal to given maxValue
        assertEquals(defaultMaxValue, slider.getMaxValue());

        // actValue of object not null and equal to given actValue
        assertEquals(defaultActValue, slider.getActValue());

        // steps of object not null and equal to given steps
        assertEquals(defaultSteps, slider.getSteps());
    }

    @Test(expected = Test.None.class) /* no exception expected */
    public void testEqualsMethod() {
        // given
        FilterSettingSlider slider = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        FilterSettingSlider sameSlider = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);

        // both objects must not be null
        assertNotNull(slider);
        assertNotNull(sameSlider);

        // should be asserted as equal
        assertEquals(slider, sameSlider);

        // following are different settings, which should not be equal

        // different name
        FilterSettingSlider differentSlider = new FilterSettingSlider("different name", defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotEquals(slider, differentSlider);

        // different min text
        differentSlider = new FilterSettingSlider(defaultName, "different min text", defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotEquals(slider, differentSlider);

        // different max text
        differentSlider = new FilterSettingSlider(defaultName, defaultMinText, "different max text", defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotEquals(slider, differentSlider);

        // different min value
        differentSlider = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, 1, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotEquals(slider, differentSlider);

        // different max value
        differentSlider = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, 42, defaultActValue, defaultSteps);
        assertNotEquals(slider, differentSlider);

        // different actual value
        differentSlider = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, 33, defaultSteps);
        assertNotEquals(slider, differentSlider);

        // different step size
        differentSlider = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, 5);
        assertNotEquals(slider, differentSlider);
    }

    @Test(expected = Test.None.class) /* no exception expected */
    public void testHashCode() {
        FilterSettingSlider slider = new FilterSettingSlider(defaultName, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        assertNotNull(slider);

        FilterSettingSlider sameSlider = new FilterSettingSlider(slider.getName(), slider.getMinText(), slider.getMaxText(), slider.getMinValue(), slider.getMaxValue(), slider.getActValue(), slider.getSteps());
        assertNotNull(sameSlider);

        // objects with same values should have same hash code
        assertEquals(slider.hashCode(), sameSlider.hashCode());

        // the following objects do not throw a null pointer exception when calling .hashcode() method
        FilterSettingSlider nullSlider = new FilterSettingSlider(null, defaultMinText, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        int temp = nullSlider.hashCode();

        nullSlider = new FilterSettingSlider(defaultName, null, defaultMaxText, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        temp = nullSlider.hashCode();

        nullSlider = new FilterSettingSlider(defaultName, defaultMinText, null, defaultMinValue, defaultMaxValue, defaultActValue, defaultSteps);
        temp = nullSlider.hashCode();
    }
}
