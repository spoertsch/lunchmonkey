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

        $scope.openCreateLocationDialog = function () {
            $scope.selectedLocation = {name: "", foodStyle: "", url: "", votes: null}
            $scope.editLocationPopupTitle = "Create Location"
            $scope.isCreate = true
        }

        $scope.openUpdateLocationDialog = function (selectedLocation) {
            $scope.selectedLocation = selectedLocation
            $scope.editLocationPopupTitle = "Edit Location"
            $scope.isCreate = false
        }

        $scope.saveLocation = function () {
            Locations.save().execute($scope.selectedLocation)
        }

        $scope.createLocation = function () {
            Locations.create().execute($scope.selectedLocation)
            $scope.locations.push($scope.selectedLocation)
        }

        $scope.deleteLocation = function(location){
            Locations.delete(location._id.$oid).execute()
            $scope.locations.splice($.inArray(location, $scope.locations),1);
        }

        $scope.voteLocation = function(location){
            location.votes = [{username: "test", positive: true}]
            Locations.save().execute(location)
        }
    }]
);
