package pl.slawek.test.jfiller.util;

import pl.slawek.test.jfiller.FieldInfo;

/**
 * Created by slawek on 2015-11-04.
 */
public class SimpleFieldInfo extends FieldInfo {

	private Class fieldClass;
	private Class parentClass;

	private SimpleFieldInfo() {
		super(null, null);
	}

	public static SimpleFieldInfo createForFieldClass(Class fieldClass) {
		SimpleFieldInfo simpleFieldInfo = new SimpleFieldInfo();
		simpleFieldInfo.fieldClass = fieldClass;
		return simpleFieldInfo;
	}

	@Override
	public Class getFieldClass() {
		return fieldClass;
	}

	@Override
	public Class getParentClazz() {
		return parentClass;
	}
}
