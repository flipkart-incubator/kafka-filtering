import flipkart.kafka.filtering.Codec;
import flipkart.kafka.filtering.exp.FilterExpression;
import flipkart.kafka.filtering.exp.impl.MvelExpression;
import flipkart.kafka.filtering.model.FilterWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pradeep on 22/06/15.
 */
public class FilterTest {

    private static byte[] DATA = "guasdak".getBytes();
    private static Map<String,String> tags = new HashMap<String, String>() {{
        put("entity", "ORDER");
        put("type", "CREATED");
        put("long", "1283102390123");
    }};
    private static Codec codec = new Codec();
    private static FilterExpression falseExpression = new MvelExpression("entity==1");
    private static FilterExpression trueExpression = new MvelExpression("entity=='ORDER' && type == 'CREATED'");

    public static void main(String args[]) {

        /** WARMUP **/
        byte[] encoded = codec.encode(DATA, tags);
        /** WARMUP ENDS**/

        {
            long start = System.nanoTime();
            int iter = 1000000;
            for ( int i = 0; i < iter; i++) {
                codec.encode(DATA, tags);
            }

            long stop = System.nanoTime();

            System.out.println("Encode: " + iter + " calls, time taken for each call: " + ((stop - start) * 1.0 /  iter / 1000) + " micro secs");
        }

        /** WARMUP **/
        {
            FilterWrapper wrappedMsg = codec.decode(encoded);
            trueExpression.isInteresting(wrappedMsg);
        }
        /** WARMUP ENDS**/

        {

            long start = System.nanoTime();
            int iter = 1000000;
            for ( int i = 0; i < iter; i++) {
                FilterWrapper wrappedMsg = codec.decode(encoded);
                trueExpression.isInteresting(wrappedMsg);
            }

            long stop = System.nanoTime();

            System.out.println("Decode & Filter: " + iter + " calls, time taken for each call:" + ((stop - start) * 1.0 / iter / 1000) + " micro secs");
        }
    }

}
