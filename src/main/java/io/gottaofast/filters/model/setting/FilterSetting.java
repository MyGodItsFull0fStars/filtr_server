package io.gottaofast.filters.model.setting;

public abstract class FilterSetting {
    private final SettingTypes type;
    private final String name;

    public FilterSetting(SettingTypes type, String name) {
        if (name == null) name = "";
        this.type = type;
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public final SettingTypes getType() {
        return type;
    }
}
