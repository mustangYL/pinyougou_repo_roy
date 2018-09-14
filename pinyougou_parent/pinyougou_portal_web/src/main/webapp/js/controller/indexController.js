 //控制层 
app.controller('indexController' ,function($scope,contentService,promotionService,$interval){	
	
	
	//0：未开始  1：已开始  2:已结束
	$scope.status=["未开始","已开始","已结束"];
	
	$scope.findBannerList=function(){
		contentService.findByCategoryId(1).success(function(response){
			$scope.bannerList=response;
		})
		
	}
	
	$scope.search=function(){
//		跳转项目
		location.href="http://search.pinyougou.com/search.html#?keyword="+$scope.keyword;
	
	}
	
	$scope.findPromotionListByStatus=function(){
		promotionService.findPromotionListByStatus().success(function(response){
			$scope.promotionList = response;
			
		})
		
		
	}
	
	
    
});	
