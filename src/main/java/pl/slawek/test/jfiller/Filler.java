package pl.slawek.test.jfiller;

import pl.slawek.test.jfiller.rules.FillerRule;
import pl.slawek.test.jfiller.rules.FillerRuleCollection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by slawek on 2015-11-04.
 */
public class Filler {
	private List<Exception> problemsDuringFilling = new ArrayList<Exception>();
	private Random random = new Random();
	private FillerRuleCollection ruleCollection;
	private FillerRule<Object> defaultFiller = new FillerRule<Object>() {
		public boolean match(FieldInfo fieldInfo) {
			return true;
		}

		public Object generate(FieldInfo fieldInfo, Random random) throws Exception {
			return Filler.this.fill(fieldInfo.getFieldClass());
		}
	};

	public Filler(FillerRuleCollection ruleCollection) {
		this.ruleCollection = ruleCollection;
	}

	public <T> T fill(Class<T> tClass) throws Exception {
		T instance = tClass.newInstance();
		fillFields(instance);

		return instance;
	}

	public void fillFields(Object instance) throws IllegalAccessException {
		if (instance != null) {
			Class instanceClass = instance.getClass();
			Field[] fields = instanceClass.getDeclaredFields();
			for (Field field : fields) {
				fillField(instance, instanceClass, field);
			}
		}
	}

	private void fillField(Object instance, Class instanceClass, Field field) {
		field.setAccessible(true);
		FieldInfo fieldInfo = new FieldInfo(instanceClass, field);
		FillerRule fillerRule = ruleCollection.getFillerRuleForFieldOrDefault(fieldInfo, defaultFiller);
		try {
			field.set(instance, fillerRule.generate(fieldInfo, random));
		} catch (Exception e) {
			problemsDuringFilling.add(e);
		}
	}

	public List<Exception> getProblemsDuringFilling() {
		return Collections.unmodifiableList(problemsDuringFilling);
	}
}
