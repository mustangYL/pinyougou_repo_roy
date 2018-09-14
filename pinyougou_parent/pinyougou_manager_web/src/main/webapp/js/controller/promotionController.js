app.controller('promotionController' ,function($scope,$controller,$location,promotionService,uploadService){	
	
//	controller的继承
	$controller('baseController',{$scope:$scope});//继承  本质就是共用一个$scope
	
	$scope.status=["未开始","进行中","过期"];
	
	$scope.entity={description:"",titleImg:""};
	
	
	//查询所有
	$scope.findAll=function(){
			promotionService.findAll().success(function(response){
				$scope.list = response;
			})
		}
	
	$scope.searchEntity={};// 为了在刷新页面或者第一次访问页面时不报错（因为searchEntity是 undefined）
	$scope.search=function(pageNo,pageSize){
//	 		当前页码
//	 		 每页显示的条数
//				searchEntity
			 	promotionService.search(pageNo,pageSize,$scope.searchEntity).success(function(response){
//	 			 response:{total:100,rows:[{},{},{}]}
				 $scope.paginationConf.totalItems =response.total; //给分页组件赋总条数
				 $scope.list =response.rows; //当前页的数据
			 })
		 }
	
	 $scope.findPage=function(pageNo,pageSize){
		 
		 promotionService.findPage(pageNo,pageSize).success(function(response){
// 			 response:{total:100,rows:[{},{},{}]}
			 $scope.paginationConf.totalItems =response.total; //给分页组件赋总条数
			 $scope.list =response.rows; //当前页的数据
			 
		 })
		 
	 }
	 
//		商品新增
		$scope.save=function(){
//			从富文本编辑器中取值的方式：editor.html();
			$scope.entity['description']=editor.html();
			$scope.entity.startDate = start;
			$scope.entity.endDate = end;
			
			
			if($scope.entity.id == null){
				promotionService.add($scope.entity).success(function(response){
					if(response.success){
						location.href="promotion.html";
					}else{
						alert(response.message);
					}
				})
			}else{
				promotionService.update($scope.entity).success(function(response){
					if(response.success){
						location.href="promotion.html";
					}else{
						alert(response.message);
					}
				})
			}
		}
		
		$scope.uploadFile=function(){
			uploadService.uploadFile().success(function(response){
				if(response.success){  //response={success:true,message:图片地址}
					$scope.image.url = response.message;
				}else{
					alert(response.message);
				}
				
			})
			
		}
		
//		动态添加图片
		$scope.addItemImages=function(){
			$scope.entity.titleImg=$scope.image.url;
		}

//		动态删除图片
		$scope.deleItemImages=function(){
			$scope.entity.titleImg="";
		}		
	
		//批量删除 
		$scope.dele=function(){			
			//获取选中的复选框			
			promotionService.dele( $scope.selectIds ).success(
				function(response){
					if(response.success){
						$scope.reloadList();//刷新列表
					}						
				}		
			);				
		}
		
		$scope.findOne=function(){
			var id = $location.search()['id'];
			if(id){
				promotionService.findOne(id).success(function(response){
					$scope.entity = response;
					editor.html(response.description);
				})
			}
		}
	


    
});	
