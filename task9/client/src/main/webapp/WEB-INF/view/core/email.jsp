<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2019/5/19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    function validate() {
        var pwd1 = document.getElementById("pwd1").value;
        var pwd2 = document.getElementById("pwd2").value;
        <!-- 对比两次输入的密码 -->
        if(pwd1 == pwd2) {
            document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
            document.getElementById("submit").disabled = false;
        }
        else {
            document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
            document.getElementById("submit").disabled = true;
        }
    }
    // 获取验证码
    function getCode() {
        var email = document.getElementById('email').value;
        $.ajax({
            type: "get",
            /*返回类型*/
            contentType: "application/json;charset=utf-8",
            url:"/email/emailCode",
            data: {"email": email},
            success: function (result) {
                alert(result.message);
            },
            error: function (result) {
                alert(result.message);
            }
        });
    }
</script>



<div  style="display: flex; justify-content:space-around;align-content: center;width: 100%">
    <div style=" margin-top: 300px;">
        <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png"/>
    </div>
          <form method="post" action="/email" target="postFrame">
        <table>
            <h2> <a href="/phone">点击进入手机注册页面</a></h2>

                ${error}
                ${message}

            <tr>
                <td>用户名:</td>
                <td><input class="easyui-validatebox" required="true" missingMessage="姓名必须填写" size="20"  type="text" name="name"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input class="easyui-validatebox" required="true" missingMessage="密码必须填写" size="20" type="password" name="pwd" id="pwd1"></td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td><input class="easyui-validatebox" required="true" missingMessage="密码必须填写" size="20" type="password" name="pwd3" id="pwd2" onkeyup="validate()"/><span id="tishi"></span></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input class="easyui-validatebox" required="true" missingMessage="邮箱必须填写" size="20"  type="text" name="email" id="email" value=""></td>
            </tr>
            <tr>
                <td>验证码:</td>
                <td><input class="easyui-validatebox" required="true" missingMessage="验证码必须填写" size="20"  type="text" name="emailCode"></td>
                <td><input type="button" value="发送验证码" onclick="getCode()" ></td>
            </tr>
            <tr >

                <td><input type="submit" value="提交"></td>
                <td><input type="reset" value="重新输入"> </td>
            </tr>
        </table>

          </form>
    </div>
</div>

