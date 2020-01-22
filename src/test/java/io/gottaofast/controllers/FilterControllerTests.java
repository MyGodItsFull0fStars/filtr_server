package io.gottaofast.controllers;

import io.gottaofast.Application;
import io.gottaofast.filters.model.FilterModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class FilterControllerTests {

    @LocalServerPort
    private int port;

    @Value("${local.management.port}")
    private int mgt;

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * Tests if we receive the status code 200 (OK)
     *
     * @throws Exception
     * @see FilterModel
     * @see io.gottaofast.filters.controller.FilterController
     */
    @Test
    public void shouldReturn200WhenSendingRequestToController() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<List> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/filters", List.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    /**
     * Tests if we receive at least one FilterModel from the FilterController
     *
     * @throws Exception
     * @see FilterModel
     * @see io.gottaofast.filters.controller.FilterController
     */
    @Test
    public void shouldReturnFilterTypesWhenSendingRequestToController() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<List> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/filters", List.class);

        ArrayList<FilterModel> arrayList = (ArrayList<FilterModel>) entity.getBody();

        // received correct status code
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        // the list of filters must not be empty
        then(arrayList.size()).isGreaterThan(0);
    }
}
