package javaBasic;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class Topic_02_AssertJ {
	
	@Test
	public void TC_01() {
		Topic_02_AssertJ frodo = new Topic_02_AssertJ();
		Topic_02_AssertJ sauron = new Topic_02_AssertJ();
		// basic assertions
		assertThat(frodo.getName()).isEqualTo("Frodo");
		assertThat(frodo).isNotEqualTo(sauron);

		// chaining string specific assertions
		assertThat(frodo.getName()).startsWith("Fro").endsWith("n").isEqualToIgnoringCase("frodo");
	}
	public String getName() {
		return "Frodo";
	}
}
