package com.gshop.schatu2.gshop;

/**
 * Created by schatu2 on 4/2/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Product> products;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("GShop");
        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        products = new ArrayList<>();
        products.add(new Product("Hallmark", "Beautiful pantry, colorful workplace", "Rs. 20", R.drawable.hallmark));
        products.add(new Product("Supreme", "Nice and cosy pantry without a foosball table, structurally weak", "Rs. 6", R.drawable.supreme));
        products.add(new Product("Taj Mahal", "Majestic marble mausolem surrounded by lush green gardens", "Rs. 150", R.drawable.taj));
        products.add(new Product("Eiffel Tower", "Rust free wrought iron tower in the middle of Paris", "Rs. 45", R.drawable.eiffel));
        products.add(new Product("Leaning Tower of Pisa", "Beautiful bell tower in Pisa, slightly tilted", "Rs. 80", R.drawable.pisa));
        products.add(new Product("Burj Khalifa", "Very tall building surrounded by oil", "Rs. 124", R.drawable.burj));
        products.add(new Product("Iron Throne", "Very sought after, made of 1 million swords, 2 Kingsguards free", "Rs. 300", R.drawable.throne));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(products);
        rv.setAdapter(adapter);
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
