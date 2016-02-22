<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>  
    <div class="container">
        <div class="row" ng-controller="MyController as ctrl">
            <div class="alert alert-danger" role="alert" ng-show="ctrl.error!=null">{{ctrl.error}}</div>
            <h1>To do list</h1>
            <div>
                <table class="table table-hover" ng-show="ctrl.todos.length > 0">
                    <thead>
                        <tr><th>Id</th><th>Description</th><th>Action</th></tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="todo in ctrl.todos">
                            <td>
                                <span ng-style="todo.done ? {'text-decoration': 'line-through'} : {'text-decoration': 'none'}">{{todo.id}}</span>
                            </td>
                            <td>
                                <span ng-style="todo.done ? {'text-decoration': 'line-through'} : {'text-decoration': 'none'}">{{todo.description}}</span>
                            </td>
                            <td>
                                <span class="glyphicon glyphicon-ok" ng-click="ctrl.done(todo)" ng-show="!todo.done"></span>
                                <span class="glyphicon glyphicon-remove" ng-click="ctrl.delete(todo)"></span>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <span class="form-inline">
                    <input type="text" class="form-control" placeholder="new todo" ng-model="ctrl.newDescription">
                    <button ng-click="ctrl.add()" class="btn btn-default">creer</button>
                </span>
            </div>
            <!--
            <div id="controllers" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
            -->
        </div>
    </div>

</body>
</html>
