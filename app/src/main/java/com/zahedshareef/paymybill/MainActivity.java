package com.zahedshareef.paymybill;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    TextView mQuantityTextView;
    TextView mOrderSummaryTextView;
    Button mQuantityMinusButton;
    Button mQuantityPlusButton;
    EditText mCustomerNameEditText;
    CheckBox mToppingsCheckBox;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuantityTextView = (TextView) findViewById(R.id.tv_quantity);
        mQuantityMinusButton = (Button) findViewById(R.id.bt_decrease);
        mQuantityPlusButton = (Button) findViewById(R.id.bt_increase);
        mToppingsCheckBox = (CheckBox) findViewById(R.id.cb_toppings);
        mCustomerNameEditText = (EditText) findViewById(R.id.et_customerName);
        mOrderSummaryTextView = (TextView) findViewById(R.id.tv_orderSummary);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // TODO (1) This is my Todo

    /**
     * <div class="special reference">
     * <p>
     * <p>Decreases the Quantity of the Order on Button Click. Performs validations to
     * check if Quantity is greater than or equal to 1 before the new value is set.</p>
     * </div>
     */
    public void decrement(View view) {
        int currentQuantity = Integer.parseInt(mQuantityTextView.getText().toString());
        if (currentQuantity >= 1) {
            currentQuantity += -1;
            mQuantityTextView.setText("" + currentQuantity);
        }
    }

    /**
     * <div class="special reference">
     * <p>
     * <p>Increases the Quantity of the Order on Button Click. Performs validations to
     * check if Quantity is greater than or equal to 0 before the new value is set.</p>
     * </div>
     */
    public void increment(View view) {
        int currentQuantity = Integer.parseInt(mQuantityTextView.getText().toString());
        if (currentQuantity >= 0) {
            currentQuantity += 1;
            mQuantityTextView.setText("" + currentQuantity);
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
