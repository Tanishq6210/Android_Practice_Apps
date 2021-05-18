package com.example.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.(OR we can say here it will give you the value one when button is clicked)
     */
    public void submitOrder (View view){
        CheckBox check = (CheckBox) findViewById(R.id.check_whippedCream);
        CheckBox checkChocolate = (CheckBox) findViewById(R.id.check_chocolate);
        EditText nameInput = (EditText) findViewById(R.id.input_name);
        boolean isChecked = check.isChecked();
        boolean isChecked_chocolate = checkChocolate.isChecked();
        String inputName = String.valueOf(nameInput.getText());
        String toShow = createOrderSummary(quantity, isChecked, isChecked_chocolate, inputName);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your Bill of Tanishq's Cafe");
        intent.putExtra(Intent.EXTRA_TEXT, toShow);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method is called when the + button is clicked. This method increase the value of quantity
     */
    public void increaseQuantity (View view){
        if(quantity == 100){
            Toast.makeText(this, "You cannot order more than 100 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked. This method decrease the value of quantity.
     */
    public void decreaseQuantity (View view){
        if(quantity == 1) {

            Toast.makeText(this, "You cannot order less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the display function is called which is present in the submitOrder Function.
     */
    private void displayQuantity(int number) {
        TextView ob = findViewById(R.id.quantity_text_view);
        ob.setText(""+number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     *
     * @return quantity * 5
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate){
        int pricePerCup = 5;
        if(hasWhippedCream) pricePerCup += 1;
        if(hasChocolate) pricePerCup += 2;
        return pricePerCup * quantity;
    }

    /**
     *
     * @param quantity
     * @param addWhipedCream
     * @param addChocolate
     * @return
     */
    private String createOrderSummary(int quantity, boolean addWhipedCream, boolean addChocolate, String inputName){
        int price = calculatePrice(addWhipedCream, addChocolate);
        String toReturn = getString(R.string.order_summary_name,inputName);
        toReturn += "\n Add whipped cream? " + addWhipedCream;
        toReturn += "\n Add chocolate? " + addChocolate;
        toReturn += "\n Quantity: " + quantity;
        toReturn += "\n Total: $" + price;
        toReturn += "\n" + getString(R.string.Thank_you);
        return toReturn;

    }
}