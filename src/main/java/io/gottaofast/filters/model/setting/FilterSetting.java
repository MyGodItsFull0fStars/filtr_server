package io.gottaofast.filters.model.setting;

public abstract class FilterSetting {
    private final SettingTypes type;
    private final String name;

    public FilterSetting(SettingTypes type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SettingTypes getType() {
        return type;
    }
}
