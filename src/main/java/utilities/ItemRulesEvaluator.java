package utilities;

import domain.Rule;
import domain.Product;
import javafx.util.Pair;

import java.util.*;

public class ItemRulesEvaluator {

    Map<Integer, Integer> prodListByRule = new HashMap<Integer, Integer>();
    Map<Product, Integer> frequencyOfEachProduct = new HashMap<>();
    float totalValue = 0.0f;


    //public Map<Product,Integer> GetProductList_AppliedRules(List<Rule> rules, List<Product> productList) {
    public float GetProductList_AppliedRules(List<Rule> rules, List<Product> productList) {

        Pair<Rule, Integer> pairRuleFreq = new Pair<Rule, Integer>(null, 0);
        List<Pair<Rule, Integer>> listPairRuleFrequency = new ArrayList<Pair<Rule, Integer>>();
       return  getTotalCost(productList, rules);

    }
     public float getTotalCost(List<Product> productList, List<Rule> rules) {

         frequencyOfEachProduct = getFrequencyOfEachProduct(productList);
         for (Map.Entry<Product,Integer> entry : frequencyOfEachProduct.entrySet()){
             int counter =0;
             for (Rule rule : rules) {
                 if (ruleAplies(rule, entry.getKey())) {
                     totalValue = totalValue + rule.calculatePrice(entry.getKey(), entry.getValue());
                     counter++;
                 }
             }
                 if(counter == 0){
                     totalValue = totalValue + (entry.getValue() * entry.getKey().getPrice());
                 }
             }
         return totalValue;
     }

    public  Map<Product, Integer> getFrequencyOfEachProduct(List<Product> productList) {
        Map<Product, Integer> productWithFrequency= new HashMap<>();
        Set<Product> uniqueSet = new HashSet<>(productList);
        for (Product p : uniqueSet) {
            productWithFrequency.put(p, Collections.frequency(productList, p));
        }
        return productWithFrequency;
    }

    private boolean ruleAplies(Rule rule, Product prod) {
        return rule.getProdut().contains(prod.getCode());
    }
    private void orderRuleListById(List<Rule> rules) {
        Collections.sort(rules);
    }
}
