package eu.company.hosel.bsl.test.model;

public class ErrorItems {
	private String ErrorMessage;	
	public ErrorItems(String errorMessage) {
		super();
		ErrorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	} 
}

