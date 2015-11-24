package pl.slawek.test.jfiller.rules.base;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

/**
 * Created by slawek on 2015-11-04.
 */
public class BooleanRule implements FillerRule<Boolean> {
	public boolean match(FieldInfo fieldInfo) {
		return fieldInfo.getFieldClass().equals(Boolean.class);
	}

	public Boolean generate(FieldInfo fieldInfo, Random random) {
		return random.nextBoolean();
	}
}
