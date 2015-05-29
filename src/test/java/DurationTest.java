import com.nordicusability.jiffy.contract.data.Duration;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class DurationTest {

	@Test
	public void test1(){
		Duration duration = new Duration(TimeUnit.HOURS.toMillis(2) + TimeUnit.MINUTES.toMillis(14));
		assertEquals(2, duration.getHours());
		assertEquals(14, duration.getMinutes());
		assertEquals(2.233, duration.getFractionalHours(), 0.01);
	}

}
