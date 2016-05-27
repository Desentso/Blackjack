/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gamelogic.Game;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Olli
 */
public class Gui implements Runnable{

    private JFrame frame;
    private Draw draw;
    private Game game;
    
    public Gui(Draw draw, Game game){
        
        this.draw = draw;
        this.game = game;
    }
    
    /*@Override
    public void run() {
        
        this.frame = new JFrame();
        
        this.frame.setPreferredSize(new Dimension(600, 540));

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createObjects(this.frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
    }
    
    public void createObjects(Container container){
        
        JButton stand = new JButton("Stand");
        
        container.add(stand, BorderLayout.NORTH);
        container.add(this.draw);
    }*/


    @Override
    public void run(){

        this.frame = new JFrame();
        
        JButton jButton1 = new javax.swing.JButton();
        JButton jButton2 = new javax.swing.JButton();
        JPanel jPanel1 = this.draw;
        JTextField jTextField1 = new javax.swing.JTextField();
        JButton jButton3 = new javax.swing.JButton();

        this.frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Stand");
        jButton1.addActionListener(new StandButtonListener(this.game));
        
        jButton2.setText("Hit");
        jButton2.addActionListener(new HitButtonListener(this.game));
        
        
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        jTextField1.setText("Bet Amount");

        jButton3.setText("Bet");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.frame.getContentPane());
        this.frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(40, 40, 40)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(33, 33, 33))
        );

        this.frame.pack();
        this.frame.setVisible(true);
    }
    
}
