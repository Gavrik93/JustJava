/*
package com.example.gava.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.gava.justjava;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    Button priceButton;
    int coffeePrice;

    EditText coffeePriceInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffeePriceInput = (EditText) findViewById(R.id.coffeePrice);

        priceButton = (Button) findViewById(R.id.priceButton);
        priceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeePrice = Integer.valueOf(coffeePriceInput.getText().toString());
            }
        });
    }

    /**
     * This method is called when the order button is clicked.
     */
    int numberOfCoffees = 0;


    public void submitOrder(View view) {
        String priceMessage = "You owe "+ (numberOfCoffees*coffeePrice) + "bucks, dude" + "\n Thank you! ";
        displayMessage(priceMessage);
//        display(numberOfCoffees);
//        displayPrice(numberOfCoffees*10);
    }



    /*This metod change increment*/
    public void increment(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);
    }
    /*This metod change decrement*/
    public void decrement(View view) {
        if (numberOfCoffees > 0) numberOfCoffees--;
        display(numberOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}