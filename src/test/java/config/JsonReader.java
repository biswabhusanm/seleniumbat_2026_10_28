package config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static String readJsondata(String key) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();//create object for ObjectMapper
        JsonNode jsonNode=objectMapper.readTree(new File("src/test/resources/Testdata/testdata.json"));//reading the json from json file
        String name=jsonNode.get(key).asText();
        return name;

    }
}
