//服务层
app.service('promotionService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findPromotionListByStatus=function(){
		return $http.get('../promotion/findPromotionListByStatus');		
	}
	
	this.updatePromotionStatus=function(promotion){
		return $http.post('../promotion/updatePromotionStatus',promotion);
	}
	
	this.deletePromotionById=function(id){
		return $http.post('../promotion/deletePromotionById/'+id);
	}
	
});
