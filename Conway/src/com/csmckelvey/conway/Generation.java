package com.csmckelvey.conway;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

import static com.csmckelvey.conway.util.ConwayConstants.MAX_CELL_DISTANCE;

public class Generation {
	
	private List<Cell> population = new LinkedList<>();

	public void addCell(Cell c) {
		int positionX = c.getX();
		int positionY = c.getY();
		
		if (positionX < MAX_CELL_DISTANCE && positionX > -MAX_CELL_DISTANCE && positionY < MAX_CELL_DISTANCE && positionY > -MAX_CELL_DISTANCE) {
			this.population.add(c);
		}
	}
	
	public List<Cell> getPopulation() { 
		return this.population; 
	}
	
	@Override
	public String toString() {
		return "Current Population - " + this.population.size() + "\n" + Arrays.toString(this.population.toArray());
	}

}
