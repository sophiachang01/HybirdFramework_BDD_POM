package froms;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import objects.Forms;



public class RegisterForm {

	
	//Map<String, Forms> allForms = new HashMap<>();
	private Forms global = new Forms("title,firstName,lastName,password,day,month,year,company,address,city,state,zipCode,country,mobile"
			,"radio,text,text,password,select,select,select,text,text,select,select,text,select,text"); // NOSONAR
	
	
	
    public RegisterForm() {
        Forms forms = new Forms();
        
    }

    public Forms getForm(String market) {
        return global;
    }
	
}
