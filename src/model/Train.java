package model;

public class Train {
	private int trainId;
	private String trainNumber;
	private Station source;
	private Station destination;
	private Station center;
	private int centerTime;
	private int time;
	private int capacity;

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Station getSource() {
		return source;
	}

	public void setSource(Station source) {
		this.source = source;
	}

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	public Station getCenter() {
		return center;
	}

	public void setCenter(Station center) {
		this.center = center;
	}

	public int getCenterTime() {
		return centerTime;
	}

	public void setCenterTime(int centerTime) {
		this.centerTime = centerTime;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
