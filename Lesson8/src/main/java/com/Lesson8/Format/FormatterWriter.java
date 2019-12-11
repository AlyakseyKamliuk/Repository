package com.Lesson8.Format;

import java.util.List;

public interface FormatterWriter {

     void fileWriteTo(Object o, String filePath);
     void fileWriteTo(List<Object> objects, String filePath);
}
