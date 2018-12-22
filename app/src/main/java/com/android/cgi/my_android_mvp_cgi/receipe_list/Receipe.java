package com.android.cgi.my_android_mvp_cgi.receipe_list;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipe {
    private String title;
    private String href;
        private List<String> ingredients = null;
        private String thumbnail;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public List<String> getIngredients() {
            return ingredients;
        }

        public void setIngredients(List<String> ingredients) {
            this.ingredients = ingredients;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
