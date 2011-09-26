package com.isobar.isohealth;

import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 * When using a Spring Controller that is ignorant of media types, the resulting model
 * objects end up in a map as values. The MappingJacksonJsonView then converts this map
 * to JSON, which (possibly) incorrectly wraps the single model object in the map
 * entry's key. This class eliminates this wrapper element if there is only one model
 * object.
 */
public class NoWrappingMappingJacksonJsonView extends MappingJacksonJsonView {
    @Override
    @SuppressWarnings("unchecked")
    protected Object filterModel(Map<String, Object> model) {
        Map<String, Object> filteredModel = (Map<String, Object>) super.filterModel(model);
        if(filteredModel.size() != 1) return filteredModel;
        return filteredModel.entrySet().iterator().next().getValue();
    }
}