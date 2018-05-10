package vn.khoapham.manager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class EditPost extends AppCompatActivity {

    private Button btn_home;
    private Button btn_find;
    private Button btn_post;
    private Button btn_set;
    private Button btn_update;
    private Button btn_del;
    private Button btn_cancel;
    private String key1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        Bundle key = getIntent().getExtras();
        if (key != null){
            key1 = key.getString("khoa");
        }

        btn_post = (Button)findViewById(R.id.post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(EditPost.this,ManagePost.class);
                startActivity(view_post);
            }
        });
        btn_home = (Button)findViewById(R.id.home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_home = new Intent(EditPost.this,MainActivity.class);
                startActivity(view_home);
            }
        });

        btn_find = (Button)findViewById(R.id.find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_find = new Intent(EditPost.this,FindPost.class);
                startActivity(view_find);
            }
        });

        btn_set = (Button)findViewById(R.id.setting);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_set = new Intent(EditPost.this,SettingApp.class);
                startActivity(view_set);
            }
        });

        btn_update = (Button)findViewById(R.id.update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_update = new Intent(EditPost.this,UpdatePost.class);

                startActivity(view_update);
            }
        });

        btn_cancel = (Button)findViewById(R.id.cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_cancel = new Intent(EditPost.this,ManagePost.class);
                startActivity(view_cancel);
            }
        });



        btn_del = (Button)findViewById(R.id.delete);
       btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            delete();
            }


        });
    }
    private void delete() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new goiserviceEdit().execute("https://pteapp.000webhostapp.com/delete.php?id="+key1);
            }
        });
        Toast.makeText(getBaseContext(),"Da Xoa Du Lieu",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ManagePost.class);
        startActivity(intent);
    }

    private static String docnoidung(String theurl)
    {
        StringBuilder content=new StringBuilder();


        try {

            URL url=new URL(theurl);
            URLConnection conn=url.openConnection();
            BufferedReader buffread=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line=buffread.readLine())!=null)
            {
                content.append(line+"\n");
            }
            buffread.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    class goiserviceEdit extends AsyncTask<String,Integer,String>
    {

        @Override
        protected String doInBackground(String... params) {
            return docnoidung(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONArray postphp=new JSONArray(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

}
