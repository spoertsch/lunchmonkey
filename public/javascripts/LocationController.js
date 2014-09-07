(function () {
    var app = angular.module('lunchmonkey', []);

    app.controller('LocationController', function ($scope, $http) {

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
            $http({method: 'GET', url: '/locations/random'}).
                success(function (data, status, headers, config) {
                    console.log("success: " + data)
                    $scope.random = data
                    document.getElementById("random").style.display = 'block'

                    var newLocation = document.getElementById(data.name)
                    newLocation.style.backgroundColor = '#dff0d8'
                    if(oldLocation != null && oldLocation != newLocation) {
                        oldLocation.style.backgroundColor = '#ffffff'
                    }
                    oldLocation = newLocation
                }).
                error(function (data, status, headers, config) {
                    console.log("error")
                    document.getElementById("random").style.display = 'none'
                });
        }
    });

})();