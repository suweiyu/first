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
<script type="text/JavaScript">

</script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "empId"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "empId"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="addEmp.jsp";
   document.getElementById("fom").submit();
}

</SCRIPT>

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
		
		 $("#job").load("getAllJob",{job:'${job}'});
		 $("#empType").load("getAllEmpType",{empType:'${empType}'});
		
	});
</script>
</head>
<body>
<form name="fom" id="fom" method="post" action="empDelete"></form>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
			  <td width="519">
			 姓名<input  type="text" size="12" name="empName" form="pageInfoForm" value="${empName}"/>&nbsp;
			 职位<select name="job" form="pageInfoForm" id="job">
			 
			 </select>&nbsp;
			 员工类型<select name="empType" form="pageInfoForm" id="empType">
			 
			 </select>&nbsp;
			   <input name="Submit" type="submit" class="right-button02" value="查 询" form="pageInfoForm"/>
			   
			   </td>
			   <td width="679" align="left"><a href="#" onclick="sousuo()">
			     <input name="Submit" type="button" class="right-button07" value="高级搜索" />
			   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选人员信息" id="but_delete"/> <input name="Submit" type="button" class="right-button08" value="添加人员信息" onclick="link();" />
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="15" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 工资详细列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
					 <td width="9%" height="20" align="center" bgcolor="#EEEEEE">唯一编号</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">真实姓名</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">职位</td>
					<td width="9%" align="center" bgcolor="#EEEEEE">员工类型</td>
					<td width="10%" align="center" bgcolor="#EEEEEE">省份证号码</td>
					<td width="4%" align="center" bgcolor="#EEEEEE">性别</td>
					<td width="4%" align="center" bgcolor="#EEEEEE">年龄</td>
					<td width="11%" align="center" bgcolor="#EEEEEE">出生年月</td>
					<td width="10%" align="center" bgcolor="#EEEEEE">联系电话</td>
                    <td width="19%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                 <!--  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
					<td height="20" bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">1235</a></td>
                    <td bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">张三</a></td>
                    <td bgcolor="#FFFFFF">程序员</td>
                    <td bgcolor="#FFFFFF">实习</td>
                    <td bgcolor="#FFFFFF">11111111111111</td>
					<td height="20" bgcolor="#FFFFFF">男</td>
					<td height="20" bgcolor="#FFFFFF">22</td>
					<td height="20" bgcolor="#FFFFFF">1985-04-06</td>
					<td height="20" bgcolor="#FFFFFF">123456789</td>
                    <td bgcolor="#FFFFFF"><a href="yuangong.htm">编辑</a>&nbsp;|&nbsp;<a href="yuangongsalary.html">发工资</a></a>&nbsp;|&nbsp;<a href="yuangongxiangmu.html">项目</a></td>
                  </tr> -->
                 <c:forEach items="${list}" var="e">
                 <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="empId" value="${e.empId}" form="fom"/></td>
					<td height="20" bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">${e.empNo}</a></td>
                    <td bgcolor="#FFFFFF"><a href="listyuangongmingxi.html">${e.empName}</a></td>
                    <td bgcolor="#FFFFFF">${e.job}</td>
                    <td bgcolor="#FFFFFF">${e.empType}</td>
                    <td bgcolor="#FFFFFF">${e.idCard}</td>
					<td height="20" bgcolor="#FFFFFF">${e.sex}</td>
					<td height="20" bgcolor="#FFFFFF">22</td>
					<td height="20" bgcolor="#FFFFFF">${e.birth}</td>
					<td height="20" bgcolor="#FFFFFF">${e.tel}</td>
                    <td bgcolor="#FFFFFF"><a href="updateEmp?empId=${e.empId}">编辑</a>&nbsp;|&nbsp;<a href="yuangongsalary.html">发工资</a></a>&nbsp;|&nbsp;<a href="yuangongxiangmu.html">项目</a></td>
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

</body>
</html>
