package com.tyss.quizdao;

import java.util.Date;

import com.tyss.quizdto.QuizQuestions;
import com.tyss.quizdto.Register;
import com.tyss.quizdto.Results;

interface Quiz {
	
	abstract  Register login(String username,String Password);
	
	abstract  Register register(Register register);
	
	abstract QuizQuestions questions(int id);
	
	abstract void results(Results results);
	
	abstract Results getResults(Date date);

}
