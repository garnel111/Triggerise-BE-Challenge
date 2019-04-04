package utilities;

import domain.Rule;
import domain.rulesImplementation.TakeMoreForLess;
import domain.rulesImplementation.TakeTwoForOne;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PricingRules {


    public static List<Rule> importRules(String file) throws FileNotFoundException, ParseException {
        List<String> importRules = FilesReader.leituradeCsvFile(file);
        List<Rule> rules = new ArrayList<Rule>();

        for (String item : importRules) {

            String[] aux = item.split(";");


            switch (Integer.parseInt(aux[0])) {
                case 1:
                    Rule ruleOne = new TakeTwoForOne(Integer.parseInt(aux[0]), (aux[1]), aux[2], Integer.parseInt(aux[3]));
                    rules.add(ruleOne);
                    break;

                case 2:
                    Rule ruleTwo = new TakeMoreForLess(Integer.parseInt(aux[0]), (aux[1]), aux[2], Integer.parseInt(aux[3]));
                    rules.add(ruleTwo);
                    break;

                default:
                    break;
            }

        }
        return rules;
    }
}