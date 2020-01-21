package io.gottaofast.filters.model;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.filters.model.setting.FilterSetting;

import java.util.ArrayList;
import java.util.List;

public class FilterModel {
    private final Filters id; // maybe UUID?
    private final String name;
    private final String imgUrl;
    private List<FilterSetting> filterSettings;


    public FilterModel(Filters id, String name, String imgUrl, List<FilterSetting> filterSettings) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.filterSettings = filterSettings;
    }

    public FilterModel(Filters id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.filterSettings = new ArrayList<>();
    }

    public Filters getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<FilterSetting> getFilterSettings() {
        return filterSettings;
    }

    public void addFilterSetting(FilterSetting filterSetting) {
        filterSettings.add(filterSetting);
    }
}
