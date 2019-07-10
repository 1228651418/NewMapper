<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@page import="com.gt.pageModel.SessionInfo"%>
<%@page import="com.gt.utils.Contans"%>--%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userNm = "";

	/*if (session.getAttribute(Contans.SESSION_BEAN) != null) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(Contans.SESSION_BEAN);
		if (sessionInfo.getOperInf() != null) {
			if (sessionInfo.getOperInf().getOperCd() != null
					&& sessionInfo.getOperInf().getOperCd().length() > 0) {
				userNm = sessionInfo.getOperInf().getOperCd();
			}
		}
	}*/
%>

<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
<title>LaySSH开发框架</title>
<jsp:include page="inc.jsp"></jsp:include>
<link rel="stylesheet" href="css/global.css" media="all">
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
</head>

<body>
	<div class="layui-layout layui-layout-admin" style="border-bottom: solid 5px #1aa094;">
		<div class="layui-header header header-demo">
			<div class="layui-main">
				<div class="admin-login-box">
					<a class="logo" style="left: 0;" href="#"> <span
						style="font-size: 22px;">自驾游管理系统</span>
					</a>
					<div class="admin-side-toggle">
						<i class="fa fa-bars" aria-hidden="true"></i>
					</div>
					<div class="admin-side-full">
						<i class="fa fa-life-bouy" aria-hidden="true"></i>
					</div>
				</div>
				<ul class="layui-nav admin-header-item">

					<li class="layui-nav-item"><a href="javascript:;"
						class="admin-header-user"> <img src="images/0.jpg" /> <span id="main_user"><%="admin"/*userNm*/%></span>
					</a>
						<dl class="layui-nav-child">
							<dd id="changePwd">
								<a href="javascript:;"><i class="fa fa-gear"
									aria-hidden="true"></i> 修改密码</a>
							</dd>
							<dd id="sysout">
								<a href="#"><i class="fa fa-sign-out"
									aria-hidden="true"></i> 注销</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>
		<div class="layui-side layui-bg-black" id="admin-side"><%-- navBarId--%>
			<div class="layui-side-scroll" id="navBarId"<%--admin-navbar-side--%>
				lay-filter="side"></div>
			<%--	<div id="navBarId" class="layui-side layui-bg-black">
				</div>--%>
		</div>
		<div class="layui-body"
			style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
			<div class="layui-tab admin-nav-card layui-tab-brief"
				lay-filter="admin-tab">
				<ul class="layui-tab-title">
					<li class="layui-this"><i class="fa fa-dashboard"
						aria-hidden="true"></i> <cite>首页</cite></li>
				</ul>
				<div class="layui-tab-content"
					style="min-height: 150px; padding: 5px 0 0 0;">
					<div class="layui-tab-item layui-show">
						<iframe src="wecome.jsp"></iframe>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-footer footer footer-demo" id="admin-footer">
				<div class="layui-main">
					<p>
						www.layssh.com
					</p>
				</div>
			</div>
			<div class="site-tree-mobile layui-hide">
				<i class="layui-icon">&#xe602;</i>
			</div>
			<div class="site-mobile-shade"></div>
			</div>

	<script>
        // 导航菜单的间隔像素
        var menuCell = 5;

        layui.use('element', function(){
            var element = layui.element;
            var $ = layui.jquery;

           /* $.ajax({
                url:basePath+"api/permissions",
                type:"get",
                dataType:"json",
                data:{},
                success:function(data){
                  /!*  console.log("data: "+data);*!/
                    var liStr= "";
                    // 遍历生成主菜单
                    for( var i = 0; i <data.length; i++){
                        //console.log("--> "+JSON.stringify(data[i]));
                        // 判断是否存在子菜单
                        if(data[i].children!=null&&data[i].children.length>0){
                           /!* console.log("--> "+JSON.stringify(data[i].children));*!/
                            liStr+="<li class=\"layui-nav-item\"><a class=\"\" href=\"javascript:;\">"+data[i].title+"</a>\n"+
                                "<dl class=\"layui-nav-child\">\n";
                            // 遍历获取子菜单
                            for( var k = 0; k <data[i].children.length; k++){
                                liStr+=getChildMenu(data[i].children[k],0);
                            }
                            liStr+="</dl></li>";
                        }else{
                            liStr+="<li class=\"layui-nav-item\"><a class=\"\" href=\""+data[i].url+"\">"+data[i].title+"</a></li>";
                        }
                    };
                    /!*console.log(">>>> "+liStr);*!/
                    $("#navBarId").html("<ul class=\"layui-nav layui-nav-tree\"  lay-filter=\"test\">\n" +liStr+"</ul>");
                    element.init();
                }
            });*/
            /*element.on('click(side)', function(data) {
                tab.tabAdd(data.field);*/
        });

       /* // 递归生成子菜单
        function getChildMenu(subMenu,num) {
           /!* console.log("num: "+num);*!/
            num++;
            var subStr = "";
            if(subMenu.children!=null&&subMenu.children.length>0){
                subStr+="<dd><ul><li class=\"layui-nav-item\" ><a style=\"margin-Left:"+num*menuCell+"px\" class=\"\" href=\"javascript:;\">"+subMenu.title+"</a>" +
                    "<dl class=\"layui-nav-child\">\n";
                for( var j = 0; j <subMenu.children.length; j++){
                    subStr+=getChildMenu(subMenu.children[j],num);
                }
                subStr+="</dl></li></ul></dd>";
            }else{
                subStr+="<dd><a style=\"margin-Left:"+num*menuCell+"px\" href=\""+subMenu.url+"\">"+subMenu.title+"</a></dd>";
            }
            return subStr;
        }*/
	</script>
		<script type="text/javascript">
		if("<%="admin"/*userNm*/%>" == "") {
			window.location.href = "operInf/login.do";
		}
		</script>
		<script src="js/index.js"></script>
		<script>
			var basePath = '<%=basePath%>'
			layui.use('layer', function() {
				var $ = layui.jquery, layer = layui.layer;
				var that = this; 
				
				//系统退出
				$('#sysout').on('click', function() {
					layer.confirm('是否退出系统？', {
					  btn: ['退出','取消'] //按钮
					}, function(){
						location.href = '${pageContext.request.contextPath}/operInf/logout.do';
					}, function(){
					  
					});
				});
				
				//密码修改
				$('#changePwd').on('click', function() {
				  layer.open({
				      type: 2,
				      title: '密码修改',
				      shadeClose: false,//点击遮罩关闭
				      anim: 3,
				      btnAlign: 'c',
				      shade: 0.3,//是否有遮罩，可以设置成false
				      maxmin: true, //开启最大化最小化按钮
				      area: ['550px', '350px'],
				      boolean:true,
					  content: ['sys/OperInf/OperInfChangePwd.jsp', 'yes'], //iframe的url，no代表不显示滚动条
					  success: function(layero, lockIndex) {
						var body = layer.getChildFrame('body', lockIndex);
						//绑定解锁按钮的点击事件
						body.find('button#close').on('click', function() {
							layer.close(lockIndex);
						});
					  }
				    });
				});
			});
		</script>
</body>

</html>