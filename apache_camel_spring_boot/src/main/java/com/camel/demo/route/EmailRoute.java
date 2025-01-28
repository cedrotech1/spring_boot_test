// EmailRoute.java
package com.camel.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.camel.demo.controller.requests.EmailRequest;;

@Component
public class EmailRoute extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        from("direct:sendEmail")
            .setHeader("subject", simple("${body.subject}"))
            .setHeader("to", simple("${body.to}"))
            .setHeader("from", constant("{{mail.username}}"))
            .setBody(simple("${body.body}"))
            .to("smtps://smtp.gmail.com:465?username={{mail.username}}&password={{mail.password}}")
            .log("Email sent successfully to ${header.to}");
    }
}