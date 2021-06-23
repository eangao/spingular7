package com.mycompany.myapp.cucumber;

import com.mycompany.myapp.Spingular7App;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = Spingular7App.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
