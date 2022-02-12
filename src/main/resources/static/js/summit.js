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

function SendToDo(pTitle, pName, pSequence) {
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

function rarrActionFunc(numId, todoSequence, todoTitle) {
    var xhr_rarr = new XMLHttpRequest();
    xhr_rarr.onreadystatechange = function () {
        if (xhr_rarr.readyState === xhr_rarr.DONE) {
            if (xhr_rarr.status === 200 || xhr_rarr.status === 201) {
                todoMoveRight(numId);
            } else {
                console.error(xhr_rarr.responseText);
                alert('이동 문제발생')
            }
        }
    };
    //[OFFICE CASE]
    var ur_xhr_rarr = 'http://localhost:8080/basic-v2/HOME/todoId=' + numId +'/&todoSequence='+todoSequence;
    //var ur_xhr_rarr = 'http://localhost:8080/basic-v2/HOME';
    xhr_rarr.open('GET', ur_xhr_rarr);
    xhr_rarr.send();
}

function todoMoveRight(todoId_Right) {
    var frameRParent_DOING = document.getElementById('todoList2_frameId');
    var frameRParent_DONE = document.getElementById('todoList3_frameId');

    if (document.getElementById("todo1Id_"+todoId_Right)) {
        var tr1 = document.getElementById("todo1Id_"+todoId_Right);
        tr1.id = "todo2Id_"+todoId_Right;
        frameRParent_DOING.append(tr1);
    } else if (document.getElementById("todo2Id_"+todoId_Right)) {
        var tr2 = document.getElementById("todo2Id_"+todoId_Right);
        tr2.id = "todo3Id_"+todoId_Right;
        frameRParent_DONE.append(tr2);
    } else {
        alert('오른쪽 이동 문제발생');
    }
}

function todoMoveLeft(todoId_Left) {
    var frameLParent_TODO = document.getElementById('todoList1_frameId');
    var frameLParent_DOING = document.getElementById('todoList2_frameId');
}

function todoDeleteFunc(todoId_del) {
    var xhr_DF = new XMLHttpRequest();
    xhr_DF.onreadystatechange = function () {
        if (xhr_DF.readyState === xhr_DF.DONE) {
            if (xhr_DF.status === 200 || xhr_DF.status === 201) {
                todoChildDelete(todoId_del);
            } else {
                console.error(xhr_DF.responseText);
                alert('삭제 문제 발생')
            }
        }
    };
    //[OFFICE CASE]
    var ur_xhr_DF = 'http://localhost:8080/basic-v2/HOME/DEL/' + todoId_del;
    xhr_DF.open('GET', ur_xhr_DF);
    xhr_DF.send();
}

function todoChildDelete(todoId_CD) {
    var frame_CD_TODO = document.getElementById('todoList1_frameId');
    var frame_CD_DOING = document.getElementById('todoList2_frameId');
    var frame_CD_DONE = document.getElementById('todoList3_frameId');

    if (document.getElementById("todo1Id_"+todoId_CD)) {
        var CD1 = document.getElementById("todo1Id_"+todoId_CD);
        frame_CD_TODO.removeChild(CD1);
    } else if (document.getElementById("todo2Id_"+todoId_CD)) {
        var CD2 = document.getElementById("todo2Id_"+todoId_CD);
        frame_CD_DOING.removeChild(CD2);
    } else if (document.getElementById("todo3Id_"+todoId_CD)) {
        var CD3 = document.getElementById("todo3Id_"+todoId_CD);
        frame_CD_DONE.removeChild(CD3);
    }
    else {
        alert('DOM 삭제 문제발생');
    }
}