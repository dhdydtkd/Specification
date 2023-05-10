//프로젝트 버전 확인
importScripts('https://www.gstatic.com/firebasejs/8.10.1/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.10.1/firebase-messaging.js');

firebase.initializeApp({
    apiKey: "AIzaSyDYv5uPWBXTSDDIR7vEWfhkZ6heQ8FUKnE",
    authDomain: "specification-fcm.firebaseapp.com",
    projectId: "specification-fcm",
    storageBucket: "specification-fcm.appspot.com",
    messagingSenderId: "337617238692",
    appId: "1:337617238692:web:c10125bfd2399b74548431",
    measurementId: "G-LVW43MVPV3"
});

const messaging = firebase.messaging();

messaging.onBackgroundMessage((payload) => {
    console.log(
        '[firebase-messaging-sw.js] Received background message ',
        payload
    );
});
