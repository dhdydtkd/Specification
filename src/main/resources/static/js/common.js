$.ajaxGET = function (url, data= null, successCallBack = null, failCallBack = null, type = null) {
    var url = "http://localhost:8080/"+url;
    var ajaxSuccessCallBack = null;
    var ajaxFailCallBack = null;
    var contentType = "application/json;charset=UTF-8";

    if(successCallBack != null && typeof successCallBack == 'function'){
        ajaxSuccessCallBack = successCallBack;
    }
    if(failCallBack != null && typeof failCallBack == 'function'){
        ajaxFailCallBack = failCallBack;
    }
    if(type != null && type == "file"){
        contentType = contentType; // 수정 필요
    }
    $.ajax({
        type: "GET",
        url: url,
        data : JSON.stringify(data),
        contentType: contentType,
        success: (data) => {
            if(data.state.code=="0000"){
                ajaxSuccessCallBack(data);
            }else{
                ajaxFailCallBack(data);
            }
        },
        error:(data)=>{
            ajaxFailCallBack(data);
        }
    });
}

$.ajaxPOST = function (url, data= null, successCallBack = null, failCallBack = null, type = null) {
    var url = "http://localhost:8080/"+url;
    var ajaxSuccessCallBack = null;
    var ajaxFailCallBack = null;
    var contentType = "application/json;charset=UTF-8";

    if(successCallBack != null && typeof successCallBack == 'function'){
        ajaxSuccessCallBack = successCallBack;
    }
    if(failCallBack != null && typeof failCallBack == 'function'){
        ajaxFailCallBack = failCallBack;
    }
    if(type != null && type == "file"){
        contentType = contentType; // 수정 필요
    }
    $.ajax({
        type: "POST",
        url: url,
        data : JSON.stringify(data),
        contentType: contentType,
        success: (data) => {
            ajaxSuccessCallBack(data);
        },
        error:(data)=>{
            ajaxFailCallBack(data);
        }
    });
}