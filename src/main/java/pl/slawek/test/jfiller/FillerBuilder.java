package pl.slawek.test.jfiller;

import pl.slawek.test.jfiller.rules.FillerRule;
import pl.slawek.test.jfiller.rules.FillerRuleCollection;
import pl.slawek.test.jfiller.rules.impl.SimpleFillerRuleCollection;

public class FillerBuilder {
	private FillerRuleCollection ruleCollection;

	public FillerBuilder() {
		registerRuleCollection(new SimpleFillerRuleCollection());
	}

	public void registerRuleCollection(FillerRuleCollection ruleCollection) {
		this.ruleCollection = ruleCollection;
		fillRuleCollectionWithDefaultRule();
	}

	public Filler build() {
		FillerRuleCollection collection = ruleCollection.clone();
		return new Filler(ruleCollection);
	}

	private void fillRuleCollectionWithDefaultRule() {
		RegisterDefaultRule registerDefaultRule = RegisterDefaultRule.getInstance();
		for (FillerRule rule : registerDefaultRule.getDefaultRules()) {
			ruleCollection.addRule(rule);
		}
	}
}
