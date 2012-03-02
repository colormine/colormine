package org.colorMine.servlet.validation;

import java.util.ArrayList;

public class ValidationResult implements IValidationResult {

	private final boolean _status;
	private final ArrayList<String> _errorMessage;

	public ValidationResult(boolean status, ArrayList<String> errorMessage) {
		_status = status;
		_errorMessage = errorMessage;
	}

	public ValidationResult(boolean status) {
		_status = status;
		_errorMessage = new ArrayList<String>();
	}

	@Override
	public boolean isValid() {
		return _status;
	}

	@Override
	public ArrayList<String> getErrorMessage() {
		return _errorMessage;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (String message : _errorMessage) {
			output.append(message + " ");
		}
		return output.toString();
	}

}