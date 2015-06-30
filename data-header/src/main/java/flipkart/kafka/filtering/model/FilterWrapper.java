package flipkart.kafka.filtering.model;

import java.util.Map;

/**
 * Created by pradeep on 20/06/15.
 */
public class FilterWrapper {

    Map<String, String> tags;

    byte[] data;

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
