package com.example.tsdmif.JsonParse;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Args {
    private JSONObject jsonObject;
    private JSONObject jsonObject1;

    public Args(String text) throws JSONException {
        jsonObject = new JSONObject(text);
        jsonObject1 = jsonObject.getJSONObject("#value");
    }


    public String[][] column2() throws JSONException {
        JSONArray jsonArray = jsonObject1.getJSONArray("row");
        String[][] column2 = new String[jsonArray.length()][];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray jsonArray1 = jsonArray.getJSONArray(i);
            column2[i] = new String[jsonArray1.length()];
            for (int j = 0; j < jsonArray1.length(); j++) {
                column2[i][j] = jsonArray1.getString(j);

            }
        }
        return column2;
    }
}