package pl.slawek.test.jfiller.rules;

import pl.slawek.test.jfiller.FieldInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by slawek on 2015-11-10.
 */
public interface FillerRuleCollection extends Cloneable {
	<T> void addRule(FillerRule<T> fillerRule, int level);

	<T> void addRule(FillerMatcher fillerMatcher, FillerGenerator<T> generator, int level);

	Map<Integer, List<FillerRule>> getAllRules();

	FillerRule getFillerRuleForFieldOrDefault(FieldInfo fieldInfo, FillerRule defaultFiller);

	FillerRuleCollection clone();
}
