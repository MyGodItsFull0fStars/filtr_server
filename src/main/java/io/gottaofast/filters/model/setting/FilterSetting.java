package io.gottaofast.filters.model.setting;

public abstract class FilterSetting {
    private final int type;
    private final String name;

    public FilterSetting(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
