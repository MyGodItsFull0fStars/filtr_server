package io.gottaofast.filters.controller;

import io.gottaofast.filters.filter.impl.Blur;
import io.gottaofast.filters.filter.impl.DeepFry;
import io.gottaofast.filters.filter.impl.EdgeDetection;
import io.gottaofast.filters.filter.impl.Greyscale;
import io.gottaofast.filters.model.FilterModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * In Spring's approach to building RESTful web services, HTTP requests are handled by a controller.
 * These components are easily identified by the <code>@RestController</code> annotation,
 * and the <code>filters()</code> method below handles <code>GET</code> requests for
 * <code>/filters</code> by returning a list of all available <code>FilterModel</code> classes.
 */
@RestController
public class FilterController {

    /**
     * The <code>@GetMapping</code> annotation ensures that HTTP GET requests to <code>/filters</code>
     * are mapped to the <code>filters()</code> method.
     * <p>
     *
     * @return a new <code>FilterModel</code> object with <code>id</code>, <code>name</code> and <code>settings</code> attributes.
     * The object data will be written directly to the HTTP response as JSON.
     */
    @GetMapping("/filters")
    public List<FilterModel> filters() {

        ArrayList<FilterModel> filterList = new ArrayList<>();
        filterList.add(new Greyscale().getFilterModel());
        filterList.add(new DeepFry().getFilterModel());
        filterList.add(new EdgeDetection().getFilterModel());
        filterList.add(new Blur().getFilterModel());

        return filterList;
    }
}
