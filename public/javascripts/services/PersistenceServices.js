'use strict';

/* Services */

var host = 'http://localhost:9000';

var persistenceServices = angular.module('persistenceServices', []);

persistenceServices.factory('Locations', ['$resource',
    function ($resource) {
        return {
            getAll: function () {
                return $resource(host + '/locations', {}, {
                    query: {method: 'GET', isArray: true}
                });
            },
            create: function () {
                return $resource(host + '/location', {}, {
                    execute: {method: 'POST'}
                });
            },
            save: function () {
                return $resource(host + '/location', {}, {
                    execute: {method: 'PUT'}
                });
            },
            delete: function (id) {
                return $resource(host + '/location/:locationId', {}, {
                    execute: {
                        method: 'DELETE',
                        params: {locationId: id}
                    }
                });
            }
        };
    }
]);

