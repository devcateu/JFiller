package pl.slawek.test.jfiller.rules;

import org.junit.Test;
import pl.slawek.test.jfiller.rules.base.StringRule;
import pl.slawek.test.jfiller.util.SimpleFieldInfo;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by slawek on 2015-11-10.
 */
public class StringRuleTest {

	@Test
	public void testMatch() throws Exception {
		StringRule stringRule = new StringRule();
		assertTrue(stringRule.match(SimpleFieldInfo.createForFieldClass(String.class)));
		assertFalse(stringRule.match(SimpleFieldInfo.createForFieldClass(Long.class)));
	}
}