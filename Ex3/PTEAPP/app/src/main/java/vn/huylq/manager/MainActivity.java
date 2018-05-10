package vn.khoapham.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn_home;
    private ImageButton btn_find;
    private ImageButton btn_post;
    private ImageButton btn_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_post = (ImageButton) findViewById(R.id.imageButton3);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(MainActivity.this, FindPost.class);
                startActivity(view_post);
            }
        });

        btn_find = (ImageButton) findViewById(R.id.imageButton4);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_find = new Intent(MainActivity.this, ManagePost.class);
                startActivity(view_find);
            }
        });
        btn_set = (ImageButton) findViewById(R.id.imageButton5);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_set = new Intent(MainActivity.this, SettingApp.class);
                startActivity(view_set);
            }
        });

        btn_home = (ImageButton) findViewById(R.id.imageButton2);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(view_post);
            }
        });

    }

}
