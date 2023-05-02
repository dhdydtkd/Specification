
function sessionDataAdd(name, value){
    session.setAttribute(name, value);
}

function sessionDataGet(name){
    session.getAttribute(name);
}

function sessionDataDelete(name){
    session.removeAttribute(name);
}