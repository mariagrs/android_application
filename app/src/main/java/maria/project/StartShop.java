package maria.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class StartShop extends AppCompatActivity {
    TextView productName;
    TextView productPrice;
    ElegantNumberButton btn;
    String numberOfItem;
    ImageButton addToList;
    Integer total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_shop);

        productName = findViewById(R.id.nameProduct);
        productPrice = findViewById(R.id.priceProduct);

        btn = findViewById(R.id.elegantButton);

        final String product = getIntent().getStringExtra("PRODUCT");
        final Integer price = (getIntent().getIntExtra("PRICE",0));

        btn.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfItem = btn.getNumber();
                total = price * Integer.parseInt(numberOfItem);

                Toast.makeText(StartShop.this, "Total Price : " + total, Toast.LENGTH_SHORT).show();
            }
        });

        productName.setText(product);
        productPrice.setText(String.valueOf(price));


        addToList = findViewById(R.id.addToListBtn);
        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(StartShop.this , Dashboard.class);
                in.putExtra("frag", "list");
                in.putExtra("PRODUCT", product);
                in.putExtra("PRICE", price);
                in.putExtra("TOTAL", total);
                in.putExtra("NbItem", numberOfItem);
                startActivity(in);


            }
        });

    }

}
