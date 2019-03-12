<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<div style="float: right;">
		<form action="${pageInfo.url}" method="post" id="pageInfoForm">
			<input type="hidden" name="currentPage" id="tt">
			总记录数:${pageInfo.recordSize}&nbsp;
			总页数:${pageInfo.pageCount}&nbsp;
			当前页数:${pageInfo.currentPage}&nbsp;
			每页记录数:${pageInfo.pageSize}&nbsp;
			<a href="javascript:return void(0)" value="1" class="page">首页</a>
			<c:if test="${pageInfo.currentPage-1>0}">
				<a href="javascript:return void(0)" value="${pageInfo.currentPage-1}" class="page">上一页</a>
			</c:if>
			<c:if test="${pageInfo.currentPage+1<=pageInfo.pageCount}">
				<a href="javascript:return void(0)" value="${pageInfo.currentPage+1}" class="page">下一页</a>
			</c:if>
			<a href="javascript:return void(0)" value="${pageInfo.pageCount}" class="page">尾页</a>
		</form>
		<script type="text/javascript">
		$(function(){
			$(".page").click(function(){
				$("#tt").val($(this).attr("value"));
				$("#pageInfoForm").submit();
			});
		});
		
		</script>
		</div>
		