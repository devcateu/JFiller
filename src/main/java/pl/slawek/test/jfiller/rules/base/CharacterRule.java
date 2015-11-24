package pl.slawek.test.jfiller.rules.base;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

/**
 * Created by slawek on 2015-11-04.
 */
public class CharacterRule implements FillerRule<Character> {
	public boolean match(FieldInfo fieldInfo) {
		return fieldInfo.getFieldClass().equals(Character.class);
	}

	public Character generate(FieldInfo fieldInfo, Random random) {
		return (char) (random.nextInt(26) + 'a');
	}
}
