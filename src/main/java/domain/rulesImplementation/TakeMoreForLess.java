package domain.rulesImplementation;

import domain.Product;
import domain.Rule;

public class TakeMoreForLess extends Rule {

    private float value_Hoodie_Item_WithDiscount = (float) 19.00;

    public TakeMoreForLess(int id, String description, String produt, int form_id) {
        super(id, description, produt, form_id);
    }

    @Override
    public float calculatePrice(Product prod, int produtFrequency) {

        if (produtFrequency >= 3) {
            return produtFrequency * (prod.getPrice() - 1) ;
        } else {
            return produtFrequency * prod.getPrice();
        }
    }



}
