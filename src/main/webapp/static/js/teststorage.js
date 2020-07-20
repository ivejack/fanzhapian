function getAllTestStorage() {
   $("#addForm").hide();
   var data = $("#testForm").serialize();
   $.ajax("getTestStorageAll",{
       data:data,
       type:"post",
       success:function (rel) {
             console.log(rel);
            var trs ="";
           var pages="";
            $(rel.records).each(function (i) {
                trs+=" <tr>";
                trs+="<td>"+(i+1)+"</td>";
                trs+="<td>"+this.question+"</td>";
                trs+="<td>"+this.answer+"</td>";
                trs+="<td>"+this.analysis+"</td>";
                trs+="<td><span onclick=\"openForm(this,'"+this.id+"')\">修改</span>  <span onclick='delTestStorage("+this.id+")'>删除</span></td>";
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
    getAllTestStorage();
}

function openForm(e,id) {
    // console.log(id);
    $("#titleForm").text(e.innerText+"题目");
    if (id!=-1){
        //修改
        $.ajax("getOneTestStorage",{
            data: {"id":id},
            type: "post",
            success:function (rel) {
                // console.log(rel);
                $("input[name='id']").val(rel.id);
                $("input[name='question']").val(rel.question);
                $("select[name='answer']:optional").val(rel.answer).checkbox;

                $("input[name='analysis']").val(rel.analysis);
            }
        })
    }else {
        //新增
        $("input[name='id']").val(id);
    }
    $("#addForm").show();
}

function saveorupdate() {
    var data = $("#addForm").serialize();
    $.ajax("saveTestStorage",{
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
            window.location.href='teststorage.jsp';
        }
    })
}

function delTestStorage(id) {
    $.ajax("delTestStorage",{
        data:{"id":id},
        type:"post",
        success:function (rel) {
            if(rel){
                confirm("删除成功");
            }else {
                confirm("删除失败");
            }
            window.location.href='teststorage.jsp';
        }
    })
}