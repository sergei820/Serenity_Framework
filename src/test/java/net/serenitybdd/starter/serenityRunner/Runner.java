package net.serenitybdd.starter.serenityRunner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/featuresStorage",
        glue = "net.serenitybdd.starter.fetests")
public class Runner {
    ///fe
}
