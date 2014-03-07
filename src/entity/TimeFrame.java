package entity;

import java.sql.Timestamp;
import java.util.List;

public class TimeFrame {

	private Timestamp startTime;
	private Timestamp endTime;
	private List<String> daysNotEnabled;

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public List<String> getDaysNotEnabled() {
		return this.daysNotEnabled;
	}

	public void setDaysNotEnabled(List<String> daysNotEnabled) {
		this.daysNotEnabled = daysNotEnabled;
	}

}