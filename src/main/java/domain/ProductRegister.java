package domain;

import java.util.ArrayList;
import java.util.List;

public class ProductRegister {


    private List<Product> productList = new ArrayList<Product>();

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
      return productList;
    }

    public void presentProductList() {
        for (Product item : productList) {
            System.out.println(item);
        }
    }

    public void presentRulesList() {
    }
}
