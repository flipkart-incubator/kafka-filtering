package flipkart.kafka.filtering;

import com.google.flatbuffers.FlatBufferBuilder;
import flipkart.kafka.filtering.fds.FB_FilterWrap;
import flipkart.kafka.filtering.fds.FB_Tuple;
import flipkart.kafka.filtering.model.FilterWrapper;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pradeep on 20/06/15.
 */
public class Codec {

    public byte[] encode(byte[] serializedWithoutWrap, Map<String, String> tags) {

        FlatBufferBuilder fbb = new FlatBufferBuilder(1024);

        int[] tagsArr = new int[tags.size()];

        int i = 0;
        for (Map.Entry<String, String> entry : tags.entrySet()) {
            tagsArr[i] = _encodeEntry(entry, fbb);
            i++;
        }

        int tagsRef = FB_FilterWrap.createTagsVector(fbb, tagsArr);
        int dataRef = FB_FilterWrap.createDataVector(fbb, serializedWithoutWrap);


        int filterWrapRef = FB_FilterWrap.createFB_FilterWrap(fbb, tagsRef, dataRef);
        FB_FilterWrap.finishFB_FilterWrapBuffer(fbb, filterWrapRef);

        int buffer_start = fbb.dataBuffer().position();
        int buffer_length = fbb.offset();
        byte[] full_buffer = fbb.dataBuffer().array();

        return Arrays.copyOfRange(full_buffer, buffer_start, buffer_start + buffer_length);
    }

    private static int _encodeEntry(Map.Entry<String, String> entry, FlatBufferBuilder fbb) {
        int k_ref =  fbb.createString(entry.getKey());
        int v_ref = fbb.createString(entry.getValue());

        return FB_Tuple.createFB_Tuple(fbb, k_ref, v_ref);
    }

    public FilterWrapper decode(byte[] serializedWithWrap) {
        ByteBuffer bb = ByteBuffer.wrap(serializedWithWrap);
        FB_FilterWrap fbWrapper = FB_FilterWrap.getRootAsFB_FilterWrap(bb);

        FilterWrapper wrapper = new FilterWrapper();
        wrapper.setData(fbWrapper.dataAsByteBuffer());
        wrapper.setTags(getTags(fbWrapper));
        return wrapper;
    }

    public static Map<String, String> getTags(FB_FilterWrap filterWrapper) {
        int len = filterWrapper.tagsLength();
        Map<String, String> tags = new HashMap<String, String>();
        for ( int i = 0; i < len; i++ ) {
            FB_Tuple tagTuple = filterWrapper.tags(i);
            tags.put(tagTuple.k(), tagTuple.v());
        }

        return tags;
    }


}
