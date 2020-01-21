package io.gottaofast.filters.model.setting;

public class FilterSettingSlider extends FilterSetting {

    private final String minText;
    private final String maxText;

    private final double minValue;
    private final double maxValue;

    private final double actValue;
    private final double steps;

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
