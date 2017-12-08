package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RateingsTest {

	Rateings test = new Rateings(1L, 2L, 3);
	
	@Test
	public void testCreate() {
		assertEquals(1, 1L, test.userid);
		assertEquals(1, 2L, test.movieid);
		assertEquals(3, test.rateing);
	}

	@Test
	public void testToString() {
		assertEquals("Rateings{" + test.id + ", 2, 1, 3}", test.toString());
	}

}