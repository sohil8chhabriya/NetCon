import java.util.Iterator;
import java.util.List;

public class TvShowsUtil {
	public TvShows convertProgramsShowByChanneltoMap(List<TvShows> channels) {
		if (channels==null || channels.isEmpty()) {
			return new TvShows();
		}
		Iterator<TvShows> it = channels.iterator();
		TvShows m = new TvShows();
		while(it.hasNext()) {
			TvShows show = it.next();
			m.put(show.getchannel(), show.getPrograms());
		}
		System.out.println(m);
		return m;
	}

	public TvShows getDupPercentageCheck(TvShows o){
		if (o==null || o.isEmpty()) {
			return new TvShows();
		}
		TvShows resultM = new TvShows();
		for (TvShows.Entry<ChannelsEnum, List<ProgramsEnum>> entry : o.entrySet()) {
			for (TvShows.Entry<ChannelsEnum, List<ProgramsEnum>> entry2 : o.entrySet()) {
				if(entry.getValue().size() == 0){
					break;
				}
				if(entry.getKey().equals(entry2.getKey())){
					continue;
				}
				entry.getValue().removeAll(entry2.getValue());
			}
			TvShows mmtemp = new TvShows();
			mmtemp.put(entry.getKey(), entry.getValue());
			//double dupPercent = (dupSize/topArraySize)*100;
			resultM.putAll(mmtemp);

			//System.out.println(entry.getKey());
			//System.out.println("topArraySize: "+topArraySize);
			//System.out.println(entry.getValue());
			//System.out.println("dupeSize: "+dupPercent);
		}
		System.out.println(resultM);
		return resultM;
	}

	public void printResults(TvShows channelsWithUniqueShows) {
		for (TvShows.Entry<ChannelsEnum, List<ProgramsEnum>> entry : channelsWithUniqueShows.entrySet()) {
			System.out.println("Unique channel in "+entry.getKey().getValue() + " is " + entry.getValue());
		}
	}
}
