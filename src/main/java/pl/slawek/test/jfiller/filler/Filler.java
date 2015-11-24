package pl.slawek.test.jfiller.filler;

import pl.slawek.test.jfiller.ProblemDuringFilling;

import java.util.List;

public interface Filler {
	<T> T fill(Class<T> tClass) throws Exception;

	void fillFields(Object instance) throws Exception;

	List<ProblemDuringFilling> getProblemsDuringFilling();
}
