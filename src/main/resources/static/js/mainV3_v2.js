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

function makeTemplate(data) {

}

function sendCategoryAjax(url, clickedName) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
        //var data = JSON.parse(oReq.responseText);
        var data =''
        makeTemplate(data);
    });
    oReq.open("GET",'http://49.236.147.192:9090/api/products', true);
    oReq.setRequestHeader('X-PINGOTHER', 'pingpong');
    oReq.setRequestHeader('Content-Type', 'application/xml');
    oReq.withCredentials = true;
    //oReq.onreadystatechange = someHandler;
    oReq.send();
}

var categoryClick = document.querySelectorAll(".anchor");
var cateFirst = categoryClick[0];

for (var i = 0, len=categoryClick.length; i < len; i++ ) {
    categoryClick[i].addEventListener('click', function(evt) {
        for (var j = 0, len2=categoryClick.length; j < len2; j++ ) {
            categoryClick[j].className ='anchor';
        }
        evt.currentTarget.className = 'anchor active';
        sendCategoryAjax('','test');
    });
}

function productCountFunc(data) {
    var productCategoryListCount = document.querySelector(".pink");
    productCategoryListCount.innerText = data;
    productCategoryListCount.style.color = red;
}

function createListEventBox(parentNode) {
    var moreBtnPos = document.querySelector(".more");
    var moreBtnParent = moreBtnPos.parentNode;

    var moreCreateElement2 = document.createElement("li");
    moreCreateElement2.className = "item";

    var moreCreateElement4 = document.createElement("a");
    moreCreateElement4.className = "item_book";
    moreCreateElement2.appendChild(moreCreateElement4);

    var moreCreateElement5 = document.createElement("div");
    moreCreateElement5.className = 'item_preview';
    moreCreateElement4.appendChild(moreCreateElement5);

    var moreCreateElement6 = document.createElement("img");
    moreCreateElement6.className = 'img_thumb';
    var moreCreateElement7 = document.createElement("span");
    moreCreateElement7.className = 'img_border';
    moreCreateElement5.appendChild(moreCreateElement6);
    moreCreateElement5.appendChild(moreCreateElement7);

    var moreCreateElement8 = document.createElement("div");
    moreCreateElement8.className = 'event_txt';
    moreCreateElement4.appendChild(moreCreateElement8);

    var moreCreateElement9 = document.createElement("h4");
    moreCreateElement9.className = 'event_txt_tit';
    moreCreateElement8.appendChild(moreCreateElement9);

    var moreCreateElement10 = document.createElement("span");
    var moreCreateElement11 = document.createElement("small");
    moreCreateElement11.className = 'sm';
    moreCreateElement9.appendChild(moreCreateElement10);
    moreCreateElement9.appendChild(moreCreateElement11);

    var moreCreateElement12 = document.createElement("p");
    moreCreateElement12.className = 'event_txt_dsc';
    moreCreateElement8.appendChild(moreCreateElement12);

    parentNode.appendChild(moreCreateElement2);
    moreBtnParent.insertBefore(parentNode, moreBtnPos);
}

function moreList(e) {
    var temp2 = document.querySelector(".more");
    var parent = temp2.parentNode;

    var moreCreateElement1 = document.createElement("ul");
    moreCreateElement1.className = "lst_event_box";
    createListEventBox(moreCreateElement1);
    createListEventBox(moreCreateElement1);
}