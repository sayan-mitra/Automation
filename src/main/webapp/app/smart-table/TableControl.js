angular.module('myApp.tableView', ['ngMaterial', 'ui.grid', 'angularBootstrapNavTree'])

.controller('tableCtrl',  function ($scope, $filter, $http, CommonService) {

    var tree

    $scope.swapData = function() {
        if ($scope.gridOpts.data === data1) {
            $scope.gridOpts.data = data2;
            $scope.gridOpts.columnDefs = columnDefs2;
        }
        else {
            $scope.gridOpts.data = data1;
            $scope.gridOpts.columnDefs = columnDefs1;
        }
    };

    $scope.addData = function() {
        var n = $scope.gridOpts.data.length + 1;
        $scope.gridOpts.data.push({
            "firstName": "New " + n,
            "lastName": "Person " + n,
            "company": "abc",
            "employed": true,
            "gender": "male"
        });
    };

    $scope.removeFirstRow = function() {
        //if($scope.gridOpts.data.length > 0){
        $scope.gridOpts.data.splice(0,1);
        //}
    };

    $scope.reset = function () {
        data1 = angular.copy(origdata1);
        data2 = angular.copy(origdata2);

        $scope.gridOpts.data = data1;
        $scope.gridOpts.columnDefs = columnDefs1;
    }

    var columnDefs1 = CommonService.getColumns;

    var data1 = [
        {
            "firstName": "Cox",
            "lastName": "Carney",
            "company": "Enormo",
            "gender": "male"
        },
        {
            "firstName": "Lorraine",
            "lastName": "Wise",
            "company": "Comveyer",
            "gender": "female"
        },
        {
            "firstName": "Nancy",
            "lastName": "Waters",
            "company": "Fuelton",
            "gender": "female"
        },
        {
            "firstName": "Misty",
            "lastName": "Oneill",
            "company": "Letpro",
            "gender": "female"
        }
    ];

    var origdata1 = angular.copy(data1);

    var columnDefs2 = [
        { name: 'firstName' },
        { name: 'lastName' },
        { name: 'company' },
        { name: 'employed' }
    ];

    var data2 = [
        {
            "firstName": "Waters",
            "lastName": "Shepherd",
            "company": "Kongene",
            "employed": true
        },
        {
            "firstName": "Hopper",
            "lastName": "Zamora",
            "company": "Acium",
            "employed": true
        },
        {
            "firstName": "Marcy",
            "lastName": "Mclean",
            "company": "Zomboid",
            "employed": true
        },
        {
            "firstName": "Tania",
            "lastName": "Cruz",
            "company": "Marqet",
            "employed": true
        },
        {
            "firstName": "Kramer",
            "lastName": "Cline",
            "company": "Parleynet",
            "employed": false
        },
        {
            "firstName": "Bond",
            "lastName": "Pickett",
            "company": "Brainquil",
            "employed": false
        }
    ];

    var origdata2 = angular.copy(data2);

    $scope.gridOpts = {
			columnDefs: columnDefs1,
			data: []
		}
    
   /* $scope.gridOpts =   {
    						columnDefs: columnDefs1,
    						data: data1
    					};*/

    /*var treedata_geography = [{
        label: 'North America',
        children: [{
            label: 'Canada',
            data: {"ABC" : "a"},
            children: ['Toronto', 'Vancouver']
        }, {
            label: 'USA',
            children: ['New York', 'Los Angeles']
        }, {
            label: 'Mexico',
            children: ['Mexico City', 'Guadalajara']
        }]
    }, {
        label: 'South America',
        children: [{
            label: 'Venezuela',
            children: ['Caracas', 'Maracaibo']
        }, {
            label: 'Brazil',
            children: ['Sao Paulo', 'Rio de Janeiro']
        }, {
            label: 'Argentina',
            children: ['Buenos Aires', 'Cordoba']
        }]
    }];*/
    
    $scope.my_data = [] //treedata_geography;
    $scope.my_tree = tree = {};

    $http.get("/rest/folders").success(function(data){
        $scope.my_data = data;
    });
    
    $scope.my_tree_handler = function(branch){
        var br = tree.get_selected_branch()
        //alert(br.data)
        if(br.data.id == 1) {
        	$http.get("/rest/grid/" + br.data.id).success(function(data){
                //$scope.gridOpts.columnDefs = columnDefs1;
        		$scope.gridOpts.data = data;
            });
        }
        
        else {
	        //$scope.gridOpts.columnDefs = columnDefs1;
	        $scope.gridOpts.data = data1;
        }
        
        /*tree.add_branch(br, {
            label: 'New Branch',
            data: {
                something: 42,
                'else': 43
            }
        })*/
        
    }

});