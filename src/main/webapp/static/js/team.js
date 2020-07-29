//成员查询
function getMyTeamPeople() {
    $.ajax("getMyPeople",{
        type:"post",
        success:function (rel) {
            console.log(rel);
            // console.log(rel[0].team);
            var trs="";
            $(rel).each(function (i) {
                    trs+="<tr>";
                    trs+="<td>"+(i+1)+"</td>\n";
                    trs+="<td>"+this.user.username+"</td>\n";
                    trs+="<td>"+this.user.birthday+"</td>\n";
                    trs+="<td>"+this.user.sex+"</td>\n";
                    trs+="<td>"+this.user.phone+"</td>\n";
                    trs+="</tr>\n";
            })
            $("#table1").html(trs);
            if(rel!=null){
                $("#teamname").text("您暂时没有加入任何团队");
            }
        }
    })
}
//我的项目查询
function getMyProject() {
    $.ajax("getMyProject",{
        type:"post",
        success:function (rel) {
            // console.log("myproject");
            // console.log(rel);
            var trs="";
            $(rel).each(function (i) {
                if (this.project!=null){
                    trs+="<tr>";
                    trs+="<td>"+(i+1)+"</td>\n";
                    trs+="<td>"+this.project.name+"</td>\n";
                    trs+="<td><span onclick='delproject("+this.project.id+")'>删除</span></td>\n";
                    trs+="</tr>\n";
                }else {

                }
            })
            $("#table2").html(trs);
        }
    })
}
//项目列表
function getProjectList() {
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
                trs+="<td><span onclick='addproject("+this.id+")'>添加</span></td>\n";
                trs+="</tr>\n";
            })
            $("#table3").html(trs);
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

//新增我的项目
function addproject(id) {
    // console.log(id);
    $.ajax("addproject",{
        data:{"id":id},
        type:"post",
        success:function (rel) {
            if (rel){
                confirm("新增成功");
            }else {
                confirm("新增失败");
            }
            window.location.href='team.jsp';
        }
    })
}
//删除我的项目
function delproject(id) {
    // console.log(id);
    $.ajax("delproject",{
        data:{"id":id},
        type:"post",
        success:function (rel) {
            if (rel){
                confirm("删除成功");
            }else {
                confirm("删除失败");
            }
            window.location.href='team.jsp';
        }
    })
}

function getTeamList() {
    var data = $("#testForm").serialize();
    $.ajax("getTeamList",{
        data:data,
        type:"post",
        success:function (rel) {
            console.log(rel);
            var trs="";
            var pages="";
            $(rel.list).each(function (i) {
                trs+="<tr>";
                trs+="<td>"+(i+1)+"</td>\n";
                trs+="<td>"+this.name+"</td>\n";
                trs+="<td>"+this.username.username+"</td>\n";
                trs+="<td><span onclick='delTeam("+this.id+")'>删除</span></td>";
                trs+="</tr>\n";
            })
            $("tbody").html(trs);
            pages +="<span onclick='toPage(1)'>首页</span>";
            pages +="<span onclick='toPage("+rel.pages+")'>尾页</span>";
            pages +="<span onclick='toPage("+((rel.pageNum-1)<1?rel.pages:(rel.pageNum-1))+")'>上一页</span>";
            pages +="<span onclick='toPage("+((rel.pageNum+1)>rel.pages?1:(rel.pageNum+1))+")'>下一页</span>";
            $("#page").html(pages);
        }
    })
}

function toPage(page){
    $("input[name='pageNum']").val(page);
    getTeamList();
}
//删除
function delTeam(id) {
    $.ajax("delTeam",{
        data: {"id":id},
        type: "post",
        success:function (rel) {
            if (rel){
                confirm("删除成功");
            }else {
                confirm("删除失败");
            }
            window.location.href='teammanager.jsp';
        }
    })
}