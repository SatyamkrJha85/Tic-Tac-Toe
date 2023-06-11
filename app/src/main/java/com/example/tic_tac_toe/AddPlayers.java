package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        EditText Playerone=findViewById(R.id.Playerone);
        EditText Playertwo=findViewById(R.id.Playertwo);
        Button StartGameButton=findViewById(R.id.StartGameButton);

        StartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getPlayerOneName = Playerone.getText().toString();
                String getPlayerTwoName = Playertwo.getText().toString();

                if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                    Toast.makeText(AddPlayers.this, "Please Enter Player Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(AddPlayers.this,MainActivity.class);
                    intent.putExtra("playerOne",getPlayerOneName);
                    intent.putExtra("playerTwo",getPlayerTwoName);
                    startActivity(intent);

                }
            }
        });

    }
}