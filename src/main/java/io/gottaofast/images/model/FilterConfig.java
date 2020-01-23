package io.gottaofast.images.model;

/**
 * The Filter setting value and setting name for process requests.
 * These are used to configure the filter before applying it
 */
public class FilterConfig {
    private final String name;
    private final double value;

    /**
     * Set the setting name/id and value
     * @param name The name of the setting
     * @param value The value of the setting
     */
    public FilterConfig(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
