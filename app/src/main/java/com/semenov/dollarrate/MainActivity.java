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

            ArrayList list = new ArrayList();
            ArrayList list2 = new ArrayList();
            ArrayList list3 = new ArrayList();
            ArrayList list4 = new ArrayList();
            ArrayList list5 = new ArrayList();
            ArrayList list6 = new ArrayList();
            ArrayList list7 = new ArrayList();
            ArrayList list8 = new ArrayList();
            ArrayList list9 = new ArrayList();
            ArrayList list10 = new ArrayList();
            ArrayList list11 = new ArrayList();



        } catch (Exception ex){

        }
    }

}