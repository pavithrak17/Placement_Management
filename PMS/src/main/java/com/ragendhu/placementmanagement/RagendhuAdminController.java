package com.ragendhu.placementmanagement;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Annotation to mark this class as a RESTful controller
@RestController
public class RagendhuAdminController {

    // Autowiring the service to handle business logic
    @Autowired
    private RagendhuAdminService service;

    // RESTful API Endpoint for creating a new RagendhuAdmin
    @PostMapping("/admin")
    public void add(@RequestBody RagendhuAdmin s) {
        // Calling service layer to handle the creation logic
        service.create(s);
    }

    // RESTful API Endpoint for deleting a RagendhuAdmin by ID
    @DeleteMapping("/admin/{id}")
    public void remove(@PathVariable Integer id) {
        // Calling service layer to handle deletion
        service.delete(id);
    }

    // RESTful API Endpoint to retrieve all RagendhuAdmin records
    @GetMapping("/admin")
    public List<RagendhuAdmin> list() {
        // Retrieving all records through the service layer
        return service.listAll();
    }

    // RESTful API Endpoint to retrieve a specific RagendhuAdmin by ID
    @GetMapping("/admin/{id}")
    public ResponseEntity<RagendhuAdmin> get(@PathVariable Integer id) {
        try {
            // Attempting to retrieve the RagendhuAdmin by ID
            RagendhuAdmin s = service.retrieve(id);
            // Returning the found entity with HTTP OK status
            return new ResponseEntity<RagendhuAdmin>(s, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // Handling the case where the entity is not found
            return new ResponseEntity<RagendhuAdmin>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API Endpoint to update a RagendhuAdmin by ID
    @PutMapping("/admin/{id}")
    public ResponseEntity<RagendhuAdmin> update(@RequestBody RagendhuAdmin s, @PathVariable Integer id) {
        try {
            // Verifying if the RagendhuAdmin exists before updating
            @SuppressWarnings("unused")
            RagendhuAdmin s1 = service.retrieve(id);
            // Updating the entity by calling the service layer (should ideally be an update method)
            service.create(s);
            // Returning the updated entity with HTTP OK status
            return new ResponseEntity<RagendhuAdmin>(s, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // Handling the case where the entity is not found
            return new ResponseEntity<RagendhuAdmin>(HttpStatus.NOT_FOUND);
        }
    }
}