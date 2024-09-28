package com.ragendhu.placementmanagement;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing RagendhuAdmin entities.
 * This interface extends JpaRepository, providing a set of standard methods for 
 * performing CRUD operations without the need for boilerplate code. The 
 * RagendhuAdmin entities are stored in a relational database, and this interface
 * allows for interaction with that database.
 * @see RagendhuAdmin
 */

public interface RagendhuAdminRepository extends JpaRepository<RagendhuAdmin, Integer> {
    // No additional methods are required at this point, 
    // but you can define custom query methods here if needed.
}
