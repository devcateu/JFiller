package pl.slawek.test.jfiller;

public class ProblemDuringFilling {
	private final Exception exception;

	public ProblemDuringFilling(Exception exception) {
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}
}
