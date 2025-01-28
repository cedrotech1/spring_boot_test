// CamelFileRoute.java
package com.camel.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelFileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // Error handler
        errorHandler(defaultErrorHandler()
            .maximumRedeliveries(3)
            .redeliveryDelay(1000)
            .logRetryAttempted(true)
            .logStackTrace(true));

        from("direct:uploadFile")
            .routeId("fileUploadRoute")
            .log("Uploading file: ${header.CamelFileName}")
            .log("To destination: ${header.destination}")
            .onException(Exception.class)
                .handled(true)
                .log("Error uploading file: ${exception.message}")
                .end()
            // Use the `fileName` option to dynamically set the file name
            .toD("file:${header.destination}?fileName=${header.CamelFileName}")
            .log("File uploaded successfully: ${header.CamelFileName}");
    }
}

