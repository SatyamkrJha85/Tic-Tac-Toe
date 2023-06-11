package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tic_tac_toe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList= new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0}; //9 zero
    private int playerTurn=1;
    private int totalSelectionBoxs=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationList.add(new int[]{0,1,2});
        combinationList.add(new int[]{3,4,5});
        combinationList.add(new int[]{6,7,8});
        combinationList.add(new int[]{0,3,6});
        combinationList.add(new int[]{1,4,7});
        combinationList.add(new int[]{2,5,8});
        combinationList.add(new int[]{2,4,6});
        combinationList.add(new int[]{0,4,8});
        //combinationList.add(new int[]{8,7,4});

        String getplayerOneName= getIntent().getStringExtra("playerOne");
        String getplayerTwoName= getIntent().getStringExtra("playerTwo");

        binding.PlayerOneName.setText(getplayerOneName);
        binding.PlayerTwoName.setText(getplayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(0)){
                    performAction((ImageView) v ,0);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(1)){
                    performAction((ImageView) v ,1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(2)){
                    performAction((ImageView) v ,2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(3)){
                    performAction((ImageView) v ,3);
                }
            }
        });

        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(4)){
                    performAction((ImageView) v ,4);
                }
            }
        });

        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(5)){
                    performAction((ImageView) v ,5);
                }
            }
        });

        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(6)){
                    performAction((ImageView) v ,6);
                }
            }
        });

        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(7)){
                    performAction((ImageView) v ,7);
                }
            }
        });

        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxselection(8)){
                    performAction((ImageView) v ,8);
                }
            }
        });




    }
    private void performAction(ImageView imageView , int selectedBoxPosition){
        boxPositions[selectedBoxPosition]=playerTurn;
        if (playerTurn==1){
            imageView.setImageResource(R.drawable.ximage);
            if(checkResult()){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.PlayerOneName.getText().toString()
                        + " is a Winner!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else if (totalSelectionBoxs==9){
                ResultDialog resultDialog=new ResultDialog(MainActivity.this,"Match Draw",MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else{
                changePlayerTurn(2);
                totalSelectionBoxs++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.oimage);
            if(checkResult()){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.PlayerTwoName.getText().toString()
                        + " is a Winner!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else if (totalSelectionBoxs==9){
                ResultDialog resultDialog=new ResultDialog(MainActivity.this,"Match Draw",MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else{
                changePlayerTurn(1);
                totalSelectionBoxs++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn=currentPlayerTurn;
        if(playerTurn==1){
            binding.playerOneLayout.setBackgroundColor(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundColor(R.drawable.white_box);
        }
        else{

            binding.playerTwoLayout.setBackgroundColor(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundColor(R.drawable.white_box);
        }
    }
    private boolean checkResult(){
        boolean responce =false;
        for (int i=0;i<combinationList.size();i++){
            final int[] combination = combinationList.get(i);

            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn&&
            boxPositions[combination[2]]==playerTurn){
                responce=true;
            }
        }
        return responce;
    }
    private boolean isBoxselection(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition]==0){
            response=true;
        }
        return response;
    }
    public void restartMatch(){
        boxPositions=new int[]{0,0,0,0,0,0,0,0,0}; //9 zero
        playerTurn=1;
        totalSelectionBoxs=1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);








    }
}