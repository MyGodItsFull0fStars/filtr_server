package io.gottaofast.model;

import io.gottaofast.filters.filter.Filters;
import io.gottaofast.filters.model.FilterModel;
import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingCheckbox;
import io.gottaofast.filters.model.setting.FilterSettingSlider;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class FilterModelTests {

    Filters filters;
    String name;
    String imgUrl;
    LinkedList<FilterSetting> filterSettings;

    FilterModel modelWithFilterSettings;
    FilterModel modelWithoutFilterSettings;

    @Before
    public void setup() {
        filters = Filters.TEST;
        name = "name";
        imgUrl = "imgUrl";

        filterSettings = new LinkedList<>();
        filterSettings.add(new FilterSettingCheckbox("checkbox", true));
        filterSettings.add(new FilterSettingSlider(
                "name",
                "minText",
                "maxText",
                0,
                100,
                50,
                1)
        );

        modelWithFilterSettings = new FilterModel(filters, name, imgUrl, filterSettings);
        assertNotNull(modelWithFilterSettings);

        modelWithoutFilterSettings = new FilterModel(filters, name, imgUrl);
        assertNotNull(modelWithoutFilterSettings);
    }

    @Test
    public void basicGetterTests_withValidValues() {
        // filters field in object is non null and of correct type
        assertNotNull(modelWithFilterSettings.getId());
        assertEquals(Filters.TEST, modelWithFilterSettings.getId());

        // name field in object is non null and of correct value
        assertNotNull(modelWithFilterSettings.getName());
        assertEquals(name, modelWithFilterSettings.getName());

        // imgUrl field in object is non null and of correct value
        assertNotNull(modelWithFilterSettings.getImgUrl());
        assertEquals(imgUrl, modelWithFilterSettings.getImgUrl());

        // filterSettings list in object is non null, non empty and stores the correct settings
        assertNotNull(modelWithFilterSettings.getFilterSettings());
        assertEquals(filterSettings.size(), modelWithFilterSettings.getFilterSettings().size());
        assertEquals(filterSettings, modelWithFilterSettings.getFilterSettings());
    }

    @Test
    public void testAddFilterSetting_withValidSettings() {
        // given
        LinkedList<FilterSetting> testList = new LinkedList<>(filterSettings);
        FilterSetting setting = new FilterSettingCheckbox("name", false);
        testList.add(setting);

        // when
        modelWithFilterSettings.addFilterSetting(setting);

        // then
        // filterSettings list in object must have same size and settings as testList
        assertEquals(testList.size(), modelWithFilterSettings.getFilterSettings().size());
        assertEquals(testList, modelWithFilterSettings.getFilterSettings());
    }
}
