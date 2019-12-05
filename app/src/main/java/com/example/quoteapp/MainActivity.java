package com.example.quoteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String url;

    private OkHttpClient client;

    private TextView quotivation;

    private Button clickforMotivation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quotivation = findViewById(R.id.quotivation);
        clickforMotivation = findViewById(R.id.clickforMotivation);
        client = new OkHttpClient();
        url = "https://healthruwords.p.rapidapi.com/v1/quotes/?id=731&t=Wisdom&maxR=1&size=medium";
        clickforMotivation.setOnClickListener(v -> {
            try {
                doGetRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public String doGetRequest(String newUrl) throws IOException {
        Request request = new Request.Builder()
                .url(newUrl)
                .get()
                .addHeader("x-rapidapi-host", "healthruwords.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "SIGN-UP-FOR-KEY")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
