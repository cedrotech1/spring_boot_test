package com.camel.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class HttpCall extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // Timer-based route
        from("timer:fetchPosts?period=60000") // Trigger every 60 seconds
            .to("direct:processHttpCall");

        // Direct route for manual triggering
        from("direct:processHttpCall")
            .to("https://jsonplaceholder.typicode.com/users") // Call external API
            .log("Received raw response: ${body}") // Log the response
            .process(exchange -> {
                // Extract the response body
                String response = exchange.getIn().getBody(String.class);

                // Parse JSON response into a pretty JSON format
                ObjectMapper mapper = new ObjectMapper();
                Object json = mapper.readValue(response, Object.class);
                String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

                // Set the processed JSON response back into the exchange
                exchange.getIn().setBody(prettyJson);
            })
            .to("file:D://data?fileName=users.json") // Save the response to a file as JSON
            .log("Data saved to file: ${body}");
    }
}
