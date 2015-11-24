package pl.slawek.test.jfiller.rules.base;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

/**
 * Created by slawek on 2015-11-04.
 */
public class LongRule implements FillerRule<Long> {
	public boolean match(FieldInfo fieldInfo) {
		return fieldInfo.getFieldClass().equals(Long.class);
	}

	public Long generate(FieldInfo fieldInfo, Random random) {
		return random.nextLong();
	}
}
