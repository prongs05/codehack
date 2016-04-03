package com.gshop.schatu2.gshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ygirdha on 4/3/2016.
 */
public class ProductLayout extends AppCompatActivity{
    TextView Name;
    TextView Description;
    TextView Price;
    ImageView photo;
    Button b1, b2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_page);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Product List");
        final String productName = getIntent().getExtras().getString("productName");
        String productDescription = getIntent().getExtras().getString("productDescription");
        final String productPrice = getIntent().getExtras().getString("productPrice");
        
        Price = (TextView)findViewById(R.id.textView4);
        Description = (TextView)findViewById(R.id.textView5);
        Name = (TextView)findViewById(R.id.textView);
        photo = (ImageView)findViewById(R.id.imageButton);
        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button3);
        Name.setText(productName);
        Description.setText(productDescription);
        Price.setText(productPrice);

        if (productName.equals("Hallmark")) {
            photo.setImageResource(R.drawable.hallmark);
        } else if (productName.equals("Supreme")) {
            photo.setImageResource(R.drawable.supreme);
        } else if (productName.equals("Taj Mahal")) {
            photo.setImageResource(R.drawable.taj);
        } else if (productName.equals("Eiffel Tower")) {
            photo.setImageResource(R.drawable.eiffel);
        } else if (productName.equals("Leaning Tower of Pisa")) {
            photo.setImageResource(R.drawable.pisa);
        } else if (productName.equals("Burj Khalifa")) {
            photo.setImageResource(R.drawable.burj);
        } else if (productName.equals("Iron Throne")) {
            photo.setImageResource(R.drawable.throne);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductLayout.this, Checkout.class);
                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
