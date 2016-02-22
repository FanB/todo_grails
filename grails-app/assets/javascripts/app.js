angular.module('myApp',['ngResource']);

angular.module('myApp').factory('Todo',['$resource',function($resource) {
  return $resource('/todos/:id',null,
    {
        'update': { method:'PUT' }
    }
  );
}]);

angular.module('myApp').controller('MyController',['Todo',function(Todo){
  //assigne le controller a la variable ctrl
  var ctrl = this;
  //récupère la liste des todos
  ctrl.todos = Todo.query();
  //fonction d'ajout
  ctrl.add = function(){
    ctrl.error = null;
    var todo = new Todo({description: ctrl.newDescription, done: false});
    todo = todo.$save(function(todo){
      console.log(todo.id);
    	ctrl.todos.push(todo);
      ctrl.newDescription = null;
    },function(error){
      console.log(error);
      ctrl.error = error.data.errors.map(function(e){
        return e.message;
      }).join(', ');
      //message = "";
      //error.
    });
  };
  //fonction de suppression
  ctrl.delete = function(todo){
    var id = todo.id;
    ctrl.error = null;
    Todo.remove({id: todo.id},function(todo){
      for(var i=0;i<ctrl.todos.length;i++){
        if(ctrl.todos[i].id == id){
          ctrl.todos.splice(i,1);
        }
      }
    },function(error){
      console.log(error);
    });
  };
  //fonction de modification
  ctrl.done = function(todo){
    ctrl.error = null;
    todo.done = true;
    Todo.update({id: todo.id},todo);
    console.log(ctrl.todos);
  };
}]);
