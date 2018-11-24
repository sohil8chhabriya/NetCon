import java.util.ArrayList;
import java.util.List;


public class TvShows {
	private ChannelsEnum channel;
	private List<ProgramsEnum> programsList;

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
}
