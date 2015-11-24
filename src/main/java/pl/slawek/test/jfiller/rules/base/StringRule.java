package pl.slawek.test.jfiller.rules.base;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

/**
 * Created by slawek on 2015-11-10.
 */
public class StringRule implements FillerRule<String> {

	private final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public String generate(FieldInfo fieldInfo, Random random) throws Exception {
		StringBuilder sb = new StringBuilder(20);
		for (int i = 0; i < 20; i++) {
			sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}
		return sb.toString();
	}

	public boolean match(FieldInfo fieldInfo) {
		return fieldInfo.getFieldClass().equals(String.class);
	}
}
