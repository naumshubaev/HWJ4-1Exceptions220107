package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;


public class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository(new Product());

    private Product first = new Product(1, "first", 1);
    private Product second = new Product(22, "second", 10);
    private Product third = new Product(333, "third", 100);

    @BeforeEach
    public void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    public void shouldRemoveIfExists() {

        int id = 333;
        repo.removeById(id);

        Product[] actual = repo.getAll();
        Product[] expected = new Product[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int id = 100;

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(id);
        });
    }
}
