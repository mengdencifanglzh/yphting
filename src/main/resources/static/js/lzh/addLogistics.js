/**
 * 
 */

	initState();
	function initState(){
		$.ajax("/lzh/api/getShareaState",{
			type:"GET",
			dataType:"json",
			success:function(data){
				$.each(data,function(i,obj){
					$("[name=state]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	
	initState2();
	function initState2(){
		$.ajax("/lzh/api/getShareaState",{
			type:"GET",
			dataType:"json",
			success:function(data){
				$.each(data,function(i,obj){
					$("[name=state2]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	
	setTimeout(function(){initChina()},2000)
	function initChina(){
		var state=$("[name=state]").val();
			getChina(state);
	}
	setTimeout(function(){initChina2()},2000)
	function initChina2(){
		var state=$("[name=state2]").val();
			getChina2(state);
	}
	function getChina(state){
		$.ajax("/lzh/api/getChinaCity/"+state,{
			type:"GET",
			dataType:"json",
			success:function(data){
				$("[name=city]").html("");$("[name=city]").append("<option value=''>请选择</option>");
				$.each(data,function(i,obj){
					$("[name=city]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	
	function getChina2(state){
		$.ajax("/lzh/api/getChinaCity/"+state,{
			type:"GET",
			dataType:"json",
			success:function(data){
				$("[name=city2]").html("");$("[name=city2]").append("<option value=''>请选择</option>");
				$.each(data,function(i,obj){
					$("[name=city2]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	
	function setarea(state){
		if (state=="中国") {
			initChina(state);
		}else{
			getKorea(state);
		}
	}
	function setarea2(state){
		if (state=="中国") {
			initChina2(state);
		}else{
			getKorea2(state);
		}
	}
	function bindsCity(sheng){
		var state=$("[name=state]").val();
		if (state=="中国") {
			getChinaCity(sheng);
		}else{
			getKoreaCity(sheng);
		}
	}
	function bindsCity2(sheng){
		var state=$("[name=state2]").val();
		if (state=="中国") {
			getChinaCity2(sheng);
		}else{
			getKoreaCity2(sheng);
		}
	}
	function getKoreaCity(city){
		$.ajax("/lzh/api/getKoreaArea/"+city,{
			type:"GET",
			dataType:"json",
			success:function(data){
				$("[name=area]").html("");$("[name=area]").append("<option value=''>请选择</option>");
				$.each(data,function(i,obj){
					$("[name=area]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	function getKoreaCity2(city){
		$.ajax("/lzh/api/getKoreaArea/"+city,{
			type:"GET",
			dataType:"json",
			success:function(data){
				$("[name=area2]").html("");$("[name=area2]").append("<option value=''>请选择</option>");
				$.each(data,function(i,obj){
					$("[name=area2]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	function getChinaCity(city){
		$.ajax("/lzh/api/getChinaArea/"+city,{
			type:"GET",
			dataType:"json",
			success:function(data){
				$("[name=area]").html("");$("[name=area]").append("<option value=''>请选择</option>");
				$.each(data,function(i,obj){
					$("[name=area]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	function getChinaCity2(city){
		$.ajax("/lzh/api/getChinaArea/"+city,{
			type:"GET",
			dataType:"json",
			success:function(data){
				$("[name=area2]").html("");$("[name=area2]").append("<option value=''>请选择</option>");
				$.each(data,function(i,obj){
					$("[name=area2]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	function getKorea(state){
		$.ajax("/lzh/api/getKoreaCity/"+state,{
			type:"GET",
			dataType:"json",
			success:function(data){
				$("[name=city]").html("");$("[name=city]").append("<option value=''>请选择</option>");
				$.each(data,function(i,obj){
					$("[name=city]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}
	function getKorea2(state){
		$.ajax("/lzh/api/getKoreaCity/"+state,{
			type:"GET",
			dataType:"json",
			success:function(data){
				$("[name=city2]").html("");$("[name=city2]").append("<option value=''>请选择</option>");
				$.each(data,function(i,obj){
					$("[name=city2]").append("<option value="+obj.name+">"+obj.mergername+"</option>");
				});
			}
		});
	}