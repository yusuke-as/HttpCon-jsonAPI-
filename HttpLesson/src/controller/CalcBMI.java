package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.BMI;


@WebServlet("/CalcBMI")
public class CalcBMI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String height=request.getParameter("height");
		String weight=request.getParameter("weight");
		height=height==null ? "0":height;
		weight=weight==null ? "0":weight;
		double h=Integer.parseInt(height);
		double w=Integer.parseInt(weight);
		String result;
		double bmi=w/h/h*10000;
		if(bmi<18.5) {
			result="http://localhost:8080/HttpLesson/images/img1.jpg";
		}else if(bmi>=18.5&&bmi<25.0) {
			result="http://localhost:8080/HttpLesson/images/img2.jpg";
		}else if(bmi>=25.0 && bmi<30.0){
			result="http://localhost:8080/HttpLesson/images/img3.jpg";
		}else if(bmi>=30.0 && bmi<35.0){
			result="http://localhost:8080/HttpLesson/images/img4.jpg";
		}else if(bmi>=35.0 && bmi<40.0){
			result="http://localhost:8080/HttpLesson/images/img5.jpg";
		}else{
			result="http://localhost:8080/HttpLesson/images/img6.jpg";
		}
		BMI bn=new BMI();
		bn.setHeight(h);bn.setWeight(w);bn.setBmi(Math.round(bmi*100)/100d);bn.setResult(result);
		Gson gson=new Gson();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(gson.toJson(bn));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}