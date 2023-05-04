package com.example.specification.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FCMInitializer {

    @PostConstruct
    public void initialize() throws IOException {
        System.out.println("FCMInitializer Ready");
        Path currentPath = Paths.get("");
        String path = currentPath.toAbsolutePath().toString();
        FileInputStream refreshToken = new FileInputStream(path+"/FCM/service-account-file.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .setProjectId("specification-fcm")
                .build();

        FirebaseApp.initializeApp(options);
        System.out.println("FCMInitializer Success");
    }
}