package utilities;

import controller.ProductRegisterController;
import domain.Product;
import domain.ProductRegister;
import domain.Rule;
import domain.model.Hat;
import domain.model.Hoodie;
import domain.model.Ticket;
import domain.rulesImplementation.TakeMoreForLess;
import domain.rulesImplementation.TakeTwoForOne;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemRulesEvaluatorTest {




    @Test
    public void InputTwoTicket_ShouldReturnValueFive() throws FileNotFoundException, ParseException {

        System.out.println("*********************");
        System.out.println("Should Return Value Five");

        //Arrange
        List<Product> products = new ArrayList<>();
        Ticket t1 = new Ticket("TICKET", "ticket", 5.00f);
        Ticket t2 = new Ticket("TICKET", "ticket", 5.00f);
        products.add(t1);
        products.add(t2);
        List<Rule> rules = new ArrayList<Rule>();
        TakeTwoForOne takeTwoForOne = new TakeTwoForOne(1,"2-for-1 special on TICKET items;TICKET","TICKET",1 );
        TakeMoreForLess takeMoreForLess = new TakeMoreForLess(2,"3 or more HOODIE items, the price per unit should be 19.00€","HOODIE",2);
        rules.add(takeTwoForOne);
        rules.add(takeMoreForLess);
        ProductRegisterController productRegisterController = mock(ProductRegisterController.class);
        PricingRules pricingRules = mock(PricingRules.class);
        ProductRegister productRegister = mock(ProductRegister.class);
        ItemRulesEvaluator itemRulesEvaluator = new ItemRulesEvaluator();
        when(productRegisterController.showRulesList()).thenReturn(rules);
        float expectedResult = 5.00f;

        //Act
        float result = itemRulesEvaluator.getTotalCost(products, rules);

        //Assert
        Assert.assertEquals(expectedResult,result, 0.5);
        System.out.println("Valor obtido  da compra para\n" + products.toString() +"\n" + result + " euros");

    }

    @Test
    public void InputTwoTicket_ShouldReturnValueTwentyFive() throws FileNotFoundException, ParseException {

        System.out.println("*********************");
        System.out.println("Should Return Value TwentyFive");
        //Arrange
        List<Product> products = new ArrayList<>();
        Ticket t1 = new Ticket("TICKET", "ticket", 5.00f);
        Hoodie h1 = new Hoodie("HOODIE", "h1", 20);
        Ticket t2 = new Ticket("TICKET", "ticket", 5.00f);
        products.add(t1);
        products.add(h1);
        products.add(t2);
        List<Rule> rules = new ArrayList<Rule>();
        TakeTwoForOne takeTwoForOne = new TakeTwoForOne(1,"2-for-1 special on TICKET items;TICKET","TICKET",1 );
        TakeMoreForLess takeMoreForLess = new TakeMoreForLess(2,"3 or more HOODIE items, the price per unit should be 19.00€","HOODIE",2);
        rules.add(takeTwoForOne);
        rules.add(takeMoreForLess);
        ItemRulesEvaluator itemRulesEvaluator = new ItemRulesEvaluator();
        float expectedResult = 25.00f;

        //Act
        float result = itemRulesEvaluator.getTotalCost(products, rules);
        //Assert
        Assert.assertEquals(expectedResult,result, 0.5);
        System.out.println("Valor obtido  da compra para\n" + products.toString() +"\n" + result + " euros");
    }


    @Test
    public void InputSeveralItems_ShouldReturnValueEightyOne() throws FileNotFoundException, ParseException {

        System.out.println("*********************");
        System.out.println("Should Return Value EightyOne");
        //Arrange
        List<Product> products = new ArrayList<>();
        Ticket t1 = new Ticket("TICKET", "ticket", 5.00f);
        Hoodie h1 = new Hoodie("HOODIE", "h1", 20);
        Hoodie h2 = new Hoodie("HOODIE", "h1", 20);
        Hoodie h3 = new Hoodie("HOODIE", "h1", 20);
        Hoodie h4 = new Hoodie("HOODIE", "h1", 20);
        Ticket t2 = new Ticket("TICKET", "ticket", 5.00f);
        products.add(t1);
        products.add(h1);
        products.add(h2);
        products.add(h3);
        products.add(h4);

        List<Rule> rules = new ArrayList<Rule>();
        TakeTwoForOne takeTwoForOne = new TakeTwoForOne(1,"2-for-1 special on TICKET items;TICKET","TICKET",1 );
        TakeMoreForLess takeMoreForLess = new TakeMoreForLess(2,"3 or more HOODIE items, the price per unit should be 19.00€","HOODIE",2);
        rules.add(takeTwoForOne);
        rules.add(takeMoreForLess);

        ItemRulesEvaluator itemRulesEvaluator = new ItemRulesEvaluator();
        float expectedResult = 81.00f;

        //Act
        float result = itemRulesEvaluator.getTotalCost(products, rules);


        //Assert
        Assert.assertEquals(expectedResult,result, 0.5);
        System.out.println("Valor obtido  da compra para\n" + products.toString() +"\n" + result + " euros");

    }

    @Test
    public void InputTSomeItems_ShouldReturnFrequencyAndMatchProducts() throws FileNotFoundException, ParseException {

        System.out.println("*********************");
        System.out.println("Should Return Frequency and Match Products");
        //Arrange
        int value = 3;
        List<Product> products = new ArrayList<>();
        Ticket t1 = new Ticket("TICKET", "ticket", 5.00f);
        Ticket t2 = new Ticket("TICKET", "ticket", 5.00f);
        Ticket t3 = new Ticket("TICKET", "ticket", 5.00f);
        products.add(t1);
        products.add(t2);
        products.add(t3);

        List<Rule> rules = new ArrayList<Rule>();
        TakeTwoForOne takeTwoForOne = new TakeTwoForOne(1, "2-for-1 special on TICKET items;TICKET", "TICKET", 1);
        TakeMoreForLess takeMoreForLess = new TakeMoreForLess(2, "3 or more HOODIE items, the price per unit should be 19.00€", "HOODIE", 2);
        rules.add(takeTwoForOne);
        rules.add(takeMoreForLess);


        //Act
        ItemRulesEvaluator itemRulesEvaluator = new ItemRulesEvaluator();
        Map<Product, Integer> result = itemRulesEvaluator.getFrequencyOfEachProduct(products);
        for (Map.Entry<Product, Integer> entry: result.entrySet()
             ) {

            Assert.assertEquals("TICKET", entry.getKey().getCode());
            Assert.assertEquals( entry.getValue().toString(), "3");
            System.out.println("Values:" + entry.getValue().toString());
        }
    }

    @Test
    public void InputSeveralItems_ShouldReturnValueSeventyFive() throws FileNotFoundException, ParseException {

        System.out.println("*********************");
        System.out.println( "Should Return Value SeventyFive And Half");
        //Arrange
        List<Product> products = new ArrayList<>();
        Ticket t1 = new Ticket("TICKET", "ticket", 5.00f);
        Hoodie h1 = new Hoodie("HOODIE", "h1", 20);
        Hoodie h2 = new Hoodie("HOODIE", "h1", 20);
        Hoodie h3 = new Hoodie("HOODIE", "h1", 20);
        Hoodie h4 = new Hoodie("HOODIE", "h1", 20);
        Ticket t2 = new Ticket("TICKET", "ticket", 5.00f);
        Ticket t3 = new Ticket("TICKET", "ticket", 5.00f);
        Hat hat1 = new Hat("HAT","Hat",7.50f);
        products.add(t1);
        products.add(t2);
        products.add(t3);
        products.add(h1);
        products.add(h2);
        products.add(h3);
        products.add(hat1);

        List<Rule> rules = new ArrayList<Rule>();
        TakeTwoForOne takeTwoForOne = new TakeTwoForOne(1,"2-for-1 special on TICKET items;TICKET","TICKET",1 );
        TakeMoreForLess takeMoreForLess = new TakeMoreForLess(2,"3 or more HOODIE items, the price per unit should be 19.00€","HOODIE",2);
        rules.add(takeTwoForOne);
        rules.add(takeMoreForLess);

        ItemRulesEvaluator itemRulesEvaluator = new ItemRulesEvaluator();
        float expectedResult = 74.50f;

        //Act
        float result = itemRulesEvaluator.getTotalCost(products, rules);

        //Assert
        Assert.assertEquals(expectedResult,result, 0.5);
        System.out.println("Valor obtido  da compra para\n" + products.toString() +"\n" + result + " euros");
    }
}