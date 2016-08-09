package io.github.toandv.translate;

import java.util.Arrays;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;

public class Translates {
	public static void main(String[] args) {
		NetHttpTransport transport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		// Translate translate = new Translate(transport, jsonFactory, null);

		try {
			// See comments on
			// https://developers.google.com/resources/api-libraries/documentation/translate/v2/java/latest/
			Translate t = new Translate.Builder(
					com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport(), jsonFactory,
					null).setApplicationName("Stackoverflow-Example").build();

			Translate.Translations.List list = t.new Translations().list(
					Arrays.asList(
							// Pass in list of strings to be translated
							"Hello World", "How to use Google Translate from Java"),
					// Target language
					"ES");
			// Set your API-Key from https://console.developers.google.com/
			list.setKey("you-need-your-own-api-key");
			TranslationsListResponse response = list.execute();
			for (TranslationsResource tr : response.getTranslations()) {
				System.out.println(tr.getTranslatedText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
