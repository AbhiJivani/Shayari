package Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.shayari.R;

import Adapter.Category_Adapter;


public class Main_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Category_Adapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    String name[]={"   શુભસકામના શાયરી","   દોસ્તી શાયરી","   મજેદાર શાયરી","   ભગવાન શાયરી","   પ્રેરણા સ્તોત્ર શાયરી","   જીવન શાયરી","   મોહબ્બત શાયરી","   યાદ શાયરી","   અન્ય શાયરી","   રાજનીતિ શાયરી","   પ્રેમ શાયરી","   દર્દ શાયરી","   શરાબ શાયરી","   બેવફા શાયરી","   જન્મદિવસ શાયરી","   હોળી શાયરી"};

    int imgArr[] ={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,R.drawable.img15,R.drawable.img16,};
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerList);
        adapter=new Category_Adapter(Main_Activity.this,name,imgArr);
        swipeRefreshLayout=findViewById(R.id.swipeRefresh);

        LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                recyclerView.setAdapter(adapter);
                swipeRefreshLayout.setRefreshing(false);
            }
        });



    }
}