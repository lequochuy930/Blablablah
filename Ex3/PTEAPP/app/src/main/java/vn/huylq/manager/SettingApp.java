package vn.khoapham.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SettingApp extends AppCompatActivity {

    private Button btn_home;
    private Button btn_find;
    private Button btn_post;
    private Button btn_set;
    private FirebaseAuth auth;
    private  Button btn_sign;
    private Button btn_login;
    private  Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_app);

        btn_home = (Button)findViewById(R.id.post);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_home = new Intent(SettingApp.this,HomeScreen.class);
                startActivity(view_home);
            }
        });
        auth = FirebaseAuth.getInstance();
        btn_sign = (Button)findViewById(R.id.signup);
        btn_login = (Button)findViewById(R.id.login);
        btn_logout  = (Button)findViewById(R.id.logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(getApplicationContext(), "Logout Sucessful!", Toast.LENGTH_SHORT).show();
                Intent viewlogin = new Intent(SettingApp.this, LoginActivity.class);
                startActivity(viewlogin);
// this listener will be called when there is change in firebase user session
                /*FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if (user == null) {
                            // user auth state is changed - user is null
                            // launch login activity
                            startActivity(new Intent(SettingApp.this, LoginActivity.class));

                            finish();
                        }
                    }
                };*/
                btn_logout.setVisibility(View.GONE);
                btn_login.setVisibility(View.VISIBLE);
            }
        });
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewregisty = new Intent(SettingApp.this, SignupActivity.class);
                startActivity(viewregisty);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewlogin = new Intent(SettingApp.this, LoginActivity.class);
                startActivity(viewlogin);
                btn_login.setVisibility(View.GONE);
                btn_logout.setVisibility(View.VISIBLE);
            }
        });
        btn_post = (Button)findViewById(R.id.post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(SettingApp.this,ManagePost.class);
                startActivity(view_post);
            }
        });

        btn_find = (Button)findViewById(R.id.find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_find = new Intent(SettingApp.this,FindPost.class);
                startActivity(view_find);
            }
        });
        btn_set = (Button)findViewById(R.id.setting);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_set = new Intent(SettingApp.this,SettingApp.class);
                startActivity(view_set);
            }
        });

        if (auth.getCurrentUser() != null) {
            btn_login.setVisibility(View.GONE);
            btn_logout.setVisibility(View.VISIBLE);
        }
        else
        {
            btn_logout.setVisibility(View.GONE);
            btn_login.setVisibility(View.VISIBLE);
        }
    }
}
