package music1;

import java.util.Comparator;

public class Desort implements Comparator<Music>  {
	@Override
	public int compare(Music o1, Music o2) {
		// TODO Auto-generated method stub
		Music m1 = o1;
		Music m2 = o2;
		return m1.getSinger().compareTo(m2.getSinger())*-1;
	}

}
