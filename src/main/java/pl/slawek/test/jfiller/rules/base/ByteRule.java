package pl.slawek.test.jfiller.rules.base;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

/**
 * Created by slawek on 2015-11-04.
 */
public class ByteRule implements FillerRule<Byte> {
	public boolean match(FieldInfo fieldInfo) {
		return fieldInfo.getFieldClass().equals(Byte.class);
	}

	public Byte generate(FieldInfo fieldInfo, Random random) {
		byte[] byt = new byte[1];
		random.nextBytes(byt);
		return byt[0];
	}
}
