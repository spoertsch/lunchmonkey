(function () {
    var app = angular.module('lunchmonkey', []);

    app.controller('LocationController', function ($scope, $http) {

        $scope.predicate = "name";
        $scope.reverse = false;

        $http({method: 'GET', url: '/locations'}).
            success(function (data, status, headers, config) {
                console.log("success: " + data)
                $scope.locations = data
            }).
            error(function (data, status, headers, config) {
                console.log("error")
            });

        var oldLocation = null

        $scope.randomButton = function () {
            var randomIndex = Math.floor(Math.random()*$scope.filteredLocations.length)
            $scope.random = $scope.filteredLocations[randomIndex]
            var newLocation = document.getElementById($scope.random.name)
            newLocation.style.backgroundColor = '#dff0d8'
            if(oldLocation != null && oldLocation != newLocation) {
                oldLocation.style.backgroundColor = '#ffffff'
            }
            oldLocation = newLocation
        }

        $scope.sortButton = function () {
            $scope.reverse = !$scope.reverse
        }
    });

})();