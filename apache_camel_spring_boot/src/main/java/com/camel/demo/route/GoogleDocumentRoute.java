package com.camel.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GoogleDocumentRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        String fileId = "1zDE33T4XgIi7h7Ngt8a2YrSllBSpyICiRdShLs2bn7A"; // Replace with your file ID
        String googleDocUrl = "https://docs.google.com/feeds/download/documents/export/Export?id=" + fileId + "&exportFormat=txt";

        from("direct:fetchGoogleDoc")
            .doTry()
                .toD(googleDocUrl) // Dynamic URL
                .log("Fetched document content: ${body}")
                .to("file:D://data?fileName=google_doc.txt") // Save file locally
                .log("Google document saved to D://data/google_doc.txt")
            .doCatch(Exception.class)
                .log("Error occurred: ${exception.message}")
                .setBody(simple("An error occurred while fetching the document: ${exception.message}"));
    }
}
