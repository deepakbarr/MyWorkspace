package com.hack.tracker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void refresh(View view) {

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            TableLayout tableLayout = (TableLayout) findViewById(R.id.table);

            List<Order> orderList = new MyClient().getOrderStatuses();


            tableLayout.removeAllViews();
            ProgressDialog barProgressDialog = new ProgressDialog(this);
            barProgressDialog.setTitle("Wait ...");
            barProgressDialog.show();
            Thread.sleep(1000);
            barProgressDialog.dismiss();
            setProgressBarIndeterminateVisibility(false);

            for (Order order : orderList) {
                TableRow tr = new TableRow(this);
                TextView c1 = new TextView(this);
                c1.setText(order.getOrderId());
                c1.offsetLeftAndRight(50);
                TextView c2 = new TextView(this);
                c2.setText(order.getSeller());
                c2.offsetLeftAndRight(50);
                TextView c3 = new TextView(this);
                c3.setText(order.getStatus());
                c3.setTextColor(Color.GREEN);
                c3.offsetLeftAndRight(50);
                TextView c4 = new TextView(this);
                c4.setText(order.getLastUpdated());
                c4.offsetLeftAndRight(50);
                tr.addView(c1);
                tr.addView(c2);
                tr.addView(c4);
                tr.addView(c3);
                tableLayout.addView(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
