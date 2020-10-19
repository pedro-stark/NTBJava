package ch.ntb.orionRobo.networking.webService.datatypes;

public class CalibrationValues {
	private long[] distances;
	private long[] times;
	
	public CalibrationValues(long[] times, long[] distances) {
		this.times = times;
		this.distances = distances;
		
	}
	
	public CalibrationValues(long[] times) {
		this.times = times;
		this.distances = null;
		
	}

	public CalibrationValues() {
		this.times = null;
		this.distances = null;
		
	}
	
	public long[] getDistances() {
		return distances;
	}

	public void setDistances(long[] distances) {
		this.distances = distances;
	}

	public long[] getTimes() {
		return times;
	}

	public void setTimes(long[] times) {
		this.times = times;
	}
	
}
