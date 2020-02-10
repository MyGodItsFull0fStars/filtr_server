package io.gottaofast.filters.model.setting;

import java.util.Objects;

/**
 * A Slider setting which can take a value within a specified range
 */
public class FilterSettingSlider extends FilterSetting {

    private final String minText;
    private final String maxText;

    private final double minValue;
    private final double maxValue;

    private final double actValue;
    private final double steps;

    /**
     * Create a new FilterSettingSlider
     *
     * @param name     The name of the setting
     * @param minText  The text that will be displayed as the minimum value on the client
     * @param maxText  The text that will be displayed as the maximum value on the client
     * @param minValue The minimum value the slider can have
     * @param maxValue The maximum value the slider can have
     * @param actValue The actual value the slider is set to
     * @param steps    The step size of the slider
     */
    public FilterSettingSlider(String name, String minText, String maxText, double minValue, double maxValue, double actValue, double steps) {
        super(SettingTypes.SLIDER, name);
        if (minValue >= 0 && maxValue > minValue) {
            this.minText = minText != null ? minText : "min";
            this.maxText = maxText != null ? maxText : "max";
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.actValue = inRange(minValue, maxValue, actValue) ? actValue : Math.floor((maxValue + minValue) / 2);
        } else { // if there is an invalid value, default settings are applied
            this.minText = "min";
            this.maxText = "max";
            this.minValue = 0;
            this.maxValue = 100;
            this.actValue = 50;
        }
        this.steps = steps;
    }

    public String getMinText() {
        return minText;
    }

    public String getMaxText() {
        return maxText;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getActValue() {
        return actValue;
    }

    public double getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilterSettingSlider)) return false;
        FilterSettingSlider that = (FilterSettingSlider) o;
        return this.getName().equals(that.getName()) &&
                Double.compare(that.getMinValue(), getMinValue()) == 0 &&
                Double.compare(that.getMaxValue(), getMaxValue()) == 0 &&
                Double.compare(that.getActValue(), getActValue()) == 0 &&
                Double.compare(that.getSteps(), getSteps()) == 0 &&
                getMinText().equals(that.getMinText()) &&
                getMaxText().equals(that.getMaxText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMinText(), getMaxText(), getMinValue(), getMaxValue(), getActValue(), getSteps());
    }

    private boolean inRange(double minValue, double maxValue, double actualValue) {
        return minValue <= actualValue && actualValue <= maxValue;
    }
}
