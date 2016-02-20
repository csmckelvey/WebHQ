package com.csmckelvey.conway;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.csmckelvey.conway.util.ConwayConstants;

@SuppressWarnings("serial")
public class ConwayControlPanel extends JPanel {
	
	private JButton speedTest;
	private JButton startStopButton;
	private JComboBox<String> sizeList;
	private JComboBox<String> shapeList;
	private JComboBox<String> speedList;
	private final String stop = "Stop";
	private final String start = "Start";
	private List<ConwayControlEventListener> listeners = new LinkedList<>();
	
	public ConwayControlPanel() {
		super();
		this.setBackground(Color.WHITE);
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(600, 50));
		
		buildStartStopButton();
		buildSpeedTestButton();
		buildSizeList();
		buildShapeList();
		buildSpeedList();
	}
	
	private void buildStartStopButton() {
		startStopButton = new JButton(start);
		startStopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (start.equals(startStopButton.getText())) { 
					startStopButton.setText(stop);
				}
				else { 
					startStopButton.setText(start); 
				}
				
				for (ConwayControlEventListener l : listeners) { 
					l.handleControlEvent(new ConwayControlEvent(ConwayControlEvent.PLAY)); 
				}
			}
		});
		this.add(startStopButton);
	}
	
	private void buildSpeedTestButton() {
		speedTest = new JButton("Speed Test");
		speedTest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (ConwayControlEventListener l : listeners) { 
					l.handleControlEvent(new ConwayControlEvent(ConwayControlEvent.SPEEDTEST)); 
				}
			}
		});
		this.add(speedTest);
	}
	
	private void buildSizeList() {
		sizeList = new JComboBox<>(ConwayConstants.getViewSizes());
		sizeList.setSelectedIndex(0);
		sizeList.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
		        for (ConwayControlEventListener l : listeners) { 
		        	l.handleControlEvent(new ConwayControlEvent(ConwayControlEvent.ZOOM, ((JComboBox<String>) e.getSource()).getSelectedIndex())); 
		        }
			}
		});
		this.add(sizeList);
	}
	
	private void buildShapeList() {
		shapeList = new JComboBox<>(ConwayConstants.getShapes());
		shapeList.setSelectedIndex(0);
		shapeList.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stop.equals(startStopButton.getText())) { 
					startStopButton.setText(start); 
				}
				
				for (ConwayControlEventListener l : listeners) { 
		        	l.handleControlEvent(new ConwayControlEvent(ConwayControlEvent.CHANGESHAPE, ((JComboBox<String>) e.getSource()).getSelectedIndex())); 
		        }
			}
		});
		this.add(shapeList);
	}
	
	private void buildSpeedList() {
		speedList = new JComboBox<>(ConwayConstants.getSpeeds());
		speedList.setSelectedIndex(0);
		speedList.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
		        for (ConwayControlEventListener l : listeners) { 
		        	l.handleControlEvent(new ConwayControlEvent(ConwayControlEvent.CHANGESPEED, ((JComboBox<String>) e.getSource()).getSelectedIndex())); 
		        }
			}
		});
		this.add(speedList);
	}
	
	public void addConwayControlEventListener(ConwayControlEventListener l) {
		listeners.add(l);
	}
	
}
