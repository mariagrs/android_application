package maria.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Dashboard extends AppCompatActivity {

    ListFragment list = new ListFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNav = findViewById(R.id.bottomnav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        final String frag = getIntent().getStringExtra("frag");

        if(frag == null)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScanFragment()).commit();
        else if(frag.equals("list")){
            String product = getIntent().getStringExtra("PRODUCT");
            Integer price = getIntent().getIntExtra("PRICE",0);
            Integer total = getIntent().getIntExtra("TOTAL",0);
            String nbItem = getIntent().getStringExtra("NbItem");
            Bundle b = new Bundle();
            b.putString("Product", product);
            b.putInt("Price", price);
            b.putInt("Total", total);
            b.putString("NbItem", nbItem);
            list.setArguments(b);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,list).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFrag = null;

                switch (menuItem.getItemId()) {
                    case R.id.listView:
                      selectedFrag = list;
                    break;

                    case R.id.scan:
                        selectedFrag = new ScanFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();
                return true;
            }
        };
}

