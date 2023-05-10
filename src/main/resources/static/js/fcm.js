import { initializeApp } from 'https://www.gstatic.com/firebasejs/9.19.0/firebase-app.js'
import { getMessaging, getToken, onMessage } from 'https://www.gstatic.com/firebasejs/9.19.0/firebase-messaging.js'

const config = {
    apiKey: "AIzaSyDYv5uPWBXTSDDIR7vEWfhkZ6heQ8FUKnE",
    authDomain: "specification-fcm.firebaseapp.com",
    projectId: "specification-fcm",
    storageBucket: "specification-fcm.appspot.com",
    messagingSenderId: "337617238692",
    appId: "1:337617238692:web:c10125bfd2399b74548431",
    measurementId: "G-LVW43MVPV3"
};

const app = initializeApp(config);
const messaging = getMessaging();
//토큰값 얻기
getToken(messaging, {
    vapidKey:
        "BM7YVW-9FWsKVn28AaG1r0OtRfBYKOSdmnqh66KoiwU0xgwGhwsfZEodJijifeeo50vasleZfLQAoFg0ikRvo9k",
})
    .then((currentToken) => {
        if (currentToken) {
            console.log(currentToken);
            sessionDataAdd("FCM_CLIENT_TOKEN",currentToken);
        } else {
            // Show permission request UI
            console.log(
                "No registration token available. Request permission to generate one."
            );
        }
    })
    .catch((err) => {
        console.log("An error occurred while retrieving token. ", err);
        // ...
    });

//포그라운드 메시지 수신
onMessage(messaging, (payload) => {
    console.log("포그라운드 메시지 수신");
    console.log("Message received. ", payload);
    foreGroundOnMessage(payload.notification.title,payload.notification.body);
});