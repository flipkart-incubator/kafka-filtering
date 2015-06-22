import flipkart.kafka.filtering.Codec;
import flipkart.kafka.filtering.exp.FilterExpression;
import flipkart.kafka.filtering.exp.impl.MvelExpression;
import flipkart.kafka.filtering.model.FilterWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pradeep on 20/06/15.
 */
public class FilterTest {

    private static byte[] DATA = "asbjhjh".getBytes(); //json
    private static Map<String,String> tags = new HashMap<String, String>()
    {{
        put("a", "1");
        put("type", "CREATED");
    }};


    public static void main(String args[]) {

        Codec codec = new Codec();
        FilterExpression filterExpression = new MvelExpression("a==1 && type == 'CREATED'");
        byte[] msg = codec.encode(DATA, tags);

        FilterWrapper fw = codec.decode(msg);
        if ( filterExpression.isInteresting(fw) ) {
            System.out.println("Yes I want!");
        }

    }

}
