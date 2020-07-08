package academy.learnProgramming.service;

import academy.learnProgramming.model.TodoData;
import academy.learnProgramming.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();
}
