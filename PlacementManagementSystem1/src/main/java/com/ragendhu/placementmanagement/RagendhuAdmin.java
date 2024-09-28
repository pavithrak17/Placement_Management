package com.ragendhu.placementmanagement;

import jakarta.persistence.Entity; // This annotation marks the class as a JPA entity
import jakarta.persistence.Id;   // This annotation marks the 'id' field as the primary key

/**
 * This class represents an Admin user in the Ragendhu placement management system.
 * Admin users are responsible for managing various aspects of the placement process.
 */
@Entity
public class RagendhuAdmin {

    /**
     * Unique identifier for the Admin user. (Primary Key)
     */
    @Id
    private Integer id;

    /**
     * Name of the Admin user.
     */
    private String name;

    /**
     * Password for the Admin user account. (Storing passwords in plain text is not recommended. Consider hashing)
     */
    private String password;

    /**
     * Default constructor for RagendhuAdmin. (JPA requirement)
     */
    public RagendhuAdmin() {
        super();
    }

    /**
     * Parameterized constructor for RagendhuAdmin.
     * @param id Unique identifier for the Admin user.
     * @param name Name of the Admin user.
     * @param password Password for the Admin user account.
     */
    public RagendhuAdmin(Integer id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * Getter method for the 'id' field.
     *
     * @return Unique identifier of the Admin user.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for the 'id' field.
     *
     * @param id Unique identifier to set for the Admin user.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for the 'name' field.
     *
     * @return Name of the Admin user.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the 'name' field.
     *
     * @param name Name to set for the Admin user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the 'password' field.
     *
     * @return Password of the Admin user account. (Consider hashing passwords before storing)
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for the 'password' field.
     *
     * @param password Password to set for the Admin user account. (Consider hashing passwords before storing)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Overridden toString() method to provide a human-readable representation of the RagendhuAdmin object.
     *
     * @return String representation of the Admin user in the format "Admin [id=..., name=..., password=...]"
     */
    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
    }
}