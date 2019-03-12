<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/xiangmu.js"></script>
<script src="../js/jquery-1.9.1.min.js"></script>
<script >
	$(function(){
		$("#but_delete").click(function(){
			if($("input:checked").size()!=0){
				if(confirm("确认删除?")){
					$("#fom").submit();
				}
			}else {
				alert("请选择想要删除的信息");
			}
		});
		
		$(".a_delete").click(function(){
			if(confirm("确认删除?")){
				var v=$(this).attr("value");
				window.open("updateSendMessage?sendId="+v,"_self");
			}
			
		});
	});
</script>
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "sendId"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "sendId"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="sendxiaoxi.htm";
   document.getElementById("fom").submit();
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
</SCRIPT>

<body onload="on_load()">
<form name="fom" id="fom" method="post" action="updateSendMessage"></form>
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="../images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="../images/ico07.gif" width="20" height="18" /></td>
			<td width="550">查看内容：接收人：
			 <input name="empName" type="text" size="12" form="pageInfoForm" value="${empName}"/>
			 <input name="Submit" type="submit" class="right-button02" value="查 询" form="pageInfoForm"/>
			 </td>
			 <td width="132" align="left"><a href="#" onclick="sousuo()">
			   <input name="Submit" type="button" class="right-button07" value="高级搜索" /></a></td>	
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" value="删除所选信息" id="but_delete"/>
	              <input name="Submit2" type="button" class="right-button08" value="新建信息" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="14" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 发送信息列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="14%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="19%" height="20" align="center" bgcolor="#EEEEEE">标题</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">接收人</td>
                    <td width="21%" align="center" bgcolor="#EEEEEE">发送时间</td>
                    <td width="26%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                 <!--  <tr align="center">
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td height="20" bgcolor="#FFFFFF">xxxxx</td>
                    <td bgcolor="#FFFFFF">电信</td>
                    <td bgcolor="#FFFFFF">500万</td>
                    <td bgcolor="#FFFFFF"><a href="#">删除</a>|<a href="sendxiaoximingxi.htm">查看</a></td>
                  </tr> -->
                   <c:forEach items="${list}" var="s">
                   <tr align="center">
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="sendId" form="fom" value="${s.sendId}"/></td>
                    <td height="20" bgcolor="#FFFFFF">${s.messageTitle}</td>
                    <td bgcolor="#FFFFFF">
                    <c:forEach items="${s.receive}" var="r">
                    		${r.emp.empName }&nbsp;
                    	</c:forEach></td>
                    <td bgcolor="#FFFFFF">${s.createDate}</td>
                    <td bgcolor="#FFFFFF"><a href="javascript:return void(0);" class="a_delete" value="${s.sendId}">删除</a>&nbsp;|&nbsp;<a href="sendMessageDetail?sendId=${s.sendId}">查看</a></td>
                  </tr>
               </c:forEach>
                  
				
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      
      	<%@ include file="subPage.jsp" %>
      
      </td>
  </tr>
</table>


<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="file:///F|/项目管理相关资料/项目管理系统页面/images/loadon.gif" />
</div>

</body>
</html>
