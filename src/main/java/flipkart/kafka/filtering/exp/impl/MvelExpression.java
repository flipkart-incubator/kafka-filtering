package flipkart.kafka.filtering.exp.impl;

import flipkart.kafka.filtering.exp.FilterExpression;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by pradeep on 20/06/15.
 */
public class MvelExpression extends FilterExpression {


    private final Serializable compiled;

    public MvelExpression(String mvelExpr) {
        compiled = MVEL.compileExpression(mvelExpr);
    }

    @Override
    public boolean isInteresting(Map<String, String> tags) {
        return (Boolean) MVEL.executeExpression(compiled, tags);
    }
}
