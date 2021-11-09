package b13_mang1chieu;

import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class xuatdulieu extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	
	int[] a;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xuatdulieu frame = new xuatdulieu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public xuatdulieu() {
		setTitle("Nhập dữ liệu");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 734, 465);
		
		JPanel panel = new JPanel();
		
		
		
		JButton btnNewButton = new JButton("nhập mảng một chiều");
		//Váº½ máº£ng 1 chiá»�u
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics2D gr = (Graphics2D)panel.getGraphics();
				int maxX = panel.getWidth();
				int maxY = panel.getHeight();
				
				int step = 5;
				int n = maxX/step;
				a = new int[n];
				Random rnd = new Random();
				for(int i = 0; i < n; i++) {
					a[i] = rnd.nextInt(maxY);
				}
				
				int beginX = 0;
				int beginY = 0;
				gr.clearRect(0, 0, maxX, maxY);
				for(int i = 0; i < n; i++) {
					//gr.drawRect(beginX, beginY, step, a[i]);
					gr.drawRect(beginX, maxY - a[i], step, a[i]);
					beginX += step;
				}
				
			}
		});
		
		JButton btnSapXep = new JButton("Sắp xếp mảng");
		//
		// Sap xep mang mot chieu
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics2D gr = (Graphics2D)panel.getGraphics();
				int maxX = panel.getWidth();
				int maxY = panel.getHeight();
				
				int step = 5;
				int n = maxX/step;
				
				int beginX = 0;
				int beginX2 = 0;
				
				for(int i = 0; i < n - 1; i++) {
					for(int j = i; j < n; j++) {
						if(a[i] > a[j]) {
							int temp = a[i];
							// Xoa hinh a[i] cu
							gr.clearRect(beginX, maxY - a[i], step, a[i]);
							//
							a[i] = a[j];
							// Ve hinh a[i] moi
							gr.drawRect(beginX, maxY - a[i], step, a[i]);
							//
							// Xoa hinh a[j] cu
							beginX2 = j*step;
							gr.clearRect(beginX2, maxY - a[i], step, a[i]);
							//
							// Ve hinh a[j] moi
							a[j] = temp;
							gr.drawRect(beginX2, maxY - a[i], step, a[i]);
							
						}
					}
					
					beginX += step;
					
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSapXep, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSapXep, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}

