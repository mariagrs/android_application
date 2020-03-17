package maria.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    TextView totalPrice;
    Button Paybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Integer total = getIntent().getIntExtra("TOTAL",0);
        totalPrice = findViewById(R.id.TotalToPay);
        Paybtn = findViewById(R.id.payBtn);

        totalPrice.setText(String.valueOf(total) + " euros");

        Paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Payment.this, "Thank You", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
