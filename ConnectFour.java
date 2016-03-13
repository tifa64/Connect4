/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Krietallo
 */
import javax.swing.*;
import java.awt.GridLayout;

public class ConnectFour extends JFrame {
	JPanel p = new JPanel();
    JButton[][] buttons = new JButton[6][7];
    Game c = new Game();
		
	public ConnectFour() {
		super("Connect Four");
		setSize(400, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				buttons[i][j] = new JButton();
				ImageIcon c = new ImageIcon(("circle.png"));
				buttons[i][j].setIcon(c);
				p.add(buttons[i][j]);
			}
		}
		add(p);
		setVisible(true);
	}
	
	boolean validateCol(String x){
		int n = x.length();
		if(n!=1)	return false;
		if(!(x.charAt(0) >= '1' && x.charAt(0) <= '7') || c.height[x.charAt(0) - '0' - 1] >= 6)
			return false;
		return true;
	}
	
	void playGame(){
		
		JOptionPane.showMessageDialog(null,"Welcome to Connect-4\n to continue press OK ");
		String player1 = JOptionPane.showInputDialog(null, "First Player Name");
		String player2 = JOptionPane.showInputDialog(null, "Second Player Name");
		String col;
		
		for(int  i =0; i < 42; i++)
		{
			int curPlayer = i%2 + 1;
			
			int ROW=0,COL=0;
			
			if(curPlayer == 1)
				JOptionPane.showMessageDialog(null,player1 + "'s turn :");
			else	
				JOptionPane.showMessageDialog(null,player2 + "'s turn :");
			
			boolean f = false;
			
			do{
				col = JOptionPane.showInputDialog(null, "Input Column");
				
				// VALIDATION
				if(validateCol(col)){
					COL = Integer.parseInt(col) - 1;
					ROW = c.height[COL];
					c.addCoin(curPlayer, COL);
					f = false;
				}
				else{	
					JOptionPane.showMessageDialog(null,"Invalid move. Try again.");
					f = true;
				}
				 
			}while(f);
			
			System.out.println(ROW+" "+COL);
			
			if(curPlayer == 1)
			{
				ImageIcon Orange = new ImageIcon(("Orange.png"));
				buttons[5-ROW][COL].setIcon(Orange);
				//p.add(buttons[ROW][COL]);
			}
			
			else	
			{
				ImageIcon Blue = new ImageIcon(("Blue.png"));
				buttons[5-ROW][COL].setIcon(Blue);
				//p.add(buttons[ROW][COL]);
			}
			
			if(c.isWinner(curPlayer, ROW, COL))
			{
				if(curPlayer == 1)
					JOptionPane.showMessageDialog(null,player1 + "WINS");
				else	
					JOptionPane.showMessageDialog(null,player2 + "WINS");
				
				return;
			}
		}
		
		JOptionPane.showMessageDialog(null,"DRAW! NOBODY WINS!");
	}

	/*static void ChangeButtonOrange(JButton b)
	{
		ImageIcon Orange = new ImageIcon(("Orange.png"));
		b.setIcon(Orange);
		p.add(b);
	}
	 static void ChangeButtonBlue(JButton b)
	{
		ImageIcon Blue = new ImageIcon(("Blue.png"));
		b.setIcon(Blue);
		p.add(b);
	}*/
	
}
