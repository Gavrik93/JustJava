
package com.example.gava.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;

    // processing button Order
    public void submitOrder(View view) {
        EditText nameField = findViewById(R.id.nameField);
        String name = nameField.getText().toString();

        //Checkbox logic @whipped_cream
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Checkbox logic @chocolate_checkbox
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();


        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order coffee" + name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {

        int basePrice = 5;
        if (hasWhippedCream){
            basePrice = basePrice +1;
        }
        if (hasChocolate){
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    /**
     * Create summary of the order
     *
     * @param name            of the customer
     * @param price           of the order
     * @param hasWhippedCream is whether or not to add whipped cream to the coffee
     * @param hasChocolate    is whether or not to add chocolate to the coffee
     * @return text summary of the order
     */

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {


        String priceMessage = "Name: " + name;
        priceMessage = priceMessage + "\nAdd whipped cream? " + hasWhippedCream;
        priceMessage = priceMessage + "\nAdd chocolate?  " + hasChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nYou owe " + price + " bucks, dude" + "\n Thank you! ";
        return priceMessage;
    }

    /*This metod change increment*/
    public void increment(View view) {
        if (quantity == 50) {
            Toast.makeText(this, "You cannot have more then 50 cups of coffees",Toast.LENGTH_SHORT).show();
            return;
        }

        quantity++;
        displayQuanity(quantity);
    }

    /*This metod change decrement*/
    public void decrement(View view) {
        if (quantity >= 0) {
            Toast.makeText(this, "You cannot have less then 0 cup of coffee",Toast.LENGTH_SHORT).show();
            return;
        }
            quantity--;
        displayQuanity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuanity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
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