/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

class SystemSolar extends JPanel {
        URL imageURL= this.getClass().getResource("solar.png");
        Image image = new ImageIcon(imageURL).getImage();
	//ImageIcon im = new ImageIcon("solar.jpg");

	int mercury = 0;
	int venus = 0;
	int earth = 0;
	int march = 0;
	int moon = 0;
	int xearth = 0;
	int yearth = 0;
	Timer time = new Timer(1, new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			repaint();

		}
	});

	public SystemSolar() {
		time.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
                //g.drawImage(image, x, y, this);
		g.drawImage(image, 0, 0, 1024, 768, this);

		int x = getWidth();
		int y = getHeight();

		int xcenter = x / 2;
		int ycenter = y / 2;
		int sun_radius = 70;
		int mercury_radius = 13;
		int venus_radius = 25;
		int earth_radius = 25;
		int moon_radius = 5;
		int mach_radius = 27;
		// Draw Sun
		g.setColor(Color.red);
		g.fillOval(xcenter - (sun_radius / 2), ycenter - (sun_radius / 2),
				sun_radius, sun_radius);

		// Draw mercury
		mercury += 3;
		g.setColor(Color.ORANGE);
		g.fillOval((int) (xcenter - 5 + 100 * Math.cos(mercury * 0.001)),
				(int) (ycenter - 5 + 100 * Math.sin(mercury * 0.001)),
				mercury_radius, mercury_radius);

		// Draw venus
		venus += 5;
		g.setColor(Color.CYAN);
		g.fillOval((int) (xcenter - 12 + 150 * Math.cos(venus * 0.001)),
				(int) (ycenter - 12 + 150 * Math.sin(venus * 0.001)),
				venus_radius, venus_radius);

		// Draw earth
		earth += 1;
		g.setColor(Color.BLUE);
		xearth = (int) (xcenter - 12 + 230 * Math
				.cos(earth * Math.PI / 1826.25));
		yearth = (int) (ycenter - 12 + 230 * Math
				.sin(earth * Math.PI / 1826.25));
		g.fillOval(xearth, yearth, earth_radius, earth_radius);

		// Draw moon
		moon += 10;
		g.setColor(Color.WHITE);
		g.fillOval((int) (xearth + 10 + 30 * Math.cos(moon * Math.PI / 1400)),
				(int) (yearth + 10 + 30 * Math.sin(moon * Math.PI / 1400)),
				moon_radius,moon_radius);
			
		// Draw march
		march += 1;
		g.setColor(Color.ORANGE);
		g.fillOval((int) (xcenter - 12 + 300 * Math.cos(march * 0.001)),
				(int) (ycenter - 15 + 300 * Math.sin(march * 0.001)),
				mach_radius, mach_radius);

	}

}

public class NewClass19 extends JFrame{
	
	NewClass19(){
		add(new SystemSolar());
	}
	
	
	public static void main(String[] args) {
		NewClass19 uni=new NewClass19();
	
		uni.setSize(999,690);
		uni.setTitle("The Universe");
		uni.setLocationRelativeTo(null);
		uni.setDefaultCloseOperation(EXIT_ON_CLOSE);
		uni.setVisible(true);
	}

}