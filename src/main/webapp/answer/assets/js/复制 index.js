var userId="";
var openId="";

//题目数据
var data={};
//选择的答案
var choiceList=new Array();
//正确答案
var rightList=new Array();
//idList
var idList=new Array();
//平移位置
var frame_left = 0;
//使用
var action="answer";//show 展示题目   answer 答题   test 测试



//测试题目数据
var testData=[ {"id" : "1",  "title": "1. 众所周知我们所处的宇宙的质能公式是E=mc2，其中c是真空中的光速，和我们的宇宙平行的另一个宇宙meta.",  
			"xuanxiang":["String","int","char","void",],
             "answer":"A",},
             {"id" : "2","title": "编译和运行下面代码时显示的结果是（）",
             "xuanxiang":["打开当前目录下的文件2.txt，既可以向文件写数据","ClassCastException","FileNotFoundException","IndexOutOfBoundsException",],
             "answer":"A",},
             {"id" : "3","title": "编译和运行下面代码时显示的结果是（）",
             "xuanxiang":["打开当前目录下的文件2.txt，既可以向文件写数据，也可以从文件读数据","ClassCastException","FileNotFoundException","IndexOutOfBoundsException",],
             "answer":"A",},
             {"id" : "4","title": "编译和运行下面代码时显示的结果是（）",
             "xuanxiang":["既可以向文件写数据，也可以从文件读数据","ClassCastException","FileNotFoundException","IndexOutOfBoundsException",],
             "answer":"A",},
             {"id" : "5","title": "编译和运行下面代码时显示的结果是（）",
            "xuanxiang":["既可以向文件写数据，也可以从文件读数据","ClassCastException","FileNotFoundException","IndexOutOfBoundsException",],
             "answer":"A",}
        ];

(function(win){
	//开始图片显示
	$("#imgDiv").fadeOut(5000);
	//设置全局变量
	if(getQueryVariable("userId")){
		userId=getQueryVariable("userId");
	}
	var mydate = new Date();
	var sign= mydate.getFullYear()+""+(mydate.getMonth()+1)+""+mydate.getDate();
	
	if(getQueryVariable("sign")){
		sign=getQueryVariable("sign");
		action="show";
	}
	action="test";
	if(action=="show"){//展示题目
		
	}else if(action=="answer"){//答题
		getProblem();
	}else if(action=="test"){//测试
		TiMu(testData)//测试用例
	}
	
	
}(window));

//本地变量控制
// localStorage.setItem("key",vale);
// localStorage.getItem("key");
// localStorage.clear();
// localStorage.removeItem("arr");

function TiMu(data){
	//渲染所有题目界面
	for(var i in data){
		//渲染主要的界面
		var div = document.createElement("div");
		div.className = "entrance-bottom-frame-line";
		document.querySelector(".entrance-bottom-frame").appendChild(div);
		//渲染题目
		var div2 = document.createElement("div");
		div2.className = "entrance-bottom-frame-line-title";
		div2.innerHTML = data[i].title;
		document.querySelectorAll(".entrance-bottom-frame-line")[i].appendChild(div2);
		
		var divli1 = document.createElement("div");
		divli1.innerHTML = parseInt(i) + 1;
		var timu = data.length;
		//渲染选项
		for(var j in data[i].xuanxiang){
			var div3 = document.createElement("div");
			div3.className = "entrance-bottom-frame-line-button";
			
			var div3_id = document.createElement("div");
			div3_id.className = "entrance-bottom-frame-line-button-id";
			if(j == 0){
				 div3_id.innerHTML = "A";
				 div3.name='A';
			}else if(j == 1){
				 div3_id.innerHTML = "B";
				 div3.name='B';
			}else if(j == 2){
				 div3_id.innerHTML = "C";
				  div3.name='C';
			}else{
				 div3_id.innerHTML = "D";
				  div3.name='D';
			}
			var div4 = document.createElement("div");
			div4.className = "entrance-bottom-frame-line-button-frame";
			div4.innerHTML = data[i].xuanxiang[j];
			div3.appendChild(div3_id)
			div3.appendChild(div4);
			document.querySelectorAll(".entrance-bottom-frame-line")[i].appendChild(div3);
			
		}
		
	}
	var lastDiv = document.createElement("div");
	lastDiv.className = "entrance-bottom-frame-line";
	lastDiv.setAttribute("id","balance");
	document.querySelector(".entrance-bottom-frame").appendChild(lastDiv);
	
	mintime = 1; 
	var dact = document.querySelector(".entrance-bottom-frame-line")
	var active = "active"
	var none = "none"
	addClass(dact, active)
	var timu_id = 0
	var select1 = 1
	
	document.querySelector(".entrance-bottom-frame").style.marginLeft = frame_left + "%"
	document.querySelector(".topic-frameli").innerHTML = "第 " + "<div>" + select1 + "</div>" + "/" + timu + " 题"
	//设置按键事件
	for(var i = 0;i<document.querySelectorAll(".entrance-bottom-frame-line-button").length;i++){
		document.querySelectorAll(".entrance-bottom-frame-line-button")[i].onclick = function(){
			choiceList.push(this.name);
			if(timu_id < document.querySelectorAll(".entrance-bottom-frame-line").length - 2){
				//修改当前题目
				select1++;
				document.querySelector(".topic-frameli").innerHTML = "第 " + "<div>" + select1 + "</div>" + "/" + timu + " 题"
			}else{
				let score =compute();
				document.querySelector(".topic-frameli").innerHTML = "<div id='solo-title'>答题结束</div>";//<div>结算</div>
				var htmlStr=""//<img src='../assets/img/sueccss.png' class='solo-img' />
				htmlStr+="<div class='solo-font'>得分："+score+"</div>"
				htmlStr+="<div class='solo-button' onclick='goTo()' >确定</div>"
				document.getElementById("balance").innerHTML = htmlStr;
				submit(score); 
			}
			//切换效果
			frame_left += -100
			timu_id++;
			document.querySelector(".entrance-bottom-frame").style.marginLeft = frame_left + "%"
			addClass(document.querySelectorAll(".entrance-bottom-frame-line")[timu_id], active)
			removeClass(document.querySelectorAll(".entrance-bottom-frame-line")[timu_id-1], active)
			
		}
	}
}

