<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>

<html>
<head>
    <title>Reve Spac Site</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="/css/main.css" />
</head>

<!-- Scripts -->
<script src="/js/jquery.min.js"></script>
<script src="/js/browser.min.js"></script>
<script src="/js/breakpoints.min.js"></script>
<script src="/js/util.js"></script>
<script src="/js/main.js"></script>
<script src="/js/sessionManagement.js"></script>
<script type="module" src="/js/fcm.js"></script>

<body class="is-preload">

<script>
    let serviceWorkerFlag = false;
    let notificationFlag = false;
    let pushManagerFlag = false;

    permissionChecking();
    function permissionChecking() {
        if (('serviceWorker' in navigator)) {
            serviceWorkerFlag = true;
            console.log("1. ServiceWorker ok");
        }else{
            console.log("1. ServiceWorker fail");
            return;
        }

        console.log("권한 요청 중...");
        Notification.requestPermission().then((permission) => {
            if (permission === 'granted') {
                notificationFlag = true;
                console.log('2. 알림 권한이 허용됨');
            }else {
                console.log("2. 알림 권한 허용 안됨");
            }
            if ("PushManager" in window) {
                pushManagerFlag = true;
                console.log("3. PushManager ok");
            }else{
                console.log("3. PushManager fail");
            }
        });
    }
    $(() => {
        serviceWorkerCheck();
        $("#fcm_send").click(function() {

            let title = $('#title');
            let body = $('#body');
            let titleText = "";
            let bodyText = "";
            if(title.val()==""){
                titleText="안녕하세요, FCM Push Title 테스트입니다.";
            }else{
                titleText = title.val();
            }
            if(body.val()==""){
                bodyText = "안녕하세요, FCM Push Body 테스트입니다.";
            }else{
                bodyText = body.val();
            }
            console.log("FCM_CLIENT_TOKEN : "+sessionDataGet("FCM_CLIENT_TOKEN"));
            // $.ajaxPOST("fcm/send", data, function(result){
            //     if (result.state.code == "0000") {
            //         if(result.body != null) {
            //         }
            //         return;
            //     }
            // });
        });

        function serviceWorkerCheck(){
            if (!serviceWorkerFlag) {
                $('#serviceWorkerText').append("해당 브라우저는 serviceWorker를 지원하지 않는 브라우저입니다.");
                $("#serviceWorkerText").css("color","red");

            }else{
                $('#serviceWorkerText').append("해당 브라우저는 serviceWorker를 지원하는 브라우저입니다.");
                $("#serviceWorkerText").css("color","#3e79dc");
            }
            if (!pushManagerFlag) {
                $('#pushManagerText').append("해당 브라우저는 pushManager 지원하지 않는 브라우저입니다.");
                $("#pushManagerText").css("color","red");

            }else{
                $('#pushManagerText').append("해당 브라우저는 pushManager 지원하는 브라우저입니다.");
                $("#pushManagerText").css("color","#3e79dc");
            }
            if (!notificationFlag) {
                $('#notificationText').append("알림에 대해 동의하지 않으셨습니다. 브라우저 설정을 통해 알림을 허용해주세요.");
                $("#notificationText").css("color","red");

            }else{
                $('#notificationText').append("알림에 대해 동의 하셨습니다.");
                $("#notificationText").css("color","#3e79dc");
            }
        }
    });


</script>
<!-- Wrapper -->
<div id="wrapper">
    <!-- Main -->
    <div id="main">
        <div class="inner">
            <!-- Header -->
            <header id="header">
                <strong>FCM</strong>
            </header>

            <!-- Banner -->
            <div style="margin-top: 30px" class="content">
                <div class="col-12 col-12-xsmall">
                    <b style="color: #f45c5c">주의 <브라우저에서의 url 알림 권환과 다르게 컴퓨터 브라우저 환경설정으로 인해 알림이 오지 않을 수 있습니다.></b>
                </div>
                <div class="col-12 col-12-xsmall">
                    ServiceWorker : <z id="serviceWorkerText" ></z><a>https://caniuse.com/</a>
                </div>
                <div class="col-12 col-12-xsmall">
                    PushManager : <z id="pushManagerText" ></z>
                </div>
                <div class="col-12 col-12-xsmall">
                    Notification Permission : <z id="notificationText" ></z>
                </div>

                <div style="margin-top: 30px" class="col-12 col-12-xsmall">
                    Title<input style="width: 50%" type="text" id="title" value="" placeholder="FCM 제목 입력란입니다." />
                </div>
                <div class="col-12	 col-12-xsmall">
                    Body<input style="width:50%" type="text" id="body" value="" placeholder="FCM 내용 입력란입니다." />
                </div>
                <div style="margin-top: 20px" class="col-12">
                    <ul class="actions">
                        <li><input id="fcm_send" type="button" value="FCM send" class="primary" /></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
    <!-- Sidebar -->
    <jsp:include page="sidebar.jsp" flush="false"/>
</div>

</body>
</html>
