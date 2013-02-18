package com.fritzmahnke.color;

import java.util.List;

public interface Reference {
    List<ColorSample> getSamples();
    String toString();
    List<String> getDataFields();
}

