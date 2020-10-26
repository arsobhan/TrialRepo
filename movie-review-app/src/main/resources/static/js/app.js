var app = angular.module("myApp", []);
/*app.config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'index.html',
		controller : 'movieListCtrl'
	}).when('/review', {
		templateUrl : 'reviewlist.html',
		controller : 'reviewlistCtrl'
	}).otherwise('/');
  }); */
	app.controller("movieListCtrl", function($scope, $http) {
	    loadData();
		$scope.addMovie = function () {
			var data = {
					"movieName" : $scope.movieName,
					"movieDesc":$scope.movieDesc
			};
			console.log(data);
			$http.post('http://localhost:8060/movie-service/movies/movie', JSON.stringify(data)).then(function (response) {
				if (response.data)

					$scope.msg = "Movie Details Submitted Successfully!";

				}, function (response) {

					$scope.msg = "Service not Exists";

				});
			loadData();
		}
        $scope.reset = function(){
            $scope.myForm.$setPristine(); //reset Form
        };
		$scope.dbrecords = [];
		
		function loadData() {
	        $http.get("http://localhost:8060/movie-list-service/movielist/")
	            .then(function (response) {
	                $scope.dbrecords = response.data;
	            })
	            .catch(function(error) {
	                $scope.error = error;
	            });
	    }
	});
	
	app.controller("reviewListCtrl", function($scope, $http) {
		loadData();
		$scope.addReview = function () {
			var data = {
					"movieID" : $scope.selected.id,
					"reviewDesc":$scope.reviewDesc
			};
			console.log(data);
			$http.post('http://localhost:8060/review-service/reviews/review', JSON.stringify(data)).then(function (response) {
				if (response.data)

					$scope.msg = "Review Details Submitted Successfully!";

				}, function (response) {

					$scope.msg = "Service not Exists";

				});
			loadData();
		}
	       $scope.reset = function(){
	            $scope.myForm.$setPristine(); //reset Form
	        };
			$scope.dbrecords = [];
			
			function loadData() {
		        $http.get("http://localhost:8060/movie-list-service/movielist/")
		            .then(function (response) {
		                $scope.dbrecords = response.data;
		            })
		            .catch(function(error) {
		                $scope.error = error;
		            });
		    }
	});