angular.module('todoApp', ['ui.bootstrap']);
angular.module('todoApp', ['kendo.directives']);
angular.module('todoApp').controller('PopoverDemoCtrl', function ($scope, $sce, $window) {    
    var vm = this;
 
 vm.nombres="Jefferson ";
  vm.apellidos="Balcazar";
  vm.fecha="10/07/1990"
  vm.pais="Ecuador"

 
 vm.limpiar = function (){
	  console.log("saludos "+ vm.nombres); 
	  vm.nombres="";
	  vm.apellidos="";
	  vm.fecha="";
	  vm.pais="";
 };
       
	/*tooltip fecha*/
	$('[data-toggle="tooltip"]').tooltip();
    
    /*Data Combos*/
    vm.itemsOrigen = [
    {nombre: "Ecuador", codigo: 1},
    {nombre: "Peru", codigo: 2},
    {nombre: "Colombia", codigo: 3}
    ];
    vm.data = [
              { id: 1, text: "Foo" },
              { id: 2, text: "Bar" },
              { id: 3, text: "Baz" }
    ];
    vm.selectOptions2 = {
                placeholder: "Seleccione...",
                optionLabel: "Select...",
                dataTextField: "ProductName",
                dataValueField: "ProductID",
                filter:"contains",
                dataSource: [
                        {ProductName: "Ecuador", ProductID: 1},
                        {ProductName: "Peru", ProductID: 2},
                        {ProductName: "Colombia", ProductID: 3},
                        {ProductName: "Brazil", ProductID: 4},
                        {ProductName: "Paraguay", ProductID: 5},
                        {ProductName: "Ecuador2", ProductID: 6},
                        {ProductName: "Peru2", ProductID: 7},
                        {ProductName: "Colombia2", ProductID: 8},
                        {ProductName: "Brazil2", ProductID: 9},
                        {ProductName: "Paraguay2", ProductID: 10}
                    ]
  };
    vm.selectOptions = {

                dataTextField: "nombre",
                dataValueField: "codigo",
                valuePrimitive: true,
                autoBind: false,
                value: [
                       {nombre: "Ecuador", codigo: 1},
                        {nombre: "Peru", codigo: 2},
                        {nombre: "Colombia", codigo: 3},
                        {nombre: "Brazil", codigo: 4},
                        {nombre: "Paraguay", codigo: 5},
                        {nombre: "Uruguay", codigo: 6},
                        {nombre: "Bolivia", codigo: 7},
                        {nombre: "Chile", codigo: 8},
                        {nombre: "Argentina", codigo: 9}
                    ],
             items: [
                      { type: "button", text: "Button" },
                      { type: "button", text: "Toggle Button", togglable: true },
                      {
                          type: "splitButton",
                          text: "Insert",
                          menuButtons: [
                              { text: "Insert above", icon: "insert-n" },
                              { text: "Insert between", icon: "insert-m" },
                              { text: "Insert below", icon: "insert-s" }
                          ]
                      }]
   };

});

