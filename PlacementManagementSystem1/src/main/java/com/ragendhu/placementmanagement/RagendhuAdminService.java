package com.ragendhu.placementmanagement;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing RagendhuAdmin entities.
 * This class contains the business logic for the RagendhuAdmin entity. 
 * It interacts with the RagendhuAdminRepository to perform CRUD operations
 * and includes methods for retrieving, creating, updating, and deleting 
 * RagendhuAdmin records.
 */
@Service
@Transactional // Ensures that methods in this class are transactional
public class RagendhuAdminService {

    // Autowiring the repository for data access
    @Autowired
    private RagendhuAdminRepository repo;

    /**
     * Retrieves all RagendhuAdmin records.
     * @return List of all RagendhuAdmin entities.
     */
    public List<RagendhuAdmin> listAll() {
        // Calls the repository method to find all records
        return repo.findAll();
    }

    /**
     * Creates or updates a RagendhuAdmin record.
     * @param s The RagendhuAdmin entity to be created or updated.
     */
    public void create(RagendhuAdmin s) {
        // Saves the RagendhuAdmin entity (creates or updates)
        repo.save(s);
    }

    /**
     * Retrieves a single RagendhuAdmin record by its ID. 
     * @param id The ID of the RagendhuAdmin to retrieve.
     * @return The RagendhuAdmin entity with the specified ID.
     * @throws NoSuchElementException if no record with the specified ID exists.
     */
    public RagendhuAdmin retrieve(Integer id) {
        // Fetches the RagendhuAdmin entity by ID
        return repo.findById(id).get();
    }

    /**
     * Deletes a RagendhuAdmin record by its ID.
     * @param id The ID of the RagendhuAdmin to delete.
     */
    public void delete(Integer id) {
        // Deletes the RagendhuAdmin entity with the specified ID
        repo.deleteById(id);
    }
}