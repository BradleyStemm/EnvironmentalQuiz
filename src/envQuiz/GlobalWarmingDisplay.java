package envQuiz;

public class GlobalWarmingDisplay 
{
	public static void main( String[] args)
		{
			GlobalWarmingQuiz thisQuiz = new GlobalWarmingQuiz();
			for(int question = 1; question <= 5; question++)
			{
				switch (question)
				{

				case 1:
					thisQuiz.score[0] = questionRun(thisQuiz.questionOne,thisQuiz.score[0]);
					break;
				case 2:	
					thisQuiz.score[1] = questionRun(thisQuiz.questionTwo,thisQuiz.score[1]);
					break;
				case 3:	
					thisQuiz.score[2] = questionRun(thisQuiz.questionThree,thisQuiz.score[2]);
					break;
				case 4:
					thisQuiz.score[3] = questionRun(thisQuiz.questionFour,thisQuiz.score[3]);
					break;
				case 5:
					thisQuiz.score[4]= questionRun(thisQuiz.questionFive,thisQuiz.score[4]);
					break;
					
				}
			}
			
			results(thisQuiz.score);

		}
	public static void results(boolean[] score)
	{
		QuizQuestionBox myQuiz = new QuizQuestionBox();
		myQuiz.displayResults(score);
		myQuiz.dispose();
	}
	
	public static boolean questionRun(String[] qAndAArray,boolean score)
	{
		QuizQuestionBox myQuiz = new QuizQuestionBox();
		score = myQuiz.populateBox(qAndAArray, score);
		myQuiz.dispose();
		return score;
	}
	
}
