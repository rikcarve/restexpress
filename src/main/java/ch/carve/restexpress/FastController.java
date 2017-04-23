package ch.carve.restexpress;

import org.restexpress.Request;
import org.restexpress.Response;

public class FastController {

    public String read(Request request, Response response) {
        return request.getRemoteAddress().getHostName();
    }
}
