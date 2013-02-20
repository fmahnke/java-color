package com.fritzmahnke.color;

import java.util.List;

public interface Reference {
    List<CxFDocument> getSamples();
    String toString();
    List<String> getDataFields();
}

