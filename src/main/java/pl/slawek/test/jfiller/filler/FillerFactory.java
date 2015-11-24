package pl.slawek.test.jfiller.filler;

import pl.slawek.test.jfiller.rules.FillerRuleCollection;

public interface FillerFactory {
	Filler create(FillerRuleCollection ruleCollection);
}
