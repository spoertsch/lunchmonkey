'use strict';

/* Services */

var persistenceServices = angular.module('persistenceServices', []);

persistenceServices.factory('Locations', ['$resource',
    function ($resource) {
        return {
            getAll: function () {
                return $resource('/locations', {}, {
                    query: {method: 'GET', isArray: true}
                });
            },
            create: function () {
                return $resource('/location', {}, {
                    execute: {method: 'POST'}
                });
            },
            save: function () {
                return $resource('/location', {}, {
                    execute: {method: 'PUT'}
                });
            },
            delete: function (id) {
                return $resource('/location/:locationId', {}, {
                    execute: {
                        method: 'DELETE',
                        params: {locationId: id}
                    }
                });
            }
        };
    }
]);

persistenceServices.factory('Feedbacks', ['$resource',
    function ($resource) {
        return {
            getAll: function () {
                return $resource('/feedbacks', {}, {
                    query: {method: 'GET', isArray: true}
                });
            },
            create: function () {
                return $resource('/feedback', {}, {
                    execute: {method: 'POST'}
                });
            },
            save: function () {
                return $resource('/feedback', {}, {
                    execute: {method: 'PUT'}
                });
            },
            delete: function (id) {
                return $resource('/feedback/:feedbackId', {}, {
                    execute: {
                        method: 'DELETE',
                        params: {feedbackId: id}
                    }
                });
            }
        };
    }
]);
