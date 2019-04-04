package domain.rulesImplementation;

import domain.Product;
import domain.Rule;

public class TakeTwoForOne extends Rule {

    public TakeTwoForOne(int id, String description, String produt, int form_id) {
        super(id, description, produt, form_id);
    }

    @Override
    public float calculatePrice(Product prod, int produtFrequency) {
        if (produtFrequency == 1) {

            return prod.getPrice();
        }

        if ((produtFrequency % 2) == 0) {

            return ((produtFrequency / 2) * prod.getPrice());

        } else {
            return (((produtFrequency / 2) * prod.getPrice()) + prod.getPrice());
        }
    }


}
