window.addEventListener("load", function() {
    var slideImg = document.getElementById("slideImg");
    var slideImgCnt = slideImg.getElementsByClassName("visual_img_mk");
    var slideImgCntItem = slideImgCnt[0].getElementsByTagName("img");
    var start = 0;
    var end = 0;
    var slideImgCalInitPos = -40;
    var MOVEING_PX = 4;
    var moveIng = false;
    const AUTO_TIME = 3000;
    let mainTimerCount = 0;
    slideImgCntItem[0].style.left = 0;
    setInterval(function() {
        if (!moveIng) {
            start++;
            if(start >= slideImgCntItem.length) {
                start = 0;
            }
            move(start, end, "right");
            end = start;
        }
    }, AUTO_TIME);
    function move(start, end, type) {
        var nextX = slideImg.offsetWidth;
        var prevX = 0;
        var set = null;
        set = setInterval(function() {
            moveIng = true;
            nextX -= MOVEING_PX;
            slideImgCntItem[start].style.left = nextX + 'px';

            if (nextX <= 0) {
                clearInterval(set);
                nextX = slideImg.offsetWidth;
                moveIng = false;
            }
            prevX -= MOVEING_PX;
            slideImgCntItem[end].style.left = prevX + 'px';
        });
    }
});

function makeTemplate(data, clickedName) {
    console.log(clickedName);
}

function sendCategoryAjax(url, clickedName) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
        //var data = JSON.parse(oReq.responseText);
        var data =''
        makeTemplate(data, clickedName);
    });
    oReq.open("GET",url);
    oReq.send();
}

var categoryClick = document.querySelectorAll(".anchor");
var cateFirst = categoryClick[0];
//[].forEach.call(categoryClick, function(evt){
//    evt.addEventListener('click',function(evt2){
//        sendCategoryAjax("",evt2.target);
//    });
//});

for (var i = 0, len=categoryClick.length; i < len; i++ ) {
    categoryClick[i].addEventListener('click', function(evt) {
        for (var j = 0, len2=categoryClick.length; j < len2; j++ ) {
            categoryClick[j].className ='anchor';
        }
        evt.currentTarget.className = 'anchor active';
    });
}