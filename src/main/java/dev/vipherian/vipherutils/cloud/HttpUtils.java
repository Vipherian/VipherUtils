package dev.vipherian.vipherutils.cloud;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

final class HttpUtils {
    private final static HttpClient client = HttpClient.newBuilder().build();

    public static void request(String url) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        client.send(request, HttpResponse.BodyHandlers.discarding());
    }
}
