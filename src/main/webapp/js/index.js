/** index.js By Beginner Emain:zheng_jinfan@126.com HomePage:http://www.zhengjinfan.cn */

var tab;

layui.config({
	base: 'js/',
	version:new Date().getTime()
}).use(['element', 'layer', 'navbar', 'tab'], function() {
	var element = layui.element,
		$ = layui.jquery,
		layer = layui.layer,
		navbar = layui.navbar();
		tab = layui.tab({
			elem: '.admin-nav-card' //设置选项卡容器
				,
			//maxSetting: {
			//	max: 5,
			//	tipMsg: '只能开5个哇，不能再开了。真的。'
			//},
			contextMenu:true
		});
	//iframe自适应
	$(window).on('resize', function() {
		var $content = $('.admin-nav-card .layui-tab-content');
		$content.height($(this).height() - 147);
		$content.find('iframe').each(function() {
			$(this).height($content.height());
		});
	}).resize();
    navbar.set({
        spreadOne: true,
        elem: '#navBarId',
        //cached: true,
        //data: navs
        //url : basePath+'/api/permissions'
        /*cached:true,
        url: 'datas/nav.json'*/
    });
    $.ajax({
        url:basePath+"api/permissions",
        type:"get",
        dataType:"json",
        data:{},
        success:function(data){
            /*  console.log("data: "+data);*/
            var liStr= "";
            // 遍历生成主菜单
            for( var i = 0; i <data.length; i++){
                //console.log("--> "+JSON.stringify(data[i]));
                // 判断是否存在子菜单
                if(data[i].children!=null&&data[i].children.length>0){
                    /* console.log("--> "+JSON.stringify(data[i].children));*/
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
            /*console.log(">>>> "+liStr);*/
            $("#navBarId").html("<ul class=\"layui-nav layui-nav-tree\"  lay-filter=\"test\">\n" +liStr+"</ul>");
            element.init();
        }
    });
  /*  navbar.on('click(side)', function(data) {
        tab.tabAdd(data.field);
    });*/

	//设置navbar

	//渲染navbar
	navbar.render();
	//监听点击事件
    navbar.on('click(side)', function(data) {
    	alert(111)
		tab.tabAdd(data.field);
	});

	$('.admin-side-toggle').on('click', function() {
		var sideWidth = $('#admin-side').width();
		if(sideWidth === 200) {
			$('#admin-body').animate({
				left: '0'
			}); //admin-footer
			$('#admin-footer').animate({
				left: '0'
			});
			$('#admin-side').animate({
				width: '0'
			});
		} else {
			$('#admin-body').animate({
				left: '200px'
			});
			$('#admin-footer').animate({
				left: '200px'
			});
			$('#admin-side').animate({
				width: '200px'
			});
		}
	});
	$('.admin-side-full').on('click', function() {
		var docElm = document.documentElement;
		//W3C  
		if(docElm.requestFullscreen) {
			docElm.requestFullscreen();
		}
		//FireFox  
		else if(docElm.mozRequestFullScreen) {
			docElm.mozRequestFullScreen();
		}
		//Chrome等  
		else if(docElm.webkitRequestFullScreen) {
			docElm.webkitRequestFullScreen();
		}
		//IE11
		else if(elem.msRequestFullscreen) {
			elem.msRequestFullscreen();
		}
		layer.msg('按Esc即可退出全屏');
	});
	
	

	//锁屏
	$(document).on('keydown', function() {
		var e = window.event;
		if(e.keyCode === 76 && e.altKey) {
			//alert("你按下了alt+l");
			lock($, layer);
		}
	});
	$('#lock').on('click', function() {
		lock($, layer);
	});

	//手机设备的简单适配
	var treeMobile = $('.site-tree-mobile'),
		shadeMobile = $('.site-mobile-shade');
	treeMobile.on('click', function() {
		$('body').addClass('site-mobile');
	});
	shadeMobile.on('click', function() {
		$('body').removeClass('site-mobile');
	});
});
// 递归生成子菜单
function getChildMenu(subMenu,num) {
    /* console.log("num: "+num);*/
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
}
var isShowLock = false;
function lock($, layer) {
	if(isShowLock)
		return;
	//自定页
	layer.open({
		title: false,
		type: 1,
		closeBtn: 0,
		anim: 6,
		//content: $('#lock-temp').html(),
		 content: ['lock.jsp', 'no'],
		shade: [0.9, '#393D49'],
		success: function(layero, lockIndex) {
			isShowLock = true;
			//给显示用户名赋值
			layero.find('div#lockUserName').text($("#main_user").html());
			layero.find('input[name=lockPwd]').on('focus', function() {
					var $this = $(this);
					if($this.val() === '输入密码解锁..') {
						$this.val('').attr('type', 'password');
					}
				})
				.on('blur', function() {
					var $this = $(this);
					if($this.val() === '' || $this.length === 0) {
						$this.attr('type', 'text').val('输入密码解锁..');
					}
				});
			//在此处可以写一个请求到服务端删除相关身份认证，因为考虑到如果浏览器被强制刷新的时候，身份验证还存在的情况			
			//do something...
			//e.g. 
			/*
			 $.post(url,params,callback,'json');
			 */
			//绑定解锁按钮的点击事件
			layero.find('button#unlock').on('click', function() {
				var $lockBox = $('div#lock-box');

				var userName = $lockBox.find('div#lockUserName').text();
				var pwd = $lockBox.find('input[name=lockPwd]').val();
				if(pwd === '输入密码解锁..' || pwd.length === 0) {
					layer.msg('请输入密码..', {
						icon: 2,
						time: 1000
					});
					return;
				}
				unlock(userName, pwd);
			});
			/**
			 * 解锁操作方法
			 * @param {String} 用户名
			 * @param {String} 密码
			 */
			var unlock = function(un, pwd) {
				//这里可以使用ajax方法解锁
				/*$.post('api/xx',{username:un,password:pwd},function(data){
				 	//验证成功
					if(data.success){
						//关闭锁屏层
						layer.close(lockIndex);
					}else{
						layer.msg('密码输入错误..',{icon:2,time:1000});
					}					
				},'json');
				*/
				isShowLock = false;
				//演示：默认输入密码都算成功
				//关闭锁屏层
				layer.close(lockIndex);
			};
		}
	});
};