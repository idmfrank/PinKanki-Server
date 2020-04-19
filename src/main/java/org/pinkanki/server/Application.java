package org.pinkanki.server;

import io.micronaut.runtime.Micronaut;

/**
 * @author Frank Wray
 * @since 0.1
 */
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.servers.*;
/**
 * @author Frank Wray
 * @since 0.1
 */
@OpenAPIDefinition(
        info = @Info(
                title = "PinKanki-Server",
                version = "0.1",
                description = "Basic Implementation of the PinKanki-Server API",
                license = @License(name = "Apache 2.0", url = "http://www.pinkanki.org"),
                contact = @Contact(url = "http://www.pinkanki.org", name = "Administrator", email = "admin@pinkanki.org")
        ),
        servers = {
                @Server(
                        description = "www",
                        url = "http://www.pinkanki.org"
                        )
        }
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
