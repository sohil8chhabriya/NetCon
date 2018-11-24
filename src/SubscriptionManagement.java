import java.util.*;

public class SubscriptionManagement {
	public static void main(String[] args) {
		System.out.println("Hello Sohil");
		TvShows hs = new TvShows(ChannelsEnum.Netflix, ProgramsEnum.A);
		TvShows ap = new TvShows(ChannelsEnum.HotStar, ProgramsEnum.B);
		TvShows nf = new TvShows(ChannelsEnum.AmazonPrime, ProgramsEnum.C);

		List<TvShows> channels = new ArrayList<TvShows>();
		channels.add(hs);
		channels.add(nf);
		channels.add(ap);
		hs.addProgramToList(ProgramsEnum.B);
		hs.addProgramToList(ProgramsEnum.C);
		hs.addProgramToList(ProgramsEnum.D);

		ap.addProgramToList(ProgramsEnum.A);
		ap.addProgramToList(ProgramsEnum.D);
		ap.addProgramToList(ProgramsEnum.E);

		nf.addProgramToList(ProgramsEnum.F);
		nf.addProgramToList(ProgramsEnum.G);
		nf.addProgramToList(ProgramsEnum.A);
		Map<ChannelsEnum, List<ProgramsEnum>> m = convertProgramsShowByChanneltoMap(channels);
		Map<ChannelsEnum, List<ProgramsEnum>> channelsWithUniqueShows = getDupPercentageCheck(m);
		System.out.println(m);
		printResults(channelsWithUniqueShows);
	}
	private static void printResults(Map<ChannelsEnum, List<ProgramsEnum>> channelsWithUniqueShows) {
		for (Map.Entry<ChannelsEnum, List<ProgramsEnum>> entry : channelsWithUniqueShows.entrySet()) {
			System.out.println("Unique channel in "+entry.getKey().getValue() + " is " + entry.getValue());
		}
	}

	private static Map<ChannelsEnum, List<ProgramsEnum>> getDupPercentageCheck(Map<ChannelsEnum, List<ProgramsEnum>> o){
		Map<ChannelsEnum, List<ProgramsEnum>> resultM = new HashMap<ChannelsEnum, List<ProgramsEnum>>();
		for (Map.Entry<ChannelsEnum, List<ProgramsEnum>> entry : o.entrySet()) {
			int dupSize = 0;
			int topArraySize = entry.getValue().size();
			for (Map.Entry<ChannelsEnum, List<ProgramsEnum>> entry2 : o.entrySet()) {
				if(entry.getValue().size() == 0) break;
				if(entry.getKey().equals(entry2.getKey())) continue;
				entry.getValue().removeAll(entry2.getValue());
				dupSize = topArraySize - entry.getValue().size();
			}
			Map<ChannelsEnum, List<ProgramsEnum>> mmtemp = new HashMap<ChannelsEnum, List<ProgramsEnum>>();
			mmtemp.put(entry.getKey(), entry.getValue());
			double dupPercent = (dupSize/topArraySize)*100;
			resultM.putAll(mmtemp);

			System.out.println(entry.getKey());
			System.out.println("topArraySize: "+topArraySize);
			System.out.println(entry.getValue());
			System.out.println("dupeSize: "+dupPercent);
		}
		System.out.println(resultM);
		return resultM;
	}
	private static Map<ChannelsEnum, List<ProgramsEnum>> convertProgramsShowByChanneltoMap(List<TvShows> channels) {
		Iterator<TvShows> it = channels.iterator();
		Map<ChannelsEnum, List<ProgramsEnum>> m = new HashMap<ChannelsEnum, List<ProgramsEnum>>();
		while(it.hasNext()) {
			TvShows show = it.next();
			List<ProgramsEnum> l = new ArrayList<ProgramsEnum>();
			int channelId = show.getchannel().getKey();
			//System.out.print("Programs Showed by are: " + channel );
			
			Iterator<ProgramsEnum> pe = show.getPrograms().iterator();
			while(pe.hasNext()) {
				//System.out.print(programByChannel);
				l.add(pe.next());
			}
			m.put(show.getchannel(), l);
		}
		System.out.println(m);
		return m;
	}
}
