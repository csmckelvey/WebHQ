package com.csmckelvey.conway.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.csmckelvey.conway.Cell;
import com.csmckelvey.conway.Generation;

public class GenerationFactory {

	private static final Random rand = new Random();
	
	public static Generation getGlider() {
		return getGlider(0,0);
	}
	
	public static Generation getGlider(int offsetX, int offsetY) {
		Generation g = new Generation();
		g.addCell(new Cell( 0 + offsetX, -1 + offsetY));
		g.addCell(new Cell( 1 + offsetX,  0 + offsetY));
		g.addCell(new Cell( 1 + offsetX,  1 + offsetY));
		g.addCell(new Cell( 0 + offsetX,  1 + offsetY));
		g.addCell(new Cell(-1 + offsetX,  1 + offsetY));
		return g;
	}
	
	public static Generation getRandomGeneration(int numCells, int maxSize) {
		Generation g = new Generation();
		Set<Cell> newGen = new HashSet<>();
		
		while (newGen.size() < numCells) { newGen.add(new Cell(rand.nextInt(maxSize*2) - maxSize, rand.nextInt(maxSize*2) - maxSize)); }
		for (Cell c : newGen) { g.addCell(c); }
		
		return g;
	}
	
	public static Generation getGliderGun() {
		return getGliderGun(0, 0);
	}
	
	public static Generation getGliderGun(int offsetX, int offsetY) {
		Generation g = new Generation();
		
		g.addCell(new Cell( 0 + offsetX, 4 + offsetY));
		g.addCell(new Cell( 0 + offsetX, 5 + offsetY));
		g.addCell(new Cell( 1 + offsetX, 4 + offsetY));
		g.addCell(new Cell( 1 + offsetX, 5 + offsetY));
		g.addCell(new Cell(10 + offsetX, 4 + offsetY));
		g.addCell(new Cell(10 + offsetX, 5 + offsetY));
		g.addCell(new Cell(10 + offsetX, 6 + offsetY));
		g.addCell(new Cell(11 + offsetX, 3 + offsetY));
		g.addCell(new Cell(11 + offsetX, 7 + offsetY));
		g.addCell(new Cell(12 + offsetX, 2 + offsetY));
		g.addCell(new Cell(12 + offsetX, 8 + offsetY));
		g.addCell(new Cell(13 + offsetX, 2 + offsetY));
		g.addCell(new Cell(13 + offsetX, 8 + offsetY));
		g.addCell(new Cell(14 + offsetX, 5 + offsetY));
		g.addCell(new Cell(15 + offsetX, 3 + offsetY));
		g.addCell(new Cell(15 + offsetX, 7 + offsetY));
		g.addCell(new Cell(16 + offsetX, 4 + offsetY));
		g.addCell(new Cell(16 + offsetX, 5 + offsetY));
		g.addCell(new Cell(16 + offsetX, 6 + offsetY));
		g.addCell(new Cell(17 + offsetX, 5 + offsetY));
		g.addCell(new Cell(20 + offsetX, 2 + offsetY));
		g.addCell(new Cell(20 + offsetX, 3 + offsetY));
		g.addCell(new Cell(20 + offsetX, 4 + offsetY));
		g.addCell(new Cell(21 + offsetX, 2 + offsetY));
		g.addCell(new Cell(21 + offsetX, 3 + offsetY));
		g.addCell(new Cell(21 + offsetX, 4 + offsetY));
		g.addCell(new Cell(22 + offsetX, 1 + offsetY));
		g.addCell(new Cell(22 + offsetX, 5 + offsetY));
		g.addCell(new Cell(24 + offsetX, 0 + offsetY));
		g.addCell(new Cell(24 + offsetX, 1 + offsetY));
		g.addCell(new Cell(24 + offsetX, 5 + offsetY));
		g.addCell(new Cell(24 + offsetX, 6 + offsetY));
		g.addCell(new Cell(34 + offsetX, 2 + offsetY));
		g.addCell(new Cell(34 + offsetX, 3 + offsetY));
		g.addCell(new Cell(35 + offsetX, 2 + offsetY));
		g.addCell(new Cell(35 + offsetX, 3 + offsetY));
		
		return g;
	}

