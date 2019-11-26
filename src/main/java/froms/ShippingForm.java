package froms;


import objects.Forms;



public class ShippingForm {

	//Map<String, Forms> allForms = new HashMap<>();
	private Forms global = new Forms("firstName,lastName,company,address,city,state,zipCode,country,mobile,addressAlias"
			,"text,text,text,text,select,select,text,select,text,text"); // NOSONAR
	
	
	
    public ShippingForm() {
        Forms forms = new Forms();
        
    }

    public Forms getForm(String market) {
        return global;
    }
	
}
