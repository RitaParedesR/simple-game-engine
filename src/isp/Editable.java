package isp;

import java.util.Map;

public interface Editable {
    Map<String, String> readProperties();
    boolean writeProperty(String name, String value);
}
