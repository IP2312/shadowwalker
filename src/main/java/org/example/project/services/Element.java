package org.example.project.services;

import java.util.List;
import java.util.Map;

public class Element {
        public String type;
        public long id;
        public List<Long> nodes; // for "way"
        public Map<String, String> tags;
        public Double lat; // for "node"
        public Double lon;
}
