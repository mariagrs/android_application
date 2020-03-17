package maria.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    Button btn;
    ImageButton paymentBtn;
    RecyclerView recycle;
    MyAdapter myAd;
    Integer total;
    ArrayList<Barcode> productList = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);
        Bundle bundle = getArguments();
        if(bundle == null){
            LinearLayout notEmptyList = v.findViewById(R.id.notEmpty_view);
            notEmptyList.setVisibility(LinearLayout.GONE);

            btn = v.findViewById(R.id.emptyList);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new ScanFragment())
                            .commit();
                }
            });

        }
        else {
            LinearLayout emptyList = v.findViewById(R.id.empty_view);
            emptyList.setVisibility(LinearLayout.GONE);

            recycle = v.findViewById(R.id.recycleViewList);

            final String product = bundle.getString("Product");
            final String nbItem = bundle.getString("NbItem");
            final Integer price = bundle.getInt("Price");
            total = bundle.getInt("Total");

            productList.add(new Barcode(product,price,Integer.valueOf(nbItem)));

            myAd = new MyAdapter(getContext(),productList);

            recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
            recycle.setAdapter(myAd);
            myAd.notifyDataSetChanged();

            paymentBtn = v.findViewById(R.id.buyBtn);
            paymentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Payment.class);
                    intent.putExtra("TOTAL", total);
                    startActivity(intent);
                }
            });

        }
        return v;
    }
}
