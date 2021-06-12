package pl.radzik.michal.springbootmodule_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.Random;

@Service
@ConfigurationProperties(prefix="amount")
@Profile("Plus")
public class ShopPlus implements Shop{


    private final Basket basket;

    private float vat;

    @Autowired
    public ShopPlus(Basket basket) {
        this.basket = basket;
    }


    @Override
    public void addProductToBasket(Product product) {
        basket.addProductToBasket(product);
    }

    public void printTotalCostProductsInBasket() {
            BigDecimal netPrize = basket.getProducts().stream().map(x -> x.getPrize()).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal netPricePlusVat = netPrize.add(netPrize.multiply(BigDecimal.valueOf(vat)));
            System.out.println(netPricePlusVat);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        basket.addProductToBasket(new Product("rower", new BigDecimal(new Random().ints(1, 0, 3000).findFirst().getAsInt())));
        basket.addProductToBasket(new Product("tv", new BigDecimal(new Random().ints(1, 0, 3000).findFirst().getAsInt())));
        basket.addProductToBasket(new Product("telefon", new BigDecimal(new Random().ints(1, 0, 3000).findFirst().getAsInt())));
        basket.addProductToBasket(new Product("tablet", new BigDecimal(new Random().ints(1, 0, 3000).findFirst().getAsInt())));
        basket.addProductToBasket(new Product("szafka", new BigDecimal(new Random().ints(1, 0, 3000).findFirst().getAsInt())));
    }
}
