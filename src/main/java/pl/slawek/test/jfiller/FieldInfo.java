package pl.slawek.test.jfiller;

import java.lang.reflect.Field;

/**
 * Created by slawek on 2015-11-04.
 */
public class FieldInfo {
	private final Class parentClazz;
	private final Field field;

	public FieldInfo(Class parentClazz, Field field) {
		this.parentClazz = parentClazz;
		this.field = field;
	}

	public Class getFieldClass() {
		return field.getType();
	}

	public Class getParentClazz() {
		return parentClazz;
	}

	public Field getField() {
		return field;
	}
}
