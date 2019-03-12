<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<script src="../js/jquery-1.9.1.min.js"></script>
<script >

	$(function(){
		$.getJSON("emp",{},function(data){
			var table=$("<table width='100%'>");
			$("#allName_div").append(table);
			var tr=null;
			$.each(data,function(i,d){
			
				 if(i%2==0){
					tr=$("<tr>");
					table.append(tr);
				}
				var td=$("<td>");
				tr.append(td);
		
				var check=$("<input name='empId' type='checkbox'>").val(d.empId);
				check.click(function(){
					var names=[];
					$("input:checked").each(function(){
						var v=$(this).next().html();
						
						names.push(v);
						
					});
					$("#empName").val(names.join(","));
				});
				
			
				var span=$("<span>").html(d.empName);
			
				td.append(check);
				td.append(span); 
			
			});
			
			var tr2=$("<tr>");
			table.append(tr2);
			var td2=$("<td colspan='2' align=right>");
			tr2.append(td2);
			var button=$("<input type='button' value='关闭' id='button'>");
			button.click(function(){
				$("#allName_div").fadeOut();
			});
			td2.append(button);
		
			
		});
		$("#empName").focus(function(){
			$("#allName_div").fadeIn();
		});
		
	});
</script>

<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">

  <form action="sendMessage" method="post"  name="form" >
  <div id="allName_div" style="width: 400px;height: 300px;background-color: #eeeede;position: absolute;top: 170px;left: 100px;display: none;"></div>
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >新建信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="发送" class="button"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>新建信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					    
					    
					  <tr>
					    <td nowrap align="right" width="11%">消息标题:</td>
					    <td width="27%"><input name='messageTitle' type="text" class="text" style="width:154px" value="" /></td>
				        	
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					    </tr>
					    
					    
					    
					  <tr>
					    <td width="11%" align="right" nowrap>接收者:</td>
					    <td colspan="3"><input name="empName" id="empName" type="text" class="text" style="width:450px;" size="20" value="" />
					      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="priority">
							<option value="0" selected="selected">==选择==</option>
							<option value="0">低级</option>
							<option value="1">中级</option>
							<option value="2">高级</option>
						</select></td>
					    </tr>
					  
					  <tr>
					    <td  width="11%" nowrap align="right">信息内容:</td>
					    <td colspan="3"><textarea name="messageContent" cols="100" rows="20"></textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		

		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="发送" class="button"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>
