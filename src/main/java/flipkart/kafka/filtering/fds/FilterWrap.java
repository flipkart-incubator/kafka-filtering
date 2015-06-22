// automatically generated, do not modify

package flipkart.kafka.filtering.fds;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public final class FilterWrap extends Table {
  public static FilterWrap getRootAsFilterWrap(ByteBuffer _bb) { return getRootAsFilterWrap(_bb, new FilterWrap()); }
  public static FilterWrap getRootAsFilterWrap(ByteBuffer _bb, FilterWrap obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public FilterWrap __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String tags(int j) { int o = __offset(4); return o != 0 ? __string(__vector(o) + j * 4) : null; }
  public int tagsLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public int data(int j) { int o = __offset(6); return o != 0 ? bb.get(__vector(o) + j * 1) & 0xFF : 0; }
  public int dataLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer dataAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }

  public static int createFilterWrap(FlatBufferBuilder builder,
      int tags,
      int data) {
    builder.startObject(2);
    FilterWrap.addData(builder, data);
    FilterWrap.addTags(builder, tags);
    return FilterWrap.endFilterWrap(builder);
  }

  public static void startFilterWrap(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addTags(FlatBufferBuilder builder, int tagsOffset) { builder.addOffset(0, tagsOffset, 0); }
  public static int createTagsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startTagsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addData(FlatBufferBuilder builder, int dataOffset) { builder.addOffset(1, dataOffset, 0); }
  public static int createDataVector(FlatBufferBuilder builder, byte[] data) { builder.startVector(1, data.length, 1); for (int i = data.length - 1; i >= 0; i--) builder.addByte(data[i]); return builder.endVector(); }
  public static void startDataVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static int endFilterWrap(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishFilterWrapBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
};

