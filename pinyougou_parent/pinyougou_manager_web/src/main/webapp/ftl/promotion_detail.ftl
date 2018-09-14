<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<title>产品详情页</title>
	 <link rel="icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" type="text/css" href="css/webbase.css" />
    <link rel="stylesheet" type="text/css" href="css/pages-item.css" />
    <link rel="stylesheet" type="text/css" href="css/pages-zoom.css" />
    <link rel="stylesheet" type="text/css" href="css/widget-cartPanelView.css" />
    
    <script type="text/javascript" src="./plugins/angularjs/angular.min.js"></script>
    
    <script type="text/javascript" src="./js/base.js"></script>
    <script type="text/javascript" src="./js/controller/promotionController.js"></script>

</head>

<body ng-app="pinyougou" ng-controller="promotionController">


<link rel="stylesheet" type="text/css" href="css/promotion_detail.css">
<div class="container promotions" >
	<div class="col-md-2 prolist">
		<h5 class="title"><a href="#/promotion"><strong>返回促销列表</strong></a></h5>
		<img src="${promotion.titleImg}" class="img-responsive">
	</div>
	<div class="col-md-10 procontent">
		<h5 class="title">${promotion.title!""}</h5>
		<div class="intro">
			<p>活动范围: ${promotion.activeScope!""}</p>
			<p>活动时间: ${promotion.startDate?string("yyyy-MM-dd")} - 
				${promotion.endDate?string("yyyy-MM-dd")}</p>
		</div>
		<div class="partline clearfix"></div>
		<div class="promotionbox">
			${promotion.description!""} 
		</div>
	</div>
</div>



<script type="text/javascript" src="js/model/cartModel.js"></script>
<script type="text/javascript" src="js/plugins/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript" src="js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.jqzoom/jquery.jqzoom.js"></script>
<script type="text/javascript" src="js/plugins/jquery.jqzoom/zoom.js"></script>
</body>

</html>
