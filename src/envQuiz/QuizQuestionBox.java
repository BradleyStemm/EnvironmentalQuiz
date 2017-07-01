package envQuiz;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class QuizQuestionBox extends JFrame implements ActionListener
	{
		private static final long serialVersionUID = 1L;
		boolean flag = true;
		public ActionListener listener;
		public JLabel quizQuestion;
		public ButtonGroup  answerGroup;
		public JRadioButton[] answers;
		public JButton submit;
	
		public QuizQuestionBox()
			{
				super ("Global Warming Quiz");
				setLayout(new FlowLayout(FlowLayout.CENTER));
			}

		public void actionPerformed(ActionEvent e)
			{
				flag = false;
			}
	
		public boolean populateBox(String[] qAndAArray,boolean score)
			{
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setSize(500,100);
				this.setLocation(450, 450);
				quizQuestion = new JLabel(qAndAArray[0]);
				answerGroup = new ButtonGroup();
				answers = new JRadioButton[4];
				submit = new JButton("Submit");
				int	index = 0;	
				add(quizQuestion);
				for (int i=1; i<5;i++)
					{
						if (qAndAArray[i] == qAndAArray[5])
							{
								index = i;
							}
				
					}
				ButtonModel[] model = new ButtonModel[4];
				for (int counter = 0; counter < 4;counter++)
					{
						answers[counter] = new JRadioButton(qAndAArray[counter +1]);
						model[counter] = answers[counter].getModel();
						answerGroup.add(answers[counter]);
						add(answers[counter]);
					}
				add(submit);
				setVisible(flag);
				submit.addActionListener(this);
				while(flag)
					{
						submit.addActionListener(this);
						if (flag ==false)
							{
								setVisible(flag);
								break;
							}
					}
		
				if (model[index-1].isSelected())
					{
						score =true;
					}	
				else
					{
						score = false;
					}
			
				return score;
		
		
			}
		public void displayResults(boolean[] answers)
			{
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setSize(200,100);
				this.setLocation(450,450);
				int truths=0;
				for(int i=0;i<5;i++)
					{
						if(answers[i]== true)
							truths++;
					}
				quizQuestion = new JLabel(truths+ " out of 5 Correct");
				add(quizQuestion);
				submit = new JButton("Okay");
				submit.addActionListener(this);
				add(submit);
				setVisible(flag);
				while(flag)
					{
						submit.addActionListener(this);
						if (flag ==false)
							{
								setVisible(flag);
		
							}

					}
			
			}
	
	}

