package pl.slawek.test.jfiller.rules;

import org.junit.Test;
import pl.slawek.test.jfiller.FieldInfo;
import pl.slawek.test.jfiller.rules.base.LongRule;
import pl.slawek.test.jfiller.util.SimpleFieldInfo;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by slawek on 2015-11-04.
 */
public class LongRuleTest {

	@Test
	public void testMatch() throws Exception {
		LongRule longRule = new LongRule();
		assertTrue(longRule.match(SimpleFieldInfo.createForFieldClass(Long.class)));
	}

	@Test
	public void testGenerateValue_longClass() throws Exception {
		LongRule longRule = new LongRule();
		ConstantLongRandom constantLongRandom = new ConstantLongRandom(25L);
		FieldInfo fieldInfo = SimpleFieldInfo.createForFieldClass(Long.class);

		Object longVal = longRule.generate(fieldInfo, constantLongRandom);

		assertThat(longVal)
				.isOfAnyClassIn(Long.class)
				.isNotNull()
				.isEqualTo(25L);
	}

	private static class ConstantLongRandom extends Random {

		private long constantVar;

		public ConstantLongRandom(long constantVar) {
			this.constantVar = constantVar;
		}

		@Override
		public long nextLong() {
			return constantVar;
		}
	}
}