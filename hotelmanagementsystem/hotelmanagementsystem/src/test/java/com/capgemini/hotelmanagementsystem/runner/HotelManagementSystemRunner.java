package com.capgemini.hotelmanagementsystem.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"com.capgemini.hotelmanagementsystem"},tags = {"@tag2"})
public class HotelManagementSystemRunner {

}
