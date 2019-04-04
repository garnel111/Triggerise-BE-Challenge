package utilities;

import domain.Rule;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class PricingRulesTest {

    @Test
    public void InputTwoTicket_ShouldReturnRuleNumber() throws FileNotFoundException, ParseException {


        System.out.println("*********************");
        System.out.println(" Should Return rules number");
        //Arrange
        int expectedResult = 2;


        //Act
         List<Rule> rules =  PricingRules.importRules("rules.csv");
         int result = rules.size();

         //Assert
        System.out.println("Numero de regras: \n" + result);

        Assert.assertEquals(expectedResult,result);

    }


    }