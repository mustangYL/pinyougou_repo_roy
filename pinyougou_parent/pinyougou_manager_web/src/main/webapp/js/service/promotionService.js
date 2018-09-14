app.service('promotionService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../promotion/findAll');		
	}
	
	this.search=function(pageNo,pageSize,searchEntity){
	 	return $http.post("../promotion/search/"+pageNo+"/"+pageSize,searchEntity);
	}
	
	 this.findPage=function(pageNo,pageSize){
		 return $http.get("../promotion/findPage/"+pageNo+"/"+pageSize);
	 }
	 
	//增加 
	this.add=function(entity){
		
		return  $http.post('../promotion/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../promotion/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../promotion/delete/'+ids);
	}
	
	this.findOne=function(id){
		return $http.get('../promotion/findOne/'+id);
	}

	
	
	
	
});
