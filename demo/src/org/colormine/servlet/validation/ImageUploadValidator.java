package org.colormine.servlet.validation;

import java.util.ArrayList;

import javax.servlet.http.Part;

public class ImageUploadValidator {
	private static final int sizeLimitMb = 1;

	public static IValidationResult validate(Part part) {
		ArrayList<String> errors = new ArrayList<String>();
		// SIZE_LIMIT is given in mb
		if (part.getSize() >= (sizeLimitMb * 1024 * 1024)) {
			errors.add("Invalid upload, the file size must be under " + sizeLimitMb + "mb.");
		}

		String contentType = part.getContentType();
		if (!contentType.matches("image.*")) {
			errors.add("Invalid upload, the file must be of type gif, jpg, jpeg, or png. (" + contentType + ")");
		}

		return new ValidationResult(0 == errors.size(), errors);
	}

}