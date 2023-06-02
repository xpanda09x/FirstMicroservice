package com.example.MvcdemoApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	@PostMapping("/notification")
	public ResponseEntity<String> handleNotification(@RequestBody NotificationData notificationData) {
		// Procesa la notificación recibida de SendinBlue (Brevo)
		System.out.println("Notificación recibida:");
		System.out.println("Evento: " + notificationData.getEvent());
		System.out.println("ID del mensaje: " + notificationData.getMessageId());
		System.out.println("Datos adicionales: " + notificationData.getAdditionalData());

		// Devuelve una respuesta exitosa a SendinBlue (Brevo)
		return new ResponseEntity<>("Notificación recibida correctamente", HttpStatus.OK);
	}

	public static class NotificationData {
		private String event;
		private String messageId;
		private String additionalData;

		public String getEvent() {
			return event;
		}
		public void setEvent(String event) {
			this.event = event;
		}
		public String getMessageId() {
			return messageId;
		}
		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}
		public String getAdditionalData() {
			return additionalData;
		}
		public void setAdditionalData(String additionalData) {
			this.additionalData = additionalData;
		}
	}
}
