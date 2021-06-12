package pl.radzik.michal.springbootmodule_2;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class Basket {

    private List<Product> products = new LinkedList<>();

    public Basket() {
    }

    public void addProductToBasket(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
