package domain;

import interfaces.IRule;

public abstract class Rule implements IRule, Comparable<Rule> {

    private int id;
    private String description ;
    private String produt;
    private int form_id;

    public Rule(int id, String description, String produt, int form_id) {
        this.id = id;
        this.description = description;
        this.produt = produt;
        this.form_id = form_id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProdut() {
        return produt;
    }

    public void setProdut(String produt) {
        this.produt = produt;
    }

    @Override
    public String toString() {
        return "RuleID:" + id ;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    @Override
    public int compareTo(Rule o) {
        return this.getId() - o.getId();
    }

    @Override
    public abstract float calculatePrice(Product prod, int produtFrequency);
}
