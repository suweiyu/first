<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div>
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
          
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
            
                <td width="50%">共 <span class="right-text09">${pageInfo.pageCount}</span> 页 | 第 <span class="right-text09">${pageInfo.currentPage}</span> 页 
                 <input type="hidden" name="currentPage" id="tt" form="pageInfoForm"/></td>
                 
                <td width="49%" align="right">[<a href="javascript:return void(0)" value="1" class="page">首页</a> |
                 <c:if test="${pageInfo.currentPage-1>0}">
					<a href="javascript:return void(0)" value="${pageInfo.currentPage-1}" class="page">上一页|</a>
				</c:if>  
                 <c:if test="${pageInfo.currentPage+1<=pageInfo.pageCount}">
                 	
					<a href="javascript:return void(0)" value="${pageInfo.currentPage+1}" class="page">下一页</a>| 
				</c:if> 
                <a href="javascript:return void(0)" value="${pageInfo.pageCount}" class="page">尾页</a>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" id="va"/></td>
                      <td width="87%"><input name="Submit23222" type="button" class="right-button06" value=" " id="but_selete"/>
                      </td>
                    </tr>
                </table>
                
                </td>
              </tr>
          </table></td>
        </tr>
      </table>
		<form action="${pageInfo.url}" method="post" id="pageInfoForm"></form>
	<script type="text/javascript">
		$(function(){
			$(".page").click(function(){
				$("#tt").val($(this).attr("value"));
				$("#pageInfoForm").submit();
			});
			
			$("#but_selete").click(function(){
				var v=$("#va").val();
				if(v!=""&&v!=null){
					v=Number(v);
					if(v<1){
						$("#tt").val(1);
					}else if (v>${pageInfo.pageCount}) {
						$("#tt").val(${pageInfo.pageCount});
					}else {
						$("#tt").val(v);
					}
					$("#pageInfoForm").submit();
				}
				
			});
			
		});
		
		</script>
		</div>
		
