package ch.carve.restexpress;

import java.io.IOException;
import java.util.logging.LogManager;

import org.restexpress.RestExpress;
import org.restexpress.plugin.logging.LoggingPlugin;

import io.netty.handler.codec.http.HttpMethod;

public class RestExpressServer {

    public static void main(final String[] args) throws SecurityException, IOException {
        LogManager.getLogManager().readConfiguration(RestExpressServer.class.getResourceAsStream("/logging.properties"));
        RestExpress server = new RestExpress()
                .setName("rik")
                .setPort(8080);
        server.uri("fast", new FastController()).method(HttpMethod.GET);
        new LoggingPlugin().register(server);
        server.bind();
        server.awaitShutdown();
    }

}
