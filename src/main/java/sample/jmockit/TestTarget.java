package sample.jmockit;

public class TestTarget {

	private JMockSample jMockSample;
	
	public String get() {
		return jMockSample.is() ? "JMock" : "Sample";
	}
}
