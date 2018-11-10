<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var $this = $(this);
			var lastName = $(this).next("input[name='lastName']").val();
			var flag = confirm("确定要删除"+lastName+"的所有信息？");
			if(flag){
				var url = this.href;
				var args = {date:new Date().getTime()};
				$.post(url,args,function(data){
					if("1" == data){
						alert("删除成功");
						$this.parent().parent().remove();
					}else if("0" == data){
						alert("删除失败");
					}else{
						alert("服务器错误");
					}
				});
			}
			//取消超链接的默认行为
			return false;
		});
	})
</script>
</head>
<body>
	
	<h4>Employee List Page</h4>
	<h4><a href="emp-input">Emoloyee Add</a></center></h4>

	<s:if test="#request.emps == null || #request.emps.size() == 0">
		没有任何员工信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>empNo</td>
				<td>lastName</td>
				<td>email</td>
				<td>birth</td>
				<td>hiredate</td>
				<td>dept</td>
				<td>delete</td>
				<td>edit</td>
			</tr>
			<s:iterator value="#request.emps">
				<tr>
					<td>${empNo }</td>
					<td>${lastName }</td>
					<td>${email }</td>
					<td>
						<s:date name="birth" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="hiredate" format="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td>${dept.deptName }</td>
					<td><a href="emp-delete?empNo=${empNo}" class="delete">delete</a>
						<s:hidden name="lastName"></s:hidden>
					</td>
					<td><a href="emp-input?empNo=${empNo}">edit</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
		
</body>
</html>