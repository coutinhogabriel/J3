// todo-list.component.ts
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent {
  @Input() todos: string[] = [];

  deleteTodo(index: number): void {
    this.todos.splice(index, 1);
  }
}
