package pl.slawek.test.jfiller.filler.impl;

import pl.slawek.test.jfiller.filler.Filler;
import pl.slawek.test.jfiller.filler.FillerFactory;
import pl.slawek.test.jfiller.rules.FillerRuleCollection;

public class SimpleFillerFactory implements FillerFactory {
	public Filler create(FillerRuleCollection ruleCollection) {
		return new SimpleFiller(ruleCollection);
	}
}
