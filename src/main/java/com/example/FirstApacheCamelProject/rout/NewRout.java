package com.example.FirstApacheCamelProject.rout;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NewRout extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:firstname?period=5000")
                .transform().constant("Hello World")
                .to("log:FirstApacheCamelProject");
    }
}
