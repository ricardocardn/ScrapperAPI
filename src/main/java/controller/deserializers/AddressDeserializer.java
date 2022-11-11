package controller.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.Address;

public class AddressDeserializer {
    public AddressDeserializer() {}

    public Address addressJsonDeserializer(JsonElement json) {
        Address address = new Address();
        Address addressJson = new Gson().fromJson(json, Address.class);
        return addressJson;
    }
}
