package com.javier.deeplinks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();

        if(intent.getAction().equals(Intent.ACTION_VIEW)) {

            String data = intent.getDataString();
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
            tv.setText(formatDataString(data));
        }
    }

    private String formatDataString(String dataString) {
        int indexOfSlash = dataString.lastIndexOf("/");
        String urlEnd = dataString.substring(indexOfSlash + 1);
        String[] words = urlEnd.split("-");
        String finalString = "";
        for (String word : words) {
            word = capitalizeWord(word);
            finalString += word + " ";
        }
        return finalString.substring(0, finalString.length() - 1);
    }

    private String capitalizeWord(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
