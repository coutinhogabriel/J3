// todo-edit.component.ts
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-todo-edit',
  templateUrl: './todo-edit.component.html',
  styleUrls: ['./todo-edit.component.css']
})
export class TodoEditComponent {
  @Input() todo: string = '';
  @Output() saveEdit = new EventEmitter<string>();
  @Output() cancelEdit = new EventEmitter<void>();

  editedTodo: string = '';

  ngOnInit(): void {
    this.editedTodo = this.todo;
  }

  save(): void {
    if (this.editedTodo.trim() !== '') {
      this.saveEdit.emit(this.editedTodo);
    }
  }

  cancel(): void {
    this.cancelEdit.emit();
  }
}
