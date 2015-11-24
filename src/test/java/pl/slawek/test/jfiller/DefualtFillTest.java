package pl.slawek.test.jfiller;

import org.junit.Test;
import pl.slawek.test.jfiller.filler.Filler;
import pl.slawek.test.jfiller.models.ClassWithNumberField;

import static org.assertj.core.api.Assertions.assertThat;

public class DefualtFillTest {

	@Test
	public void testFiller_fillDtoWithFloat_byDefault() throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();

		ClassWithNumberField instance = filler.fill(ClassWithNumberField.class);

		Float var = instance.getFloatVar();
		assertThat(var).isNotNull();
	}

	@Test
	public void testFiller_fillDtoWithDouble_byDefault() throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();

		ClassWithNumberField instance = filler.fill(ClassWithNumberField.class);

		Double var = instance.getDoubleVar();
		assertThat(var).isNotNull();
	}

	@Test
	public void testFiller_fillDtoWithLong_byDefault() throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();

		ClassWithNumberField instance = filler.fill(ClassWithNumberField.class);

		Long var = instance.getLongVar();
		assertThat(var).isNotNull();
	}

	@Test
	public void testFiller_fillDtoWithBoolean_byDefault() throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();

		ClassWithNumberField instance = filler.fill(ClassWithNumberField.class);

		Boolean var = instance.getBooleanVar();
		assertThat(var).isNotNull();
	}

	@Test
	public void testFiller_fillDtoWithInteger_byDefault() throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();

		ClassWithNumberField instance = filler.fill(ClassWithNumberField.class);

		Integer var = instance.getIntegerVar();
		assertThat(var).isNotNull();
	}

	@Test
	public void testFiller_fillDtoWithString_byDefault() throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();

		ClassWithNumberField instance = filler.fill(ClassWithNumberField.class);

		String var = instance.getStringVar();
		assertThat(var).isNotNull();
	}
}
