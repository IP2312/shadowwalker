package org.example.project.model;

import java.util.List;
import java.util.Map;

public class OverpassElement {
        public String type;
        public long id;
        public List<Long> nodes;
        public Map<String, String> tags;
        public Double lat;
        public Double lon;
}
