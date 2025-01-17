package com.example.FirstApacheCamelProject.rout;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewRout extends RouteBuilder {

    @Autowired
    private  PrintMsg printMsg;


    @Override
    public void configure() throws Exception {
        from("timer:firstname?period=5000")
              //  .transform().constant("Hello World")
                .bean(printMsg)
                .to("log:FirstApacheCamelProject");
    }
}
@Component
class  PrintMsg{
    public String print(){
        return  "Hello World !" ;
    }

}
