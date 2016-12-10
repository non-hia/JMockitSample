package sample.jmockit;

public class TestTarget {

	public String get(JMockSample jMockSample) {
		return jMockSample.is() ? "JMock" : "Sample";
	}
}
