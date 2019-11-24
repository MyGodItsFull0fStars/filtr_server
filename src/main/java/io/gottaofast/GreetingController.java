package io.gottaofast;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * In Spring's approach to building RESTful web services, HTTP requests are handled by a controller.
 * These components are easily identified by the <code>@RestController</code> annotation,
 * and the <code>GreetingController</code> below handles <code>GET</code> requests for
 * <code>/greeting</code> by returning a new instance of the Greeting class
 */
@RestController
public class GreetingController {

    private final static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    /**
     * The <code>@RequestMapping</code> annotation ensures that HTTP requests to <code>/greeting</code>
     * are mapped to the <code>greeting()</code> method.
     * <p>
     * Annotation @RequestMapping maps all HTTP operations by default.
     * Use @RequestMapping(method=GET) to narrow this mapping.
     * <p>
     * Annotation <code>@RequestParam</code> binds the value of the query string parameter <code>name</code>
     * into the name parameter of the <code>greeting</code> method.
     *
     * @param name
     * @return a new <code>Greeting</code> object with <code>id</code> and <code>content</code> attributes.
     * The object data will be written directly to the HTTP response as JSON.
     */
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
