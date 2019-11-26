package com.qtpselenium.hybridFramework.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/",
        glue = "com.qtpselenium.hybridFramework.glue",
       
        plugin = {
              
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"
                
        })
 
public class MyTestngRunner extends AbstractTestNGCucumberTests{
   
}
