(function() {
    var app = angular.module('lunchmonkey', []);

    app.controller('LocationController', function($scope, $http){

        $http({method: 'GET', url: '/locations'}).
            success(function(data, status, headers, config) {
                console.log("success: " + data)
                $scope.locations = data
            }).
            error(function(data, status, headers, config) {
                console.log("error")
            });
    });

})();