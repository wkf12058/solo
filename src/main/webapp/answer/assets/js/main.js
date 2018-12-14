

var serverUrl="http://127.0.0.1:8080";




var mydate = new Date();
var sign= mydate.getFullYear()+""+(mydate.getMonth()+1)+""+mydate.getDate();

//获取参数
function getQueryVariable(variable){
   var query = window.location.search.substring(1);
   var vars = query.split("&");
   for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
   }
   return(false);
}