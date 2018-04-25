package com.diem.den.pulse;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denys Baranov inc. on 24.04.2018.
 */

public class RecipeRequestout extends StringRequest {
    private static final String RECIPE_REQUEST_URL = "https://buylistden.000webhostapp.com/recipe.php";
    private Map<String, String> params;

    public RecipeRequestout(String username, String doctorUN,String medicine,String instruction,String time, Response.Listener<String> listener) {
        super(Method.POST, RECIPE_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("doctorUN", doctorUN);
        params.put("medicine", medicine);
        params.put("instruction", instruction);
        params.put("time", time);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}