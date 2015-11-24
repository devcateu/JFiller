package pl.slawek.test.jfiller.rules.base;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

/**
 * Created by slawek on 2015-11-04.
 */
public class IntegerRule implements FillerRule<Integer> {
	public boolean match(FieldInfo fieldInfo) {
		return fieldInfo.getFieldClass().equals(Integer.class);
	}

	public Integer generate(FieldInfo fieldInfo, Random random) {
		return random.nextInt();
	}
}
