function enrollmentFunc(pName, pContent) {
    var xhr = new XMLHttpRequest();
    var ur = 'http://localhost:8080/basic-v3/guestbook/write'
    xhr.onreadystatechange = function () {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                console.log(xhr.responseText);

                //Temporary Redirect..
                window.location.replace('http://localhost:8080/basic-v3/guestbook/list');
            } else {
                console.error(xhr.responseText);
                alert('write 문제발생');
            }
        }
    };

    var eF_Data = "name=" + encodeURIComponent(pName.value) +
    "&content=" + encodeURIComponent(pContent.value);

    xhr.open('POST', ur, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(eF_Data);
}