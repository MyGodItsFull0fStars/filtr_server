package io.gottaofast.filters.controller;

import io.gottaofast.filters.model.FilterModel;
import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingCheckbox;
import io.gottaofast.filters.model.setting.FilterSettingSlider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * In Spring's approach to building RESTful web services, HTTP requests are handled by a controller.
 * These components are easily identified by the <code>@RestController</code> annotation,
 * and the <code>Filter</code> below handles <code>GET</code> requests for
 * <code>/filters</code> by returning a list of all available <code>FilterModel</code> classes.
 */
@RestController
public class FilterController {

    /**
     * The <code>@GetMapping</code> annotation ensures that HTTP GET requests to <code>/filters</code>
     * are mapped to the <code>filters()</code> method.
     * <p>
     *
     * @return a new <code>FilterModel</code> object with <code>id</code>, <code>name</code> and <code>settings</code> attributes.
     * The object data will be written directly to the HTTP response as JSON.
     */
    @GetMapping("/filters")
    public List<FilterModel> filters() {

        FilterSetting settingCheckbox = new FilterSettingCheckbox("CheckBox1", true);
        FilterSetting settingCheckbox2 = new FilterSettingCheckbox("CheckBox2", false);

        FilterModel fm1 = new FilterModel(1, "TestFilter1");
        fm1.addFilterSetting(settingCheckbox);
        fm1.addFilterSetting(settingCheckbox2);

        FilterSetting settingCheckbox3 = new FilterSettingCheckbox("CheckBox3", true);
        FilterSetting settingCheckbox4 = new FilterSettingCheckbox("CheckBox4", false);
        FilterSetting settingSlider = new FilterSettingSlider("slider1", "minVal", "maxVal", 0, 10, 1, 1);

        FilterModel fm2 = new FilterModel(2, "TestFilter2");
        fm2.addFilterSetting(settingCheckbox3);
        fm2.addFilterSetting(settingCheckbox4);
        fm2.addFilterSetting(settingSlider);

        ArrayList<FilterModel> filterList = new ArrayList<>();
        filterList.add(fm1);
        filterList.add(fm2);

        return filterList;
    }
}
