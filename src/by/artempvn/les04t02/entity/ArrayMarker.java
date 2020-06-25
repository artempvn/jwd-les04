package by.artempvn.les04t02.entity;

public class ArrayMarker {
	private int value;
	private int startPosition;

	public ArrayMarker(int value, int startPosition) {
		this.value = value;
		this.startPosition = startPosition;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getStartPosition() {
		return startPosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + startPosition;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ArrayMarker other = (ArrayMarker) obj;
		if (startPosition != other.startPosition) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("ArrayMarker [value=%s, startPosition=%s]", value,
				startPosition);
	}

}
