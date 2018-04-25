package com.diem.den.pulse;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denys Baranov inc. on 24.04.2018.
 */

public class RecipeRequestIn extends StringRequest {
    private static final String RECIPE_REQUEST_URL = "https://buylistden.000webhostapp.com/getRecipe.php";
    private Map<String, String> params;

    public RecipeRequestIn(String username, Response.Listener<String> listener) {
        super(Method.POST, RECIPE_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}