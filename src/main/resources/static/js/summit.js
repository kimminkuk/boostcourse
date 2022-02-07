function return_main() {
	var Post_DB2 = document.PostDB;
    Post_DB2.action = "HOME";
    Post_DB2.submit(); // Send to Servlet
    return true;
}

function GetDateFunc() {
    var currentDate = new Date();
    var tt = currentDate.getMonth() + 1;
    var Date_current = currentDate.getFullYear() + "-" + tt + "-" + currentDate.getDate();
    return Date_current;
}

function SendToDo(param1, param2, param3) {
    var currentDate = GetDateFunc();

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                console.log(xhr.responseText);
            } else {
                console.error(xhr.responseText);
            }
        }
    };

    //var ur = 'http://localhost:8080/basic-v2/HOME?' + "WhatWork_name=" + param1.value
    //+ "&WhoWork_name=" + param2.value + "&PriorityBtn_name=" + param3.value;
    var ur = 'http://localhost:8080/basic-v2/TODO'
    var temp = 'param1=' + encodeURIComponent(param1);
    xhr.open('POST', ur);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(temp);
}
