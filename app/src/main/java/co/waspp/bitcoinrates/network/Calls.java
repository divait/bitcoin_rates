package co.waspp.bitcoinrates.network;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by divait on 1/02/2017.
 */

public class Calls {
    private static Calls calls;

    public static Calls getInstace() {
        if(calls == null)
            calls = new Calls();

        return calls;
    }

    public interface OnResponseInterface {
        public void onSuccessRequest(String data);
        public void onExceptionRequest(Exception ex);
    }

    private OkHttpClient client;

    private Calls(){
        client = new OkHttpClient();
    }

    public void get(String url, final OnResponseInterface  onResponse) {
        try {
            run(url, onResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run(String url, final OnResponseInterface onResponseInterface) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                onResponseInterface.onExceptionRequest(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()) {
                    IOException e = new IOException("Unexpected code " +response);
                    onResponseInterface.onExceptionRequest(e);

                    throw e;
                } else {
                    onResponseInterface.onSuccessRequest(response.body().string());
                }
            }
        });
    }
}
