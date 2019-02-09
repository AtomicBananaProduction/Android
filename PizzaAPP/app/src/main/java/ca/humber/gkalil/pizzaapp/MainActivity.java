package ca.humber.gkalil.pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Pizza pizza;

    TextView total;
    TextView delivery_note;

    double totalPrice;

    double totalPriceRotation;

    boolean deliveryCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza = new Pizza();

        total = findViewById(R.id.total);

        delivery_note = findViewById(R.id.deliveryNote);
    }

    public void radioClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.rb1:
                if(checked){
                    pizza.setPizza_size_price(9);
                }
            break;
            case R.id.rb2:
                if(checked){
                    pizza.setPizza_size_price(10);
                }
                break;
            case R.id.rb3:
                if(checked){
                    pizza.setPizza_size_price(11);
                }
                break;
        }

        total.setText("Total Price:  " + String.format("%.2f", calculateTotal()) + "$");
    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()){
            case R.id.cb1:
                if(checked){
                    pizza.setPepperoni_price(2);
                }
                else{
                    pizza.setPepperoni_price(0);
                }
            break;
            case R.id.cb2:
                if(checked){
                    pizza.setGarlic_price(2);
                }
                else{
                    pizza.setGarlic_price(0);
                }
                break;
            case R.id.cb3:
                if(checked){
                    pizza.setOlives_price(2);
                }
                else{
                    pizza.setOlives_price(0);
                }
                break;
        }

        total.setText("Total Price:  " + String.format("%.2f", calculateTotal()) + "$");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("totalprice", totalPrice);
        outState.putBoolean("deliverynote", deliveryCheck);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        totalPriceRotation = savedInstanceState.getDouble("totalprice");
        deliveryCheck = savedInstanceState.getBoolean("deliverynote");
        if(deliveryCheck){
            delivery_note.setText("Delivery required.");
        }
        else{
            delivery_note.setText("");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        total.setText("Total Price:  " + String.format("%.2f", totalPriceRotation) + "$");
    }

    private double calculateTotal(){

        totalPrice = pizza.getPizza_size_price() + pizza.getGarlic_price() + pizza.getPepperoni_price() + pizza.getOlives_price();
        return totalPrice;
    }

    public void onSwitchClicked(View view) {

        Switch swButton = (Switch) view;
        if(swButton.isChecked()){
            delivery_note.setText("Delivery required.");
            deliveryCheck = true;
        }
        else{
            delivery_note.setText("");
            deliveryCheck = false;
        }
    }

    public void getHelp(View view) {

        Intent helpIntent = new Intent(this, AboutActivity.class);

        startActivityForResult(helpIntent, 0);
    }

    public void confirmOrder(View view) {
    }
}
