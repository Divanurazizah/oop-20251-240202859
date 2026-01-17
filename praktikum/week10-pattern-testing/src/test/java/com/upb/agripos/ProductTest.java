package test.java.com.upb.agripos;

import static org.junit.jupiter.api.Assertions.assertEquals; // import model Product
import org.junit.jupiter.api.Test;     // JUnit 5

import main.java.com.upb.agripos.model.Product;

public class ProductTest {

    @Test
    void testProductName() {
        Product p = new Product("P01", "Pupuk Organik", 50000);
        assertEquals("Pupuk Organik", p.getName(), "Nama product harus sama");
    }

    @Test
    void testProductId() {
        Product p = new Product("P01", "Pupuk Organik", 50000);
        assertEquals("P01", p.getCode(), "ID product harus sama");
    }

    @Test
    void testProductPrice() {
        Product p = new Product("P01", "Pupuk Organik", 50000);
        assertEquals(50000, p.getPrice(), "Harga product harus sama");
    }
}
