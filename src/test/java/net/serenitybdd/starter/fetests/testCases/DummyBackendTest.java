package net.serenitybdd.starter.fetests.testCases;

import net.serenitybdd.starter.fetests.testCases.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DummyBackendTest extends BaseTest {

    @Test
    public void imitateBackendTest() {
        assertThat(2+2).isEqualTo(4);
    }
}
