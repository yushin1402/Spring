package com.example.todo.domain.repository.todo;

import java.util.Collection;
import java.util.Optional;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;
import com.example.todo.domain.model.Todo;

@Repository
public class TodoRepositoryImpl implements TodoRepository {
	private static final Map<String, Todo> TODO_MAP = new ConcurrentHashMap<String, Todo>();
	

	@Override
	public Optional<Todo> findById(String todoId) {
		// TODO 自動生成されたメソッド・スタブ
		return Optional.ofNullable(TODO_MAP.get(todoId));
	}

	@Override
	public Collection<Todo> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return TODO_MAP.values();
	}

	@Override
	public void create(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		TODO_MAP.put(todo.getTodoId(),todo);
	}

	@Override
	public boolean updateById(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		TODO_MAP.put(todo.getTodoId(),todo);
		return true;
	}

	@Override
	public void deleteById(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		TODO_MAP.remove(todo.getTodoId());
	}

	@Override
	public long countByFinished(boolean finished) {
		// TODO 自動生成されたメソッド・スタブ
		long count = 0;
		for (Todo todo : TODO_MAP.values()) {
			if (finished == todo.isFinished()) {
				count ++ ;
			}
		}
		return count;
	}

}
