package io.gottaofast;

import io.gottaofast.controllers.FilterControllerTests;
import io.gottaofast.model.FilterSettingCheckboxTests;
import io.gottaofast.model.FilterSettingSliderTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        FilterControllerTests.class,
        FilterSettingCheckboxTests.class,
        FilterSettingSliderTests.class
})

public class TestSuite {
}
