package io.gottaofast.filters.model;

import io.gottaofast.filters.model.setting.FilterSetting;

import java.util.ArrayList;
import java.util.List;

public class FilterModel {
    private final long id; // maybe UUID?
    private final String name;
    private List<FilterSetting> filterSettings;


    public FilterModel(long id, String name, List<FilterSetting> filterSettings) {
        this.id = id;
        this.name = name;
        this.filterSettings = filterSettings;
    }

    public FilterModel(long id, String name) {
        this.id = id;
        this.name = name;
        this.filterSettings = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FilterSetting> getFilterSettings() {
        return filterSettings;
    }

    public void addFilterSetting(FilterSetting filterSetting) {
        filterSettings.add(filterSetting);
    }
}
