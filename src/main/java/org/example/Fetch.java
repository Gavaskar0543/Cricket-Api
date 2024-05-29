package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Fetch {
    private final OkHttpClient client = new OkHttpClient();

    public String run(String url, String apiKey) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("apiKey", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
