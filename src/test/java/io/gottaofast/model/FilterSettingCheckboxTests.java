package io.gottaofast.model;


import io.gottaofast.filters.model.setting.FilterSetting;
import io.gottaofast.filters.model.setting.FilterSettingCheckbox;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FilterSettingCheckboxTests {

    @Test
    public void basicConstructorTest_withValidParameters() {
        // non null object expected
        FilterSettingCheckbox checkbox = new FilterSettingCheckbox("Checkbox", true);
        Assertions.assertNotNull(checkbox);

        // non null object expected
        FilterSettingCheckbox checkbox1 = new FilterSettingCheckbox("Checkbox", false);
        Assertions.assertNotNull(checkbox1);
    }

    @Test
    public void constructorTest_handlesNullValue() {
        // given null parameter, empty string is expected
        FilterSetting checkbox = new FilterSettingCheckbox(null, true);
        Assertions.assertNotNull(checkbox);
        Assertions.assertNotNull(checkbox.getName());

        // given null parameter, empty string is expected
        FilterSetting checkbox1 = new FilterSettingCheckbox(null, false);
        Assertions.assertNotNull(checkbox1);
        Assertions.assertNotNull(checkbox1.getName());
    }

    /**
     * Tests if correct value is saved in checked boolean field
     */
    @Test
    public void testIsCheckedGetterMethod() {
        // true expected
        FilterSettingCheckbox checkboxTrue = new FilterSettingCheckbox("Checkbox", true);
        Assertions.assertNotNull(checkboxTrue);
        Assertions.assertTrue(checkboxTrue.isChecked());

        // false expected
        FilterSettingCheckbox checkboxFalse = new FilterSettingCheckbox("Checkbox", false);
        Assertions.assertNotNull(checkboxFalse);
        Assertions.assertFalse(checkboxFalse.isChecked());
    }
}