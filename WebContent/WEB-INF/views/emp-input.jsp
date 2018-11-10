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
		$("input[name='lastName']").change(function(){
			var lastName = $(this).val();
			lastName = $.trim(lastName);
			var $this = $(this);
			var url = "emp-validateLastName";
			var args = {lastName:lastName,date:new Date().getTime()};
			if(lastName!=''){
				//把当前节点后面的所有 font 兄弟节点删除
				$this.next("font").remove();
				$.post(url,args,function(data){
					//表示可用
					if(data == "1"){
						$this.after("<font color='green'>LastName可用!</font>");
					}
					//不可用
					else if(data == "0"){
						$this.after("<font color='red'>LastName不可用!</font>");						
					}
					//服务器错误
					else{
						alert("服务器错误!");
					}
				});
			}else{
				alert("lastName 不能为空");
				$this.val("");
				$this.focus();
			}
		});
	})
</script>
</head>
<body>
	

	<s:debug></s:debug>

	<h4>Employee Input Page</h4>

	<s:form action="emp-save" method="post">
		<s:if test="empNo !=null">
			<s:textfield name="lastName" label="lastName" disabled="true"></s:textfield>
			<s:hidden name="empNo"></s:hidden>
		</s:if>
		<s:else><s:textfield name="lastName" label="lastName"></s:textfield></s:else>
		<s:textfield name="email" label="email"></s:textfield>
		<s:textfield name="birth" label="birth"></s:textfield>
		<s:select list="#request.depts" listKey="deptNo" listValue="deptName" name="dept.deptNo" label="deptName"></s:select>
		<s:submit></s:submit>
	</s:form>

</body>
</html>