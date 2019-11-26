package objects;

import java.lang.reflect.Field;

public class CommonDataMethods {

	public void mapData(String data, Forms form) {
		String[] userData = data.split(",", -1);// feature
		String[] allField = form.getFields().split(",", -1); // forms and UserData class

		if (userData.length != allField.length) {
			throw new RuntimeException("Not equal Form Fields: " + form.getFields() + "Test data: " + data
					+ " Form Size " + allField.length + " Test data size: " + userData.length);
		}

		try {
			for (int i = 0; i < allField.length; i++) {
				accessField(allField[i], userData[i]);
			}
		} catch (Exception e) {
			System.out.println("INFO " + e.getMessage());
		}
	}

	private void accessField(String allFieldElement, String userDataElement)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Field field = this.getClass().getDeclaredField(allFieldElement);

		field.setAccessible(true);
		if ("y".equalsIgnoreCase(userDataElement)) {
			field.set(this, true);
		} else if ("n".equalsIgnoreCase(userDataElement)) {
			field.set(this, false);
		} else {
			field.set(this, userDataElement);
		}

	}

}
