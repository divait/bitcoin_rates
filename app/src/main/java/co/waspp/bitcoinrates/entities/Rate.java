package co.waspp.bitcoinrates.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by divait on 1/02/2017.
 */

public class Rate {
    @SerializedName("15m")
    private String fMin;
    private String last;
    private String buy;
    private String sell;
    private String symbol;

    public Rate() {}

    public String get15Min() {
        return fMin;
    }

    public String getLast() {
        return last;
    }

    public String getBuy() {
        return buy;
    }

    public String getSell() {
        return sell;
    }

    public String getSymbol() {
        return symbol;
    }
}
