package ca.humber.gkalil.pizzaapp;

public class Pizza {

    double pizza_size_price;
    double pepperoni_price = 0;
    double garlic_price = 0;
    double olives_price = 0;

    public Pizza() {
    }

    public double getPizza_size_price() {
        return pizza_size_price;
    }

    public void setPizza_size_price(double pizza_size_price) {
        this.pizza_size_price = pizza_size_price;
    }

    public double getPepperoni_price() {
        return pepperoni_price;
    }

    public void setPepperoni_price(double pepperoni_price) {
        this.pepperoni_price = pepperoni_price;
    }

    public double getGarlic_price() {
        return garlic_price;
    }

    public void setGarlic_price(double garlic_price) {
        this.garlic_price = garlic_price;
    }

    public double getOlives_price() {
        return olives_price;
    }

    public void setOlives_price(double olives_price) {
        this.olives_price = olives_price;
    }
}