	public static Generation getGliderCyclone() {
		return getGliderCyclone(0, 0);
	}
	
	public static Generation getGliderCyclone(int offsetX, int offsetY) {
		Generation g = new Generation();
		
		//
		//		TOP LEFT GLIDER GUN
		//
		g.addCell(new Cell( 0 + offsetX, 4 + offsetY));
		g.addCell(new Cell( 0 + offsetX, 5 + offsetY));
		g.addCell(new Cell( 1 + offsetX, 4 + offsetY));
		g.addCell(new Cell( 1 + offsetX, 5 + offsetY));
		g.addCell(new Cell(10 + offsetX, 4 + offsetY));
		g.addCell(new Cell(10 + offsetX, 5 + offsetY));
		g.addCell(new Cell(10 + offsetX, 6 + offsetY));
		g.addCell(new Cell(11 + offsetX, 3 + offsetY));
		g.addCell(new Cell(11 + offsetX, 7 + offsetY));
		g.addCell(new Cell(12 + offsetX, 2 + offsetY));
		g.addCell(new Cell(12 + offsetX, 8 + offsetY));
		g.addCell(new Cell(13 + offsetX, 2 + offsetY));
		g.addCell(new Cell(13 + offsetX, 8 + offsetY));
		g.addCell(new Cell(14 + offsetX, 5 + offsetY));
		g.addCell(new Cell(15 + offsetX, 3 + offsetY));
		g.addCell(new Cell(15 + offsetX, 7 + offsetY));
		g.addCell(new Cell(16 + offsetX, 4 + offsetY));
		g.addCell(new Cell(16 + offsetX, 5 + offsetY));
		g.addCell(new Cell(16 + offsetX, 6 + offsetY));
		g.addCell(new Cell(17 + offsetX, 5 + offsetY));
		g.addCell(new Cell(20 + offsetX, 2 + offsetY));
		g.addCell(new Cell(20 + offsetX, 3 + offsetY));
		g.addCell(new Cell(20 + offsetX, 4 + offsetY));
		g.addCell(new Cell(21 + offsetX, 2 + offsetY));
		g.addCell(new Cell(21 + offsetX, 3 + offsetY));
		g.addCell(new Cell(21 + offsetX, 4 + offsetY));
		g.addCell(new Cell(22 + offsetX, 1 + offsetY));
		g.addCell(new Cell(22 + offsetX, 5 + offsetY));
		g.addCell(new Cell(24 + offsetX, 0 + offsetY));
		g.addCell(new Cell(24 + offsetX, 1 + offsetY));
		g.addCell(new Cell(24 + offsetX, 5 + offsetY));
		g.addCell(new Cell(24 + offsetX, 6 + offsetY));
		g.addCell(new Cell(34 + offsetX, 2 + offsetY));
		g.addCell(new Cell(34 + offsetX, 3 + offsetY));
		g.addCell(new Cell(35 + offsetX, 2 + offsetY));
		g.addCell(new Cell(35 + offsetX, 3 + offsetY));
		
		//
		//		TOP RIGHT GLIDER GUN
		//
		g.addCell(new Cell(71 + offsetX, 12 + offsetY));
		g.addCell(new Cell(71 + offsetX, 13 + offsetY));
		g.addCell(new Cell(72 + offsetX, 11 + offsetY));
		g.addCell(new Cell(72 + offsetX, 15 + offsetY));
		g.addCell(new Cell(73 + offsetX, 10 + offsetY));
		g.addCell(new Cell(73 + offsetX, 16 + offsetY));
		g.addCell(new Cell(73 + offsetX, 24 + offsetY));
		g.addCell(new Cell(74 + offsetX,  0 + offsetY));
		g.addCell(new Cell(74 + offsetX,  1 + offsetY));
		g.addCell(new Cell(74 + offsetX, 10 + offsetY));
		g.addCell(new Cell(74 + offsetX, 14 + offsetY));
		g.addCell(new Cell(74 + offsetX, 16 + offsetY));
		g.addCell(new Cell(74 + offsetX, 17 + offsetY));
		g.addCell(new Cell(74 + offsetX, 22 + offsetY));
		g.addCell(new Cell(74 + offsetX, 24 + offsetY));
		g.addCell(new Cell(75 + offsetX,  0 + offsetY));
		g.addCell(new Cell(75 + offsetX,  1 + offsetY));
		g.addCell(new Cell(75 + offsetX, 10 + offsetY));
		g.addCell(new Cell(75 + offsetX, 16 + offsetY));
		g.addCell(new Cell(75 + offsetX, 20 + offsetY));
		g.addCell(new Cell(75 + offsetX, 21 + offsetY));
		g.addCell(new Cell(76 + offsetX, 11 + offsetY));
		g.addCell(new Cell(76 + offsetX, 15 + offsetY));
		g.addCell(new Cell(76 + offsetX, 20 + offsetY));
		g.addCell(new Cell(76 + offsetX, 21 + offsetY));
		g.addCell(new Cell(76 + offsetX, 34 + offsetY));
		g.addCell(new Cell(76 + offsetX, 35 + offsetY));
		g.addCell(new Cell(77 + offsetX, 12 + offsetY));
		g.addCell(new Cell(77 + offsetX, 13 + offsetY));
		g.addCell(new Cell(77 + offsetX, 20 + offsetY));
		g.addCell(new Cell(77 + offsetX, 21 + offsetY));
		g.addCell(new Cell(77 + offsetX, 34 + offsetY));
		g.addCell(new Cell(77 + offsetX, 35 + offsetY));
		g.addCell(new Cell(78 + offsetX, 22 + offsetY));
		g.addCell(new Cell(78 + offsetX, 24 + offsetY));
		g.addCell(new Cell(79 + offsetX, 24 + offsetY));
		
		//
		//		BOTTOM RIGHT GLIDER GUN
		//
		g.addCell(new Cell(44 + offsetX, 76 + offsetY));
		g.addCell(new Cell(44 + offsetX, 77 + offsetY));
		g.addCell(new Cell(45 + offsetX, 76 + offsetY));
		g.addCell(new Cell(45 + offsetX, 77 + offsetY));
		g.addCell(new Cell(55 + offsetX, 73 + offsetY));
		g.addCell(new Cell(55 + offsetX, 74 + offsetY));
		g.addCell(new Cell(55 + offsetX, 78 + offsetY));
		g.addCell(new Cell(55 + offsetX, 79 + offsetY));
		g.addCell(new Cell(57 + offsetX, 74 + offsetY));
		g.addCell(new Cell(57 + offsetX, 78 + offsetY));
		g.addCell(new Cell(58 + offsetX, 75 + offsetY));
		g.addCell(new Cell(58 + offsetX, 76 + offsetY));
		g.addCell(new Cell(58 + offsetX, 77 + offsetY));
		g.addCell(new Cell(59 + offsetX, 75 + offsetY));
		g.addCell(new Cell(59 + offsetX, 76 + offsetY));
		g.addCell(new Cell(59 + offsetX, 77 + offsetY));
		g.addCell(new Cell(62 + offsetX, 74 + offsetY));
		g.addCell(new Cell(63 + offsetX, 73 + offsetY));
		g.addCell(new Cell(63 + offsetX, 74 + offsetY));
		g.addCell(new Cell(63 + offsetX, 75 + offsetY));
		g.addCell(new Cell(64 + offsetX, 72 + offsetY));
		g.addCell(new Cell(64 + offsetX, 76 + offsetY));
		g.addCell(new Cell(65 + offsetX, 74 + offsetY));
		g.addCell(new Cell(66 + offsetX, 71 + offsetY));
		g.addCell(new Cell(66 + offsetX, 77 + offsetY));
		g.addCell(new Cell(67 + offsetX, 71 + offsetY));
		g.addCell(new Cell(67 + offsetX, 77 + offsetY));
		g.addCell(new Cell(68 + offsetX, 72 + offsetY));
		g.addCell(new Cell(68 + offsetX, 76 + offsetY));
		g.addCell(new Cell(69 + offsetX, 73 + offsetY));
		g.addCell(new Cell(69 + offsetX, 74 + offsetY));
		g.addCell(new Cell(69 + offsetX, 75 + offsetY));
		g.addCell(new Cell(78 + offsetX, 74 + offsetY));
		g.addCell(new Cell(78 + offsetX, 75 + offsetY));
		g.addCell(new Cell(79 + offsetX, 74 + offsetY));
		g.addCell(new Cell(79 + offsetX, 75 + offsetY));
		
		//
		//		BOTTOM LEFT GLIDER GUN
		//	
		g.addCell(new Cell(0 + offsetX, 55 + offsetY));
		g.addCell(new Cell(1 + offsetX, 55 + offsetY));
		g.addCell(new Cell(1 + offsetX, 57 + offsetY));
		g.addCell(new Cell(2 + offsetX, 44 + offsetY));
		g.addCell(new Cell(2 + offsetX, 45 + offsetY));
		g.addCell(new Cell(2 + offsetX, 58 + offsetY));
		g.addCell(new Cell(2 + offsetX, 59 + offsetY));
		g.addCell(new Cell(2 + offsetX, 66 + offsetY));
		g.addCell(new Cell(2 + offsetX, 67 + offsetY));
		g.addCell(new Cell(3 + offsetX, 44 + offsetY));
		g.addCell(new Cell(3 + offsetX, 45 + offsetY));
		g.addCell(new Cell(3 + offsetX, 58 + offsetY));
		g.addCell(new Cell(3 + offsetX, 59 + offsetY));
		g.addCell(new Cell(3 + offsetX, 64 + offsetY));
		g.addCell(new Cell(3 + offsetX, 68 + offsetY));
		g.addCell(new Cell(4 + offsetX, 58 + offsetY));
		g.addCell(new Cell(4 + offsetX, 59 + offsetY));
		g.addCell(new Cell(4 + offsetX, 63 + offsetY));
		g.addCell(new Cell(4 + offsetX, 69 + offsetY));
		g.addCell(new Cell(4 + offsetX, 78 + offsetY));
		g.addCell(new Cell(4 + offsetX, 79 + offsetY));
		g.addCell(new Cell(5 + offsetX, 55 + offsetY));
		g.addCell(new Cell(5 + offsetX, 57 + offsetY));
		g.addCell(new Cell(5 + offsetX, 62 + offsetY));
		g.addCell(new Cell(5 + offsetX, 63 + offsetY));
		g.addCell(new Cell(5 + offsetX, 65 + offsetY));
		g.addCell(new Cell(5 + offsetX, 69 + offsetY));
		g.addCell(new Cell(5 + offsetX, 78 + offsetY));
		g.addCell(new Cell(5 + offsetX, 79 + offsetY));
		g.addCell(new Cell(6 + offsetX, 55 + offsetY));
		g.addCell(new Cell(6 + offsetX, 63 + offsetY));
		g.addCell(new Cell(6 + offsetX, 69 + offsetY));
		g.addCell(new Cell(7 + offsetX, 64 + offsetY));
		g.addCell(new Cell(7 + offsetX, 68 + offsetY));
		g.addCell(new Cell(8 + offsetX, 66 + offsetY));
		g.addCell(new Cell(8 + offsetX, 67 + offsetY));
		
		return g;
	}

}
