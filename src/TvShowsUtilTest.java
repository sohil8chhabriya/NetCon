import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TvShowsUtilTest{

	@Test
	void testConvertProgramsShowByChanneltoMapIsNull(){
		TvShowsUtil utils = new TvShowsUtil();
		TvShows nullShows = utils.convertProgramsShowByChanneltoMap(null);
		assertEquals(nullShows,new TvShows());
	}

	@Test
	void testConvertProgramsShowByChanneltoMapIsBlank(){
		TvShowsUtil utils = new TvShowsUtil();
		TvShows emptyShows = utils.convertProgramsShowByChanneltoMap(new ArrayList<TvShows>());
		assertEquals(emptyShows, new TvShows());
	}

	@Test
	void testGetDupPercentageCheckIsNull(){
		TvShowsUtil utils = new TvShowsUtil();
		TvShows dupeCheckWithNull = utils.getDupPercentageCheck(null);
		assertEquals(dupeCheckWithNull,new TvShows());
	}
	@Test
	void testGetDupPercentageCheckIsBlank(){
		TvShowsUtil utils = new TvShowsUtil();
		TvShows dupeCheckWithBlank = utils.getDupPercentageCheck(new TvShows());
		assertEquals(dupeCheckWithBlank, new TvShows());
	}

}
