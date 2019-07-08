<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加客户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="<%=basePath%>resource/css/admin.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="<%=basePath%>resource/js/CheckForm.js"></script>
	<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
	<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/FormValid.js"></script>


  </head>
  
  <body>
<form action="<%=basePath%>servlet/CustomerAddServlet"  name="form1" onsubmit="return validator(this)" method="post" >
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
	<tr class=editHeaderTr>
		<td class=editHeaderTd colSpan=7>  请输入客户信息</td>
	</tr>  
    <tr>
	    <td bgcolor="#FFFDF0"><div align="center">客户姓名：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"   maxlength="20" style=" width: 145px" name="customerJob"></td>
	  	<td bgcolor="#FFFDF0"><div align="center">客户年龄：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"   maxlength="10"  style=" width: 145px" valid="required"  errmsg="客户姓名不能为空!" name="customerName"></td>
	 	
    </tr>
	
    <tr>
		
		<td width="13%" bgcolor="#FFFDF0"><div align="center">客户来源：</div></td>
		<td width="33%" colspan="3" bgcolor="#FFFFFF"><select name="customerSource" style=" width: 145px">
			<%-- <%List <CustomerSourceInfo> sourceList =(List <CustomerSourceInfo>) request.getAttribute("sourceInfo"); %> --%>
			<%-- <%for ( int i=0;i<sourceList.size();i++){
											CustomerSourceInfo sourceInfo =sourceList.get(i);
										%>		 --%>
			<option  value="<%-- <%=sourceInfo.getSourceId() %> --%>"><%-- <%=sourceInfo.getSourceName() %> --%></option>
			<%-- <% }%> --%>
		</select>	  </td>
		<td bgcolor="#FFFDF0"><div align="center">客户状态：</div></td>
		<td colspan="3" bgcolor="#FFFFFF">
		<select name="customerType" style=" width: 145px">
			<option value='1'>潜在客户</option>
			<option value='1'>已成交客户</option>
			<option value='1'>老客户</option>
		<%-- 	<%List <CustomerTypeInfo> typeList =(List <CustomerTypeInfo>) request.getAttribute("typeInfo"); %>
			<%for ( int i=0;i<typeList.size();i++){
											CustomerTypeInfo typeInfo =typeList.get(i);
										%>		 --%>
			<option  value="<%-- <%=typeInfo.getCustomerTypeId() %> --%>"><%-- <%=typeInfo.getCustomerTypeName() %> --%></option>
			<%-- <% }%> --%>
		</select>		</td>
    </tr>
	<tr>
		<td bgcolor="#FFFDF0"><div align="center">客户性别：</div></td>
		<td colspan="3" bgcolor="#FFFFFF">
			<input type="radio" name="customerSex" value="男"  checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="customerSex" value="女"  />女<br/>		</td>
		<td bgcolor="#FFFDF0"><div align="center">邮箱（Email）：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input style=" width: 145px"  maxlength="50"  type="text" name="customerEmail"   valid="required|isEmail"  errmsg="Email不能为空|Email格式不对!"></td>
    </tr>
	
	
    <tr>
		<td bgcolor="#FFFDF0"><div align="center" >客户手机：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"   valid="regexp"  regexp="^1[3|4|5|8][0-9]\d{8}$"   errmsg="请输入正确的手机号码!"  style=" width: 145px"    name="customerMobile"></td>
		<td bgcolor="#FFFDF0"><div align="center">客户QQ：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"      valid="isQQ"   errmsg="请输入正确的QQ号码!"  style=" width: 145px" name="customerQq"></td>
    </tr>
    
    <tr>
		<td bgcolor="#FFFDF0"><div align="center">客户所属省：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><select name="customerCondition" style=" width: 145px"></select></td>
		<td bgcolor="#FFFDF0"><div align="center">客户所属市：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><select name="customerCondition1" style=" width: 145px">
			<%-- <%List <CustomerConditionInfo> conditionList =(List <CustomerConditionInfo>) request.getAttribute("conditionInfo"); %>
			<%for ( int i=0;i<conditionList.size();i++){
											CustomerConditionInfo conditionInfo =conditionList.get(i);
										%>		 --%>
			<option  value="<%-- <%=conditionInfo.getConditionId() %> --%>"><%-- <%=conditionInfo.getConditionName() %> --%></option>
			<%-- <% }%> --%>
		</select>		</td>
    </tr>
  
	<tr>
		<td bgcolor="#FFFDF0"><div align="center">家庭地址：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"  maxlength="50"  style=" width: 145px" name="customerAddress"></td>
		<td bgcolor="#FFFDF0"><div align="center">公司名称：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"  maxlength="10"  style=" width: 145px" name="customerChangeMan"></td>
    </tr>

    <tr>
		<td bgcolor="#FFFDF0"><div align="center">所属员工：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"  maxlength="10"  style=" width: 145px" valid="required"  errmsg="创建人不能为空!"  name="customerAddMan"></td>
		<td bgcolor="#FFFDF0"><div align="center">管辖区域：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"  maxlength="50"  style=" width: 145px"  name="customerBlog"></td>
    </tr>

	<%-- <tr>
		<td bgcolor="#FFFDF0"><div align="center">客户座机：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"   valid="isPhone"   errmsg="请输入正确的座机号码!"   style=" width: 145px" name="customerTel"></td>
		<td bgcolor="#FFFDF0"><div align="center">客户MSN：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"    maxlength="50" style=" width: 145px" name="customerMsn"></td>
    </tr>
  
	<tr>
		<td bgcolor="#FFFDF0"><div align="center">客户公司：</div></td>
		<td colspan="5" bgcolor="#FFFFFF"><input type="text"  maxlength="50"  style=" width: 145px" name="customerCompany">
		<input type="hidden"    value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>"  name="customerAddTime" >
		<input type="hidden"    value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>"  name="customerChangeTime" >		</td>
		
    </tr>
    
	<tr>
		<td bgcolor="#FFFDF0"><div align="center">备注：</div></td>
		<td colspan="5" bgcolor="#FFFFFF"><textarea rows="10" name="customerRemark" style="width:100%; resize:none; "  ></textarea></td>
	</tr> --%>
 </table>

<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
	<tr bgcolor="#ECF3FD">
					<td width="25%"></td>
					<td width="17%"><input type="submit" name="submit"  value="添加"></td>
					<td width="17%"><input type="reset" name="reset"  value="重置"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
	</tr>
</table>
</form>
  </body>
</html>

