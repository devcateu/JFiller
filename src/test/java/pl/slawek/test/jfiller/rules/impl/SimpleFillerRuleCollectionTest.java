package pl.slawek.test.jfiller.rules.impl;

import org.junit.Test;
import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.FillerGenerator;
import pl.slawek.test.jfiller.rules.FillerMatcher;
import pl.slawek.test.jfiller.rules.FillerRule;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by slawek on 2015-11-10.
 */
public class SimpleFillerRuleCollectionTest {

	@Test
	public void testAddRule_FillerGenerator_FillerMatcher() throws Exception {
		SimpleFillerRuleCollection ruleCollection = new SimpleFillerRuleCollection();
		assertThat(ruleCollection.getAllRules().size()).isEqualTo(0);
		ruleCollection.addRule(new FillerMatcher() {
			public boolean match(FieldInfo fieldInfo) {
				return false;
			}
		}, new FillerGenerator() {
			public Object generate(FieldInfo fieldInfo, Random random) throws Exception {
				return null;
			}
		}, 6);
		assertThat(ruleCollection.getAllRules().size()).isEqualTo(1);
	}

	@Test
	public void testAddRule_FillerRule() throws Exception {
		SimpleFillerRuleCollection ruleCollection = new SimpleFillerRuleCollection();
		assertThat(ruleCollection.getAllRules().size()).isEqualTo(0);

		ruleCollection.addRule(new FillerRule() {
			public Object generate(FieldInfo fieldInfo, Random random) throws Exception {
				return null;
			}

			public boolean match(FieldInfo fieldInfo) {
				return false;
			}
		}, 7);
		assertThat(ruleCollection.getAllRules().size()).isEqualTo(1);
	}
}