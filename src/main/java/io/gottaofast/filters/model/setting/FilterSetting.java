package io.gottaofast.filters.model.setting;

/**
 * Configuration for a specific filter setting
 */
public abstract class FilterSetting {

    private final SettingTypes type;
    private final String name;

    /**
     * Create a new FilterSetting
     *
     * @param type The SettingType of the setting, e.g. CHECKBOX or SLIDER
     * @param name The name of the setting
     */
    public FilterSetting(SettingTypes type, String name) {
        this.type = type;
        this.name = name != null ? name : "";
    }

    public final String getName() {
        return name;
    }

    public final SettingTypes getType() {
        return type;
    }
}
