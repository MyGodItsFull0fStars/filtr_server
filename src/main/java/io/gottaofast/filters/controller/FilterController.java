package io.gottaofast.filters.controller;

import io.gottaofast.filters.model.FilterModel;
import io.gottaofast.filters.model.FilterSettingsModel;
import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingCheckbox;
import io.gottaofast.filters.model.setting.FilterSettingSlider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping("/filters")
    public List<FilterModel> filters() {

        FilterSetting settingCheckbox = new FilterSettingCheckbox("CheckBox1", true);
        FilterSetting settingCheckbox2 = new FilterSettingCheckbox("CheckBox2", false);

        FilterSettingsModel fsm = new FilterSettingsModel();
        fsm.addFilterSetting(settingCheckbox);
        fsm.addFilterSetting(settingCheckbox2);
        FilterModel fm1 = new FilterModel(1, "TestFilter1", fsm);

        FilterSetting settingCheckbox3 = new FilterSettingCheckbox("CheckBox3", true);
        FilterSetting settingCheckbox4 = new FilterSettingCheckbox("CheckBox4", false);
        FilterSetting settingSlider = new FilterSettingSlider("slider1", "minVal", "maxVal", 0, 10, 1, 1);

        FilterSettingsModel fsm2 = new FilterSettingsModel();
        fsm2.addFilterSetting(settingCheckbox3);
        fsm2.addFilterSetting(settingCheckbox4);
        fsm2.addFilterSetting(settingSlider);
        FilterModel fm2 = new FilterModel(2, "TestFilter2", fsm2);

        ArrayList<FilterModel> filterList = new ArrayList<>();
        filterList.add(fm1);
        filterList.add(fm2);

        return filterList;
    }
}
