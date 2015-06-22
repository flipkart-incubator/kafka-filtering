package flipkart.kafka.filtering.model;

import java.nio.ByteBuffer;
import java.util.Map;

/**
 * Created by pradeep on 20/06/15.
 */
public class FilterWrapper {

    Map<String, String> tags;

    ByteBuffer data;

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public ByteBuffer getData() {
        return data;
    }

    public void setData(ByteBuffer data) {
        this.data = data;
    }
}
