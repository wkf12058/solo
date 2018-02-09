require.config(
        {
//      	baseUrl: "js/lib",
            paths: {
                'jquery': './lib/jquery-2.1.1.min',
                'bootstrap':'../bootstrap-3.3.7-dist/js/bootstrap',
                'tool':'./tool/tool'
            }
            
        }
    );
    require(['jquery','tool'],function($){
    	$(function(){
    		 alert("加载完毕");  
    	});
    });
