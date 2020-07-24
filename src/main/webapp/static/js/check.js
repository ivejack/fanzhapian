//查询所有审核
//模糊 分页
//发表文章
function getCheckPublishEssay() {
    var data = $("#checkForm").serialize();
    $.ajax("getCheckPublishEssay",{
        data:data,
        type:"post",
        success:function (rel) {
            console.log(rel);
            var lis="";
            lis += "<ul class=\"lib_li\">\n" +
                "                    <li style=\"margin-right: 20px\">序号</li>\n" +
                "                    <li style=\"margin-right: 30px\">发表人</li>\n" +
                "                    <li style=\"margin-right: 130px\">标题</li>\n" +
                "                    <li style=\"margin-right: 100px\">文章描述</li>\n" +
                "                    <li style=\"margin-right: 40px\">审核人</li>\n" +
                "                    <li style=\"margin-right: 50px\">上传日期</li>\n" +
                "                    <li style=\"margin-right: 60px\">审核日期</li>\n" +
                "                    <li style=\"margin-right: 60px\">审核状态</li>\n" +
                "                    <li style=\"margin-right: 60px\">审核结果</li>\n" +
                "                    <li style=\"margin-right: 50px\">操作</li><br/>\n" +
                "                </ul>";
            $(rel.list).each(function (i) {
                lis += "<ul class=\"lib_li2\">";
                lis += "<li style=\"margin-left: 8px\">"+(i+1)+"</li>";
                lis += "<li style=\"margin-left: 90px\">"+this.userids.username+"</li>";
                lis += "<li style=\"margin-left: 25px\">"+this.contentids.title+"</li>";
                lis += "<li style=\"margin-left: 25px\">"+this.contentids.content+"</li>";
                lis += "<li style=\"margin-left: 30px\">"+(this.checkpeoples!=null?this.checkpeoples.username:'无')+"</li>";
                lis += "<li style=\"margin-left: 35px\">"+this.checktime+"</li>";
                lis += "<li style=\"margin-left: 20px\"><br/>&nbsp;&nbsp;10:30</li>";
                lis += "<li style=\"margin-left: 25px;color: #FDBE22;\">"+(this.statu==0?'未审核':'已审核')+"</li>";
                lis += "<li style=\"margin-left: 25px;color: #FDBE22;\">"+(this.result==0?'未审核':(this.result==1?'不通过':'通过'))+"</li>";
                if(this.statu==0){
                    lis += "<li style=\"margin-left: 80px;color: #3ce650\"><span onclick='gotoCheck(2,"+this.id+");'>批准</span>&nbsp;&nbsp;&nbsp;<span style=\"color: #FDBE22;\" onclick='gotoCheck(1,"+this.id+");'>驳回</span>";
                }else{
                    lis += "<li style=\"margin-left: 80px;color: #3ce650\"><span onclick='delCheck("+this.id+");'>删除</span>";
                }
                lis += "</ul>";
                lis += "<hr style=\"margin-top: 50px;width: 98%;margin-left: 10px;background-color: #F1F1F1;height: 1px;border:none\"/>";
            })

            lis += "<span style=\"color: skyblue; font-size: 12px; float: right;margin-top: 22px;margin-right: 30px;\">";
            lis += "<span onclick=\"toPage(1)\">首页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick=\"toPage("+rel.pages+")\">尾页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick=\"toPage("+((rel.pageNum-1)<1?rel.pages:(rel.pageNum-1))+")\">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick=\"toPage("+((rel.pageNum+1)>rel.pages?1:(rel.pageNum+1))+")\">下一页</span>";
            lis += "</span>";
            $(".cxk").html(lis);
        }
    })
}
//举报文章
function getCheckReport() {
    var data = $("#checkForm").serialize();
    $.ajax("getCheckReport",{
        data:data,
        type:"post",
        success:function (rel) {
            console.log(rel);
            var lis="";
            lis += "<ul class=\"lib_li\">\n" +
                "                    <li style=\"margin-right: 20px\">序号</li>\n" +
                "                    <li style=\"margin-right: 30px\">举报人</li>\n" +
                "                    <li style=\"margin-right: 130px\">标题</li>\n" +
                "                    <li style=\"margin-right: 100px\">文章描述</li>\n" +
                "                    <li style=\"margin-right: 40px\">审核人</li>\n" +
                "                    <li style=\"margin-right: 50px\">举报日期</li>\n" +
                "                    <li style=\"margin-right: 60px\">审核日期</li>\n" +
                "                    <li style=\"margin-right: 60px\">审核状态</li>\n" +
                "                    <li style=\"margin-right: 60px\">审核结果</li>\n" +
                "                    <li style=\"margin-right: 50px\">操作</li><br/>\n" +
                "                </ul>";
            $(rel.list).each(function (i) {
                lis += "<ul class=\"lib_li2\">";
                lis += "<li style=\"margin-left: 8px\">"+(i+1)+"</li>";
                lis += "<li style=\"margin-left: 90px\">"+this.userids.username+"</li>";
                lis += "<li style=\"margin-left: 25px\">"+this.contentids.title+"</li>";
                lis += "<li style=\"margin-left: 25px\">"+this.contentids.content+"</li>";
                lis += "<li style=\"margin-left: 30px\">"+(this.checkpeoples!=null?this.checkpeoples.username:'无')+"</li>";
                lis += "<li style=\"margin-left: 35px\">"+this.checktime+"</li>";
                lis += "<li style=\"margin-left: 20px\"><br/>&nbsp;&nbsp;10:30</li>";
                lis += "<li style=\"margin-left: 25px;color: #FDBE22;\">"+(this.statu==0?'未审核':'已审核')+"</li>";
                lis += "<li style=\"margin-left: 25px;color: #FDBE22;\">"+(this.result==0?'未审核':(this.result==1?'举报无效':'举报有效'))+"</li>";
                if (this.statu==0){
                    lis += "<li style=\"margin-left: 80px;color: #3ce650\"><span onclick='gotoCheckReport(2,"+this.id+");'>批准</span>&nbsp;&nbsp;&nbsp;<span style=\"color: #FDBE22;\" onclick='gotoCheckReport(1,"+this.id+");'>驳回</span>";
                }else {
                    lis += "<li style=\"margin-left: 80px;color: #3ce650\"><span onclick='delCheck("+this.id+");'>删除</span>";
                }
                lis += "</ul>";
                lis += "<hr style=\"margin-top: 50px;width: 98%;margin-left: 10px;background-color: #F1F1F1;height: 1px;border:none\"/>";
            })

            lis += "<span style=\"color: skyblue; font-size: 12px; float: right;margin-top: 22px;margin-right: 30px;\">";
            lis += "<span onclick=\"toPage(1)\">首页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick=\"toPage("+rel.pages+")\">尾页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick=\"toPage("+((rel.pageNum-1)<1?rel.pages:(rel.pageNum-1))+")\">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick=\"toPage("+((rel.pageNum+1)>rel.pages?1:(rel.pageNum+1))+")\">下一页</span>";
            lis += "</span>";
            $(".cxk").html(lis);
        }
    })
}

function toPage(page) {
    var dd = $("input[name='pageNow']").val(page);
    //console.log(dd.val());
    var title = $("title").text();
    console.log(title);
    if (title=="举报审核"){
        getCheckReport();
    }else {
        getCheckPublishEssay();
    }
}

//审核
//发表
function gotoCheck(result,id) {
    // console.log(e.innerText);
    $.ajax("gotoCheck",{
        data:{"id":id,"result":result},
        type: "post",
        success:function (rel) {
                if (rel){
                    window.confirm("成功");
                }else {
                    window.confirm("失败");
                }
            getCheckPublishEssay();
        }
    })
}

//审核
//举报
function gotoCheckReport(result,id) {
    // console.log(e.innerText);
    $.ajax("gotoCheckReport",{
        data:{"id":id,"result":result},
        type: "post",
        success:function (rel) {
            if (rel){
                window.confirm("成功");
            }else {
                window.confirm("失败");
            }
            getCheckPublishEssay();
        }
    })
}

function delCheck(id) {
    $.ajax("delCheck",{
        data:{"id":id},
        type: "post",
        success:function (rel) {
            if (rel){
                window.confirm("成功");
            }else {
                window.confirm("失败");
            }
            getCheckPublishEssay();
        }
    })
}