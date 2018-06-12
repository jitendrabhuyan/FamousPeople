package app.demo.com.famouspeople;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateUser extends AppCompatActivity {

    private static final String TAG = CreateUser.class.getName();
    EditText firstName;
    EditText lastName;
    EditText email;
    Button saveUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email_id);
        saveUser = findViewById(R.id.add_user_button);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Production").allowMainThreadQueries().build();
        saveUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG,firstName.getText().toString());
                db.userDao().InsertAll(new User(firstName.getText().toString(),lastName.getText().toString(),email.getText().toString()));
                startActivity(new Intent(CreateUser.this,MainActivity.class));
            }
        });


    }

}
