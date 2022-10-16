package util;

import bean.ConfigBean;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonParser {
    public ConfigBean parse() throws FileNotFoundException {
        Gson gson=new Gson();
        ConfigBean config=gson.fromJson(new FileReader("Config.json"),ConfigBean.class);
        return config;
    }



}
