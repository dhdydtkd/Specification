
function sessionDataAdd(name, value){
    sessionStorage.setItem(name, value);
}

function sessionDataGet(name){
    return sessionStorage.getItem(name);
}

function sessionDataDelete(name){
    sessionStorage.removeItem(name);
}

