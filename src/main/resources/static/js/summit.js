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

function SendToDo(pTitle, pName, pSequence) {
    var currentDate = GetDateFunc();

    var xhr = new XMLHttpRequest();
    var ur = 'http://localhost:8080/basic-v2/TODO'
    xhr.onreadystatechange = function () {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                console.log(xhr.responseText);
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
