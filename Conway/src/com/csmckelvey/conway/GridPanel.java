package com.csmckelvey.conway;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.csmckelvey.conway.util.ConwayConstants;
import com.csmckelvey.conway.util.GenerationFactory;

public class GridPanel extends JPanel implements ConwayControlEventListener {
	private static final long serialVersionUID = 1736181048482462183L;
	
	private int speed;
	private int drawX;
	private int drawY;
	private int numRows;
	private int numCols;
	private int offsetX;
	private int offsetY;
	private int numCells;
	private int neighbors;
	private int cellWidth;
	private int cellHeight;
	
	private Generation next;
	private Generation currentGeneration;

	private Timer workerTimer;
	private List<Cell> currentPopulation;
	private Set<Cell> deadCells = new HashSet<>();
	
	private Cell topLeft, left, bottomLeft, top, bottom, topRight, right, bottomRight;
	
	public GridPanel() {
		super();
		this.setPreferredSize(new Dimension(800, 800));
		this.numCols = ConwayConstants.SMALLVIEW_NUM_ROWSCOLS;
		this.numRows = ConwayConstants.SMALLVIEW_NUM_ROWSCOLS;
		this.currentGeneration = GenerationFactory.getGlider();
		this.setBackground(Color.BLACK);
		
		this.workerTimer = new Timer(ConwayConstants.SLOW_SPEED_DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentGeneration = nextGeneration(currentGeneration);
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int myWidth = this.getWidth();
		int myHeight = this.getHeight();
		
		offsetX = numCols / 2;
		offsetY = numRows / 2;
		cellWidth = this.getWidth() / numCols;
		cellHeight = this.getHeight() / numRows;
		
		g.setColor(Color.GRAY);
		for (int i = 1; i < numCols; i++) { g.drawLine(cellWidth*i, 0, cellWidth*i, myHeight); }
		for (int i = 1; i < numRows; i++) { g.drawLine(0, cellHeight*i, myWidth, cellHeight*i); }
		
		g.setColor(Color.GREEN);
		for (Cell c : this.currentGeneration.getPopulation()) {
			drawX = ((c.getX() + offsetX) * cellWidth) + 2;
			drawY = ((c.getY() + offsetY) * cellHeight) + 2;
			if (drawX > 0 && drawX < myWidth && drawY > 0 && drawY < myHeight) {
				g.fillRect(drawX, drawY, cellWidth - 3, cellHeight - 3);
			}
		}
	}

	public Generation nextGeneration(Generation g) {
		next = new Generation();
		deadCells.clear();
		currentPopulation = currentGeneration.getPopulation();
		
		for (Cell c : currentPopulation) {
			determineNeighbors(c);
			neighbors = countCurrentNeighbors(false);
			if (neighbors == 2 || neighbors == 3) { next.addCell(c); }
		}
		
		for (Cell c : deadCells) {
			determineNeighbors(c);
			neighbors = countCurrentNeighbors(true);
			if (neighbors == 3) { next.addCell(c); }
		}
		
		return next;
	}
	
	private int countCurrentNeighbors(boolean ignoreDeadCells) {
		int count = 0;
		
		if (ignoreDeadCells) {
			if (currentPopulation.contains(topLeft))     { count++; }
			if (currentPopulation.contains(left))        { count++; }
			if (currentPopulation.contains(bottomLeft))  { count++; }
			if (currentPopulation.contains(top))         { count++; }
			if (currentPopulation.contains(bottom))      { count++; }
			if (currentPopulation.contains(topRight))    { count++; }
			if (currentPopulation.contains(right))       { count++; }
			if (currentPopulation.contains(bottomRight)) { count++; }
		}
		else {
			if (currentPopulation.contains(topLeft))     { count++; } else { deadCells.add(topLeft); }
			if (currentPopulation.contains(left))        { count++; } else { deadCells.add(left); }
			if (currentPopulation.contains(bottomLeft))  { count++; } else { deadCells.add(bottomLeft); }
			if (currentPopulation.contains(top))         { count++; } else { deadCells.add(top); }
			if (currentPopulation.contains(bottom))      { count++; } else { deadCells.add(bottom); }
			if (currentPopulation.contains(topRight))    { count++; } else { deadCells.add(topRight); }
			if (currentPopulation.contains(right))       { count++; } else { deadCells.add(right); }
			if (currentPopulation.contains(bottomRight)) { count++; } else { deadCells.add(bottomRight); }
		}
		
		return count;
	}
	
	private void determineNeighbors(Cell c) {
		int positionX = c.getX();
		int positionY = c.getY();
		
		topLeft     = new Cell(positionX-1, positionY-1);
		left        = new Cell(positionX-1, positionY  );
		bottomLeft  = new Cell(positionX-1, positionY+1);
		top         = new Cell(positionX  , positionY-1);
		bottom      = new Cell(positionX  , positionY+1);
		topRight    = new Cell(positionX+1, positionY-1);
		right       = new Cell(positionX+1, positionY  );
		bottomRight = new Cell(positionX+1, positionY+1);
	}
	
	@Override
	public void handleControlEvent(ConwayControlEvent e) {
		int event = e.getEvent();
		int modifier = e.getEventModifier();
		
		if (event == ConwayControlEvent.PLAY) {
			if (!workerTimer.isRunning()) { workerTimer.start(); }
			else { workerTimer.stop(); }
		}
		else if (event == ConwayControlEvent.SPEEDTEST) {
			if (workerTimer.isRunning()) { workerTimer.stop(); }
			else {
				speed = ConwayConstants.NUCLEAR_SPEED_DELAY;
				numRows = numCols = ConwayConstants.LARGEVIEW_NUM_ROWSCOLS;
				currentGeneration = GenerationFactory.getRandomGeneration(ConwayConstants.SMALL_RANDOM_NUM_ROWSCOLS, ConwayConstants.SMALLVIEW_NUM_ROWSCOLS/2);
				
				workerTimer = new Timer(speed, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						currentGeneration = nextGeneration(currentGeneration);
						repaint();
					}
				});
				
				workerTimer.start();
			}
		}
		else if (event == ConwayControlEvent.ZOOM) {
			switch (modifier) {
				case 0: numRows = numCols = ConwayConstants.SMALLVIEW_NUM_ROWSCOLS; break;
				case 1: numRows = numCols = ConwayConstants.NORMALVIEW_NUM_ROWSCOLS; break;
				case 2: numRows = numCols = ConwayConstants.LARGEVIEW_NUM_ROWSCOLS; break;
			}
			
			repaint();
		}
		else if (event == ConwayControlEvent.CHANGESHAPE) {
			workerTimer.stop();
			
			switch (modifier) {
				case 0: currentGeneration = GenerationFactory.getGlider(); break;
				case 1: currentGeneration = GenerationFactory.getGliderGun(-40, -40); break;
				case 2: currentGeneration = GenerationFactory.getGliderCyclone(-40,-40); break;
				case 3:
					if (numRows <= ConwayConstants.SMALLVIEW_NUM_ROWSCOLS) { 
						numCells = ConwayConstants.SMALL_RANDOM_NUM_ROWSCOLS; 
					}
					else if (numRows <= ConwayConstants.NORMALVIEW_NUM_ROWSCOLS) { 
						numCells = ConwayConstants.NORMAL_RANDOM_NUM_ROWSCOLS; 
					}
					else { 
						numCells = ConwayConstants.LARGE_RANDOM_NUM_ROWSCOLS; 
					}
					currentGeneration = GenerationFactory.getRandomGeneration(numCells, numRows/2); break;
			}
			
			repaint();
		}
		else if (event == ConwayControlEvent.CHANGESPEED) {
			boolean running = workerTimer.isRunning();
			
			switch (modifier) {
				case 0: speed = ConwayConstants.SLOW_SPEED_DELAY; break;
				case 1: speed = ConwayConstants.MEDIUM_SPEED_DELAY; break;
				case 2: speed = ConwayConstants.FAST_SPEED_DELAY; break;
				case 3: speed = ConwayConstants.NUCLEAR_SPEED_DELAY; break;
			}
			
			if (running) { workerTimer.stop(); }
			
			workerTimer = new Timer(speed, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					currentGeneration = nextGeneration(currentGeneration);
					repaint();
				}
			});
			
			if (running) { workerTimer.start(); }
		}
	}
}
