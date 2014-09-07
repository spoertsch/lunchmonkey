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

        var old = null

        $scope.randomButton = function () {
            $http({method: 'GET', url: '/locations/random'}).
                success(function (data, status, headers, config) {
                    console.log("success: " + data)
                    $scope.random = data
                    document.getElementById("random").style.display = 'block'

                    document.getElementById(data.name).style.backgroundColor = '#dff0d8'
                    if(old != null) {
                        old.style.backgroundColor = '#ffffff'
                    }
                    old = document.getElementById(data.name)
                }).
                error(function (data, status, headers, config) {
                    console.log("error")
                    document.getElementById("random").style.display = 'none'
                });
        }
    });

})();