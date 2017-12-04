'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
    'ngMaterial',
  'myApp.view1',
  'myApp.view2',
  'myApp.version', 'myApp.tableView'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  //$routeProvider.otherwise({redirectTo: '/view1'});
}])

.service('CommonService',function(){

    this.getColumns = function () {
            return [
                { name: 'firstName' },
                { name: 'lastName' },
                { name: 'company' },
                { name: 'gender' }
            ];

    }
})

.controller('ButtonCtrl', [function(CommonService) {

}]);
