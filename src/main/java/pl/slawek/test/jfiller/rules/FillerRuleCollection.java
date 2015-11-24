package pl.slawek.test.jfiller.rules;

import pl.slawek.test.jfiller.FieldInfo;

import java.util.List;

/**
 * Created by slawek on 2015-11-10.
 */
public interface FillerRuleCollection extends Cloneable {
	<T> void addRule(FillerRule<T> fillerRule);

	<T> void addRule(FillerMatcher fillerMatcher, FillerGenerator<T> generator);

	List<FillerRule> getAllRules();

	FillerRule getFillerRuleForFieldOrDefault(FieldInfo fieldInfo, FillerRule defaultFiller);

	FillerRuleCollection clone();
}
