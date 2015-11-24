package pl.slawek.test.jfiller.rules.impl;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerGenerator;
import pl.slawek.test.jfiller.rules.FillerMatcher;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

/**
 * Created by slawek on 2015-11-10.
 */
public class FillerRuleWrapper<T> implements FillerRule<T> {

	private final FillerGenerator<T> generator;
	private final FillerMatcher matcher;

	public FillerRuleWrapper(FillerGenerator<T> generator, FillerMatcher matcher) {
		this.generator = generator;
		this.matcher = matcher;
	}

	public T generate(FieldInfo fieldInfo, Random random) throws Exception {
		return generator.generate(fieldInfo, random);
	}

	public boolean match(FieldInfo fieldInfo) {
		return matcher.match(fieldInfo);
	}
}
