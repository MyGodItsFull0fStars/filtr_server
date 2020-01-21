package io.gottaofast.filters.model.setting;

public class FilterSettingCheckbox extends FilterSetting {
    private static final int FILTER_TYPE_CHECKBOX = 1; // TODO: maybe change to enum?

    private final boolean checked;

    public FilterSettingCheckbox(String name, boolean checked) {
        super(SettingTypes.CHECKBOX, name);
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }
}
