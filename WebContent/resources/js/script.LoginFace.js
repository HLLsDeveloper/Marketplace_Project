
function checkLoginState()
{
    FB.getLoginStatus(function(response) {
        if (response.status === 'connected') {
            // usuario logado no facebook e com o app aceito
 
        } else if (response.status === 'not_authorized') {
            // Usuario logado no facebook, mas nao aceitou o App
        } else {
            // Usuario nao logado no facebook
        	// 
        }
    });
}


//https://marlosirapuan.com/como-testar-facebook-login-no-localhost/



  window.fbAsyncInit = function() {
    FB.init({
      appId      : '968512356646824',
      xfbml      : true,
      version    : 'v3.2'
    });
    FB.AppEvents.logPageView();
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
  

