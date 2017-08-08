angular.module('saasApp', [])
    .factory('saasService', ['$http', function($http) {

        function listar(callback) {
            $http({
                method:'GET',
                url:'/'
            }).success(function (data) {
                if (callback) callback(data)
            });
        }

        function salvar(hq, callback) {
            $http({
                method:'POST',
                url:'/',
                data:JSON.stringify(hq)
            }).success(function (data) {
                if (callback) callback(data)
            });
        }

        return {
            listar:listar,
            salvar:salvar
        };
    }])
    .controller('saasCtrl', ['$scope', 'saasService',function($scope, saasService) {

        $scope.greeting = "Oi";
        saasService.listar(function(hqs) {
            $scope.hqs = hqs;
        });

        $scope.salvar = function(hq) {
            saasService.salvar(hq, function(hq) {
                $scope.hqs.push(hq);
            });
        }
    }]);
