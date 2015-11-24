package pl.slawek.test.jfiller.rules.impl;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerGenerator;
import pl.slawek.test.jfiller.rules.FillerMatcher;
import pl.slawek.test.jfiller.rules.FillerRule;
import pl.slawek.test.jfiller.rules.FillerRuleCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by slawek on 2015-11-10.
 */
public class SimpleFillerRuleCollection implements FillerRuleCollection {
	private List<FillerRule> rules = new ArrayList<FillerRule>();

	public <T> void addRule(FillerRule<T> fillerRule) {
		rules.add(fillerRule);
	}

	public <T> void addRule(FillerMatcher fillerMatcher, FillerGenerator<T> generator) {
		rules.add(new FillerRuleWrapper<T>(generator, fillerMatcher));
	}

	public FillerRule getFillerRuleForFieldOrDefault(FieldInfo fieldInfo, FillerRule defaultFiller) {
		for (FillerRule fillerRule : rules) {
			if (fillerRule.match(fieldInfo)) {
				return fillerRule;
			}
		}
		return defaultFiller;
	}

	@Override
	public FillerRuleCollection clone() {
		SimpleFillerRuleCollection newCollection = new SimpleFillerRuleCollection();
		newCollection.rules = new ArrayList<FillerRule>(this.rules);
		return newCollection;
	}

	public List<FillerRule> getAllRules() {
		return Collections.unmodifiableList(rules);
	}
}
