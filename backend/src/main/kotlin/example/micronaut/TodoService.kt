package example.micronaut

interface TodoService {

    fun createTodo(todo: Todo): Todo

    fun listTodos(): List<Todo>

    fun getTodoById(id: Long): Todo

    fun deleteTodoById(id: Long): Todo

    fun updateTodoById(id: Long, todoIn: Todo): Todo

    fun toggleTodoCompletionById(id: Long): Todo

}