package presentation;

import domain.Rule;
import console.Console;
import controller.ProductRegisterController;
import domain.ProductRegister;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class ProductRegisterUI {

    private ProductRegisterController productRegisterController = new ProductRegisterController();

    public void createProductsList() {

        System.out.println("Products Registry");
        String code = Console.readLine("Code:").toUpperCase();
        String name = Console.readLine("Name:").toUpperCase();
        float price = Console.readInteger("Price:");
        ProductRegister productList = productRegisterController.addProduct(code, name, price);
    }

    public void presentProductList() {
        System.out.println("*** Presents products list ***\n");
         productRegisterController.presentProductList();
    }

    public void itemsCost() throws FileNotFoundException, ParseException {
        productRegisterController.getCostAndValues();
    }

    public void showRulesList() throws FileNotFoundException, ParseException {
        List<Rule> listRules = productRegisterController.showRulesList();
        for (Rule item: listRules
             ) {
            System.out.println( item.toString());
        }
    }

    public void calTotalValue() {
        try {
           float value =  productRegisterController.getCostAndValues();
            System.out.println("Valor total: " +value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
