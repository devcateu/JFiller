package pl.slawek.test.jfiller.rules;

import pl.slawek.test.jfiller.FieldInfo;

/**
 * Created by slawek on 2015-11-10.
 */
public interface FillerMatcher {
	boolean match(FieldInfo fieldInfo);
}
