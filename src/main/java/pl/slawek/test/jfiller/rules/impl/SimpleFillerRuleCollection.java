package pl.slawek.test.jfiller.rules.impl;

import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerGenerator;
import pl.slawek.test.jfiller.rules.FillerMatcher;
import pl.slawek.test.jfiller.rules.FillerRule;
import pl.slawek.test.jfiller.rules.FillerRuleCollection;

import java.util.*;

/**
 * Created by slawek on 2015-11-10.
 */
public class SimpleFillerRuleCollection implements FillerRuleCollection {
	private List<FillerRule> rules = new ArrayList<FillerRule>();
	private TreeMap<Integer, List<FillerRule>> rulesMap = new TreeMap<Integer, List<FillerRule>>();

	public <T> void addRule(FillerRule<T> fillerRule, int level) {
		List<FillerRule> rules = rulesMap.get(level);
		if (rules == null) {
			rules = new ArrayList<FillerRule>();
			rulesMap.put(level, rules);
		}
		rules.add(fillerRule);
	}

	public <T> void addRule(FillerMatcher fillerMatcher, FillerGenerator<T> generator, int level) {
		addRule(new FillerRuleWrapper<T>(generator, fillerMatcher), level);
	}

	public FillerRule getFillerRuleForFieldOrDefault(FieldInfo fieldInfo, FillerRule defaultFiller) {
		Set<Integer> sortedKeys = rulesMap.keySet();
		for (Integer key : sortedKeys) {
			List<FillerRule> rules = rulesMap.get(key);
			for (FillerRule fillerRule : rules) {
				if (fillerRule.match(fieldInfo)) {
					return fillerRule;
				}
			}
		}
		return defaultFiller;
	}

	@Override
	public FillerRuleCollection clone() {
		SimpleFillerRuleCollection newCollection = new SimpleFillerRuleCollection();
		newCollection.rulesMap = copyMap();
		return newCollection;
	}

	private TreeMap<Integer, List<FillerRule>> copyMap() {
		TreeMap<Integer, List<FillerRule>> newRulesMap = new TreeMap<Integer, List<FillerRule>>();
		Set<Integer> keys = rulesMap.keySet();
		for (Integer key : keys) {
			List<FillerRule> rules = rulesMap.get(key);
			newRulesMap.put(key, rules);
		}
		return newRulesMap;
	}

	public Map<Integer, List<FillerRule>> getAllRules() {
		return Collections.unmodifiableMap(rulesMap);
	}
}
