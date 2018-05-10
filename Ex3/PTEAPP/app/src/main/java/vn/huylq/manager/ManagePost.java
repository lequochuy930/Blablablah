package vn.khoapham.manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ManagePost extends AppCompatActivity {

    private Button btn_home;
    private Button btn_find;
    private Button btn_post;
    private Button btn_set;
    private Button btn_view;
    private Button btn_new;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_post);

        btn_post = (Button)findViewById(R.id.post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(ManagePost.this,ManagePost.class);
                startActivity(view_post);
            }
        });
        btn_home = (Button)findViewById(R.id.home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_home = new Intent(ManagePost.this,HomeScreen.class);
                startActivity(view_home);
            }
        });

        btn_find = (Button)findViewById(R.id.find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_find = new Intent(ManagePost.this,FindPost.class);
                startActivity(view_find);
            }
        });

        btn_set = (Button)findViewById(R.id.setting);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_set = new Intent(ManagePost.this,SettingApp.class);
                startActivity(view_set);
            }
        });


        btn_view = (Button)findViewById(R.id.view_post);
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_view = new Intent(ManagePost.this,ViewPost.class);
                startActivity(view_view);
            }
        });

        btn_new = (Button)findViewById(R.id.new_post);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_new = new Intent(ManagePost.this,NewPost.class);
                startActivity(view_new);
            }
        });
    }
}
