$(function () {
    /**
     * 用户名输入框失去焦点事件，ajax判断是否该名称已经被注册
     */
    $("#user").blur(function () {
        var userName = $("#user").val().trim();
        var sendData = JSON.stringify({'userName': userName});
        console.log(sendData);
        if (userName.length != 0) {
            /**
             * 返回data类型
             * {successed ： true | false} 注册是否成功
             * {errStatus : 1  } 用户名已经被注册

             */
            $.ajax({
                type: "get",
                url: "/user/checkusername",
                data: {
                    "userName":userName
                },
                success: function (data) {
                    console.log(data);
                    var code=data.code;
                    if (code==0) {
                        $('#user').css({
                            border: "1px solid #D7D7D7",
                            boxShadow: "none"
                        });
                        $("#userCue").html("欢迎注册EastChat！");
                    }else if(code == 11){
                        $('#user').focus().css({
                            border: "1px solid red",
                            boxShadow: "0 0 2px red"
                        });
                        $('#userCue').html("<font color='red'><b>该用户名已经被注册！</b></font>");
                    }
                }
            })
        }
        $('#user').css({
            border: "1px solid #D7D7D7",
            boxShadow: "none"
        });
        $("#userCue").html("欢迎注册Free！");
    });

    /**
     * 注册按钮点击事件
     */
    $("#reg").click(function () {
        var userName = $("#user").val().trim();
        var pwd1 = $("#passwd").val().trim();
        var pwd2 = $("#passwd2").val().trim();
        if (userName.length == 0 || pwd1.length == 0 || pwd2.length == 0){
            sweetAlert("出错了", "您还有些内容未填写~", "error");
            return;
        }else if (pwd1 != pwd2){
            sweetAlert("出错了", "两次密码输入不一致，请重新填写~", "error");
        }else {
            var sendData = JSON.stringify({"userName" : userName, "password": pwd1});
            $.ajax({
                type: "POST",
                url: "/user/register",
                data: {
                    "userName":userName,
                    "password":pwd1
                },
                success : function (data) {
                    if (data.code==0){
                        sweetAlert("注册成功啦！", "快去登录~加入聊天吧~", "success");
                    }else {
                        sweetAlert("出错了", "注册失败，请再次尝试~", "error");
                    }
                }
            });
        }

    });
    $('#switch_qlogin').click(function () {
        $('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_bottom').animate({left: '0px', width: '70px'});
        $('#qlogin').css('display', 'none');
        $('#web_qr_login').css('display', 'block');

    });
    $('#switch_login').click(function () {

        $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_bottom').animate({left: '154px', width: '70px'});

        $('#qlogin').css('display', 'block');
        $('#web_qr_login').css('display', 'none');
    });
    if (getParam("a") == '0') {
        $('#switch_login').trigger('click');
    }

});

function logintab() {
    scrollTo(0);
    $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
    $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
    $('#switch_bottom').animate({left: '154px', width: '96px'});
    $('#qlogin').css('display', 'none');
    $('#web_qr_login').css('display', 'block');

}


//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) {
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&');
    if (ArrParam.length == 1) {
        //只有一个参数的情况 
        return params.split('=')[1];
    }
    else {
        //多个参数参数的情况
        for (var i = 0; i < ArrParam.length; i++) {
            if (ArrParam[i].split('=')[0] == pname) {
                return ArrParam[i].split('=')[1];
            }
        }
    }
}


