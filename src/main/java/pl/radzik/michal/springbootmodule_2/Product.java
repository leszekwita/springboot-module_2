package pl.radzik.michal.springbootmodule_2;

import java.math.BigDecimal;

public class Product {

    private String name;

    private BigDecimal prize;

    public Product(String name, BigDecimal prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }


}
