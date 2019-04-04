package controller;

import domain.Product;
import domain.ProductRegister;
import domain.Rule;
import utilities.ItemRulesEvaluator;
import utilities.PricingRules;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class ProductRegisterController {

    private ProductRegister productRegister = new ProductRegister();
    private float totalValue;
    public ProductRegister addProduct(String code, String name, float price) {
        Product product = new Product(code, name, price);
        productRegister.add(product);
        return productRegister;
    }

    public void presentProductList() {
        productRegister.presentProductList();
    }

    public float  getCostAndValues() throws FileNotFoundException, ParseException {

        float totalValue = 0;
        String file = "rules.csv";
        List<Rule> rules = PricingRules.importRules(file);
        List<Product> produtList = productRegister.getProductList();
        ItemRulesEvaluator itemRulesEvaluator = new ItemRulesEvaluator();
        totalValue = itemRulesEvaluator.GetProductList_AppliedRules(rules, produtList);
        return totalValue;

    }

    public List<Rule> showRulesList() throws FileNotFoundException, ParseException {
        String file = "rules.csv";
        List<Rule> rules = PricingRules.importRules(file);
        return rules;
    }


}
