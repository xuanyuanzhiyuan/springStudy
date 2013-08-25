package com.xysoft.springstudy.mvc.view;

import com.google.gson.Gson;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.Map;

/**
 * User: jinyanhua
 * Date: 13-8-25
 * Time: 上午11:25
 */
public class JsonGenView implements View {
    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        Writer writer = response.getWriter();
        writer.write(gson.toJson(model));
        writer.flush();
        writer.close();
    }
}
