//프로젝트 버전 확인
// import { initializeApp } from 'https://www.gstatic.com/firebasejs/9.19.0/firebase-app.js'
// import { getMessaging } from 'https://www.gstatic.com/firebasejs/9.19.0/firebase-messaging.js'
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




// import { initializeApp } from 'https://www.gstatic.com/firebasejs/9.19.0/firebase-app.js'
// import { getMessaging } from 'https://www.gstatic.com/firebasejs/9.19.0/firebase-messaging.js'

// const config = {
//     apiKey: "AIzaSyDYv5uPWBXTSDDIR7vEWfhkZ6heQ8FUKnE",
//     authDomain: "specification-fcm.firebaseapp.com",
//     projectId: "specification-fcm",
//     storageBucket: "specification-fcm.appspot.com",
//     messagingSenderId: "337617238692",
//     appId: "1:337617238692:web:c10125bfd2399b74548431",
//     measurementId: "G-LVW43MVPV3"
// };
//
// const app = initializeApp(config);
// const messaging = getMessaging();
//
// //백그라운드 서비스워커 설정
// messaging.onBackgroundMessage(messaging, (payload) => {
//     console.log(
//         "[firebase-messaging-sw.js] Received background message ",
//         payload
//     );
//
//     // Customize notification here
//     const notificationTitle = "Background Message Title";
//     const notificationOptions = {
//         body: payload,
//         icon: "/firebase-logo.png",
//     };
//
//     self.registration.showNotification(notificationTitle, notificationOptions);
// });