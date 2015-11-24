package pl.slawek.test.jfiller.rules.base;

import pl.slawek.test.jfiller.rules.DefaultFillerRuleInitializer;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Arrays;
import java.util.List;

public class AdderRulesToRegister implements DefaultFillerRuleInitializer {

	public List<? extends FillerRule> getFillerDefaultRule() {
		return Arrays.asList(new FloatRule(), new DoubleRule(), new LongRule(), new IntegerRule(), new BooleanRule(), new StringRule(), new
				ByteRule(), new CharacterRule(), new ShortRule());
	}
}
