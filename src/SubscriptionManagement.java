import java.util.ArrayList;
import java.util.List;

public class SubscriptionManagement {
	public static void main(String[] args) {
		TvShows nf = new TvShows(ChannelsEnum.Netflix);
		TvShows hs = new TvShows(ChannelsEnum.HotStar);
		TvShows ap = new TvShows(ChannelsEnum.AmazonPrime);

		List<TvShows> channels = new ArrayList<TvShows>();
		channels.add(hs);
		channels.add(nf);
		channels.add(ap);
		hs.addProgramToList(ProgramsEnum.A);
		hs.addProgramToList(ProgramsEnum.C);
		hs.addProgramToList(ProgramsEnum.D);

		ap.addProgramToList(ProgramsEnum.A);
		ap.addProgramToList(ProgramsEnum.D);
		ap.addProgramToList(ProgramsEnum.E);

		nf.addProgramToList(ProgramsEnum.F);
		nf.addProgramToList(ProgramsEnum.G);
		TvShowsUtil util = TvShows.getUtilities();

		TvShows tvShowsMap = util.convertProgramsShowByChanneltoMap(channels);
		tvShowsMap = util.getDupPercentageCheck(tvShowsMap);
		util.printResults(tvShowsMap);
	}
}
