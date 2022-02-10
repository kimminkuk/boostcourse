function return_main() {
	//var Post_DB2 = document.PostDB;

    //Post_DB2.action = "HOME";
    //Post_DB2.submit(); // Send to Servlet

    //redirect?
    window.location.replace('http://localhost:8080/basic-v2/HOME');
    return true;
}

function GetDateFunc() {
    var currentDate = new Date();
    var tt = currentDate.getMonth() + 1;
    var Date_current = currentDate.getFullYear() + "-" + tt + "-" + currentDate.getDate();
    return Date_current;
}

function SendToDoWhy(pTitle, pName, pSequence) {
    var currentDate = GetDateFunc();

    var xhr = new XMLHttpRequest();
    var ur = 'http://localhost:8080/basic-v2/TODO'
    xhr.onreadystatechange = function () {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                console.log(xhr.responseText);

                //Temporary Redirect..
                window.location.replace('http://localhost:8080/basic-v2/HOME');
            } else {
                console.error(xhr.responseText);
                alert('문제발생')
                xhr.open('GET', ur);
            }
        }
    };

    var SendToDo_Data = "param1=" + encodeURIComponent(pTitle.value) +
    "&param2=" + encodeURIComponent(pName.value) +
    "&param3=" + encodeURIComponent(pSequence.value)

    xhr.open('POST', ur, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(SendToDo_Data);
}

function rarrActionFunc(todoId, parentId, numId, todoSequence) {
    var xhr_rarr = new XMLHttpRequest();
    xhr_rarr.onreadystatechange = function () {
        if (xhr_rarr.readyState === xhr_rarr.DONE) {
            if (xhr_rarr.status === 200 || xhr_rarr.status === 201) {
                var transTodo = document.getElementById(todoId);
                var frameParent = document.getElementById(parentId);
                frameParent.appendChild(transTodo);

            } else {
                console.error(xhr_rarr.responseText);
                alert('이동 문제발생')
            }
        }
    };
    //[OFFICE CASE]
    //var ur_xhr_rarr = 'http://localhost:8080/basic-v2/HOME/' + numId;
    //var ur_xhr_rarr = 'http://localhost:8080/basic-v2/HOME/test';
    var ur_xhr_rarr = 'http://localhost:8080/basic-v2/HOME/todoId=' + numId +'/&todoSequence='+todoSequence;
    xhr_rarr.open('GET', ur_xhr_rarr);
    xhr_rarr.send();
}