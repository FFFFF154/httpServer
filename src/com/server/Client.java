package com.server;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_1_1).connectTimeout(Duration.ofSeconds(10L)).build();
            URI uri = new URI("http://localhost:8080");
            HttpRequest request = HttpRequest.newBuilder().uri(uri).version(Version.HTTP_1_1).GET().build();
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            System.out.println(1);
            System.out.println(response.statusCode());
            System.out.println(5);
        } catch (Exception var5) {
        }

    }
}