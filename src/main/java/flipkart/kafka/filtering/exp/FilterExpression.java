package flipkart.kafka.filtering.exp;

import flipkart.kafka.filtering.model.FilterWrapper;

import java.util.Map;

/**
 * Created by pradeep on 20/06/15.
 */
public abstract class FilterExpression {

    protected abstract boolean isInteresting(Map<String, String> tags);

//    public final boolean isInteresting(FB_FilterWrap filterWrapper) {
//        return isInteresting(
//                Codec.getTags(filterWrapper)
//        );
//    }

    public final boolean isInteresting(FilterWrapper filterWrapper) {
        return isInteresting(
                filterWrapper.getTags()
        );
    }

}
