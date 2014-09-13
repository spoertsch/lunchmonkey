'use strict';

var locationControllers = angular.module('locationController', []);

locationControllers.controller('LocationController', ['$scope', 'Locations', function ($scope, Locations) {

        $scope.predicate = "name";
        $scope.reverse = false;
        $scope.locations = Locations.getAll().query()

        var oldLocation = null

        $scope.randomButton = function () {
            var randomIndex = Math.floor(Math.random() * $scope.filteredLocations.length)
            $scope.random = $scope.filteredLocations[randomIndex]
            var newLocation = document.getElementById($scope.random.name)
            newLocation.style.backgroundColor = '#dff0d8'
            if (oldLocation != null && oldLocation != newLocation) {
                oldLocation.style.backgroundColor = '#ffffff'
            }
            oldLocation = newLocation
        }

        $scope.sortButton = function () {
            $scope.reverse = !$scope.reverse
        }

        $scope.createLocation = function () {

        }
    }]
);
