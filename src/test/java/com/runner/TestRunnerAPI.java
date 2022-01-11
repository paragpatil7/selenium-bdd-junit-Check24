package com.runner;

import org.junit.runner.RunWith;



@io.cucumber.junit.CucumberOptions(
        features = "src/test/resources/features/Check24API.feature",
        glue = {"com.test.stepdefs"},
        tags = "@Test_API"
        		
        
        ) 
@RunWith(io.cucumber.junit.Cucumber.class)
public class TestRunnerAPI {

}

