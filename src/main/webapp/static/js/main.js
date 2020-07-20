//轮播
var nextIndex =1;
var timerCar = setInterval(carouse,4000);
function carouse(){
    //获取轮播装img的 div
    var carousel_img_div = document.getElementsByClassName("carousel_img_div");
    //获取轮播图片按钮的
    var carousel_button_bg =document.getElementsByClassName("carousel_button_bg");

    for(var i=0;i<carousel_img_div.length;i++){
        if(nextIndex==i) {
            carousel_img_div[i].className="carousel_img_div show";
            carousel_button_bg[i].className="carousel_button_bg hidden";
        }else{
            carousel_img_div[i].className="carousel_img_div hidden";
            carousel_button_bg[i].className="carousel_button_bg show";
        }
    }
    nextIndex++;
    if(nextIndex==carousel_img_div.length){
        nextIndex=0;
    }
}
function stop(){
    clearInterval(timerCar);
}

function startCar(){
    stop();
    timerCar = setInterval(carouse,4000);
}
function selexted(index){
    nextIndex =index;
    carouse();
}
