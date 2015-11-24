package pl.slawek.test.jfiller.rules;

import pl.slawek.test.jfiller.FieldInfo;

import java.util.Random;

/**
 * Created by slawek on 2015-11-10.
 */
public interface FillerGenerator<T> {
	T generate(FieldInfo fieldInfo, Random random) throws Exception;
}
