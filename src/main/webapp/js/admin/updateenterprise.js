$(document).ready(function() {
	$("#orgId").attr("disabled", true);
	$("#orgName").attr("disabled", true);
	$("#type").attr("disabled", true);
	$("#introduction").attr("disabled", true);
	$("#registeredCapital").attr("disabled", true);
	$("#registerTime").attr("disabled", true);
	$("#status").attr("disabled", true);
	$("#corporation").attr("disabled", true);
	$("#telephone").attr("disabled", true);
	$("#zipCode").attr("disabled", true);
	$("#email").attr("disabled",true);
	$("#address").attr("disabled", true);
	$("#bussinessLicenseNo").attr("disabled", true);
	$("#remark").attr("disabled", true);
	
	$("#updateEnter").click(function() {
		$(".save").css("display", "block");
		$(this).css("display","none");
		$("#orgId").attr("disabled", false);
		$("#orgName").attr("disabled", false);
		$("#type").attr("disabled", false);
		$("#introduction").attr("disabled", false);
		$("#registeredCapital").attr("disabled", false);
		$("#registerTime").attr("disabled", false);
		$("#status").attr("disabled", false);
		$("#corporation").attr("disabled", false);
		$("#telephone").attr("disabled", false);
		$("#zipCode").attr("disabled", false);
		$("#email").attr("disabled",false);
		$("#address").attr("disabled", false);
		$("#bussinessLicenseNo").attr("disabled", false);
		$("#remark").attr("disabled", false);
	});
	
	/** 清空错误提示* */
	$("#orgName").bind("focus", function() {
		$("#orgNameError").empty();
	});
	$("#introduction").bind("focus", function() {
		$("#introductionError").empty();
	});
	$("#registeredCapital").bind("focus", function() {
		$("#registeredCapitalError").empty();
	});
	$("#corporation").bind("focus", function() {
		$("#corporationError").empty();
	});
	$("#telephone").bind("focus", function() {
		$("#telephoneError").empty();
	});
	$("#zipCode").bind("focus", function() {
		$("zipCodeError").empty();
	});
	$("#remark").bind("focus", function() {
		$("remarkError").empty();
	});
	/** 提交表单信息* */
	$("#Fromenter").submit(function() {
		return Entersubmit();
		
	});
});

function changeFrom(){
	$(".save").css("display", "none");
	$("#updateEnter").css("display","block");
	$("#orgId").attr("disabled", true);
	$("#orgName").attr("disabled", true);
	$("#type").attr("disabled", true);
	$("#introduction").attr("disabled", true);
	$("#registeredCapital").attr("disabled", true);
	$("#registerTime").attr("disabled", true);
	$("#status").attr("disabled", true);
	$("#corporation").attr("disabled", true);
	$("#telephone").attr("disabled", true);
	$("#zipCode").attr("disabled", true);
	$("#email").attr("disabled",true);
	$("#address").attr("disabled", true);
	$("#bussinessLicenseNo").attr("disabled", true);
	$("#remark").attr("disabled", true);
}
function Entersubmit() {
	var ret = chkorgName();
	if (ret == 0) {
		$("#orgNameError").text("请填写机构名称");
		return false;
	}
	if (ret == -1) {
		$("#orgNameError").text("机构名称长度在0-50个字符");
		return false;
	}
	var ret = chkintroduction();
	if (ret == 0) {
		$("#introductionError").text("请填写机构介绍");
		return false;
	} else if (ret == -1) {
		$("#introductionError").text("机构介绍长度为5-50个字符");
		return false;
	}
	var ret = chkregisteredCapital();
	if (ret == 0) {
		$("#registeredCapitalError").text("请填写注册资金");
		return false;
	} else if (ret == -1) {
		$("#registeredCapitalError").text("注册资金只能为数字");
		return false;
	}else if(ret==-2){
		$("#registeredCapitalError").text("注册资金在十亿范围内");
		return false;
	}
	var ret = chkcorporation();
	if (ret == 0) {
		$("#corporationError").text("请填写法人代表");
		return false;
	} else if (ret == -1) {
		$("#corporationError").text("法人代表只能为中文");
		return false;
	} else if (ret == -2) {
		$("#corporationError").text("法人代表长度为20个字符");
		return false;
	}
	var ret = chktelephone();
	if (ret == 0) {
		$("#telephoneError").text("联系电话格式不正确");
		return false;
	} else if (ret == -1) {
		$("#telephoneError").text("联系电话长度不正确");
		return false;
	}
	var ret = chkzipCode();
	if (ret == 0) {
		$("#zipCodeError").text("邮政编码错误");
		return false;
	} else if (ret == -1) {
		$("#zipCodeError").text("邮政编码长度只能为6位");
		return false;
	}
	var ret = chkremark();
	if (ret == 0) {
		$("#remarkError").text("备注长度为100个字符");
		return false;
	}

	return true;
}
function chkorgName() {
	var orgName = $.trim($("#orgName").val());
	if (orgName == "") {
		return 0;
	} else if (orgName.length > 50) {
		return -1;
	}
	return 1;
}
function chkintroduction() {
	var introduction = $.trim($("#introduction").val());
	if (introduction == "") {
		return 0;
	} else if (introduction.length < 5 || introduction.length > 50) {
		return -1;
	}
	return 1;
}function chkregisteredCapital(){
	var registeredCapital=$.trim($("#registeredCapital").val());
	if(registeredCapital==""){
		return 0;
	}else if(!/^[0-9]*$/.test(registeredCapital)){
		return -1;
	}else if(registeredCapital>1000000000){
		return -2;
	}
	return 1;
}
function chkcorporation(){
	var corporation=$.trim($("#corporation").val());
	if(corporation==""){
		return 0;
	}else if(!/[^\u4E00-\u9FA5]/.test(corporation)){
		return -1;
	}else if(corporation.length>20){
		return -2;
	}
}
function chktelephone(){
	var telephone=$.trim($("#telephone").val());
	if(telephone!=""){
		if(!/^(13[0-9]{9})|(15[89][0-9]{8})$/.test(telephone)){
		return  0;
	}else if(telephone.length<11||telephone.length>12){
		return -1;
	  }
	}	
	return 1;
}
function chkzipCode(){
	var zipCode=$.trim($("#zipCode").val());
	if(zipCode!=""){
		if(!/^[0-9]\d{5}$/.test(zipCode)){
			return 0;
		}else if(zipCode.length!=6){
			return -1;
		}
	}
	return 1;
}
function chkremark(){
	var remark=$.trim($("#remark").val());
	if(remark!=""){
		if(remark.legnth>100){
			return 0;
		}
	}
	return 1;
}