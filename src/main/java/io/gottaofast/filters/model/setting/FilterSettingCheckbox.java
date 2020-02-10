package io.gottaofast.filters.model.setting;

/**
 * A Checkbox setting which can be either set or not.
 */
public class FilterSettingCheckbox extends FilterSetting {

    private final boolean checked;

    /**
     * Create a new FilterSettingCheckbox
     * @param name The name of the setting
     * @param checked Whether the checkbox is checked or not
     */
    public FilterSettingCheckbox(String name, boolean checked) {
        super(SettingTypes.CHECKBOX, name);
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }
}
