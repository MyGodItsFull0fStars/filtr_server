package io.gottaofast.images.model;

public class FilterConfig {
    private final String name;
    private final double value;

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
