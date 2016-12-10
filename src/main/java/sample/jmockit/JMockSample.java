package sample.jmockit;

public class JMockSample {

	private InnerClass innerClass;
	
	public boolean is() {
		return innerClass.is();
	}
	
	private class InnerClass {
		boolean is() {
			return false;
		}
	}
}
