
package com.example.gava.justjava;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
//import android.widget.Button;
import android.widget.CheckBox;
//import android.widget.EditText;
import android.widget.TextView;

//import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Add Button action in app, Button will save coffeePrice
    /*Button priceButton;
    int coffeePrice;

    EditText coffeePriceInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        coffeePriceInput = findViewById(R.id.coffeePrice);

        priceButton = findViewById(R.id.priceButton);
        priceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeePrice = Integer.valueOf(coffeePriceInput.getText().toString());
            }
        });
    }*/

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;


    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);

    }

    /**
     * Calculates the price of the order.
     *
     *
     */
    private  int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * Create summary of the order
     * @param price of the order
     * @return  text summary of the order
     */

    private String createOrderSummary(int price){
        //Checkbox logic we watch boolean parameter
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();


        String priceMessage = "Name: Say My Name";
        priceMessage = priceMessage + "\nWhipped cream " + hasWhippedCream;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nYou owe "+ price + " bucks, dude" + "\n Thank you! ";
        return priceMessage;
    }

    /*This metod change increment*/
    public void increment(View view) {
        quantity++;
        displayQuanity(quantity);
    }
    /*This metod change decrement*/
    public void decrement(View view) {
        if (quantity > 0) quantity--;
        displayQuanity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuanity(int number) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays order summary text on screen.
     */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}