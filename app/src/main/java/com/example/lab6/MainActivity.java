package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    private void load() {
        AsyncHttpClient client=new AsyncHttpClient();
        final ListView list=findViewById(R.id.list_main);
        final ArrayList<item> item_list=new ArrayList<>();
        client.get("http://18.219.197.67/listhomes",null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject re=response.getJSONObject(i);
                        item it=new item();
                        it.setId(re.getString("_id"));
                        it.setTitle(re.getString("directions"));
                        it.setDescription(re.getString("description"));
                        item_list.add(it);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                listAdapter adp=new listAdapter(MainActivity.this,item_list);
                list.setAdapter(adp);
            }
        });
    }
}
