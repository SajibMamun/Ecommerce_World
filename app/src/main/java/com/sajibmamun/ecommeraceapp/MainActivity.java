package com.sajibmamun.ecommeraceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.sajibmamun.ecommeraceapp.Apdater.MRVadapter;
import com.sajibmamun.ecommeraceapp.Apdater.ModelItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ModelItem> productlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT)
        {
            Window w=getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        recyclerView=findViewById(R.id.Recyclerviewid);
        productlist=new ArrayList<>();

       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
       linearLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
       recyclerView.setLayoutManager(linearLayoutManager);
       recyclerView.setKeepScreenOn(true);
       recyclerView.setHasFixedSize(true);

        productlist=new ArrayList<>();
        productlist.add(new ModelItem(R.drawable.clothes));
        productlist.add(new ModelItem(R.drawable.cosmetics));
        productlist.add(new ModelItem(R.drawable.plants));
        productlist.add(new ModelItem(R.drawable.phone));
        productlist.add(new ModelItem(R.drawable.electronic));
        productlist.add(new ModelItem(R.drawable.jwelleres));

        MRVadapter mrVadapter=new MRVadapter(productlist,this);
        recyclerView.setAdapter(mrVadapter);
        mrVadapter.notifyDataSetChanged();
        autoscrolladapter(mrVadapter);


    }



    //this is for auto scrollview recyclerviewadapter
    private void autoscrolladapter(MRVadapter mrVadapter) {
        final  int speedScroll=2000;
        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
            int count=0;
            @Override
            public void run() {
                if(count==mrVadapter.getItemCount())
                {
                    count=0;
                }
                if(count<mrVadapter.getItemCount())
                {
                    recyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this,speedScroll);
                }
            }
        };
        handler.postDelayed(runnable,speedScroll);
    }
}