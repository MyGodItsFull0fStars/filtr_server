package io.gottaofast.filters.model;

public class FilterModel {
    private final long id; // maybe UUID?
    private final String name;
    private final FilterSettingsModel settings;


    public FilterModel(long id, String name, FilterSettingsModel settings) {
        this.id = id;
        this.name = name;
        this.settings = settings;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FilterSettingsModel getSettings() {
        return settings;
    }
}
