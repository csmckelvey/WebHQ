package com.csmckelvey.conway;

public class Cell {

	private int positionX;
	private int positionY;
	
	public Cell(int x, int y) {
		this.positionX = x;
		this.positionY = y;
	}
	
	public int getX() { 
		return this.positionX; 
	}
	
	public int getY() { 
		return this.positionY; 
	}
	
	@Override
	public String toString() {
		return "Cell @ [" + positionX + "," + positionY + "] : " + hashCode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + positionX;
		result = prime * result + positionY;
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
		if (!(obj instanceof Cell)) {
			return false; 
		}
		
		Cell other = (Cell) obj;
		if (positionX != other.positionX) { 
			return false; 
		}
		if (positionY != other.positionY) { 
			return false; 
		}
		
		return true;
	}
}
