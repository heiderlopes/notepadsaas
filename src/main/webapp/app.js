angular.module('saasApp', [])
    .factory('saasService', ['$http', function($http) {

        function listar(callback) {
            $http({
                method:'GET',
                url:'/nota'
            }).then(function (data) {
                if (callback) callback(data)
            });
        }

        function salvar(hq, callback) {
            $http({
                method:'POST',
                url:'/nota',
                data:JSON.stringify(hq)
            }).then(function (data) {
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
            console.log(hqs);
        })

        $scope.salvar = function(hq) {
            saasService.salvar(hq, function(hq) {
                $scope.hqs.push(hq);
            });
        }
    }]);
