package domain.model;

import domain.Product;
import domain.Rule;

import java.util.List;

public class Ticket  extends Product {

    public Ticket(String code, String name, float price) {
        super(code, name, price);
    }
}
