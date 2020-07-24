//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
//出生日期转年龄
function getAge(birthday){
    var birs = birthday.split("-");
    var time = new Date();
    var year = time.getFullYear();
    // console.log(year);
    // console.log(birs[0]);
    // console.log(year-birs[0]);
    return year-birs[0];
}