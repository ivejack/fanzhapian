//前台查询
function getblack() {
    var data = $("#blackForm").serialize();
    $.ajax("getTBlack",{
        data:data,
        type:"post",
        success:function (rel) {
            // alert(rel.msg);
            $("#blackmessage").show();
            $("#blackmessage").text(rel.msg);
        }
    })
}
//后台
//查询，分页，模糊
function getPageTBlack() {
    $("#addForm").hide();
    var data = $("#testForm").serialize();
    $.ajax("getPageTBlack",{
        data:data,
        type:"post",
        success:function (rel) {
            console.log(rel);
            var trs ="";
            var pages="";
            $(rel.records).each(function (i) {
                trs+=" <tr>";
                trs+="<td>"+(i+1)+"</td>";
                trs+="<td>"+this.message+"</td>";
                trs+="<td>"+this.typecontent+"</td>";
                trs+="<td><span onclick=\"openForm(this,"+this.id+")\" >修改</span>  <span onclick='delBlack("+this.id+")'>删除</span></td>";
                trs+="</tr>";
            })
            $("tbody").html(trs);
            pages +="<span onclick='toPage(1)'>首页</span>";
            pages +="<span onclick='toPage("+rel.pages+")'>尾页</span>";
            pages +="<span onclick='toPage("+((rel.current-1)<1?rel.pages:(rel.current-1))+")'>上一页</span>";
            pages +="<span onclick='toPage("+((rel.current+1)>rel.pages?1:(rel.current+1))+")'>下一页</span>";
            $("#page").html(pages);
        }
    })
}

function toPage(page){
    $("input[name='pageNum']").val(page);
    getPageTBlack();
}


function openForm(e,id) {
    // console.log(id);
    $("#titleForm").text(e.innerText+"黑库");
    if (id!=-1){
        //修改
        $.ajax("getOneTBlack",{
            data: {"id":id},
            type: "post",
            success:function (rel) {
                // console.log(rel);
                $("input[name='id']").val(rel.id);
                $("input[name='message']").val(rel.message);
                $("input[name='typecontent']").val(rel.typecontent);
            }
        })
    }else {
        //新增
        $("input[name='id']").val(id);
    }
    $("#addForm").show();
}

//新增，修改
function saveorupdate() {
    var data = $("#addForm").serialize();
    $.ajax("updBlack",{
        data:data,
        type:"post",
        success:function (rel) {
            if (rel==true){
                if ($("#titleForm").text()=="新增题目"){
                    confirm("新增成功");
                }else {
                    confirm("修改成功");
                }
            }else {
                if ($("#titleForm").text()=="新增题目"){
                    confirm("新增失败");
                }else {
                    confirm("修改失败");
                }
            }
            window.location.href='blackstorage.jsp';
        }
    })
}

//删除
function delBlack(id) {
    $.ajax("delBlack",{
        data: {"id":id},
        type: "post",
        success:function (rel) {
            if (rel){
                confirm("删除成功");
            }else {
                confirm("删除失败");
            }
            window.location.href='blackstorage.jsp';
        }
    })
}