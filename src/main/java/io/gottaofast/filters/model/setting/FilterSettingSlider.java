package io.gottaofast.filters.model.setting;

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
     * @param name The name of the setting
     * @param minText The text that will be displayed as the minimum value on the client
     * @param maxText The text that will be displayed as the maximum value on the client
     * @param minValue The minimum value the slider can have
     * @param maxValue The maximum value the slider can have
     * @param actValue The actual value the slider is set to
     * @param steps The step size of the slider
     */
    public FilterSettingSlider(String name, String minText, String maxText, double minValue, double maxValue, double actValue, double steps) {
        super(SettingTypes.SLIDER, name);
        this.minText = minText;
        this.maxText = maxText;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.actValue = actValue;
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
}
