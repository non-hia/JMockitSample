package sample.jmockit;

import static org.junit.Assert.*;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;

import sample.jmockit.JMockSample;
import sample.jmockit.TestTarget;

public class JMockitSampleTest {

	private TestTarget testTarget;
	@Mocked
	private JMockSample jMockSampleMock;
	
	@Before
	public void setUp() throws Exception {
		testTarget = new TestTarget();
	}

	@Test
	public void test01() {
		new Expectations() {
			{
				jMockSampleMock.is();
				result = false;
			}
		};
		
		assertEquals(testTarget.get(jMockSampleMock), "Sample");
	}

	@Test
	public void test02() {
		new Expectations() {
			{
				jMockSampleMock.is();
				result = true;
			}
		};
		
		assertEquals(testTarget.get(jMockSampleMock), "JMock");
	}
	
	@Test
	public void test03() {
		new Expectations() {
			{
				jMockSampleMock.is();
				result = new IllegalStateException("test");
			}
		};
		
		try {
			testTarget.get(jMockSampleMock);
			fail();
		} catch (IllegalStateException e) {
			assertEquals(e.getMessage(), "test");
		}
	}
	
}
