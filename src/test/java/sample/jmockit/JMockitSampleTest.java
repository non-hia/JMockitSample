package sample.jmockit;

import static org.junit.Assert.*;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

import org.junit.Before;
import org.junit.Test;

import sample.jmockit.JMockSample;
import sample.jmockit.TestTarget;

public class JMockitSampleTest {

	@Tested
	private TestTarget testTarget;
	@Injectable
	private JMockSample jMockSampleMock;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test01() {
		new Expectations() {
			{
				jMockSampleMock.is();
				result = false;
			}
		};
		
		assertEquals(testTarget.get(), "Sample");
	}

	@Test
	public void test02() {
		new Expectations() {
			{
				jMockSampleMock.is();
				result = true;
			}
		};
		
		assertEquals(testTarget.get(), "JMock");
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
			testTarget.get();
			fail();
		} catch (IllegalStateException e) {
			assertEquals(e.getMessage(), "test");
		}
	}
	
}
