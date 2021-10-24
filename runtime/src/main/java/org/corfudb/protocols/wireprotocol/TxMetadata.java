package org.corfudb.protocols.wireprotocol;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import org.corfudb.runtime.view.Layout;
import org.corfudb.runtime.view.LayoutDeserializer;

import static java.util.Objects.requireNonNull;

public class TxMetadata {
    @Getter
    @Setter
    public byte[] txmetadata;
    /**
     * A Gson parser.
     */
    @Getter
    static final Gson parser = new GsonBuilder()
            .registerTypeAdapter(TxMetadata.class, new LayoutDeserializer())
            .create();


    public TxMetadata(byte[] txmetadata) {
        this.txmetadata = txmetadata;
    }

    /**
     * Get a layout from a JSON string.
     */
    @SuppressWarnings({"checkstyle:abbreviation"})
    public static Layout fromJSONString(String json) {
        /* Empty Json file creates an null Layout */
        return requireNonNull(parser.fromJson(json, Layout.class));
    }

    /**
     * Get the layout as a JSON string.
     */
    @SuppressWarnings({"checkstyle:abbreviation"})
    public String asJSONString() {
        return parser.toJson(this);
    }


}
