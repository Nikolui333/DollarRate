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
    private List<ListItemClass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
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
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

            // горизонтальное размещение элементов recyclerView
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            ArrayList<newElements> list = new ArrayList<newElements>();
/*            ArrayList<newElements> list2 = new ArrayList<newElements>();
            ArrayList<newElements> list3 = new ArrayList<newElements>();
            ArrayList<newElements> list4 = new ArrayList<newElements>();
            ArrayList<newElements> list5 = new ArrayList<newElements>();
            ArrayList<newElements> list6 = new ArrayList<newElements>();
            ArrayList<newElements> list7 = new ArrayList<newElements>();
            ArrayList<newElements> list8 = new ArrayList<newElements>();
            ArrayList<newElements> list9 = new ArrayList<newElements>();
            ArrayList<newElements> list10 = new ArrayList<newElements>();
            ArrayList<newElements> list11 = new ArrayList<newElements>();*/

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

                    list.add(new newElements("ere","rer","rew")); /*list.add((newElements) arrayList);*/ // приведение типов реализованно криво, но как сделать по другому, я не знаю
/*                    else  if (i == 1) list2.add((newElements) arrayList);
                    else  if (i == 2) list3.add((newElements) arrayList);
                    else  if (i == 3) list4.add((newElements) arrayList);
                    else  if (i == 4) list5.add((newElements) arrayList);
                    else  if (i == 5) list6.add((newElements) arrayList);
                    else  if (i == 6) list7.add((newElements) arrayList);
                    else  if (i == 7) list8.add((newElements) arrayList);
                    else  if (i == 8) list9.add((newElements) arrayList);
                    else  if (i == 9) list10.add((newElements) arrayList);
                    else  if (i == 10) list11.add((newElements) arrayList);*/

                   // Log.d("OneLog", list.get(0));
                }

            MyAdapter adapter = new MyAdapter(list);
/*            MyAdapter adapter2 = new MyAdapter(list2);
            MyAdapter adapter3 = new MyAdapter(list3);
            MyAdapter adapter4 = new MyAdapter(list4);
            MyAdapter adapter5 = new MyAdapter(list5);
            MyAdapter adapter6 = new MyAdapter(list6);
            MyAdapter adapter7 = new MyAdapter(list7);
            MyAdapter adapter8 = new MyAdapter(list8);
            MyAdapter adapter9 = new MyAdapter(list9);
            MyAdapter adapter10 = new MyAdapter(list10);
            MyAdapter adapter11 = new MyAdapter(list11);*/

            recyclerView.setAdapter(adapter);
/*            recyclerView2.setAdapter(adapter2);
            recyclerView3.setAdapter(adapter3);
            recyclerView4.setAdapter(adapter4);
            recyclerView5.setAdapter(adapter5);
            recyclerView6.setAdapter(adapter6);
            recyclerView7.setAdapter(adapter7);
            recyclerView8.setAdapter(adapter8);
            recyclerView9.setAdapter(adapter9);
            recyclerView10.setAdapter(adapter10);
            recyclerView11.setAdapter(adapter11);*/

        } catch (Exception ex){

        }
    }
}