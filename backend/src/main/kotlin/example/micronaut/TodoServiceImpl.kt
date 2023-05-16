package example.micronaut

import jakarta.inject.Singleton

@Singleton
class TodoServiceImpl(private val todoRepository: TodoRepo) : TodoService {
    override fun createTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    override fun listTodos(): List<Todo> {
        @Suppress("UNCHECKED_CAST")
        return todoRepository.findAll() as List<Todo>
    }

    override fun getTodoById(id: Long): Todo {
        return findTodoInDB(id)
    }

    override fun deleteTodoById(id: Long): Todo {
        val todo = findTodoInDB(id)
        todoRepository.deleteById(id)
        return todo
    }

    override fun updateTodoById(id: Long, todoIn: Todo): Todo {
        val todo = findTodoInDB(id)
        todo.description = todoIn.description
        return todoRepository.update(todo)
    }

    override fun toggleTodoCompletionById(id: Long): Todo {
        val todo = findTodoInDB(id)
        todo.completed = !todo.completed
        return todoRepository.update(todo)
    }

    private fun findTodoInDB(id: Long): Todo {
        val todo = todoRepository.findById(id)
        if (todo.isEmpty) {
            throw IllegalArgumentException("No todo found with id $id")
        }
        return todo.get()
    }

}
