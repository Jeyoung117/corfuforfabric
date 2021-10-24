package org.corfudb.protocols.wireprotocol;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rmichoud on 4/13/17.
 *
 * <p>These classes will be used to force the json deserialized object to be created by
 * the constructor. Proper validation of the object is done in the Layout class constructor.</p>
 */
public class TxMetadataDeserializer implements JsonDeserializer {
    @Override
    public TxMetadata deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2)
            throws JsonParseException {
        Gson g = new Gson();
        TxMetadata unsafeTxMetadata = g.fromJson(arg0, TxMetadata.class);

        /* Unresponsive servers is an optional field in the json, if it is not present
         * we need to create an empty list (by default gson will set it to null)
         */
//        if (unsafeLayout.unresponsiveServers == null) {
//            unsafeLayout.unresponsiveServers = new ArrayList<>();
//        }

        /* Similar to a copy constructor. This constructor holds all the validation for
        constructing a layout. */
        TxMetadata safeTxmetadata = new TxMetadata(unsafeTxMetadata.txmetadata);

        return safeTxmetadata;

    }
}

