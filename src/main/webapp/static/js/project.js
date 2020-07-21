//项目列表
function getProjectList() {
    $("#addForm").hide();
    var data = $("#testForm").serialize();
    $.ajax("getProjectList",{
        data:data,
        type:"post",
        success:function (rel) {
            // console.log("project");
            // console.log(rel);
            var trs="";
            var pages="";
            $(rel.records).each(function (i) {
                trs+="<tr>";
                trs+="<td>"+(i+1)+"</td>\n";
                trs+="<td>"+this.name+"</td>\n";
                trs+="<td><span onclick=\"openForm(this,'"+this.id+"')\">修改</span>  <span onclick='delproject("+this.id+")'>删除</span></td>";
                trs+="</tr>\n";
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
    getProjectList();
}

function openForm(e,id) {
    // console.log(id);
    $("#titleForm").text(e.innerText+"项目");
    if (id!=-1){
        //修改
        $.ajax("getOneProject",{
            data: {"id":id},
            type: "post",
            success:function (rel) {
                // console.log(rel);
                $("input[name='id']").val(rel.id);
                $("input[name='name']").val(rel.name);
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
    $.ajax("saveorupdate",{
        data:data,
        type:"post",
        success:function (rel) {
            if (rel){
                if ($("#titleForm").text()=="新增项目"){
                    confirm("新增成功");
                }else {
                    confirm("修改成功");
                }
            }else {
                if ($("#titleForm").text()=="新增项目"){
                    confirm("新增失败");
                }else {
                    confirm("修改失败");
                }
            }
            window.location.href='projectmanager.jsp';
        }
    })
}

//删除
function delproject(id) {
    $.ajax("delproject",{
        data: {"id":id},
        type: "post",
        success:function (rel) {
            if (rel){
                confirm("删除成功");
            }else {
                confirm("删除失败");
            }
            window.location.href='projectmanager.jsp';
        }
    })
}