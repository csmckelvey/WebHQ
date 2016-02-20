package com.csmckelvey.conway;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Conway {
	
	private JFrame window;
	private GridPanel gridPanel;
	private ConwayControlPanel controlPanel;
	
	public Conway() {
		window = new JFrame("Conway's Game Of Life");
		
		buildGUI();
		setWindowOptions();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	private void buildGUI() {
		gridPanel = new GridPanel();
		
		controlPanel = new ConwayControlPanel();
		controlPanel.addConwayControlEventListener(gridPanel);
		
		window.getContentPane().add(gridPanel, BorderLayout.CENTER);
		window.getContentPane().add(controlPanel, BorderLayout.SOUTH);
		
		window.pack();
	}
	
	private void setWindowOptions() {
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {	
		SwingUtilities.invokeLater(new Runnable(){
			@Override
            public void run() {
                new Conway();
            }
        });
	}

}
