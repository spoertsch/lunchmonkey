'use strict';

var feedbackController = angular.module('feedbackController', []);

feedbackController.controller('FeedbackController', ['$scope', 'Feedbacks', function ($scope, Feedbacks) {

        $scope.openFeedbackDialog = function () {
            $scope.newFeedback = {username: "", comment: ""}
            $scope.feedbacks = Feedbacks.getAll().query()
        }

        $scope.saveFeedback = function () {
            Feedbacks.save().execute($scope.newFeedback)
        }

        $scope.createFeedback = function () {
            Feedbacks.create().execute($scope.newFeedback)
            $scope.feedbacks.push($scope.newFeedback)
        }

        $scope.deleteFeedback = function(feedback){
            Feedbacks.delete(feedback._id.$oid).execute()
            $scope.feedbacks.splice($.inArray(feedback, $scope.feedbacks),1);
        }
    }]
);
