import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TvShows extends HashMap<ChannelsEnum, List<ProgramsEnum>> {
	/**
	 *
	 */
	private static final long serialVersionUID = -5820921109828832874L;
	private ChannelsEnum channel;
	private List<ProgramsEnum> programsList;

	TvShows (){ }
	TvShows (ChannelsEnum channel) {
		this(channel, new ArrayList<ProgramsEnum>());
	}
	TvShows (ChannelsEnum channel, ProgramsEnum program) {
		this(channel, convertToList(program));
	}

	TvShows (ChannelsEnum channel, List<ProgramsEnum> programsList) {
		this.channel = channel;
		this.programsList = programsList;
	}

	public ChannelsEnum getchannel() {
		return this.channel;
	}

	public List<ProgramsEnum> getPrograms() {
		return this.programsList;
	}

	public void addProgramToList(ProgramsEnum program) {
		this.programsList.add(program);
	}

	private static List<ProgramsEnum> convertToList(ProgramsEnum program){
		List<ProgramsEnum> pl = new ArrayList<ProgramsEnum>();
		pl.add(program);
		return pl;
	}
	public static TvShowsUtil getUtilities() {
		return new TvShowsUtil();
	}
}
