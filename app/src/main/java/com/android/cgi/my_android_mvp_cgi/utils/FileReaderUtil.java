package com.android.cgi.my_android_mvp_cgi.utils;

import android.content.Context;

import com.android.cgi.my_android_mvp_cgi.receipe_list.Receipe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class FileReaderUtil {
    public static List<Receipe> readFilefromResource(Context context, int resource) throws IOException {
        String json = null;
        Gson gson = new Gson();
        InputStream inputStream = context.getResources().openRawResource(resource);
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        json = new String(buffer, "UTF-8");
        Type listType = new TypeToken<List<Receipe>>(){}.getType();
        return gson.fromJson(json, listType);
    }
}