function goTo(){
	window.location.href="./record.html?userId="+userId;
}

function addClass(obj, cls){
  var obj_class = obj.className,//获取 class 内容.
  blank = (obj_class != '') ? ' ' : '';//判断获取到的 class 是否为空, 如果不为空在前面加个'空格'.
  added = obj_class + blank + cls;//组合原来的 class 和需要添加的 class.
  obj.className = added;//替换原来的 class.
}

function removeClass(obj, cls){
  var obj_class = ' '+obj.className+' ';//获取 class 内容, 并在首尾各加一个空格. ex) 'abc    bcd' -> ' abc    bcd '
  obj_class = obj_class.replace(/(\s+)/gi, ' '),//将多余的空字符替换成一个空格. ex) ' abc    bcd ' -> ' abc bcd '
  removed = obj_class.replace(' '+cls+' ', ' ');//在原来的 class 替换掉首尾加了空格的 class. ex) ' abc bcd ' -> 'bcd '
  removed = removed.replace(/(^\s+)|(\s+$)/g, '');//去掉首尾空格. ex) 'bcd ' -> 'bcd'
  obj.className = removed;//替换原来的 class.
}

function hasClass(obj, cls){
  var obj_class = obj.className,//获取 class 内容.
  obj_class_lst = obj_class.split(/\s+/);//通过split空字符将cls转换成数组.
  x = 0;
  for(x in obj_class_lst) {
    if(obj_class_lst[x] == cls) {//循环数组, 判断是否包含cls
      return true;
    }
  }
  return false;
}


//上一题
function last(){
	frame_left += 100
	document.querySelector(".entrance-bottom-frame").style.marginLeft = frame_left + "%"
}

//下一题
function next(){
	frame_left += -100
	document.querySelector(".entrance-bottom-frame").style.marginLeft = frame_left + "%"

}

//计算分数
function compute(){
	let count=0;
	for (let i=0;i<data.length;i++) {
		rightList.push(data[i].answer);
		idList.push(data[i].id);
		if(data[i].answer==choiceList[i]){
			count++;
		}
	}
	return count;
}

    
//获取题目信息
function getProblem(){
	let url=serverUrl+"/solo/problem/getList";
	let param={
		userId:userId,
		sign:sign,
		};
	$.ajax({type: "POST",url: url,data: param,
		success: function(res){
			console.log(res);
			if(res.data!=""){
				data=res.data;
				TiMu(data);
			}else{
				alert("没有题目");
			}

		},
		error:function(e){
			console.log(e.responseText);
		}
	});
}
        
//提交成绩
function submit(score){
	let url=serverUrl+"/solo/problem/submitAssets";
	let answerList=choiceList.join(',');
	let problemIdList=idList.join(',');
	let param={
		userId:userId,
		answer:answerList,
		problemId:problemIdList,
		score:score,
		sign:sign,
		};
		console.log(param);
	$.ajax({
		type: "POST",url: url,data: param,
		success: function(data){
			console.log(data);
		},
		error:function(e){
			console.log(e.responseText);
		}
	});
}

