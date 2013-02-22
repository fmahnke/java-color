package com.fritzmahnke.color;

import java.util.List;

public interface Reference {
    List<CxfDocument> getSamples();
    String toString();
    List<String> getDataFields();
}

