package com.example.tictactoemvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BoardView{

    TableLayout board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board = findViewById(R.id.board);
    }

    @Override
    public void startGame() {

        for (byte row = 0; row < 3; row++) {
            TableRow tableRow = (TableRow) board.getChildAt(row);
            for (byte col = 0; col < 3; col++) {
                Button tableCol = (Button) tableRow.getChildAt(col);
                tableCol.setText("");
                tableCol.setEnabled(true);
            }
        }
    }

    @Override
    public void putSymbol(char symbol, byte row, byte col) {
        TableRow tableRow = (TableRow) board.getChildAt(row);
        Button tableCol = (Button) tableRow.getChildAt(col);
        tableCol.setText(Character.toString(symbol));
    }

    @Override
    public void gameEnded(byte winner) {
        for (byte row = 0; row < 3; row++){
            TableRow tableRow = (TableRow) board.getChildAt(row);
            for (byte col = 0; col< 3; col++){
                Button tableCol = (Button) tableRow.getChildAt(col);
                tableCol.setEnabled(false);
            }
        }

        String msg = null;
        if (winner != 0){
            msg = "Player " + winner + " win the game";
        }
        else{
            msg = "It is draw.";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void invalidPlay(byte row, byte col) {
        Toast.makeText(this, "Invalid Row", Toast.LENGTH_SHORT).show();
    }
}