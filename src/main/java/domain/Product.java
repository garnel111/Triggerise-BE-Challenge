package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    private String code;
    private String name;
    private float price;
    private  List<Rule> rulesApllied = new ArrayList<Rule>();

    public List<Rule> getRulesApllied() {
        return rulesApllied;
    }

    public void setRulesApllied(List<Rule> rulesApllied) {
        this.rulesApllied = rulesApllied;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }
    /**
     * @param price
     */
    public void setPrice(float price) {
    this.price = price;
    }
    public Product(String code, String name, float price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Float.compare(product.getPrice(), getPrice()) == 0 &&
                getCode().equals(product.getCode()) &&
                getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getPrice(), getRulesApllied());
    }

    @Override
    public String toString() {
        return   "ProductCode:" + getCode() ;
    }
}