package objects;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Forms {

	private String fields;
	private String fieldType;

	public Forms(String fields, String fieldType) {
		this.fields = fields;
		this.fieldType = fieldType;
	}

	public Forms() {
		// Empty Constructor
	}

	public String getFields() {
		return fields;
	}

	public String getFieldsType() {
		return fieldType;
	}

	public Map<String, Forms> mapForms(List<String> markets, List<Forms> forms) {

		Map<String, Forms> allForms = new HashMap<>();
		assertTrue(markets.size() == forms.size(), "Markets and Forms have different Size");
		for (int i = 0; i < markets.size(); i++) {
			allForms.put(markets.get(i), forms.get(i));
		}
		return allForms;

	}

}
