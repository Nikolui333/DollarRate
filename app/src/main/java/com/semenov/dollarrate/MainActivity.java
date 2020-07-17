package com.semenov.dollarrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

    private Document doc;
    private Thread secThread; // второстепенный поток
    private Runnable runnable;
    private ListView listView;
  //  private CustomArrayAdapter adapter;
    private List<ListItemClass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
/*        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        adapter = new CustomArrayAdapter(this,R.layout.list_item_1,arrayList,getLayoutInflater());
        listView.setAdapter(adapter);*/
        runnable = new Runnable() {
            @Override
            public void run() {
               // getWeb();
                refresh();
            }
        };
        secThread = new Thread(runnable);
        secThread.start();
       /* ListItemClass items = new ListItemClass();
        items.setData_1("Dollar");
        items.setData_2("213");
        items.setData_3("657");
        items.setData_4("78");
        arrayList.add(items);
        items = new ListItemClass();
        items.setData_1("Dollar");
        items.setData_2("98");
        items.setData_3("6");
        items.setData_4("456");
        arrayList.add(items);
        adapter.notifyDataSetChanged();*/

    }
/*    private void getWeb()
    {
        try {
            doc = Jsoup.connect("https://minfin.com.ua/currency/").get();
            Elements tables = doc.getElementsByTag("tbody");
            Element our_table = tables.get(0);
            Elements elements_from_table = our_table.children();
            Element dollar = elements_from_table.get(0);
            Elements dollar_elements = dollar.children();
            Log.d("MyLog","Tbody size : " + our_table.children().get(0).text());
            for(int i = 0;i < our_table.childrenSize();i++ )
            {
                ListItemClass items = new ListItemClass();
                items.setData_1(our_table.children().get(i).child(0).text());
                items.setData_2(our_table.children().get(i).child(1).text());
                items.setData_3(our_table.children().get(i).child(2).text().substring(0,7));
                items.setData_4(our_table.children().get(i).child(3).text());
                arrayList.add(items);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyDataSetChanged();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

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

            ArrayList<newElements> list = new ArrayList<newElements>();
            ArrayList<newElements> list2 = new ArrayList<newElements>();
            ArrayList<newElements> list3 = new ArrayList<newElements>();
            ArrayList<newElements> list4 = new ArrayList<newElements>();
            ArrayList<newElements> list5 = new ArrayList<newElements>();
            ArrayList<newElements> list6 = new ArrayList<newElements>();
            ArrayList<newElements> list7 = new ArrayList<newElements>();
            ArrayList<newElements> list8 = new ArrayList<newElements>();
            ArrayList<newElements> list9 = new ArrayList<newElements>();
            ArrayList<newElements> list10 = new ArrayList<newElements>();
            ArrayList<newElements> list11 = new ArrayList<newElements>();

                doc = Jsoup.connect("https://minfin.com.ua/currency/").get();
                Elements tables = doc.getElementsByTag("tbody");
                Element our_table = tables.get(0);
                Elements elements_from_table = our_table.children();
                Element dollar = elements_from_table.get(0);
                Elements dollar_elements = dollar.children();
                Log.d("MyLog","Tbody size : " + our_table.children().get(0).text());
                for(int i = 0;i < our_table.childrenSize();i++ )
                {
                    ListItemClass items = new ListItemClass();
                    /*list.add(*/items.setData_1(our_table.children().get(i).child(0).text())/*)*/;
                    items.setData_2(our_table.children().get(i).child(1).text());
                    items.setData_3(our_table.children().get(i).child(2).text().substring(0,7));
                    items.setData_4(our_table.children().get(i).child(3).text());
                    arrayList.add(items);
                }
/*                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });*/

            list.add(new newElements(45));
            list.add(new newElements(23));
            list3.add(new newElements(89));

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