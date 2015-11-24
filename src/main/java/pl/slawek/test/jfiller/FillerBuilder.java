package pl.slawek.test.jfiller;

import pl.slawek.test.jfiller.filler.Filler;
import pl.slawek.test.jfiller.filler.FillerFactory;
import pl.slawek.test.jfiller.filler.impl.SimpleFillerFactory;
import pl.slawek.test.jfiller.rules.FillerRule;
import pl.slawek.test.jfiller.rules.FillerRuleCollection;
import pl.slawek.test.jfiller.rules.impl.SimpleFillerRuleCollection;

public class FillerBuilder {
	private FillerRuleCollection ruleCollection;
	private FillerFactory factory;

	public FillerBuilder() {
		registerRuleCollection(new SimpleFillerRuleCollection());
		setFillerFactory(new SimpleFillerFactory());
	}

	public void registerRuleCollection(FillerRuleCollection ruleCollection) {
		this.ruleCollection = ruleCollection;
		fillRuleCollectionWithDefaultRule();
	}

	public void setFillerFactory(FillerFactory factory) {
		this.factory = factory;
	}

	public Filler build() {
		FillerRuleCollection collection = ruleCollection.clone();
		return factory.create(collection);
	}

	private void fillRuleCollectionWithDefaultRule() {
		RegisterDefaultRule registerDefaultRule = RegisterDefaultRule.getInstance();
		for (FillerRule rule : registerDefaultRule.getDefaultRules()) {
			ruleCollection.addRule(rule);
		}
	}
}
