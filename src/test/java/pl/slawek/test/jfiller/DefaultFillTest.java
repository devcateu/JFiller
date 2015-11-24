package pl.slawek.test.jfiller;

import org.junit.Test;
import pl.slawek.test.jfiller.filler.Filler;
import pl.slawek.test.jfiller.models.ClassWithNumberField;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultFillTest {

	@Test
	public void testFiller_fillDtoWithFloat_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getFloatVar();
			}
		}, Float.class);
	}

	@Test
	public void testFiller_fillDtoWithDouble_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getDoubleVar();
			}
		}, Double.class);
	}

	@Test
	public void testFiller_fillDtoWithLong_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getLongVar();
			}
		}, Long.class);
	}

	@Test
	public void testFiller_fillDtoWithBoolean_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getBooleanVar();
			}
		}, Boolean.class);
	}

	@Test
	public void testFiller_fillDtoWithInteger_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getIntegerVar();
			}
		}, Integer.class);
	}

	@Test
	public void testFiller_fillDtoWithString_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getStringVar();
			}
		}, String.class);
	}

	@Test
	public void testFiller_fillDtoWithByte_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getByteVar();
			}
		}, Byte.class);
	}

	@Test
	public void testFiller_fillDtoWithCharacter_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getCharacterVar();
			}
		}, Character.class);
	}

	@Test
	public void testFiller_fillDtoWithShort_byDefault() throws Exception {
		testFiller_fieldIsNotNull(new TestFillerFillField() {
			public Object get(ClassWithNumberField instance) {
				return instance.getShortVar();
			}
		}, Short.class);
	}

	private void testFiller_fieldIsNotNull(TestFillerFillField testFillField, Class clazz) throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();

		ClassWithNumberField instance = filler.fill(ClassWithNumberField.class);

		Object var = testFillField.get(instance);
		assertThat(var).isNotNull().isInstanceOf(clazz);
	}

	private interface TestFillerFillField {
		Object get(ClassWithNumberField instance);
	}
}
