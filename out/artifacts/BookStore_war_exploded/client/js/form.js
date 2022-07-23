/*$().ready(function () {
    $("#submit").click = checkForm;
});*/
window.onload = function()//防止使用标签在定义之前
{
    document.getElementById("change").onclick = function()//绑定事件
    {
        var b = $("#change").val();

         if(b === "浅色模式") {
            document.getElementById("change").value = "深色模式";
            document.body.style.backgroundColor = "#fcfdef";
            document.body.style.color = "black";
        }
        else if(b === "深色模式") {
            document.getElementById("change").value = "浅色模式";
            document.body.style.backgroundColor = "black";
            document.body.style.color = "#e4ffea";
        }

    };

    // document.getElementById("submit").onclick = checkForm;
    document.getElementById("form").onsubmit = checkForm;

    document.getElementById("txtMail").onkeyup = checkEmail;
    document.getElementById("txtUser").onkeyup = checkUserName;

    document.getElementById("txtPwd").onkeyup = checkPwd;
    document.getElementById("txtRpt").onkeyup = checkPwdAgain;

    document.getElementById("phoneNum").onkeyup = checkPhone;

    document.getElementById("txtIntro").onkeyup = checkIntro;

    document.getElementById("selUser").onchange = checkType;

    document.getElementById("nation").onchange = checkNation;
};

//检验Email
function checkEmail(){
    var email = document.getElementById("txtMail").value;
    // var pattern = /^[a-zA-Z0-9#_\^\$\.\*\+\-\?\=\!\:\|\\\/\(\)\[\]\{\}]+@\[a-zA-Z0-9]+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    var pattern = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if (email.length === 0) {
        document.getElementById("tips_email").innerHTML = "<em>电子邮箱不能为空</em>";
        return false;

    }
    else if (!pattern.test(email)) {
        document.getElementById("tips_email").innerHTML = "<em>Email不合法</em>";
        return false;
    }
    else {
        document.getElementById("tips_email").innerHTML = "OK!";
        return true;
    }
}

//检验用户名
function checkUserName() {
    var reg = /[A-Za-z_][A-Za-z1-9_]*/;
    var username = $("#txtUser");

    // alert(reg.test($("#txtUser").val()));
    if(username.val().length < 1 || username.val().length > 10)
    {
        document.getElementById("tips_username").innerHTML
            = "<em>长度为1到10</em>";
        return false;
    }
    else{
        document.getElementById("tips_username").innerText = "OK!";
        return true;
    }
}

// 密码 正则表达式
function checkPwd(){
    var reg = /[^A-Za-z0-9]+/;
    var regs = /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/;

    if(document.getElementById("txtPwd").value.length < 6
        || document.getElementById("txtPwd").value.length > 18
        ||regs.test(document.getElementById("txtPwd").value) )
    {
        document.getElementById("tips_password").innerHTML =
            "<em>密码由6-18位字符组成,且必须包含字母、数字和标点符号</em>";

        return false;
    }
    else{
        document.getElementById("tips_password").innerHTML = "OK!";
        return true;
    }
}

//确认密码
function checkPwdAgain() {
    if(document.getElementById("txtRpt").value != document.getElementById("txtPwd").value
        || document.getElementById("txtRpt").value == "") {
        document.getElementById("tips_checkpassword").innerHTML = "<em>两次输入的密码不一致</em>";

        return false;
    }
    else{
        document.getElementById("tips_checkpassword").innerHTML = "OK!";
        return true;
    }
}

//检验用户类别
function checkType() {
    if(document.getElementById("selUser").selectedIndex == 0){
        document.getElementById("tips_usertype").innerHTML = "<em>没有选择用户类型</em>";
        return false;
    }
    else{
        document.getElementById("tips_usertype").innerHTML = "OK!";
        return true;
    }
}

// 校检用户性别
function checkSex(){
    var sexNum = document.getElementsByName("sex");
    var sex = "";

    for (var i = 0; i < sexNum.length; i++) {
        if(sexNum[i].checked)
            sex = sexNum[i].value;
    }

    // alert("sex = " + sex);
    if(sex == ""){
        document.getElementById("tips_sex").innerHTML = "<em>至少选择其中一项</em>";

        return false;
    }
    else{
        document.getElementById("tips_sex").innerHTML = "OK!";
        return true;
    }
}

// 检验国籍
function checkNation() {
    if(document.getElementById("nation").selectedIndex === 0){
        document.getElementById("tips_nation").innerHTML = "<em>没有选择国籍</em>";

        return false;
    }
    else{
        document.getElementById("tips_nation").innerHTML = "OK!";
        return true;
    }
}

//检验手机号码
function checkPhone() {
    var phoneReg = /^[1][3,4,5,7,8][0-9]{9}$/;
    // var phone = $("#phoneNum");
    var phone = document.getElementById("phoneNum");

    // alert(phoneReg.test(phone.val()));
    if((phoneReg.test(phone.value))&& (phone.value.length === 11)){
        $("#tips_phone").html("<span>OK</span>");
        return true;
    }
    else{
        $("#tips_phone").html("<em>您的手机号码不正确，请重新填写</em>");

        return false;
    }
}

//判断自我介绍
function checkIntro() {
    if(document.getElementById("txtIntro").value.length > 100){
        document.getElementById("tips_introduction").innerHTML = "<em>长度不能超过100个字符</em>";

        return false;
    }
    else if(document.getElementById("txtIntro").value.length <= 0){
        document.getElementById("tips_introduction").innerHTML = "<em>自我介绍不能为空</em>";

        return false;

    }
    else{
        document.getElementById("tips_introduction").innerHTML = "OK!";
        return true;
    }
}

//检验表单
function checkForm(){
    var flag = 0;

    //检验Email
    if (!checkEmail()) {
        flag = 1;
        document.getElementById("txtMail").focus();
    }

    //用户名
    if(!checkUserName()) {
        if(flag !== 1)
            document.getElementById("txtUser").focus();
        flag = 1;
    }

    //密码 正则表达式
    if(!checkPwd()) {
        if(flag !== 1)
            document.getElementById("txtPwd").focus();
        flag = 1;
    }

    //确认密码
    if(!checkPwdAgain()) {
        if(flag !== 1)
            document.getElementById("txtRpt").focus();
        flag = 1;
    }

    //检验性别
    if(!checkSex()) {
        flag = 1;
    }

    //检验手机号码
    if(!checkPhone()) {
        if(flag !== 1)
            document.getElementById("phoneNum").focus();
        flag = 1;
    }

    //判断自我介绍
    if(!checkIntro()) {
        if(flag !== 1)
            document.getElementById("txtIntro").focus();
        flag = 1;
    }


    // 检验国籍
   /* if(!checkNation()) {
        flag = 1;
    }*/

    //校检用户性别
   /* if(!checkSex()){
        flag = 1;
    }*/


    //检验用户类别
   /* if(!checkType()) {
        flag = 1;
    }*/

    if(flag === 1) {
        // alert("false");
        return false;
    }

    // alert("true");
}
