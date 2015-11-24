package pl.slawek.test.jfiller.rules.base;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

/**
 * Created by slawek on 2015-11-04.
 */
public class ShortRule implements FillerRule<Short> {
	public boolean match(FieldInfo fieldInfo) {
		return fieldInfo.getFieldClass().equals(Short.class);
	}

	public Short generate(FieldInfo fieldInfo, Random random) {
		return (short) random.nextInt();
	}
}
