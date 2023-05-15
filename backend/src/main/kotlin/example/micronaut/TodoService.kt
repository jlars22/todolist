package example.micronaut

import jakarta.inject.Singleton

@Singleton
class TodoService(private val todoRepository: TodoRepo) {
    fun createTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }
}
