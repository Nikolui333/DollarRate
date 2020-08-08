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
    private ArrayList<ListItemClass> arrayList = new ArrayList<ListItemClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launch();
    }

    private void launch() {
        // инициализируем всё что нужно
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<>();
        final MyAdapter adapter = new MyAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        // запускаем задачу загрузки
        runnable = new Runnable() {
            @Override
            public void run() {
                // getWeb();
                refresh();
                // после загрузки уведомляем адаптер что данные изменились
                // делать это можно только в UI-потоке - поэтому
                // кидаем вызов в UI-поток любым способом
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }

                });
            }
};
    secThread = new Thread(runnable);
            secThread.start();
    }

    public void refresh(){
        try {
                doc = Jsoup.connect("https://yandex.ru/news/quotes/1.html").get();
                Elements data = doc.getElementsByTag("tbody");
                Element piece_of_data = data.get(0);
                Elements elements_piece_of_data = piece_of_data.children();
                Element dollar = elements_piece_of_data.get(0);
                Elements dollar_elements = dollar.children();
                Log.d("MyLog","Tbody size : " + piece_of_data.children().get(0).text());
                for(int i = 0;i < piece_of_data.childrenSize();i++ )
                {
                    arrayList.add(new ListItemClass(piece_of_data.children().get(i).child(0).text(),
                            piece_of_data.children().get(i).child(1).text(),
                            piece_of_data.children().get(i).child(2).text()));
                }

        } catch (Exception ex){
            Log.d("OneLog", "Проблема");
        }
    }
}