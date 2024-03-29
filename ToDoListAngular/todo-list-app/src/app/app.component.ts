// app.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  todos: string[] = ['Task 1', 'Task 2', 'Task 3'];

  addTodoFromForm(newTodo: string): void {
    this.todos.push(newTodo);
  }

  deleteTodo(index: number): void {
    this.todos.splice(index, 1);
  }
}
