package com.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public void serverStart() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            if ("GET".equals(t.getRequestMethod())) {
                OutputStream os = t.getResponseBody();

                String response = "Привет, это HTTP-сервер на Java!";


                t.sendResponseHeaders(200, response.length());
                os.write(response.getBytes());
                os.close();
                System.out.println("uhuhu");
            } else if ("POST".equals(t.getRequestMethod())) {
                System.out.println("o");
            }
        }
    }

}
