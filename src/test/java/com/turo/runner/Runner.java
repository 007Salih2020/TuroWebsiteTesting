package com.turo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        // Glue path java folderdan sonra baslamali. src/test/java dan sonra
        glue = "com/turo/stepdef",
        dryRun =false,
        strict = true,
//        tags = "@smoke_test,@unit_test",
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        }
)
public class Runner {

}
