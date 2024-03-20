package CaseStudy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class TicTacToe implements ActionListener
{
    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel title_Panel=new JPanel();
    JPanel button_Panel=new JPanel();
    JLabel textfield=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean P1_turn;
    public TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        JButton resetbutton = new JButton();
        resetbutton.setText("Reset");
        resetbutton.setSize(200,200);
        resetbutton.setBackground(Color.BLACK);
        resetbutton.setForeground(Color.WHITE);
        resetbutton.setLocation(50, 0);
        resetbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
            
        });
        button_Panel.add(resetbutton);
        frame.add(resetbutton,BorderLayout.SOUTH);
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(0,255,255));
		textfield.setFont(new Font("Montserrat",Font.BOLD,25));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe:By Aashutosh & Qusai");
		textfield.setOpaque(true);

		title_Panel.setLayout(new BorderLayout());
		title_Panel.setBounds(0,0,800,100);

		button_Panel.setLayout(new GridLayout(3,3));
		button_Panel.setBackground(new Color(50,50,50));
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_Panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		title_Panel.add(textfield);
		frame.add(title_Panel,BorderLayout.NORTH);
		frame.add(button_Panel);
        for(int i=0;i<9;i++)
        {
            buttons[i].setBackground(new Color(50,50,50));
        }
		firstTurn();
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(P1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0  ));
						buttons[i].setText("X");
						P1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						P1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}			
		}
    }

    public void firstTurn()
    {
        try{
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(random.nextInt(2)==0)
        {
            P1_turn=true;
            textfield.setText("X Turn");
        }
        else
        {
            P1_turn=false;
            textfield.setText("O Turn");
        }
    }

    public void check()
    {
        if(buttons[0].getText()=="X"&&buttons[1].getText()=="X"&&buttons[2].getText()=="X")
        {
            xWins(0,1,2);
            return;   
        }
        if(buttons[3].getText()=="X"&&buttons[4].getText()=="X"&&buttons[5].getText()=="X")
        {
            xWins(3,4,5);
            return;
        }
        if(buttons[6].getText()=="X"&&buttons[7].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWins(6,7,8);
            return;
        }
        if(buttons[0].getText()=="X"&&buttons[3].getText()=="X"&&buttons[6].getText()=="X")
        {
            xWins(0,3,6);
            return;
        }
        if(buttons[1].getText()=="X"&&buttons[4].getText()=="X"&&buttons[7].getText()=="X")
        {
            xWins(1,4,7);
            return;
        }
        if(buttons[2].getText()=="X"&&buttons[5].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWins(2,5,8);
            return;
        }
        if(buttons[0].getText()=="X"&&buttons[4].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWins(0,4,8);
            return;
        }
        if(buttons[2].getText()=="X"&&buttons[4].getText()=="X"&&buttons[6].getText()=="X")
        {
            xWins(2,4,6);
            return;
        }
        if(buttons[0].getText()=="O"&&buttons[1].getText()=="O"&&buttons[2].getText()=="O")
        {
            oWins(0,1,2);
            return;
        }
        if(buttons[3].getText()=="O"&&buttons[4].getText()=="O"&&buttons[5].getText()=="O")
        {
            oWins(3,4,5);
            return;
        }
        if(buttons[6].getText()=="O"&&buttons[7].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWins(6,7,8);
            return;
        }
        if(buttons[0].getText()=="O"&&buttons[3].getText()=="O"&&buttons[6].getText()=="O")
        {
            oWins(0,3,6);
            return;
        }
        if(buttons[1].getText()=="O"&&buttons[4].getText()=="O"&&buttons[7].getText()=="O")
        {
            oWins(1,4,7);
            return;
        }
        if(buttons[2].getText()=="O"&&buttons[5].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWins(2,5,8);
            return;
        }
        if(buttons[0].getText()=="O"&&buttons[4].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWins(0,4,8);
            return;
        }
        if(buttons[2].getText()=="O"&&buttons[4].getText()=="O"&&buttons[6].getText()=="O")
        {
            oWins(2,4,6);
            return;
        }
        int count=0;
        for(int i=0;i<9;i++)
        {
            if(buttons[i].getText()=="O"||buttons[i].getText()=="X")
            {
               count++;
            }
        }
        if(count==9)
        {
            Tie();
        }
    }

    public void xWins(int a,int b,int c)
    {
            buttons[a].setBackground(Color.GREEN);
		    buttons[b].setBackground(Color.GREEN);
    		buttons[c].setBackground(Color.GREEN);

		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
    }

    public void oWins(int a,int b,int c)
    {
        buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
    	buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++) 
        {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
    }
    public void Tie()
    {
        for(int i=0;i<9;i++)
        {
            buttons[i].setBackground(Color.YELLOW);
            buttons[i].setEnabled(false);
        }
        textfield.setText("It's a TIE");
    }
    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(new Color(50,50,50));
        }
        P1_turn = true;
        textfield.setText("X Turn");
    }
}
