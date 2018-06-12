package app.demo.com.famouspeople;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    FloatingActionButton fab;
    ArrayList<User> users;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            User user = new User("Jitendra #"+i,"Bhuyan","bhuyan.jitendra@gmail.com");
            users.add(user);
        }
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewAdapter = new UserAdapter(users);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG,"floating action button clicked");
                startActivity(new Intent(MainActivity.this,CreateUser.class));
            }
        });

    }

}
