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

//    function mainTimer() {
//        setTimeout(() => {
//            if (mainTimerCount >= 20) return;
//            start++;
//            if(start >= slideImgCntItem.length) {
//                start = 0;
//            }
//            //1,0 -> 2,1 -> 3,2 -> 0,3
//            //1,0 -> 2,1 ....
//            move(start, end, "right");
//            end = start;
//            mainTimerCount++;
//            mainTimer();
//        }, AUTO_TIME);
//    }
//    function move(start, end, type) {
//        var next_XPos = slideImg.offsetWidth;
//        var pre_XPos = 0;
//        next_XPos -= MOVEING_PX;
//        slideImgCntItem[start].style.left = next_XPos + 'px';
//            if(next_XPos <= 0) {
//                clearTimeout(set);
//                next_XPos = slideImg.offsetWidth;
//            }
//        pre_XPos -= MOVEING_PX;
//        slideImgCntItem[end].style.left = pre_XPos + 'px';
//    }
//    mainTimer();
});