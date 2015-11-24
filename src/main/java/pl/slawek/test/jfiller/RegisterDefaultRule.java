package pl.slawek.test.jfiller;

import org.reflections.Reflections;
import pl.slawek.test.jfiller.rules.DefaultFillerRuleInitializer;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RegisterDefaultRule {
	private static RegisterDefaultRule ourInstance = new RegisterDefaultRule();
	private final List<FillerRule> defaultRules = new ArrayList<FillerRule>();

	private RegisterDefaultRule() {
		init();
	}

	public static RegisterDefaultRule getInstance() {
		return ourInstance;
	}

	private void init() {
		Reflections reflections = new Reflections();
		Set<Class<? extends DefaultFillerRuleInitializer>> classSet = reflections.getSubTypesOf(DefaultFillerRuleInitializer.class);
		for (Class clazz : classSet) {
			try {
				DefaultFillerRuleInitializer ruleInitializer = (DefaultFillerRuleInitializer) clazz.newInstance();
				List<? extends FillerRule> defaultRules = ruleInitializer.getFillerDefaultRule();
				this.defaultRules.addAll(defaultRules);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<FillerRule> getDefaultRules() {
		return Collections.unmodifiableList(defaultRules);
	}
}
