(function() {
    var app = angular.module('lunchmonkey', []);

    app.controller('LocationController', function(){
        this.location = location;
    });

    var location = {
        name: 'Thai Express',
        foodStyle: 'asian'
    };
})();