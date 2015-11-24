package pl.slawek.test.jfiller;

import org.junit.Test;
import pl.slawek.test.jfiller.models.SampleDtoWithClassInner;
import pl.slawek.test.jfiller.models.SampleEmptyDto;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by slawek on 2015-11-04.
 */
public class FillerTest {

	@Test
	public void testFill_whenInvoke_shouldCreateNewObject() throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();
		SampleEmptyDto instance = filler.fill(SampleEmptyDto.class);

		assertThat(instance).isNotNull();
	}

	@Test
	public void testFill() throws Exception {
		FillerBuilder fillerBuilder = new FillerBuilder();
		Filler filler = fillerBuilder.build();
		SampleDtoWithClassInner instance = filler.fill(SampleDtoWithClassInner.class);

		assertThat(instance.getEmptyDto()).isNotNull();
	}
}