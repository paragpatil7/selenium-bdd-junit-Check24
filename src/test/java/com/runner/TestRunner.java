package com.runner;

import org.junit.runner.RunWith;



@io.cucumber.junit.CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.test.stepdefs"}
        
        )
@RunWith(io.cucumber.junit.Cucumber.class)
public class TestRunner {

}
