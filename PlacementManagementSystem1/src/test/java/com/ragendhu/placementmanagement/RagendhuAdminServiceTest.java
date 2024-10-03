package com.ragendhu.placementmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class RagendhuAdminServiceTest {

    @Autowired
    private RagendhuAdminService adminService;

    @BeforeAll
    public void setUp() {
        // Creating initial data for testing purposes
        RagendhuAdmin admin1 = new RagendhuAdmin(1, "John Doe", "password123");
        RagendhuAdmin admin2 = new RagendhuAdmin(2, "Jane Smith", "password456");
        
        adminService.create(admin1);
        adminService.create(admin2);
    }

    @Test
    @Order(1)
    public void testListAllAdmins() {
        List<RagendhuAdmin> admins = adminService.listAll();
        assertNotNull(admins);
        assertEquals(2, admins.size()); // Initially we added 2 records
    }

    @Test
    @Order(2)
    public void testCreateAdmin() {
        RagendhuAdmin newAdmin = new RagendhuAdmin(3, "Test Admin", "password789");
        adminService.create(newAdmin);

        List<RagendhuAdmin> admins = adminService.listAll();
        assertEquals(3, admins.size()); // New admin should be added
    }

    @Test
    @Order(3)
    public void testRetrieveAdmin() {
        RagendhuAdmin retrievedAdmin = adminService.retrieve(1);
        assertNotNull(retrievedAdmin);
        assertEquals("John Doe", retrievedAdmin.getName());
    }

    @Test
    @Order(4)
    public void testUpdateAdmin() {
        RagendhuAdmin adminToUpdate = adminService.retrieve(2);
        adminToUpdate.setName("Updated Name");
        adminToUpdate.setPassword("newPassword");

        adminService.create(adminToUpdate);

        RagendhuAdmin updatedAdmin = adminService.retrieve(2);
        assertEquals("Updated Name", updatedAdmin.getName());
        assertEquals("newPassword", updatedAdmin.getPassword());
    }

    @Test
    @Order(5)
    public void testDeleteAdmin() {
        adminService.delete(3); // Deleting admin with ID 3

        List<RagendhuAdmin> admins = adminService.listAll();
        assertEquals(2, admins.size()); // Admin with ID 3 should be deleted
    }

    @ParameterizedTest
    @Order(6)
    @CsvSource({
        "1, John Doe",
        "2, Updated Name"
    })
    public void testRetrieveAdminParameterized(Integer id, String expectedName) {
        RagendhuAdmin admin = adminService.retrieve(id);
        assertNotNull(admin);
        assertEquals(expectedName, admin.getName());
    }

    @Test
    @Order(7)
    public void testRetrieveNonExistentAdmin() {
        assertThrows(NoSuchElementException.class, () -> {
            adminService.retrieve(999); // ID 999 should not exist
        });
    }
}
