package net.serenitybdd.starter.serenityRunner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "C:/Mentoring/project/Serenity_Framework/src/test/resources/featuresStorage/fe/",
        glue = "net.serenitybdd.starter.fetests")
public class Runner {
}
