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
<script src="/js/common.js"></script>

<script src="/js/sessionUtil.js"></script>
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
        }else{
            return;
        }
        Notification.requestPermission().then((permission) => {
            if (permission === 'granted') {
                notificationFlag = true;
            }
            if ("PushManager" in window) {
                pushManagerFlag = true;
            }
        });
    }
    function foreGroundOnMessage(title,body){
        // $("#foreground_title").text(title);
        // $("#foreground_body").text(body);
        document.getElementById("fore_ground_title").value = title;
        document.getElementById("fore_ground_body").value = body;
    }
    function backGroundOnMessage(title,body){
        // $("#foreground_title").text(title);
        // $("#foreground_body").text(body);
        document.getElementById("back_ground_title").value = title;
        document.getElementById("back_ground_body").value = body;
    }

    $(() => {
        serviceWorkerCheck();
        $("#fcm_now_send").click(function() {
            delayFCMSend(createData());
        });
        $("#fcm_delay_send").click(function() {
            setTimeout(function() {
                delayFCMSend(createData());
            }, 3000);

        });
        function delayFCMSend(data) {
            $.ajaxPOST("fcm/send", data, function(result){
                if (result.state.code == "0000") {

                    return;
                }
            });
        }
        function createData(){
            let title = "";
            let body = "";
            if($('#title').val()==""){
                title="안녕하세요, FCM Push Title 테스트입니다.";
            }else{
                title = $('#title').val();
            }
            if($('#body').val()==""){
                body = "안녕하세요, FCM Push Body 테스트입니다.";
            }else{
                body = $('#body').val();
            }
            let data = {
                title: title
                , body: body
                , token: sessionDataGet("FCM_CLIENT_TOKEN")
            }
            return data;
        }
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
                        <li><input id="fcm_now_send" type="button" value="FCM send (포그라운드 확인용)" class="primary" /></li>
                    </ul>
                    <ul class="actions">
                        <li><input id="fcm_delay_send" type="button" value="FCM send 3초 딜레이 (백그라운드 확인용)" class="primary" /></li>
                    </ul>
                </div>
                <div style="margin-top: 30px" class="col-12 col-12-xsmall">
                    <b>포그라운드에서 온 메세지</b>
                    <div class="col-12 col-12-xsmall">
                        Title
                        <input style="width: 500px" type="text" id="fore_ground_title" readonly/>
                    </div>
                    <div class="col-12 col-12-xsmall">
                        Body
                        <input style="width: 500px" type="text" id="fore_ground_body" readonly/>
                    </div>
                </div>

                <div style="margin-top: 30px" class="col-12 col-12-xsmall">
                    <b>백그라운드체크는 백그라운드 확인용 버튼을 누루고 다른 탭의 인터넷 화면이나 다른 프로그램을 ForeGround 하시고 알람을 클릭하시면 해당 탭으로 이동됍니다.</b>
                </div>
                <div style="margin-top: 50px" class="col-12 col-12-xsmall">
                </div>
            </div>
        </div>
    </div>
    <!-- Sidebar -->
    <jsp:include page="sidebar.jsp" flush="false"/>
</div>

</body>
</html>
