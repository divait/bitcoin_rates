package co.waspp.bitcoinrates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import co.waspp.bitcoinrates.entities.Rates;
import co.waspp.bitcoinrates.network.Calls;

public class MainActivity extends AppCompatActivity implements Calls.OnResponseInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calls.getInstace().get("https://blockchain.info/es/ticker", this);
    }

    @Override
    public void onSuccessRequest(String data) {
        Gson gson = new Gson();
        Rates rates = gson.fromJson(data, Rates.class);
    }

    @Override
    public void onExceptionRequest(Exception ex) {

    }
}
