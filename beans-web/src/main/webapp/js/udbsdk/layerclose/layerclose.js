var UDBSDK = {
};
UDBSDK.LayerClose = {
	"open" : function(url) {
		UDBSDK.LayerClose.show_div();
		var reqURL = url;
		reqURL = reqURL+"&UIStyle=layer_close&rdm="+Math.random();
		UDBSDK.LayerClose.loadLogin(reqURL);
	},
	"show_div" : function() {
		$.uiwidget.popupShow({id:"sdk_login"});
	},
	"hide_div" : function() {
		$.uiwidget.popupHide({id:"sdk_login"});
	},
	"loadLogin" : function(url) {
		$("#udbsdkfrm").attr("src",url);
	},
	"ajaxOpen" : function(ajaxURL,callbackURL,denyCallbackURL) {
		$.post(
				ajaxURL,
				{
					"callbackURL":callbackURL,
					"denyCallbackURL":denyCallbackURL
				},
				function(data) {
					var json =  eval('('+data+')');
					if("1" == json.success) {
						UDBSDK.LayerClose.open(json.url);
					} else {
						alert(json.errMsg);
					}
				}
			);
	},
	"ajaxOpenWithSaveToken" : function(ajaxURL,callbackURL,denyCallbackURL) {
		$.post(
				ajaxURL,
				{
					"callbackURL":callbackURL,
					"denyCallbackURL":denyCallbackURL
				},
				function(data) {
					var json =  eval('('+data+')');
					if("1" == json.success) {
						UDBSDK.LayerClose.writeCookie("udboauthtmptokensec", json.ttokensec,document.domain, "/");
						UDBSDK.LayerClose.open(json.url);
					} else {
						alert(json.errMsg);
					}
				}
			);
	},
	"writeCrossmainCookie" : function(writeCookieURL) {
		UDBSDK.LayerClose.writeCrossmainCookieWithCallBack(writeCookieURL, null);
	},
	"writeCrossmainCookieWithCallBack" : function(writeCookieURL,callBack) {
		if(writeCookieURL == null || writeCookieURL == "") return;
		var url = writeCookieURL+"&rdm="+Math.random();
		var $wFrm = $("#writecookieFrm");
		$wFrm.attr("src",url);
		if(callBack) {
			$wFrm.load(callBack);
		}
	},
	"deleteCrossmainCookie" : function(deleteCookieURL) {
		UDBSDK.LayerClose.deleteCrossmainCookieWithCallBack(deleteCookieURL, null);
	},
	"deleteCrossmainCookieWithCallBack" : function(deleteCookieURL,callBack) {
		if(deleteCookieURL == null || deleteCookieURL == "") return;
		var url = deleteCookieURL+"&rdm="+Math.random();
		var $delFrm = $("#deletecookieFrm");
		$delFrm.attr("src",url);
		UDBSDK.LayerClose.deleteCookie("oauthCookiePrivate",document.domain,"/");
		UDBSDK.LayerClose.deleteCookie("udboauthtmptokensec",document.domain,"/");
		if(callBack) {
			$delFrm.load(callBack);
		}
	},
	"deleteCookie" : function(name,domain,path) {
		if(!UDBSDK.LayerClose.hasCookie(name)) return;
		var expdate = new Date(); 
		expdate.setTime(expdate.getTime() - (86400 * 1000));
		document.cookie = name + "=_"
								+ ";expires="+ expdate.toGMTString()
								+ ";domain=" + domain
								+ ";path=" + path;
	},
	"writeCookie" : function(name,value,domain,path) {
		var expdate = new Date(); 
		expdate.setTime(expdate.getTime() + (15*60*1000));
		document.cookie = name + "=" + value
								+ ";expires="+ expdate.toGMTString()
								+ ";domain=" + domain
								+ ";path=" + path;
	},
	"hasCookie" : function(name) {
		if(document.cookie.length > 0) {
			start = document.cookie.indexOf(name + "=");
			if( start != -1) return true;
		}
		return false;
	},
	"end" : ""	
};