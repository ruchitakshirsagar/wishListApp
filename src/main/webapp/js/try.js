/**
 * 
 */
var app= angular.module('app', ['ngRoute']);

app.config(['$routeProvider',function ($routeProvider) {
	
	 
 $routeProvider
 .when('/',
 {
     templateUrl: 'views/AllProducts.html',
     controller: 'AllProducts'
 })
 .when('/viewWishList',
		 {
	 
	 templateUrl: 'views/wishList.html',
     controller: 'wishList'
		 })
		 .when('/:id',{
			 templateUrl: 'views/getProduct.html',
		     controller: 'getProduct'
		 });
}]);
app.controller('AllProducts', function($scope, $http) {
	 $scope.products=[];
    $http.get('http://localhost:8080/wishlist/webapi/products').
        then(function(response) {
            $scope.products = response.data;
        });
    
    $scope.addToWishList = function(product){
    	var config = {
                headers : {
                    'Content-Type': 'application/json;'
                }
            }
    	var data = angular.toJson(product);
    	
    	$http.post('http://localhost:8080/wishlist/webapi/wishList', data, config)
        .success(function (data, status, headers, config) {
            $scope.PostDataResponse = data;
            
        })
        .error(function (data, status, header, config) {
            $scope.ResponseDetails = "Data: " + data +
                "<hr />status: " + status +
                "<hr />headers: " + header +
                "<hr />config: " + config;
        });
    	
    };
});

app.controller('wishList', function($scope, $http) {
	
	function _refreshWishListData() {
	 $scope.products=[];
   $http.get('http://localhost:8080/wishlist/webapi/wishList').
       then(function(response) {
           $scope.products = response.data;
       });
	}
	
	_refreshWishListData();
	
   
   $scope.removeFromWishList = function(wishListID){
   	
   	
   	$http.delete('http://localhost:8080/wishlist/webapi/wishList/'+wishListID).then(
   			_refreshWishListData()
   			);
       
   }
   
   
});

app.controller('getProduct',function($scope,$http,$routeParams){
	
	
	    $http.get('http://localhost:8080/wishlist/webapi/products/'+$routeParams.id).
	        then(function(response) {
	            $scope.product = response.data;
	        });
	    
	    $scope.addToWishList = function(product){
	    	var config = {
	                headers : {
	                    'Content-Type': 'application/json;'
	                }
	            }
	    	var data = angular.toJson(product);
	    	
	    	$http.post('http://localhost:8080/wishlist/webapi/wishList', data, config)
	        .success(function (data, status, headers, config) {
	            $scope.PostDataResponse = data;
	        })
	        .error(function (data, status, header, config) {
	            $scope.ResponseDetails = "Data: " + data +
	                "<hr />status: " + status +
	                "<hr />headers: " + header +
	                "<hr />config: " + config;
	        });
	    	
	    };
});