package com.semenov.dollarrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private Document doc;
    private Thread secThread; // второстепенный поток
    private Runnable runnable;
    private ListView listView;
    private List<ListItemClass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<newElements> list = new ArrayList<newElements>();
        list.add(new newElements("ddf", "dfd", "dde"));
        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);

        runnable = new Runnable() {
            @Override
            public void run() {
               // getWeb();
                refresh();
            }
        };
        secThread = new Thread(runnable);
        secThread.start();
    }

    // метод, в котором происходит заполнение recyclerView данными с сайта
    public void refresh(){
        try {
                doc = Jsoup.connect("https://yandex.ru/news/quotes/1.html").get();
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
                    items.setData_3(our_table.children().get(i).child(2).text());
                    arrayList.add(items);
                   // Log.d("OneLog", list.get(0));
                }

        } catch (Exception ex){

        }
    }
}