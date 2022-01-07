package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    public Product[] items = new Product[0];

    public ProductRepository(Product product) {
    }

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
if (findById(id) == null) {
    throw new NotFoundException("The product id " + id + " is invalid");
        }
        int length = items.length - 1;

        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
//        for (int i = 0; i < length; i++) {

            if (item.getId() != id) {
//            if (!items[i].equals(id)) {
                tmp[index] = item; //s[i];
                index++;
            }
        }
        items = tmp;
    }
// returns reversed(!) array
    public Product[] getAll() {
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}

// "object with id" + ???id + "does not exist"