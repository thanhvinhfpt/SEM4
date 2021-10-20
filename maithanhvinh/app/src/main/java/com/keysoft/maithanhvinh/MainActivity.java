package com.keysoft.maithanhvinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edUsername, edContent, edEmail;
    Spinner spinner;
    CheckBox checkBox;
    Button btSendFeedback;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        innit();
    }




    private void innit(){
        edUsername = findViewById(R.id.edUsername);
        edContent = findViewById(R.id.edContent);
        edEmail = findViewById(R.id.edEmail);
        spinner = findViewById(R.id.spinner);
        checkBox = findViewById(R.id.checkBox);
        btSendFeedback = findViewById(R.id.btSendFeedback);
        btSendFeedback.setOnClickListener(this);
        String[] genders = {"Gripe", "Gripe 1", "Gripe 2"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        if(view == btSendFeedback){
            onSendFeedBack();
        }
    }

    private void onSendFeedBack(){
        String username = edUsername.getText().toString();
        String content =  edContent.getText().toString();
        String email = edEmail.getText().toString();
        String spinner1 = spinner.getSelectedItem().toString();
        if(username.isEmpty()){
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();
            return;
        }
        if(email.isEmpty()){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_LONG).show();
            return;
        }
        if(content.isEmpty()){
            Toast.makeText(this, "Please enter your feedback", Toast.LENGTH_LONG).show();
            return;
        }
        FeedBack model = new FeedBack();
        model.setContent(content);
        model.setEmail(email);
        model.setName(username);
        model.setSpinner(spinner1);
        db.feedBackDao().insertFeedBack(model);
        Toast.makeText(this, "Send Feedback Success", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, ListFeedBackActivity.class);
        startActivity(intent);
    }
}