// automatically generated, do not modify

package flipkart.kafka.filtering.fds;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public final class FB_Tuple extends Table {
  public static FB_Tuple getRootAsFB_Tuple(ByteBuffer _bb) { return getRootAsFB_Tuple(_bb, new FB_Tuple()); }
  public static FB_Tuple getRootAsFB_Tuple(ByteBuffer _bb, FB_Tuple obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public FB_Tuple __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String k() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer kAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public String v() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer vAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }

  public static int createFB_Tuple(FlatBufferBuilder builder,
      int k,
      int v) {
    builder.startObject(2);
    FB_Tuple.addV(builder, v);
    FB_Tuple.addK(builder, k);
    return FB_Tuple.endFB_Tuple(builder);
  }

  public static void startFB_Tuple(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addK(FlatBufferBuilder builder, int kOffset) { builder.addOffset(0, kOffset, 0); }
  public static void addV(FlatBufferBuilder builder, int vOffset) { builder.addOffset(1, vOffset, 0); }
  public static int endFB_Tuple(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

