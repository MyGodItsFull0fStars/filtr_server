package io.gottaofast.filters.model;

import io.gottaofast.filters.model.setting.FilterSetting;

import java.util.ArrayList;
import java.util.List;

public class FilterSettingsModel {
    private List<FilterSetting> filterSettings;

    public FilterSettingsModel() {
        filterSettings = new ArrayList<>();
    }

    public void addFilterSetting(FilterSetting setting) {
        filterSettings.add(setting);
    }

    public List<FilterSetting> getFilterSettings() {
        return filterSettings;
    }
}
