package com.semenov.dollarrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import static androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    RecyclerView recyclerView5;
    RecyclerView recyclerView6;
    RecyclerView recyclerView7;
    RecyclerView recyclerView8;
    RecyclerView recyclerView9;
    RecyclerView recyclerView10;
    RecyclerView recyclerView11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // метод, в котором происходит заполнение recyclerView данными с сайта
    public void refresh(){
        try {
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);
            recyclerView3 = (RecyclerView) findViewById(R.id.recycler_view3);
            recyclerView4 = (RecyclerView) findViewById(R.id.recycler_view4);
            recyclerView5 = (RecyclerView) findViewById(R.id.recycler_view5);
            recyclerView6 = (RecyclerView) findViewById(R.id.recycler_view6);
            recyclerView7 = (RecyclerView) findViewById(R.id.recycler_view7);
            recyclerView8 = (RecyclerView) findViewById(R.id.recycler_view8);
            recyclerView9 = (RecyclerView) findViewById(R.id.recycler_view9);
            recyclerView10 = (RecyclerView) findViewById(R.id.recycler_view10);
            recyclerView11 = (RecyclerView) findViewById(R.id.recycler_view11);

            // горизонтальное размещение элементов recyclerView
            recyclerView.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView2.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView3.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView4.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView5.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView6.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView7.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView8.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView9.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView10.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
            recyclerView11.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));

            ArrayList<Elements> list = new ArrayList<Elements>();
            ArrayList<Elements> list2 = new ArrayList<Elements>();
            ArrayList<Elements> list3 = new ArrayList<Elements>();
            ArrayList<Elements> list4 = new ArrayList<Elements>();
            ArrayList<Elements> list5 = new ArrayList<Elements>();
            ArrayList<Elements> list6 = new ArrayList<Elements>();
            ArrayList<Elements> list7 = new ArrayList<Elements>();
            ArrayList<Elements> list8 = new ArrayList<Elements>();
            ArrayList<Elements> list9 = new ArrayList<Elements>();
            ArrayList<Elements> list10 = new ArrayList<Elements>();
            ArrayList<Elements> list11 = new ArrayList<Elements>();

            Adapter adapter = new Adapter(list);
            Adapter adapter2 = new Adapter(list);
            Adapter adapter3 = new Adapter(list);
            Adapter adapter4 = new Adapter(list);
            Adapter adapter5 = new Adapter(list);
            Adapter adapter6 = new Adapter(list);
            Adapter adapter7 = new Adapter(list);
            Adapter adapter8 = new Adapter(list);
            Adapter adapter9 = new Adapter(list);
            Adapter adapter10 = new Adapter(list);
            Adapter adapter11 = new Adapter(list);


        } catch (Exception ex){

        }
    }

}