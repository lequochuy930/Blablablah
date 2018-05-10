package vn.khoapham.manager;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    private Button btn_home;
    private Button btn_find;
    private Button btn_post;
    private Button btn_set;

    ListView listView;
    ArrayList<td> list;
    AdapterPost adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        addControls();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new goiserviceMain().execute("https://pteapp.000webhostapp.com/allPost.php");

            }
        });

        btn_home = (Button) findViewById(R.id.home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(HomeScreen.this, MainActivity.class);
                startActivity(view_post);
            }
        });

        btn_post = (Button) findViewById(R.id.post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(HomeScreen.this, ManagePost.class);
                startActivity(view_post);
            }
        });

        btn_find = (Button) findViewById(R.id.find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_find = new Intent(HomeScreen.this, FindPost.class);
                startActivity(view_find);
            }
        });
        btn_set = (Button) findViewById(R.id.setting);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_set = new Intent(HomeScreen.this, SettingApp.class);
                startActivity(view_set);
            }
        });

    }

    private static String docnoidung(String theurl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(theurl);
            URLConnection conn = url.openConnection();
            BufferedReader buffread = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = buffread.readLine()) != null) {
                content.append(line + "\n");
            }
            buffread.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    class goiserviceMain extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            return docnoidung(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                list.clear();
                JSONArray postphp = new JSONArray(s);
                for (int i = 0; i < postphp.length(); i++) {
                    JSONObject jo = postphp.getJSONObject(i);
                    String mota = jo.getString("mota");
                    String gia = jo.getString("gia");
                    String loai = jo.getString("loai");
                    String dientich = jo.getString("dientich");
                    String diachi = jo.getString("diachi");
                    String lienhe = jo.getString("lienhe");
                    String khoa = jo.getString("khoa");
                    String hinhanh = "https://pteapp.000webhostapp.com/getimage.php?key=" + khoa;

                    list.add(new td(gia,loai,dientich,diachi,khoa,hinhanh));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            adapter.notifyDataSetChanged();
        }
    }

    private void addControls() {

        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new AdapterPost(this, list);
        listView.setAdapter(adapter);
    }

}
